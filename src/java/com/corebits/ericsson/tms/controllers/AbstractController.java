
package com.corebits.ericsson.tms.controllers;

import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author xtphere
 * @param <T>
 */
public abstract class AbstractController<T> {
    private final Class<T> entityClass;
    
    /**
     *
     * @param entityClass
     */
    public AbstractController(Class<T> entityClass){
        this.entityClass = entityClass;
    }
    
    /**
     *
     * @return
     */
    protected abstract EntityManager getEntityManager();
    
    /**
     *
     * @param entity
     */
    public void create(T entity){
        getEntityManager().persist(entity);
    }
    
    /**
     *
     * @param entity
     */
    public void edit(T entity){
        getEntityManager().merge(entity);
    }
    
    /**
     *
     * @param id
     * @return
     */
    public T find(Object id){
        return getEntityManager().find(entityClass, id);
    }
    
    /**
     *
     * @param entity
     */
    public void delete(T entity){
        getEntityManager().remove(getEntityManager().merge(entity));
    }
        
    /**
     *
     * @return
     */
    public int count(){
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
    /**
     *
     * @param namedQuery
     * @return
     */
    public List<T> findWithNamedQuery(String namedQuery){
        return findWithNamedQuery(namedQuery, null);
    }
    
    /**
     *
     * @param namedQuery
     * @param parameter
     * @return
     */
    public List<T> findWithNamedQuery(String namedQuery, Map parameter){
        return findWithNamedQuery(namedQuery, parameter, 0);
    }
    
    /**
     *
     * @param namedQuery
     * @param parameter
     * @param resultLimit
     * @return
     */
    public List<T> findWithNamedQuery(String namedQuery, Map parameter, int resultLimit){
        Query query = getEntityManager().createNamedQuery(namedQuery);        
        if (parameter != null && !parameter.isEmpty()) {
            Set<Map.Entry<String, Object>> param = parameter.entrySet();
            param.stream().forEach((p) -> {
                query.setParameter(p.getKey(), p.getValue());
            });
        }
        if(resultLimit > 0)
            query.setMaxResults(resultLimit);
        
        return query.getResultList();
    }
    
    /**
     *
     * @param namedQuery
     * @param range
     * @return
     */
    public List<T> findWithNamedQueryRange(String namedQuery, int... range){
        return findWithNamedQueryRange(namedQuery, null, range);
    }
    
    /**
     *
     * @param namedQuery
     * @param parameter
     * @param range
     * @return
     */
    public List<T> findWithNamedQueryRange(String namedQuery, Map parameter, int... range){
        Query query = getEntityManager().createNamedQuery(namedQuery);
        
        if(parameter != null && !parameter.isEmpty()){
            Set<Map.Entry<String, Object>> param = parameter.entrySet();
            param.stream().forEach((p) -> {
                query.setParameter(p.getKey(), p.getValue());
            });
        }      
        
        if(range.length > 1){
            query.setMaxResults(range[1] - range[0]);
            query.setFirstResult(range[0]);
        }
        
        return query.getResultList();
    }
    
    /**
     *
     * @return
     */
    public List<T> findAll(){
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
    /**
     *
     * @param range
     * @return
     */
    public List<T> findRange(int... range){
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }
    
    /**
     *
     * @param sql
     * @return
     */
    public List<T> findWithNativeQuery(String sql){
        return getEntityManager().createNativeQuery(sql, entityClass).getResultList();
    }    
    
}
