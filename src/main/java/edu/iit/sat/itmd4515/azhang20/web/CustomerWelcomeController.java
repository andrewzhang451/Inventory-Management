/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20.web;

import edu.iit.sat.itmd4515.azhang20.domain.Customer;
import edu.iit.sat.itmd4515.azhang20.service.CustomerService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.logging.Logger;

/**
 *
 * @author AndrewZ
 */
@Named
@RequestScoped
public class CustomerWelcomeController {

    private static final Logger LOG = Logger.getLogger(CustomerWelcomeController.class.getName());

        private Customer customer;

        @Inject LoginController loginController;
        @EJB CustomerService customerSvc;
        
        
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

    
    public CustomerWelcomeController() {
    }
    
    @PostConstruct
    private void postConstruct(){
        LOG.info("Inside CustomerWelcomeController.postConstruct with " + loginController.getAuthenticatedUsername());
        customer = customerSvc.findByUsername(loginController.getAuthenticatedUsername());
        LOG.info("Inside CustomerWelcomeController.postConstruct with " + customer.toString() );
    }
    
}
