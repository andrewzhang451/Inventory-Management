/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20.service;

import edu.iit.sat.itmd4515.azhang20.domain.Customer;
import edu.iit.sat.itmd4515.azhang20.domain.WarehouseManagement;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import java.util.logging.Logger;


/**
 *
 * @author AndrewZ
 */

@Startup
@Singleton
public class StartupServiceInitDB {
    
    private static final Logger LOG = Logger.getLogger(StartupServiceInitDB.class.getName());
    
    @EJB WarehouseManagementService wareSvc;
    @EJB CustomerService custSvc;
    
    public StartupServiceInitDB() {
        
    }
    
    @PostConstruct
    public void postConstruct(){
//        LOG.info("Inside StartupServiceInitDB.postConstruct()");

        LOG.info("Inside StartupServiceInitDB.postConstruct()");
                
        //when using JPA, create non-owning entities first, Class class = new Class2() is considered instantiating owning entity
        WarehouseManagement w1 = new WarehouseManagement("Amazon Warehouse", "Chicago, IL", 2, 998);
        WarehouseManagement w2 = new WarehouseManagement("Amazon Warehouse", "Chicago, IL", 3, 995);
        WarehouseManagement w3 = new WarehouseManagement("Amazon Warehouse", "Chicago, IL", 4, 991);
        
        
        //instead of using entity manager; call service method
        wareSvc.create(w1);
        wareSvc.create(w2);
        wareSvc.create(w3);
        
        Customer cust1 = new Customer("Jim", "Jm20@gmail.com", "9876543212", "74 S Emerald", "Kansas City", "31474");
        Customer cust2 = new Customer("Tom", "Tm78@gmail.com", "4828602715", "58 N Walkbash", "New York City", "10101");
        Customer cust3 = new Customer("George", "George@gmail.com", "4412485728", "23 W SunnySide", "Sanfrancisco", "82512");
        
        custSvc.create(cust1);
        custSvc.create(cust2);
        custSvc.create(cust3);
        
    }
    
}
