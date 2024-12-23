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
public class CustomerCreateCustomerController {
    
    @EJB CustomerService custSvc;
    @Inject CustomerWelcomeController cwc; 
    

    private static final Logger LOG = Logger.getLogger(CustomerCreateCustomerController.class.getName());

    // no persistence context so this is just a POJO
    private Customer customer;

    /**
     *
     */
    public CustomerCreateCustomerController() {
    }

    @PostConstruct
    private void postConstructor() {
        LOG.info("Inside customerController.postConstruct()");
        
        customer = new Customer();
    }

    /**
     *
     * @return
     */
    public String saveCustomer(){
        LOG.info("Inside customerControllser.savePet() before call to service: " + customer.toString());
        custSvc.create(customer); 
//        custSvc.createCustomerForAuthenticatedCustomer(customer, cwc.getCustomer());
        LOG.info("Inside customerControllser.savePet() after call to service: " + customer.toString());
        
        return "createCustomerConfirmation.xhtml";
        
    }
    
    /**
     *
     * @return
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     *
     * @param customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
