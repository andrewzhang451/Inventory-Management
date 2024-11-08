package edu.iit.sat.itmd4515.azhang20.service;

import edu.iit.sat.itmd4515.azhang20.domain.Shipping;
import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import java.util.List;

/**
 * Service class for Shipping entity operations.
 */
@Named
@Stateless
public class ShippingService extends AbstractService<Shipping> {

    public ShippingService() {
        super(Shipping.class);
    }

    public List<Shipping> findAll() {
    return em.createNamedQuery("Shipping.readAll", Shipping.class).getResultList();
}

}
