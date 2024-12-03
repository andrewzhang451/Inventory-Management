/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20;

import edu.iit.sat.itmd4515.azhang20.domain.Inventory;
import edu.iit.sat.itmd4515.azhang20.domain.WindowType;
import java.sql.SQLException;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author andrewz
 */
public class InventoryJPATest extends AbstractJPATest {

    /**
     *
     */
    @Test
    public void createTest() {
        //assert that you COULD read such val
        //if could read, then create was successful
        //create a new inventory, then assert it was successful 
        Inventory inventory = new Inventory("WindowName", LocalDate.of(2024, 1, 1), WindowType.FLOAT, 100, 250.0);
        tx.begin();
        em.persist(inventory);//this tells the manager to save the object "inventory" to database/also meant to create a table and insert it into database
        tx.commit();

        Inventory readBackFromDatabase = em.find(Inventory.class, inventory.getId());
        assertNotNull(readBackFromDatabase);
        assertTrue(readBackFromDatabase.getId() > 0);
        assertEquals("WindowName", readBackFromDatabase.getName());
    }

    /**
     *
     * @throws SQLException
     */
    @Test
    public void readTest() throws SQLException {

    }

    /**
     *
     */
    @Test
    public void updateTest() {
        Inventory inventory = em.createQuery("select i from Inventory i where i.name = 'TEST DATA'", Inventory.class).getSingleResult();
        assertTrue(inventory.getId() > 0);

        tx.begin();
        inventory.setProductionDate(LocalDate.of(2021, 01, 01));
        tx.commit();

        Inventory readBackFromDatabase = em.find(Inventory.class, inventory.getId());

        assertEquals(inventory.getId(), readBackFromDatabase.getId());

        assertEquals(LocalDate.of(2021, 01, 01), readBackFromDatabase.getProductionDate());
    }

    /**
     *
     */
    @Test
    public void deleteTest() {
        Inventory inventory = em.createQuery("select i from Inventory i where i.name = 'TEST DATA'", Inventory.class).getSingleResult();
        assertNotNull(inventory);

        tx.begin();
        em.remove(inventory);
        tx.commit();

        Inventory deletedInventory = em.find(Inventory.class, inventory.getId());
        assertNull(deletedInventory);
    }

}
