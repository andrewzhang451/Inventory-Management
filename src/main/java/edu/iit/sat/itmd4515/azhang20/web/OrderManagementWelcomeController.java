/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20.web;

import edu.iit.sat.itmd4515.azhang20.domain.OrderManagement;
import edu.iit.sat.itmd4515.azhang20.service.OrderManagementService;
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
public class OrderManagementWelcomeController {

    private static final Logger LOG = Logger.getLogger(OrderManagementWelcomeController.class.getName());

    private OrderManagement orderManagement;
    
    @Inject LoginController loginController;
    @EJB OrderManagementService omSvc;

    public OrderManagement getOrderManagement() {
        return orderManagement;
    }

    public void setOrderManagement(OrderManagement orderManagement) {
        this.orderManagement = orderManagement;
    }

    public OrderManagementWelcomeController() {
    }

    @PostConstruct
    private void postConstruct() {
     LOG.info("Inside CustomerWelcomeController.postConstruct with " + loginController.getAuthenticatedUsername());
     orderManagement = omSvc.findByUsername(loginController.getAuthenticatedUsername());
     LOG.info("Inside CustomerWelcomeController.postConstruct with " + orderManagement.toString());
    }

}
