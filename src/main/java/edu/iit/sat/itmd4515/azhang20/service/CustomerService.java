/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20.service;

import edu.iit.sat.itmd4515.azhang20.domain.Customer;
import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import java.util.List;

/**
 *
 * @author AndrewZ
 */

@Named
@Stateless
public class CustomerService extends AbstractService<Customer>{

    /**
     *
     */
    public CustomerService() {
        super(Customer.class);
    }
    
    /**
     *
     * @return
     */
    public List<Customer> readAll(){
        return super.readAll("Customer.readAll");
    }
    
}
