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
import edu.iit.sat.itmd4515.azhang20.security.Group;
import edu.iit.sat.itmd4515.azhang20.security.GroupService;
import edu.iit.sat.itmd4515.azhang20.security.User;
import edu.iit.sat.itmd4515.azhang20.security.UserService;
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
    
//    security realm services
    @EJB UserService userSvc;
    @EJB GroupService groupSvc;

    /**
     *
     */
    public StartupServiceInitDB() {

    }

    // MAKE SURE TO CREATE NON-OWNING ENTITIES FIRST AND THEN CREATE YOUR OWNING ENTITIES

    /**
     *
     */
    @PostConstruct
    public void postConstruct() {
        LOG.info("Inside StartupServiceInitDB.postConstruct()");
        
        //security realm initialization
        Group ownerGroup = new Group("OWNER_GROUP","Group of pet owners");
        Group customerGroup = new Group("CUSTOMER_GROUP","Group of customers");
        Group sellerGroup = new Group("SELLER_GROUP", "Group of sellers");
        Group adminGroup = new Group("ADMIN_GROUP", "Group of admins");
        
        groupSvc.create(ownerGroup);
        groupSvc.create(customerGroup);
        groupSvc.create(sellerGroup);
        groupSvc.create(adminGroup);

        User customer1 = new User("customer1", "customer1");
        customer1.addGroup(customerGroup);
        User customer2 = new User("customer2", "customer2");
        customer2.addGroup(customerGroup);
        User customer3 = new User("customer3", "customer3");
        customer3.addGroup(customerGroup);
        
        User owner1 = new User("owner1", "owner1");
        owner1.addGroup(ownerGroup);
        User owner2 = new User("owner2", "owner2");
        owner2.addGroup(ownerGroup);
        User owner3 = new User("owner3", "owner3");
        owner3.addGroup(ownerGroup);
        
        User admin = new User("admin", "admin");
        admin.addGroup(adminGroup);
        
        User sellerGroup1 = new User("sellerGroup1", "sellerGroup1");
        sellerGroup1.addGroup(sellerGroup);
        User sellerGroup2 = new User("sellerGroup2", "sellerGroup2");
        sellerGroup2.addGroup(sellerGroup);
        User sellerGroup3 = new User("sellerGroup3", "sellerGroup3");
        sellerGroup3.addGroup(sellerGroup);
        
        userSvc.create(customer1);
        userSvc.create(customer2);
        userSvc.create(customer3);
        userSvc.create(owner1);
        userSvc.create(owner2);
        userSvc.create(owner3);
        userSvc.create(admin);
        userSvc.create(sellerGroup1);
        userSvc.create(sellerGroup2);
        userSvc.create(sellerGroup3);
        
        
        // NONE OWNING ENTITIES
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

        // OWNING ENTITIES
        OrderManagement om1 = new OrderManagement(cust3, LocalDate.of(2023, 5, 10), "Pending", 150.75, new ArrayList<>());
        OrderManagement om2 = new OrderManagement(cust2, LocalDate.of(2023, 5, 10), "Pending", 150.75, new ArrayList<>());
        OrderManagement om3 = new OrderManagement(cust1, LocalDate.of(2023, 5, 10), "Pending", 150.75, new ArrayList<>());

        OrderItem oi1 = new OrderItem(om1, inv3, 2, 160.50);
        OrderItem oi2 = new OrderItem(om2, inv2, 2, 160.50);
        OrderItem oi3 = new OrderItem(om3, inv1, 2, 160.50);

        om1.getOrderItems().add(oi1);
        om2.getOrderItems().add(oi2);
        om3.getOrderItems().add(oi3);

        om1.setOrderStatus("Shipped");
        om2.setOrderStatus("Processing");
        om3.setOrderStatus("Delivered");

        orderMSvc.create(om1);
        orderMSvc.create(om2);
        orderMSvc.create(om3);

        orderISvc.create(oi1);
        orderISvc.create(oi2);
        orderISvc.create(oi3);

        // SHIPPING
        Shipping sh1 = new Shipping(om1, "23 W SunnySide, Sanfrancisco, 82512", "Ground", LocalDate.of(2023, 5, 11), "Shipped");
        Shipping sh2 = new Shipping(om2, "58 N Walkbash, New York City, 10101", "Air", LocalDate.of(2023, 5, 12), "In Transit");
        Shipping sh3 = new Shipping(om3, "74 S Emerald, Kansas City, 31474", "Sea", LocalDate.of(2023, 5, 13), "Delivered");

        shipSvc.create(sh1);
        shipSvc.create(sh2);
        shipSvc.create(sh3);

        // EXAMPLE: Adding and canceling an order item
        OrderManagement order = new OrderManagement(cust1, LocalDate.now(), "Pending", 100.0, new ArrayList<>());
        OrderItem item = new OrderItem(order, inv1, 2, 50.0);
        order.addOrderItem(item);
        order.cancelOrderItem(item);

        // Move all logging to the bottom
        LOG.info("========== LOGGING ENTITIES AND THEIR RELATIONSHIPS ==========");

        // Log warehouse details
        LOG.info("---------------------------------------------------------------"); 
        LOG.info("Warehouses created: ");
        LOG.info("Warehouse 1: " + w1.toString());
        LOG.info("Warehouse 2: " + w2.toString());
        LOG.info("Warehouse 3: " + w3.toString());

        // Log customer details
        LOG.info("---------------------------------------------------------------"); 
        LOG.info("Customers created: ");
        LOG.info("Customer 1: " + cust1.toString());
        LOG.info("Customer 2: " + cust2.toString());
        LOG.info("Customer 3: " + cust3.toString());

        // Log inventory details
        LOG.info("---------------------------------------------------------------"); 
        LOG.info("Inventories created: ");
        LOG.info("Inventory 1: " + inv1.toString());
        LOG.info("Inventory 2: " + inv2.toString());
        LOG.info("Inventory 3: " + inv3.toString());

        // Log order details
        LOG.info("---------------------------------------------------------------"); 
        LOG.info("Orders created: ");
        LOG.info("Order 1: " + om1.toString());
        LOG.info("Order 2: " + om2.toString());
        LOG.info("Order 3: " + om3.toString());

        // Log order items
        LOG.info("---------------------------------------------------------------"); 
        LOG.info("Order Items for Order 1: " + om1.getOrderItems().toString());
        LOG.info("Order Items for Order 2: " + om2.getOrderItems().toString());
        LOG.info("Order Items for Order 3: " + om3.getOrderItems().toString());

        // Log shipping details
        LOG.info("---------------------------------------------------------------"); 
        LOG.info("Shipping created: ");
        LOG.info("Shipping 1: " + sh1.toString());
        LOG.info("Shipping 2: " + sh2.toString());
        LOG.info("Shipping 3: " + sh3.toString());

        // Log relationships (Order -> Shipping)
        LOG.info("---------------------------------------------------------------"); 
        LOG.info("Order 1 Shipping: " + sh1.getOrder().toString());
        LOG.info("Order 2 Shipping: " + sh2.getOrder().toString());
        LOG.info("Order 3 Shipping: " + sh3.getOrder().toString());

        // Log order item added and canceled
        LOG.info("---------------------------------------------------------------"); 
        LOG.info("Added OrderItem: " + item.toString());
        LOG.info("Canceled OrderItem: " + item.toString());
    }

}
