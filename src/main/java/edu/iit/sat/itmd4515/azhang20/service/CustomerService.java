/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20.service;

import edu.iit.sat.itmd4515.azhang20.domain.Customer;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author AndrewZ
 */
@Stateless
public class CustomerService extends AbstractService<Customer>{
    Class<Customer> customerClass = Customer.class;

    public CustomerService() {
        super(Customer.class);
    }
    
    public List<Customer> readAll(){
        return super.readall("Customer.readAll");
    }
    
}
