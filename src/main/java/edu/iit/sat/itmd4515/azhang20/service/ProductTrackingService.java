/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20.service;

import edu.iit.sat.itmd4515.azhang20.domain.Customer;
import edu.iit.sat.itmd4515.azhang20.domain.ProductTracking;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author AndrewZ
 */
@Stateless
public class ProductTrackingService extends AbstractService<ProductTracking>{

    /**
     *
     */
    public ProductTrackingService() {
        super(ProductTracking.class);
    }
    
    /**
     *
     * @return
     */
    public List<ProductTracking> readAll(){
        return super.readAll("ProductTracking.readAll");
    }
    
}
