
package com.corebits.ericsson.tms.mbeans;

import com.corebits.ericsson.tms.controllers.AbstractController;
import com.corebits.ericsson.tms.mbeans.util.JsfUtil;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.faces.event.ActionEvent;

/**
 *
 * @author xtphere
 * @param <T>
 */
public abstract class AbstractMBean<T> implements Serializable{
    private AbstractController<T> ejbFacade;
    private Class<T> itemClass;
    private T selected;
    private List<T> items;
    
    private enum PersistAction{
        CREATE, DELETE, UPDATE;
    }
    
    public AbstractMBean(){        
    }
    
    public AbstractMBean(Class<T> itemClass){
        this.itemClass = itemClass;
    }
    
    protected AbstractController<T> getFacade(){
        return ejbFacade;
    }
    
    protected void setFacade(AbstractController<T> ejbFacade){
        this.ejbFacade = ejbFacade;
    }
    
    protected T getSelected(){
        return selected;
    }
    
    protected void setSelected(T selected){
        this.selected = selected;
    }
    
    public List<T> getItems(){
        if(items == null) 
            items = this.ejbFacade.findAll();        
        
        return items;
    }
    
    public void save(ActionEvent event) {
        String msg = ResourceBundle.getBundle("/bundle").getString(itemClass.getSimpleName() + "Updated");
        persist(PersistAction.UPDATE, msg);
    }

    public void saveNew(ActionEvent event) {
        String msg = ResourceBundle.getBundle("/bundle").getString(itemClass.getSimpleName() + "Created");
        persist(PersistAction.CREATE, msg);
        if (!isValidationFailed()) {
            items = null; // Invalidate list of items to trigger re-query.
        }
    }

    public void delete(ActionEvent event) {
        String msg = ResourceBundle.getBundle("/bundle").getString(itemClass.getSimpleName() + "Deleted");
        persist(PersistAction.DELETE, msg);
        if (!isValidationFailed()) {
            selected = null; // Remove selection
            items = null; // Invalidate list of items to trigger re-query.
        }
    }
    
    
    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            try {
                if (persistAction != PersistAction.DELETE) {
                    this.ejbFacade.edit(selected);
                } else {
                    this.ejbFacade.delete(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = JsfUtil.getRootCause(ex.getCause());
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/msgbundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/msgbundle").getString("PersistenceErrorOccured"));
            }
        }
    }
    
     public T prepareCreate(ActionEvent event) {
        T newItem;
        try {
            newItem = itemClass.newInstance();
            this.selected = newItem;
            return newItem;
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean isValidationFailed() {
        return JsfUtil.isValidationFailed();
    }
    
}
