package com.corebits.ericsson.tms.mbeans;

import com.corebits.ericsson.tms.controllers.AuthenticationController;
import com.corebits.ericsson.tms.models.User;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Tommy
 */
@Named(value = "authenticate")
@RequestScoped
public class Authenticate implements Serializable {

    @Inject
    AuthenticationController ac;

    private String loginId;
    private String userpassword;

    String userName;
    String password;
    User appUser;

    public Authenticate() {
    }

    public String createUser() {
        FacesMessage message;
        User u = new User();
        Map<String, Object> params = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        try {
            String fullname = (String) params.get("memberName");
            String useremail = (String) params.get("email");
            u.setUserName(fullname);
            u.setDateCreated(new Date());
            u.setFirstLoginStatus(Boolean.TRUE);
            u.setUserStatus(Boolean.TRUE);
            u.setUserEmail(useremail);
            u.setUserLoginId(loginId);
            u.setUserLoginPassword(userpassword);
            ac.persist(u);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "New User", "Completed successfully");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "New User", "Completed successfully");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return "pretty:createuser";
        }
        return "pretty:authenticate";
    }

    public String login() {
        System.out.println("login....");
        System.out.println("User :"+userName+", Password :"+password);
        FacesMessage message;
        User login = ac.login(userName, password);
        if (login != null) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Authentication", "Completed successfully");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Authentication", "Invalid login Id or Password");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return "pretty:authenticate";
        }
        return "pretty:dashboard";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getAppUser() {
        return appUser;
    }

    public void setAppUser(User appUser) {
        this.appUser = appUser;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

}
