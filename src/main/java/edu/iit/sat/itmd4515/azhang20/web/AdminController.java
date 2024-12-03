/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20.web;

import edu.iit.sat.itmd4515.azhang20.domain.Customer;
import edu.iit.sat.itmd4515.azhang20.service.CustomerService;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.List;

/**
 *this is a lightweight controller that acts as a middleman between front and back-end
 * @author AndrewZ
 */
@Named
@RequestScoped
public class AdminController {
    @EJB
    private CustomerService customerService;

    /**
     *
     * @return
     */
    public List<Customer> getCustomers() {
        return customerService.readAll();
    }
}
