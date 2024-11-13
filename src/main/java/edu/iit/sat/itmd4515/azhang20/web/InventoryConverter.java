package edu.iit.sat.itmd4515.azhang20.web;

import edu.iit.sat.itmd4515.azhang20.domain.Inventory;
import edu.iit.sat.itmd4515.azhang20.service.InventoryService;
import jakarta.ejb.EJB;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(value = "inventoryConverter")
public class InventoryConverter implements Converter<Inventory> {

    @EJB
    private InventoryService inventoryService;

    @Override
    public Inventory getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        // Convert the string ID back to an Inventory object using the read method
        return inventoryService.read(Long.parseLong(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Inventory inventory) {
        if (inventory == null || inventory.getId() == null) {
            return "";
        }
        // Convert the Inventory object back to its string ID
        return inventory.getId().toString();
    }
}
