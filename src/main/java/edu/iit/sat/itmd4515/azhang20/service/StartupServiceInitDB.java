/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20.service;

import edu.iit.sat.itmd4515.azhang20.domain.WarehouseManagement;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;

/**
 *
 * @author AndrewZ
 */

@Startup
@Singleton
public class StartupServiceInitDB {
    
    @EJB WarehouseManagementService wareSvc;
    
    public StartupServiceInitDB() {
        
    }
    
    @PostConstruct
    public void postConstruct(){
        LOG.info("Inside StartupServiceInitDB.postConstruct()");
                
        //when using JPA, create non-owning entities first, Class class = new Class2() is considered instantiating owning entity
        WarehouseManagement w1 = new WarehouseManagement("Amazon Warehouse", "Chicago, IL", 2, 998);
        WarehouseManagement w2 = new WarehouseManagement("Amazon Warehouse", "Chicago, IL", 3, 995);
        WarehouseManagement w3 = new WarehouseManagement("Amazon Warehouse", "Chicago, IL", 4, 991);
        
        
        //instead of using entity manager; call service method
        wareSvc.create(w1);
        wareSvc.create(w2);
        wareSvc.create(w1);
        
    }
    
}
