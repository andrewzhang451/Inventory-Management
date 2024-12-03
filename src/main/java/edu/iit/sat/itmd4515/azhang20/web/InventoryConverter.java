package edu.iit.sat.itmd4515.azhang20.web;

import edu.iit.sat.itmd4515.azhang20.domain.Inventory;
import edu.iit.sat.itmd4515.azhang20.service.InventoryService;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.convert.FacesConverter;

/**
 *this is a JSF converter, where it takes user input (string) into and object, and vice versa when being displayed onto webpage.
 * @author AndrewZ
 */
@Named
@RequestScoped
@FacesConverter(value = "inventoryConverter", managed = true)
public class InventoryConverter implements Converter {

    @Inject
    private InventoryService inventoryService;

    /**
     *
     * @param context
     * @param component
     * @param value
     * @return
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return inventoryService.read(Long.valueOf(value));
    }

    /**
     *
     * @param context
     * @param component
     * @param object
     * @return
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object object) {
        if (object == null) {
            return "";
        }
        return String.valueOf(((Inventory) object).getId());
    }
}
