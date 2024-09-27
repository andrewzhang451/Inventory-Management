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
public class ProductTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Inventory product; // Reference to Inventory entity
    
    private String trackingStatus; //for example: In Transit, Delivered, Delayed
    private LocalDate lastUpdated;
    private String currentLocation;

    public ProductTracking(Inventory product, String trackingStatus, LocalDate lastUpdated, String currentLocation) {
        this.product = product;
        this.trackingStatus = trackingStatus;
        this.lastUpdated = lastUpdated;
        this.currentLocation = currentLocation;
    }

    

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getTrackingStatus() {
        return trackingStatus;
    }

    public void setTrackingStatus(String trackingStatus) {
        this.trackingStatus = trackingStatus;
    }

    public Inventory getProduct() {
        return product;
    }

    public void setProduct(Inventory product) {
        this.product = product;
    }

    public ProductTracking() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final ProductTracking other = (ProductTracking) obj;
        
        //if we are using GeneratedValue(), we need one more short circuit
        //if the id is null, return false
        if( this.id == null || other.id == null ) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
    
    

    public ProductTracking(Long id) {
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
        return "ProductTracking{" + "id=" + id + ", product=" + product + ", trackingStatus=" + trackingStatus + ", lastUpdated=" + lastUpdated + ", currentLocation=" + currentLocation + '}';
    }

    
    
    

}
