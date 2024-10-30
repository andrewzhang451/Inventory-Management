/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20.service;

//
import edu.iit.sat.itmd4515.azhang20.domain.Inventory;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author AndrewZ
 */
@Stateless
public class InventoryService extends AbstractService<Inventory> {

    /**
     *
     */
    public InventoryService() {
        super(Inventory.class);
    }
    
    /**
     *
     * @return
     */
    public List<Inventory> readAll(){
        return super.readAll("Inventory.readAll");
    }
}
