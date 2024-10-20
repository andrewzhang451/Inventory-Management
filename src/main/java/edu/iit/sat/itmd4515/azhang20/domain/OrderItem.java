/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import java.util.Objects;

/**
 *
 * @author AndrewZ
 */
@Entity
@NamedQuery(name = "OrderItem.readAll", query = "select o from OrderItem o")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public OrderItem(OrderManagement order, Inventory inventory, int quantity, double unitPrice, double totalPrice) {

        this.order = order;
        this.inventory = inventory;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }

    /**
     * OrderItem is the owning side OrderManagement is the inverse side
     *
     * this is the owning side
     *
     */
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private OrderManagement order;

    @ManyToOne(cascade = CascadeType.PERSIST) // Add CascadeType.PERSIST
    @JoinColumn(name = "inventory_id", nullable = false)
    private Inventory inventory;

    private int quantity;
    private double unitPrice;

    @Column(name = "total_price")
    private double totalPrice;

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public OrderManagement getOrder() {
        return order;
    }

    public void setOrder(OrderManagement order) {
        this.order = order;
    }

    public OrderItem() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final OrderItem other = (OrderItem) obj;

        //if we are using GeneratedValue(), we need one more short circuit
        //if the id is null, return false
        if (this.id == null || other.id == null) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    public OrderItem(OrderManagement order, Inventory inventory, int quantity, double unitPrice) {
        this.order = order;
        this.inventory = inventory;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = quantity * unitPrice;
    }

    public OrderItem(Long id) {
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
        return "OrderItem{" + "id=" + id + ", order=" + order + ", inventory=" + inventory
                + ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", totalPrice=" + totalPrice + '}';
    }

}
