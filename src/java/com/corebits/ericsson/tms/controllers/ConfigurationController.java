/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corebits.ericsson.tms.controllers;

import com.corebits.ericsson.tms.models.Banks;
import com.corebits.ericsson.tms.models.BuisnessUnit;
import com.corebits.ericsson.tms.models.Department;
import java.util.List;
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
public class ConfigurationController {

    @PersistenceContext(unitName = "TMSystemPU")
    private EntityManager em;

    private static final Logger LOGGER = Logger.getLogger(ConfigurationController.class.getName());

    public void persist(Object object) {
        em.persist(object);
    }

    public List<BuisnessUnit> getBuisnessUnits() {
        List<BuisnessUnit> unit = em.createNamedQuery("BuisnessUnit.findAll").getResultList();
        return unit;
    }

    public List<Department> getDepartments() {
        List<Department> departments = em.createNamedQuery("Department.findAll").getResultList();
        return departments;
    }    
    
    public List<Banks> getBanks() {
        List<Banks> banks = em.createNamedQuery("Banks.findAll").getResultList();
        return banks;
    }

    public BuisnessUnit getBuisnessUnit(Integer unitId) {
        BuisnessUnit unit = new BuisnessUnit();
        try {
            unit = (BuisnessUnit) em.find(BuisnessUnit.class, unitId);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception getting buisness unit for Id {0}, message :{1}", new Object[]{unitId, e.getMessage()});
        }
        return unit;
    }

    public Department getDepartment(Integer departId) {
        Department department = new Department();
        try {
            department = (Department) em.find(Department.class, departId);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception getting department for Id {0}, message :{1}", new Object[]{departId, e.getMessage()});
        }
        return department;
    }
    
    public Banks getBanks(Integer bankId) {
        Banks bank = new Banks();
        try {
            bank = (Banks) em.find(Banks.class, bankId);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception getting bank for Id {0}, message :{1}", new Object[]{bankId, e.getMessage()});
        }
        return bank;
    }
}
