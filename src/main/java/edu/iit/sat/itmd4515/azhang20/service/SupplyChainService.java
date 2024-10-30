/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20.service;

import edu.iit.sat.itmd4515.azhang20.domain.Supplier;
import edu.iit.sat.itmd4515.azhang20.domain.SupplyChain;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author AndrewZ
 */
@Stateless
public class SupplyChainService extends AbstractService<SupplyChain>{

    /**
     *
     */
    public SupplyChainService() {
        super(SupplyChain.class);
    }
    
    /**
     *
     * @return
     */
    public List<SupplyChain> readAll(){
        return super.readAll("SupplyChain.readAll");
    }
    
}
