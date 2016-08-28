/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corebits.ericsson.tms.mbeans;

import com.corebits.ericsson.tms.controllers.ConfigurationController;
import com.corebits.ericsson.tms.models.Banks;
import com.corebits.ericsson.tms.models.BuisnessUnit;
import com.corebits.ericsson.tms.models.Department;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Tommy
 */
@Named(value = "config")
@RequestScoped
public class ConfiguartionMbeans {

    @Inject
    ConfigurationController cc;

    public ConfiguartionMbeans() {
    }

    public List<BuisnessUnit> getBuisnessUnits() {
        return cc.getBuisnessUnits();
    }

    public List<Department> getDepartments() {
        return cc.getDepartments();
    }
    
    public List<Banks> getBanks() {
        return cc.getBanks();
    }
}
