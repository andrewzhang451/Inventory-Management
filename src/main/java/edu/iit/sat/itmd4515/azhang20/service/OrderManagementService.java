/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20.service;
import edu.iit.sat.itmd4515.azhang20.domain.OrderManagement;
import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import java.util.List;

/**
 *
 * @author AndrewZ
 */
@Named
@Stateless
public class OrderManagementService extends AbstractService<OrderManagement>{

    /**
     *
     */
    public OrderManagementService() {
        super(OrderManagement.class);
    }
    
    /**
     *
     * @return
     */
    public List<OrderManagement> readAll(){
        return super.readAll("OrderManagement.readAll");
    }
    
    /**
     *
     * @param uname
     * @return
     */
    public OrderManagement findByUsername(String uname){
        return em.createNamedQuery("OrderManagement.findByUsername", OrderManagement.class).setParameter("uname", uname).getSingleResult();
    }
}
