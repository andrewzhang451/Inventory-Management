/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20.domain;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author AndrewZ
 */
@Entity
@NamedQuery(name = "OrderManagement.readAll", query = "select oM from OrderManagement oM")
@NamedQuery(name = "OrderManagement.findByUsername", query = "select oM from OrderManagement oM where oM.customer.user.username = :uname")


//@NamedQuery(name = "OrderManagement.findByUsername", query = "select oM from OrderManagement oM where oM.user.username = :uname")
public class OrderManagement {

   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST) // Add CascadeType.PERSIST
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    private LocalDate orderDate;
    private String orderStatus;
    private Double totalAmount;

    /**
     * OrderItem is the owning side OrderManagement is the inverse side
     *
     * this is the inverse side
     *
     */
    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
    private List<OrderItem> orderItems;

    /**
     *
     * @param customer
     * @param orderDate
     * @param orderStatus
     * @param totalAmount
     * @param orderItems
     */
    public OrderManagement(Customer customer, LocalDate orderDate, String orderStatus, Double totalAmount, List<OrderItem> orderItems) {
        this.customer = customer;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.totalAmount = totalAmount;
        this.orderItems = orderItems;
    }
    
    /**
     *
     * @param item
     */
    public void addOrderItem(OrderItem item){
        if(!this.orderItems.contains(item)){
            this.orderItems.add(item);
            item.setOrder(this);
        }
    }
    
    /**
     *
     * @param item
     */
    public void cancelOrderItem(OrderItem item) {
        if(!this.orderItems.contains(item)) {
            this.orderItems.remove(item);
            item.setOrder(null);
        } 
        
    }

    /**
     *
     * @return
     */
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    /**
     *
     * @param orderItems
     */
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    /**
     *
     * @return
     */
    public Double getTotalAmount() {
        return totalAmount;
    }

    /**
     *
     * @param totalAmount
     */
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     *
     * @return
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     *
     * @param orderStatus
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     *
     * @return
     */
    public LocalDate getOrderDate() {
        return orderDate;
    }

    /**
     *
     * @param orderDate
     */
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    /**
     *
     * @return
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     *
     * @param customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     *
     */
    public OrderManagement() {
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderManagement other = (OrderManagement) obj;

        //if we are using GeneratedValue(), we need one more short circuit
        //if the id is null, return false
        if (this.id == null || other.id == null) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    /**
     *
     * @param id
     */
    public OrderManagement(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "OrderManagement{" + "id=" + id + ", customer=" + customer + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus + ", totalAmount=" + totalAmount + '}';
    }
}
