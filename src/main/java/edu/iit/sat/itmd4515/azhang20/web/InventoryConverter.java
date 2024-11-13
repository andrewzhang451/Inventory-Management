package edu.iit.sat.itmd4515.azhang20.web;

import edu.iit.sat.itmd4515.azhang20.domain.Inventory;
import edu.iit.sat.itmd4515.azhang20.service.InventoryService;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.convert.FacesConverter;

@Named
@RequestScoped
@FacesConverter(value = "inventoryConverter", managed = true)
public class InventoryConverter implements Converter {

    @Inject
    private InventoryService inventoryService;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return inventoryService.read(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object object) {
        if (object == null) {
            return "";
        }
        return String.valueOf(((Inventory) object).getId());
    }
}
