
package com.corebits.ericsson.tms.controllers;

import com.corebits.ericsson.tms.models.LoanApplication;
import com.corebits.ericsson.tms.utils.Utility;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author xtphere
 */
@Stateless
public class LoanApplicationController extends AbstractController<LoanApplication>{    
    @PersistenceContext(unitName=Utility.PERSISTENCE_CONTEXT_UNIT_NAME)
    EntityManager em;
    public static final String NAMED_QUERY_FIND_ALL = "LoanApplication.findAll";

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public LoanApplicationController() {
        super(LoanApplication.class);
    }
}
