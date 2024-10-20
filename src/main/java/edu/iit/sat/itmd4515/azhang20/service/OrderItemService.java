/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20.service;

import edu.iit.sat.itmd4515.azhang20.domain.OrderItem;
import jakarta.ejb.Stateless;

/**
 *
 * @author AndrewZ
 */
@Stateless
public class OrderItemService extends AbstractService<OrderItem>{

    public OrderItemService() {
        super(OrderItem.class);
    }
    
}
