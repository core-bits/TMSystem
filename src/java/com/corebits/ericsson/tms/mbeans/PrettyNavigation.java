/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corebits.ericsson.tms.mbeans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Tommy
 */
@Named(value = "pretty")
@RequestScoped
public class PrettyNavigation {

    public PrettyNavigation() {
    }
    
    public String registrationPage(){
        return "pretty:newmember";
    }
    
    public String newuserPage(){
        return "pretty:createuser";
    }
}
