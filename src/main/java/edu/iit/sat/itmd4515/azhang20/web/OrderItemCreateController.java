/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20.web;

import edu.iit.sat.itmd4515.azhang20.domain.Customer;
import edu.iit.sat.itmd4515.azhang20.domain.Inventory;
import edu.iit.sat.itmd4515.azhang20.domain.OrderItem;
import edu.iit.sat.itmd4515.azhang20.domain.OrderManagement;
import edu.iit.sat.itmd4515.azhang20.service.InventoryService;
import edu.iit.sat.itmd4515.azhang20.service.OrderManagementService;
import edu.iit.sat.itmd4515.azhang20.service.OrderItemService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/**
 * OrderItemCreateController handles creating new OrderItem instances and
 * linking them to an existing order for a customer.
 *
 */
@Named
@RequestScoped
public class OrderItemCreateController {

    private static final Logger LOG = Logger.getLogger(OrderItemCreateController.class.getName());

    private OrderItem orderItem;
    private Inventory selectedInventory;
    private int quantity;
    private double unitPrice;
    private List<OrderItem> orderItemsList; // Add this property

    @Inject
    CustomerWelcomeController customerWelcomeController;
    @Inject
    OrderManagementWelcomeController orderManagementWelcomeController;

    @EJB
    OrderItemService orderItemService;
    @EJB
    OrderManagementService orderManagementService;

    public OrderItemCreateController() {
    }

    @Inject
    private InventoryService inventoryService;

    private List<Inventory> inventoryList;

    @PostConstruct
    private void postConstruct() {
        LOG.info("Inside OrderItemCreateController.postConstruct()");
        orderItem = new OrderItem();
        inventoryList = inventoryService.readAll();
        loadOrderItems(); // Load the order items for the logged-in customer
    }

    public void loadOrderItems() {
        Customer customer = customerWelcomeController.getCustomer();
        if (customer != null) {
            orderItemsList = orderItemService.findByCustomer(customer);
        }
    }

    public String displayCustomerDetailsPage(OrderItem orderItem) {
        LOG.info("Displaying details for OrderItem: " + orderItem);
        return "/customer/detailOrderItem.xhtml?faces-redirect=true";
    }

    public String displayEditCustomerPage(OrderItem orderItem) {
        LOG.info("Editing OrderItem: " + orderItem);
        return "/customer/editOrderItem.xhtml?faces-redirect=true";
    }

    public String displayDeleteCustomerPage(OrderItem orderItem) {
        LOG.info("Deleting OrderItem: " + orderItem);
        // Logic to delete the specific order item
        orderItemService.delete(orderItem);
        loadOrderItems(); // Refresh the list after deletion
        return "/customer/welcome.xhtml?faces-redirect=true"; // Adjust this path as needed
    }

    public String goToCreateOrderItemPage() {
        LOG.info("Navigating to createOrderItem page");
        return "/customer/createOrderItem.xhtml?faces-redirect=true";
    }

    // Getters and Setters
    public List<OrderItem> getOrderItemsList() {
        return orderItemsList;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public Inventory getSelectedInventory() {
        return selectedInventory;
    }

    public void setSelectedInventory(Inventory selectedInventory) {
        this.selectedInventory = selectedInventory;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public List<Inventory> getInventoryList() {
        return inventoryList;
    }

    public String createOrderItem() {
        LOG.info("Inside OrderItemCreateController.createOrderItem()");

        Customer customer = customerWelcomeController.getCustomer();
        OrderManagement order = orderManagementWelcomeController.getOrderManagement();

        if (order == null) {
            order = new OrderManagement();
            order.setCustomer(customer);
            orderManagementService.create(order);
        }

        orderItem.setOrder(order);
        orderItem.setInventory(selectedInventory);
        orderItem.setQuantity(quantity);
        orderItem.setUnitPrice(unitPrice);
        orderItem.setTotalPrice(quantity * unitPrice);

        orderItemService.create(orderItem);
        loadOrderItems(); // Reload the order items to update the list

        LOG.info("OrderItem created successfully: " + orderItem);
        return "/customer/welcome.xhtml?faces-redirect=true";

    }
}
