/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20.service;

import edu.iit.sat.itmd4515.azhang20.domain.Customer;
import edu.iit.sat.itmd4515.azhang20.domain.OrderItem;
import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author AndrewZ
 */
@Named
@Stateless
public class OrderItemService extends AbstractService<OrderItem> {

    /**
     *
     */
    public OrderItemService() {
        super(OrderItem.class);
    }

    public List<OrderItem> findByCustomer(Customer customer) {
        TypedQuery<OrderItem> query = em.createQuery(
                "SELECT oi FROM OrderItem oi WHERE oi.order.customer = :customer", OrderItem.class
        );
        query.setParameter("customer", customer);
        return query.getResultList();
    }

    /**
     *
     * @return
     */
    public List<OrderItem> readAll() {
        return super.readAll("OrderItem.readAll");
    }

    public OrderItem find(Long id) {
        return em.find(OrderItem.class, id);
    }

//        public OrderItem findByUsername(String uname){
//        return em.createNamedQuery("OrderItem.findByUsername", OrderItem.class).setParameter("uname", uname).getSingleResult();
//    }
}
