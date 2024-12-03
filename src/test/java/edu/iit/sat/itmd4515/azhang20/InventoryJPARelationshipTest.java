/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20;

import edu.iit.sat.itmd4515.azhang20.domain.Customer;
import edu.iit.sat.itmd4515.azhang20.domain.Inventory;
import edu.iit.sat.itmd4515.azhang20.domain.OrderItem;
import edu.iit.sat.itmd4515.azhang20.domain.OrderManagement;
import edu.iit.sat.itmd4515.azhang20.domain.WindowType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author AndrewZ
 */
public class InventoryJPARelationshipTest extends AbstractJPATest {

    /**
     *
     */
    @BeforeEach
    public void cleanUpTestData() {
        tx.begin();
        // Delete OrderItems
        em.createQuery("DELETE FROM OrderItem").executeUpdate();

        // Delete OrderManagement
        em.createQuery("DELETE FROM OrderManagement").executeUpdate();

        // Delete Inventory
        em.createQuery("DELETE FROM Inventory").executeUpdate();

        // Delete Customers
        em.createQuery("DELETE FROM Customer").executeUpdate();

        tx.commit();
    }
    
    /**
     *
     */
    @Test
    public void uniDirectionalTestCase() {
        // Create test data
        Inventory inventory = new Inventory("Float", LocalDate.of(2024, 2, 2), WindowType.LAMINATED, 200, 800.0);

        Customer customer = new Customer("Alice Johnson", "alice.johnson@example.com", "555-12345",
                "789 Elm St", "Los Angeles", "90001");

        Inventory inventory1 = new Inventory("Window Model A", LocalDate.of(2023, 9, 1), WindowType.OBSCURED, 50, 100.00);
        Inventory inventory2 = new Inventory("Window Model B", LocalDate.of(2023, 10, 5), WindowType.TEMPERED, 30, 200.00);

        // Manually persist the related entities sklafaklsejflskeg
        tx.begin();
        em.persist(inventory);  // Persist the base Inventory
        em.persist(inventory1); // Persist Inventory1
        em.persist(inventory2); // Persist Inventory2
        em.persist(customer);   // Persist Customer
        tx.commit();

        // creating the OrderItems and OrderManagement
        List<OrderItem> orderItems = new ArrayList<>();
        OrderManagement om = new OrderManagement(customer, LocalDate.now(), "Delayed", 400.0, orderItems);

        OrderItem orderItem1 = new OrderItem(om, inventory1, 2, 100.00);
        OrderItem orderItem2 = new OrderItem(om, inventory2, 1, 200.00);

        // Add the order items to the list in OrderManagement
        orderItems.add(orderItem1);
        orderItems.add(orderItem2);

        // Persist the OrderManagement and related OrderItems
        tx.begin();
        em.persist(om);
        tx.commit();
        
         
    }

    /**
     *
     */
    @Test
    public void biDirectionalTestCase() {
        // this create Inventory and Customer data :)
        Inventory inventory = new Inventory("Window Model C", LocalDate.of(2024, 1, 15), WindowType.TEMPERED, 50, 120.00);
        Customer customer = new Customer("John Smith", "john.smith@example.com", "555-54321",
                "123 Maple St", "Chicago", "60601");

        // Manually persist Inventory and Customer before persisting OrderItem and OrderManagement
        tx.begin();
        em.persist(inventory);  // Persist the Inventory
        em.persist(customer);   // Persist the Customer
        tx.commit();

        // this create OrderItem and OrderManagement
        List<OrderItem> orderItems = new ArrayList<>();
        OrderManagement om = new OrderManagement(customer, LocalDate.now(), "Confirmed", 360.0, orderItems);

        OrderItem orderItem = new OrderItem(om, inventory, 3, 120.00); // Link to OrderManagement

        // Add the order item to the list in OrderManagement
        orderItems.add(orderItem);

        // Persist the OrderManagement and OrderItem
        tx.begin();
        em.persist(om); // OrderItems are cascaded
        tx.commit();
    }
    
    

}
