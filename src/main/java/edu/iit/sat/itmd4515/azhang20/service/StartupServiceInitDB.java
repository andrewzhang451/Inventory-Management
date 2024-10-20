/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20.service;

import edu.iit.sat.itmd4515.azhang20.domain.Customer;
import edu.iit.sat.itmd4515.azhang20.domain.Inventory;
import edu.iit.sat.itmd4515.azhang20.domain.OrderItem;
import edu.iit.sat.itmd4515.azhang20.domain.OrderManagement;
import edu.iit.sat.itmd4515.azhang20.domain.Shipping;
import edu.iit.sat.itmd4515.azhang20.domain.WarehouseManagement;
import edu.iit.sat.itmd4515.azhang20.domain.WindowType;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author AndrewZ
 */
@Startup
@Singleton
public class StartupServiceInitDB {

    private static final Logger LOG = Logger.getLogger(StartupServiceInitDB.class.getName());

    @EJB WarehouseManagementService wareSvc;
    @EJB CustomerService custSvc;
    @EJB InventoryService invSvc;
    @EJB OrderManagementService orderMSvc;
    @EJB OrderItemService orderISvc;
    @EJB ShippingService shipSvc;

    public StartupServiceInitDB() {

    }

    // MAKE SURE TO CREATE NON-OWNING ENTITIES FIRST AND THEN CREATE YOUR OWNING ENTITIES
    @PostConstruct
    public void postConstruct() {
        LOG.info("Inside StartupServiceInitDB.postConstruct()");

        // Creating non-owning entities first
        WarehouseManagement w1 = new WarehouseManagement("Amazon Warehouse", "Chicago, IL", 2, 998);
        WarehouseManagement w2 = new WarehouseManagement("Amazon Warehouse", "Chicago, IL", 3, 995);
        WarehouseManagement w3 = new WarehouseManagement("Amazon Warehouse", "Chicago, IL", 4, 991);

        wareSvc.create(w1);
        wareSvc.create(w2);
        wareSvc.create(w3);

        Customer cust1 = new Customer("Jim", "Jm20@gmail.com", "9876543212", "74 S Emerald", "Kansas City", "31474");
        Customer cust2 = new Customer("Tom", "Tm78@gmail.com", "4828602715", "58 N Walkbash", "New York City", "10101");
        Customer cust3 = new Customer("George", "George@gmail.com", "4412485728", "23 W SunnySide", "Sanfrancisco", "82512");

        custSvc.create(cust1);
        custSvc.create(cust2);
        custSvc.create(cust3);

        Inventory inv1 = new Inventory("Window Model A", LocalDate.of(2023, 5, 10), WindowType.FLOAT, 100, 150.75);
        Inventory inv2 = new Inventory("Window Model B", LocalDate.of(2023, 2, 20), WindowType.LOW_E, 99, 200.10);
        Inventory inv3 = new Inventory("Window Model C", LocalDate.of(2022, 9, 06), WindowType.LAMINATED, 98, 125.25);

        invSvc.create(inv1);
        invSvc.create(inv2);
        invSvc.create(inv3);

        // Create OrderManagement objects with an initial status and empty list of OrderItems
        OrderManagement om1 = new OrderManagement(cust3, LocalDate.of(2023, 5, 10), "Pending", 150.75, new ArrayList<>());
        OrderManagement om2 = new OrderManagement(cust2, LocalDate.of(2023, 5, 10), "Pending", 150.75, new ArrayList<>());
        OrderManagement om3 = new OrderManagement(cust1, LocalDate.of(2023, 5, 10), "Pending", 150.75, new ArrayList<>());

        // Now create OrderItems using the instantiated OrderManagement objects
        OrderItem oi1 = new OrderItem(om1, inv3, 2, 160.50);
        OrderItem oi2 = new OrderItem(om2, inv2, 2, 160.50);
        OrderItem oi3 = new OrderItem(om3, inv1, 2, 160.50);

        // Add OrderItems to the corresponding OrderManagement objects
        om1.getOrderItems().add(oi1);  // Add OrderItem oi1 to om1
        om2.getOrderItems().add(oi2);  // Add OrderItem oi2 to om2
        om3.getOrderItems().add(oi3);  // Add OrderItem oi3 to om3

        // Set a different status using the setter after creation
        om1.setOrderStatus("Shipped");
        om2.setOrderStatus("Processing");
        om3.setOrderStatus("Delivered");

        // Save the OrderManagement objects
        orderMSvc.create(om1);  // Save OrderManagement om1
        orderMSvc.create(om2);  // Save OrderManagement om2
        orderMSvc.create(om3);  // Save OrderManagement om3

        // Save the OrderItem objects
        orderISvc.create(oi1);  // Save individual OrderItems
        orderISvc.create(oi2);
        orderISvc.create(oi3);

        // Shipping Instantiation and saving
        Shipping sh1 = new Shipping(om1, "23 W SunnySide, Sanfrancisco, 82512", "Ground", LocalDate.of(2023, 5, 11), "Shipped");
        Shipping sh2 = new Shipping(om2, "58 N Walkbash, New York City, 10101", "Air", LocalDate.of(2023, 5, 12), "In Transit");
        Shipping sh3 = new Shipping(om3, "74 S Emerald, Kansas City, 31474", "Sea", LocalDate.of(2023, 5, 13), "Delivered");

        // Save the Shipping objects
        shipSvc.create(sh1);
        shipSvc.create(sh2);
        shipSvc.create(sh3);
    }

}
