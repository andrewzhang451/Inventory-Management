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
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author AndrewZ
 */
@Entity
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

    public Shipping(OrderManagement order, String shippingAddress, String shippingMethod, LocalDate shippingDate, String shippingStatus) {
        this.order = order;
        this.shippingAddress = shippingAddress;
        this.shippingMethod = shippingMethod;
        this.shippingDate = shippingDate;
        this.shippingStatus = shippingStatus;
    }

    public String getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(String shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public OrderManagement getOrder() {
        return order;
    }

    public void setOrder(OrderManagement order) {
        this.order = order;
    }

    public Shipping() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

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
    
    

    public Shipping(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Shipping{" + "id=" + id + ", order=" + order + ", shippingAddress=" + shippingAddress + ", shippingMethod=" + shippingMethod + ", shippingDate=" + shippingDate + ", shippingStatus=" + shippingStatus + '}';
    }

}
