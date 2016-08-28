
package com.corebits.ericsson.tms.mbeans;

import com.corebits.ericsson.tms.controllers.LoanAllocationGuidelinesController;
import com.corebits.ericsson.tms.models.LoanAllocationGuidelines;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author xtphere
 */
@Named(value="loanAllocationGuidelinesMBean")
@RequestScoped
public class LoanAllocationGuidelinesMBean extends AbstractMBean<LoanAllocationGuidelines>{
    @EJB
    LoanAllocationGuidelinesController ejbFacade;
    
    public LoanAllocationGuidelinesMBean(){
        super(LoanAllocationGuidelines.class);
    }
    
    @PostConstruct
    public void init(){
        super.setFacade(ejbFacade);
    }
}
