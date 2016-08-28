/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corebits.ericsson.tms.controllers;

import com.corebits.ericsson.tms.models.User;
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
public class AuthenticationController {

    @PersistenceContext(unitName = "TMSystemPU")
    private EntityManager em;
    
    private static final Logger LOGGER = Logger.getLogger(AuthenticationController.class.getName());
    
    public void persist(Object object) {
        em.persist(object);
    }

    public void merge(Object object) {
        em.merge(object);
    }

    public User login(String userId, String password) {
        String query = "SELECT u FROM User u WHERE u.userLoginId = :id AND u.userLoginPassword = :password";
        User user = null;
        try {
            user = (User) em.createQuery(query).setParameter("id", userId).setParameter("password", password).getSingleResult();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Authentication error for User : {0}, error : {1}", new Object[]{userId, e.getMessage()});
        }
        return user;
    }
    
    
}
