package com.corebits.ericsson.tms.controllers;

import com.corebits.ericsson.tms.models.LoanType;
import com.corebits.ericsson.tms.utils.Utility;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author xtphere
 */
@Stateless
public class LoanTypeController extends AbstractController<LoanType> {
    @PersistenceContext(unitName = Utility.PERSISTENCE_CONTEXT_UNIT_NAME)
    private EntityManager em;
    public static final String NAMED_QUERY_FIND_ALL = "LoanType.findAll";

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public LoanTypeController(){
        super(LoanType.class);
    }
    
}
