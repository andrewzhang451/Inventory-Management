/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author AndrewZ
 */
@Entity
public class ProductTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String windowType;

    private String windowQuantity;

    private String frames;

    private String materials;

    /**
     * Get the value of materials
     *
     * @return the value of materials
     */
    public String getMaterials() {
        return materials;
    }

    /**
     * Set the value of materials
     *
     * @param materials new value of materials
     */
    public void setMaterials(String materials) {
        this.materials = materials;
    }

    /**
     * Get the value of frames
     *
     * @return the value of frames
     */
    public String getFrames() {
        return frames;
    }

    /**
     * Set the value of frames
     *
     * @param frames new value of frames
     */
    public void setFrames(String frames) {
        this.frames = frames;
    }

    /**
     * Get the value of windowQuantity
     *
     * @return the value of windowQuantity
     */
    public String getWindowQuantity() {
        return windowQuantity;
    }

    /**
     * Set the value of windowQuantity
     *
     * @param windowQuantity new value of windowQuantity
     */
    public void setWindowQuantity(String windowQuantity) {
        this.windowQuantity = windowQuantity;
    }

    /**
     * Get the value of windowType
     *
     * @return the value of windowType
     */
    public String getWindowType() {
        return windowType;
    }

    /**
     * Set the value of windowType
     *
     * @param windowType new value of windowType
     */
    public void setWindowType(String windowType) {
        this.windowType = windowType;
    }

//------------------------------------------------------------------------------------------------------------------
    public ProductTracking() {
    }

    public ProductTracking(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
