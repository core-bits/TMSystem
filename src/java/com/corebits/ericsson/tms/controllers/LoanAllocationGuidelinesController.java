
package com.corebits.ericsson.tms.controllers;

import com.corebits.ericsson.tms.models.LoanAllocationGuidelines;
import com.corebits.ericsson.tms.utils.Utility;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author xtphere
 */
public class LoanAllocationGuidelinesController extends AbstractController<LoanAllocationGuidelines>{
    @PersistenceContext(unitName = Utility.PERSISTENCE_CONTEXT_UNIT_NAME)
    private EntityManager em; 
    public static final String NAMED_QUERY_FIND_ALL = "LoanAllocationGuidelines.findAll"; 

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public LoanAllocationGuidelinesController(){
        super(LoanAllocationGuidelines.class);
    }
    
}
