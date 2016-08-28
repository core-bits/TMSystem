
package com.corebits.ericsson.tms.listener;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

/**
 *
 * @author xtphere
 */
public class TMSValueChangeListener implements ValueChangeListener {
    
   @Override
   public void processValueChange(ValueChangeEvent event)
      throws AbortProcessingException {
      //access country bean directly
//      UserData userData = (UserData) FacesContext.getCurrentInstance().
//         getExternalContext().getSessionMap().get("loanAmount");
//
//      userData.setSelectedCountry(event.getNewValue().toString());
   }
}
