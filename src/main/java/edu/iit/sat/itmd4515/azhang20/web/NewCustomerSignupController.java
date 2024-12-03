/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20.web;

import edu.iit.sat.itmd4515.azhang20.domain.Customer;
import edu.iit.sat.itmd4515.azhang20.security.User;
import edu.iit.sat.itmd4515.azhang20.service.CustomerService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

/**
 *
 * @author AndrewZ
 */
@Named
@RequestScoped
public class NewCustomerSignupController {

    private static final Logger LOG = Logger.getLogger(NewCustomerSignupController.class.getName());

    private Customer customer;
    @EJB
    CustomerService customerSvc;

    /**
     * Get the value of customer
     *
     * @return the value of customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Set the value of customer
     *
     * @param customer new value of customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public NewCustomerSignupController() {
    }

    @PostConstruct
    public void postConstruct() {
        // Initialize model
        customer = new Customer();

        // Initialize the associated user model
        User user = new User();
        customer.setUser(user);

        // Log customer details (after initialization)
        LOG.info("Before new customer signup: " + this.customer.toString());
    }

    //action method
    public String doCustomerSignup() {
        // create new user
        customerSvc.newCustomerSignup(customer);

        //send them to login page to sign in
        //when you do this, make sure it is brand new request
        return "login.xhtml?faces-redirect=true";
    }

}
