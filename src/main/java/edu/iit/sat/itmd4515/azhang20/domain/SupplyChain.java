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
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author AndrewZ
 */
@Entity
@NamedQuery(name = "SupplyChain.readAll", query = "select sC from SupplyChain sC")
public class SupplyChain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long supplierId;// Reference to Supplier entity
    private String supplyStatus;// e.g., Pending, Delivered
    private LocalDate expectedDeliveryDate;
    private LocalDate actualDeliveryDate;

    /**
     *
     * @param supplierId
     * @param supplyStatus
     * @param expectedDeliveryDate
     * @param actualDeliveryDate
     */
    public SupplyChain(Long supplierId, String supplyStatus, LocalDate expectedDeliveryDate, LocalDate actualDeliveryDate) {

        this.supplierId = supplierId;
        this.supplyStatus = supplyStatus;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.actualDeliveryDate = actualDeliveryDate;
    }

    /**
     *
     * @return
     */
    public LocalDate getActualDeliveryDate() {
        return actualDeliveryDate;
    }

    /**
     *
     * @param actualDeliveryDate
     */
    public void setActualDeliveryDate(LocalDate actualDeliveryDate) {
        this.actualDeliveryDate = actualDeliveryDate;
    }

    /**
     *
     * @return
     */
    public LocalDate getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    /**
     *
     * @param expectedDeliveryDate
     */
    public void setExpectedDeliveryDate(LocalDate expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    /**
     *
     * @return
     */
    public String getSupplyStatus() {
        return supplyStatus;
    }

    /**
     *
     * @param supplyStatus
     */
    public void setSupplyStatus(String supplyStatus) {
        this.supplyStatus = supplyStatus;
    }

    /**
     *
     * @return
     */
    public Long getSupplierId() {
        return supplierId;
    }

    /**
     *
     * @param supplierId
     */
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    /**
     *
     */
    public SupplyChain() {
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final SupplyChain other = (SupplyChain) obj;
        
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
    public SupplyChain(Long id) {
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
        return "SupplyChain{" + "id=" + id + ", supplierId=" + supplierId + ", supplyStatus=" + supplyStatus + ", expectedDeliveryDate=" + expectedDeliveryDate + ", actualDeliveryDate=" + actualDeliveryDate + '}';
    }
    
    

}
