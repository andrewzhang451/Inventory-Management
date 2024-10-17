/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20.service;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author AndrewZ
 */

@Stateless
public class WarehouseManagementService {
    
    @PersistenceContext(name = "itmd4515PU")
    private EntityManager em;
    
    public WarehouseManagementService() {
        
        
    }  
}
