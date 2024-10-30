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
@NamedQuery(name = "Supplier.readAll", query = "select s from Supplier s")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String supplierName;
    private String contactName;
    private String contactEmail;
    private String contactPhone;
    private String address;
    private String city;
    private String postalCode;

    /**
     *
     * @param supplierName
     * @param contactName
     * @param contactEmail
     * @param contactPhone
     * @param address
     * @param city
     * @param postalCode
     */
    public Supplier(String supplierName, String contactName, String contactEmail, String contactPhone, String address, String city, String postalCode) {

        this.supplierName = supplierName;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
    }

    /**
     *
     * @return
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     *
     * @param postalCode
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    //city, postCode

    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     *
     * @param contactPhone
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    /**
     *
     * @return
     */
    public String getContactEmail() {
        return contactEmail;
    }

    /**
     *
     * @param contactEmail
     */
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    /**
     *
     * @return
     */
    public String getContactName() {
        return contactName;
    }

    /**
     *
     * @param contactName
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     *
     * @return
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     *
     * @param supplierName
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    /**
     *
     */
    public Supplier() {
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
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
        final Supplier other = (Supplier) obj;
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
    public Supplier(Long id) {
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
        return "Supplier{" + "id=" + id + ", supplierName=" + supplierName + ", contactName=" + contactName + ", contactEmail=" + contactEmail + ", contactPhone=" + contactPhone + ", address=" + address + ", city=" + city + ", postalCode=" + postalCode + '}';
    }
    
    

}
