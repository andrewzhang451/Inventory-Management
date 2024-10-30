/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import java.util.Objects;

/**
 *
 * @author AndrewZ
 */
@Entity
@NamedQuery(name = "WarehouseManagement.readAll", query = "select w from WarehouseManagement w")
public class WarehouseManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String warehouseName;
    private String location;
    private int capacity;
    private int currentStockLevel;

    /**
     *
     * @param warehouseName
     * @param location
     * @param capacity
     * @param currentStockLevel
     */
    public WarehouseManagement(String warehouseName, String location, int capacity, int currentStockLevel) {

        this.warehouseName = warehouseName;
        this.location = location;
        this.capacity = capacity;
        this.currentStockLevel = currentStockLevel;
    }

    /**
     *
     * @return
     */
    public int getCurrentStockLevel() {
        return currentStockLevel;
    }

    /**
     *
     * @param currentStockLevel
     */
    public void setCurrentStockLevel(int currentStockLevel) {
        this.currentStockLevel = currentStockLevel;
    }

    /**
     *
     * @return
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     *
     * @param capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     *
     * @return
     */
    public String getLocation() {
        return location;
    }

    /**
     *
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     *
     * @return
     */
    public String getWarehouseName() {
        return warehouseName;
    }

    /**
     *
     * @param warehouseName
     */
    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    /**
     *
     */
    public WarehouseManagement() {
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final WarehouseManagement other = (WarehouseManagement) obj;
        
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
    public WarehouseManagement(Long id) {
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
        return "WarehouseManagement{" + "id=" + id + ", warehouseName=" + warehouseName + ", location=" + location + ", capacity=" + capacity + ", currentStockLevel=" + currentStockLevel + '}';
    }
    
    

}
