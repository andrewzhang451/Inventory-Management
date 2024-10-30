/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20.domain;

/**
 *
 * @author AndrewZ
 */
public enum WindowType {

    /**
     *
     */
    FLOAT("FLOAT"), 

    /**
     *
     */
    LAMINATED("LAMINATED"), 

    /**
     *
     */
    OBSCURED("OBSCURED"), 

    /**
     *
     */
    TEMPERED("TEMPERED"), 

    /**
     *
     */
    INSULATED("INSULATED"), 

    /**
     *
     */
    LOW_E("LOW_E"); 
    
    private String label;

    private WindowType(String label) {
        this.label = label;
    }
    
    /**
     *
     * @return
     */
    public String getLabel(){
        return label;
    }
}
