/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author AndrewZ
 */
@Entity
@NamedQuery(name = "Shipping.readAll", query = "select s from Shipping s") 
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private OrderManagement order; // Reference to OrderManagement entity
    private String shippingAddress;
    private String shippingMethod;
    private LocalDate shippingDate;
    private String shippingStatus; //For example: Shipped, In Transit, Delivered

    /**
     *
     * @param order
     * @param shippingAddress
     * @param shippingMethod
     * @param shippingDate
     * @param shippingStatus
     */
    public Shipping(OrderManagement order, String shippingAddress, String shippingMethod, LocalDate shippingDate, String shippingStatus) {
        this.order = order;
        this.shippingAddress = shippingAddress;
        this.shippingMethod = shippingMethod;
        this.shippingDate = shippingDate;
        this.shippingStatus = shippingStatus;
    }

    /**
     *
     * @return
     */
    public String getShippingStatus() {
        return shippingStatus;
    }

    /**
     *
     * @param shippingStatus
     */
    public void setShippingStatus(String shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    /**
     *
     * @return
     */
    public LocalDate getShippingDate() {
        return shippingDate;
    }

    /**
     *
     * @param shippingDate
     */
    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }

    /**
     *
     * @return
     */
    public String getShippingMethod() {
        return shippingMethod;
    }

    /**
     *
     * @param shippingMethod
     */
    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    /**
     *
     * @return
     */
    public String getShippingAddress() {
        return shippingAddress;
    }

    /**
     *
     * @param shippingAddress
     */
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    /**
     *
     * @return
     */
    public OrderManagement getOrder() {
        return order;
    }

    /**
     *
     * @param order
     */
    public void setOrder(OrderManagement order) {
        this.order = order;
    }

    /**
     *
     */
    public Shipping() {
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Shipping other = (Shipping) obj;
        
        //if we are using GeneratedValue(), we need one more short circuit
        //if the id is null, return false
        if( this.id == null || other.id == null ) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
    
    /**
     *
     * @param id
     */
    public Shipping(Long id) {
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
        return "Shipping{" + "id=" + id + ", order=" + order + ", shippingAddress=" + shippingAddress + ", shippingMethod=" + shippingMethod + ", shippingDate=" + shippingDate + ", shippingStatus=" + shippingStatus + '}';
    }

}
