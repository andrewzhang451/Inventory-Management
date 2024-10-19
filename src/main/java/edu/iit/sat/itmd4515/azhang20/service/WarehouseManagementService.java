/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20.service;

import edu.iit.sat.itmd4515.azhang20.domain.WarehouseManagement;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

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
    
    public void create(WarehouseManagement w) {
//        tx.begin();
          em.persist(w);
//        tx.commit();
    }
    
    public WarehouseManagement read(Long id) {
        return em.find(WarehouseManagement.class, id);
    }
    
    public void update(WarehouseManagement w) {
        em.merge(w);
    }
    
    public void delete(WarehouseManagement w) {
        em.remove(em.merge(w));
    }
    
    public List<WarehouseManagement> readall(){
//        return em.createQuery("select w from WarehouseManagement w", WarehouseManagement.class).getResultList();
        return em.createQuery("WarehouseManagement.readall", WarehouseManagement.class).getResultList();
    } 
    
    
}
