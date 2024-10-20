/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20.service;

import edu.iit.sat.itmd4515.azhang20.domain.Shipping;
import jakarta.ejb.Stateless;

/**
 *
 * @author AndrewZ
 */
@Stateless
public class ShippingService extends AbstractService<Shipping>{

    public ShippingService() {
        super(Shipping.class);
    }
    
}
