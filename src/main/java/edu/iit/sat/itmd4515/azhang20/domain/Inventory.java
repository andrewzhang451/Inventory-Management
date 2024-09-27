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
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "inventory")
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

    public Inventory() {
    }

    public Inventory(String name, LocalDate productionDate, WindowType type, int quantity, double pricePerUnit) {
        this.name = name;
        this.productionDate = productionDate;
        this.type = type;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }    


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "Inventory{" + 
                "id=" + id + 
                ", name=" + name + 
                ", productionDate=" + productionDate + 
                ", type=" + type + 
                ", quantity=" + quantity + 
                ", pricePerUnit=" + pricePerUnit + 
                '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Inventory other = (Inventory) obj;
        
        //if we are using GeneratedValue(), we need one more short circuit
        //if the id is null, return false
        if( this.id == null || other.id == null ) {
            return false;
        }
        
        return Objects.equals(this.id, other.id);
    }

  
    public WindowType getType() {
        return type;
    }

    public void setType(WindowType type) {
        this.type = type;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }


}
