package edu.iit.sat.itmd4515.azhang20.web;

import edu.iit.sat.itmd4515.azhang20.security.User;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.security.enterprise.AuthenticationStatus;
import jakarta.security.enterprise.SecurityContext;
import jakarta.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.Password;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AndrewZ
 */

@Named
@RequestScoped
public class LoginController {

    private static final Logger LOG = Logger.getLogger(LoginController.class.getName());

    @Inject FacesContext facesContext;
    @Inject SecurityContext securityContext;
    
    // Declare the 'user' property
    private User user;    
    
    // Constructor to initialize 'user'
    public LoginController() {
        this.user = new User(); // Initialize 'user' properly
    }

    // Getter for 'user' to allow access in login.xhtml
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    //helper method
    public String getAuthenticatedUsername(){
        return securityContext.getCallerPrincipal().getName();
    }
    
    public boolean isCustomer(){
        return securityContext.isCallerInRole("CUSTOMER_ROLE");
    }
    
    public boolean isSeller(){
        return securityContext.isCallerInRole("SELLER_ROLE");
    }
    
    public boolean isAdmin(){
        return securityContext.isCallerInRole("ADMIN_ROLE");
    }
    
    
    // Login method
    public String doLogin(){
        
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
        Credential cred = new UsernamePasswordCredential(this.user.getUsername(), new Password(this.user.getPassword()));
        
        AuthenticationStatus status = securityContext.authenticate(request, response, AuthenticationParameters.withParams().credential(cred));
        
        switch(status){
            case SUCCESS:
                LOG.info(status.toString());
                break;
            case SEND_FAILURE:
                LOG.info("FAILURE! " + status.toString());
                return "/error.xhtml";
            case NOT_DONE:
                LOG.info("FAILURE! " + status.toString());
                return "/error.xhtml";
            case SEND_CONTINUE:
                LOG.info(status.toString());
                break;
              
    }
        
        return "/welcome.xhtml?faces-redirect=true";
    }

    // Logout method
    public String doLogout(){
        
        LOG.info("LoginController.doLogout()");
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        try {
            request.logout();
        } catch (ServletException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        
        return "/login.xhtml"; 
    }

    // PostConstruct method
    @PostConstruct
    private void postConstructor(){
        LOG.info("Inside LoginController.postConstruct()");
    }
        
}
