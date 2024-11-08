package edu.iit.sat.itmd4515.azhang20.web;

import edu.iit.sat.itmd4515.azhang20.domain.Shipping;
import edu.iit.sat.itmd4515.azhang20.service.ShippingService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/**
 * Controller for managing Shipping information for the seller page.
 */
@Named
@RequestScoped
public class ShippingController {

    private static final Logger LOG = Logger.getLogger(ShippingController.class.getName());

    private List<Shipping> allShipments;

    @Inject
    private ShippingService shippingService;

    @PostConstruct
    public void init() {
        LOG.info("Initializing ShippingController and loading all shipments.");
        this.allShipments = shippingService.findAll(); // Use findAll instead of readAll
    }

    public List<Shipping> getAllShipments() {
        return allShipments;
    }
}
