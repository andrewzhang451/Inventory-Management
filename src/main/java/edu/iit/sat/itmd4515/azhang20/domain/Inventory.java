/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author AndrewZ
 */
@Entity
@Table(name = "inventory")
@NamedQuery(name = "Inventory.readAll", query = "select i from Inventory i")
//@NamedQuery(name = "Inventory.findByUsername", query = "select i from Inventory i where i.user.username = :uname")

public class Inventory {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Column(nullable = false, name = "window_name")
    private String name;
    
    @PastOrPresent
    private LocalDate productionDate;
    
    @Enumerated(EnumType.STRING)
    private WindowType type;

    private int quantity;
    
    @Column(name = "price_per_unit")
    private double pricePerUnit;

    @OneToMany(mappedBy = "inventory")
    private List<OrderItem> orderItems; // One inventory item can be referenced in many OrderItems
    
    /**
     *
     */
    public Inventory() {
    }

    /**
     *
     * @param name
     * @param productionDate
     * @param type
     * @param quantity
     * @param pricePerUnit
     */
    public Inventory(String name, LocalDate productionDate, WindowType type, int quantity, double pricePerUnit) {
        this.name = name;
        this.productionDate = productionDate;
        this.type = type;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        
    }    

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
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
        return "Inventory{" + "id=" + id + ", name=" + name + ", productionDate=" + productionDate + ", type=" + type + ", quantity=" + quantity + ", pricePerUnit=" + pricePerUnit + ", orderItems=" + orderItems + '}';
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Inventory other = (Inventory) obj;
        
        //if we are using GeneratedValue(), we need one more short circuit
        //if the id is null, return false
        if( this.id == null || other.id == null ) {
            return false;
        }
        
        return Objects.equals(this.id, other.id);
    }

    /**
     *
     * @return
     */
    public WindowType getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(WindowType type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    public LocalDate getProductionDate() {
        return productionDate;
    }

    /**
     *
     * @param productionDate
     */
    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }
    
    
    
}
