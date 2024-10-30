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
public class WarehouseManagementService extends AbstractService<WarehouseManagement>{
    
    @PersistenceContext(name = "itmd4515PU")
    private EntityManager em;

    /**
     *
     */
    public WarehouseManagementService() {
        super(WarehouseManagement.class);
    }
    
    /**
     *
     * @return
     */
    public List<WarehouseManagement> readAll(){
        return super.readAll("WarehouseManagement.readAll");
    }
    
    /**
     *
     * @param w
     */
    @Override
    public void create(WarehouseManagement w) {
//        tx.begin();
          em.persist(w);
//        tx.commit();
    }
    
    /**
     *
     * @param id
     * @return
     */
    @Override
    public WarehouseManagement read(Long id) {
        return em.find(WarehouseManagement.class, id);
    }
    
    /**
     *
     * @param w
     */
    @Override
    public void update(WarehouseManagement w) {
        em.merge(w);
    }
    
    /**
     *
     * @param w
     */
    @Override
    public void delete(WarehouseManagement w) {
        em.remove(em.merge(w));
    }
    
    /**
     *
     * @return
     */
    public List<WarehouseManagement> readall(){
//        return em.createQuery("select w from WarehouseManagement w", WarehouseManagement.class).getResultList();
        return em.createQuery("WarehouseManagement.readall", WarehouseManagement.class).getResultList();
    } 
    
    
}
