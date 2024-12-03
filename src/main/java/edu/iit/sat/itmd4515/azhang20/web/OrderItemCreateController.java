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
import jakarta.faces.context.FacesContext;

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

    /**
     *Default no-args constructor for OrderItemCreateController
     */
    public OrderItemCreateController() {
    }

    @Inject
    private InventoryService inventoryService;

    private List<Inventory> inventoryList;

    @PostConstruct
    private void postConstruct() {
        LOG.info("Inside OrderItemCreateController.postConstruct()");
        inventoryList = inventoryService.readAll(); // Load inventory options
        loadOrderItems(); // Load existing order items

        // Retrieve `orderItemId` from the request parameters
        String orderItemIdParam = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("orderItemId");

        if (orderItemIdParam != null) {
            orderItemId = Long.valueOf(orderItemIdParam); // Convert parameter to Long
            orderItem = orderItemService.find(orderItemId); // Find the OrderItem by ID

            if (orderItem != null) {
                // Pre-fill form fields with existing OrderItem values
                selectedInventory = orderItem.getInventory();
                quantity = orderItem.getQuantity();
                unitPrice = orderItem.getUnitPrice();
            } else {
                LOG.warning("No OrderItem found with ID: " + orderItemId);
                orderItem = new OrderItem(); // Create new instance if ID not found
            }
        } else {
            orderItem = new OrderItem(); // Create new instance if no ID provided
        }
    }

    /**
     *
     */
    public void loadOrderItems() {
        Customer customer = customerWelcomeController.getCustomer();
        if (customer != null) {
            orderItemsList = orderItemService.findByCustomer(customer);
        }
    }

    /**
     *
     * @param orderItem
     * @return
     */
    public String displayCustomerDetailsPage(OrderItem orderItem) {
        LOG.info("Displaying details for OrderItem: " + orderItem);
        return "/customer/detailOrderItem.xhtml?faces-redirect=true";
    }

    /**
     *
     * @param orderItem
     * @return
     */
    public String displayEditCustomerPage(OrderItem orderItem) {
        LOG.info("Editing OrderItem: " + orderItem);
        this.orderItemId = orderItem.getId(); // Set the ID of the order item being edited
        return "/customer/editOrderItem.xhtml?faces-redirect=true&orderItemId=" + orderItemId;
    }

    /**
     *
     * @param orderItem
     * @return
     */
    public String displayDeleteCustomerPage(OrderItem orderItem) {
        LOG.info("Deleting OrderItem: " + orderItem);
        // Logic to delete the specific order item
        orderItemService.delete(orderItem);
        loadOrderItems(); // Refresh the list after deletion
        return "/customer/welcome.xhtml?faces-redirect=true"; // Adjust this path as needed
    }

    /**
     *
     * @return
     */
    public String goToCreateOrderItemPage() {
        LOG.info("Navigating to createOrderItem page");
        return "/customer/createOrderItem.xhtml?faces-redirect=true";
    }

    // Getters and Setters

    /**
     *
     * @return
     */
    public List<OrderItem> getOrderItemsList() {
        return orderItemsList;
    }

    /**
     *
     * @return
     */
    public OrderItem getOrderItem() {
        return orderItem;
    }

    /**
     *
     * @param orderItem
     */
    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    /**
     *
     * @return
     */
    public Inventory getSelectedInventory() {
        return selectedInventory;
    }

    /**
     *
     * @param selectedInventory
     */
    public void setSelectedInventory(Inventory selectedInventory) {
        this.selectedInventory = selectedInventory;
    }

    /**
     *
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     *
     * @return
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     *
     * @param unitPrice
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     *
     * @return
     */
    public List<Inventory> getInventoryList() {
        return inventoryList;
    }

    /**
     *
     * @return
     */
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

        LOG.info("Customer: " + customer);
        LOG.info("Selected Inventory: " + selectedInventory);
        LOG.info("Quantity: " + quantity);
        LOG.info("Unit Price: " + unitPrice);

        LOG.info("OrderItem created successfully: " + orderItem);
        return "/customer/welcome.xhtml?faces-redirect=true";

    }

    /**
     *
     * @return
     */
    public String editOrderItem() {
        LOG.info("Inside OrderItemCreateController.editOrderItem()");

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

        LOG.info("Customer: " + customer);
        LOG.info("Selected Inventory: " + selectedInventory);
        LOG.info("Quantity: " + quantity);
        LOG.info("Unit Price: " + unitPrice);

        LOG.info("OrderItem created successfully: " + orderItem);
        return "/customer/welcome.xhtml?faces-redirect=true";

    }

    private Long orderItemId; // Holds the ID of the item being edited

    // Getter and Setter for orderItemId

    /**
     *
     * @return
     */
    public Long getOrderItemId() {
        return orderItemId;
    }

    /**
     *
     * @param orderItemId
     */
    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    /**
     *
     * @return
     */
    public String updateOrderItem() {
        LOG.info("Inside OrderItemCreateController.updateOrderItem()");

        // Ensure the order is retrieved or created
        Customer customer = customerWelcomeController.getCustomer();
        OrderManagement order = orderManagementWelcomeController.getOrderManagement();

        // If order is still null, you may need to initialize it here, depending on the logic
        if (order == null) {
            order = new OrderManagement();
            order.setCustomer(customer);
            orderManagementService.create(order);
        }

        orderItem.setOrder(order); // Set the order for the OrderItem
        orderItem.setInventory(selectedInventory);
        orderItem.setQuantity(quantity);
        orderItem.setUnitPrice(unitPrice);
        orderItem.setTotalPrice(quantity * unitPrice);

        orderItemService.update(orderItem); // Update the existing order item in the database
        loadOrderItems(); // Reload the order items to update the list

        LOG.info("OrderItem updated successfully: " + orderItem);
        return "/customer/welcome.xhtml?faces-redirect=true";
    }

}
