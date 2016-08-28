/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corebits.ericsson.tms.controllers;

import com.corebits.ericsson.tms.models.Member1;
import com.corebits.ericsson.tms.utils.Utility;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tommy
 */
@Stateless
public class RegistrationController {

    @PersistenceContext(unitName = "TMSystemPU")
    private EntityManager em;

    private static final Logger LOGGER = Logger.getLogger(RegistrationController.class.getName());

    public void persist(Object object) {
        em.persist(object);
    }

    public String createMember(Member1 member1) {
        String status;
        try {
            em.persist(member1);
            status = Utility.OPERATION_STATUS;
        } catch (Exception e) {
            status = e.getMessage();
            LOGGER.log(Level.SEVERE, "exception when creating new member ", e);
        }
        return status;
    }

    public String updateMember(Member1 member1) {
        String status;
        try {
            em.merge(member1);
            status = Utility.OPERATION_STATUS;
        } catch (Exception e) {
            status = e.getMessage();
            LOGGER.log(Level.SEVERE, "exception when updating member ", e);
        }
        return status;
    }

    public Member1 getMember(Integer memberId) {
        Member1 member1 = new Member1();
        try {
            member1 = (Member1) em.find(Member1.class, memberId);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception getting member for Id {0}, message :{1}", new Object[]{memberId, e.getMessage()});
        }
        return member1;
    }
}
