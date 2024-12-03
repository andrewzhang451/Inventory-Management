/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20.service;

import edu.iit.sat.itmd4515.azhang20.domain.Customer;
import edu.iit.sat.itmd4515.azhang20.security.Group;
import edu.iit.sat.itmd4515.azhang20.security.User;
import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import java.util.List;

/**
 *
 * @author AndrewZ
 */
@Named
@Stateless
public class CustomerService extends AbstractService<Customer> {

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
    public List<Customer> readAll() {
        return super.readAll("Customer.readAll");
    }

    /**
     *
     * @param uname
     * @return
     */
    public Customer findByUsername(String uname) {
        return em.createNamedQuery("Customer.findByUsername", Customer.class).setParameter("uname", uname).getSingleResult();
    }

//    public void createCustomerForAuthenticatedCustomer(Customer customer, Customer customer0) {
//        em.persist(customer);
//        
//        Customer customerRef = em.getReference(Customer.class, customer.getId());
//        customerRef.addCustomer
//    }
    public void newCustomerSignup(Customer c) {
        // Create non-owning entities first (Group and User)
        Group customerGroup = em.createQuery("select g from Group g where g.groupName = 'CUSTOMER_GROUP'", Group.class).getSingleResult();
        User newCustomerUser = c.getUser(); // Retrieve the User object from the Customer

        // Add the User to the Customer Group
        newCustomerUser.addGroup(customerGroup);

        // Persist the User
        em.persist(newCustomerUser);

        // Associate the User with the Customer and persist the Customer
        c.setUser(newCustomerUser);
        em.persist(c);
    }

}
