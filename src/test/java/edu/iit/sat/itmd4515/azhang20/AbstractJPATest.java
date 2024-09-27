/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20;

import edu.iit.sat.itmd4515.azhang20.domain.Inventory;
import edu.iit.sat.itmd4515.azhang20.domain.WindowType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.time.LocalDate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


/**
 *
 * @author AndrewZ
 */
public class AbstractJPATest {
    private static EntityManagerFactory emf;
    protected EntityManager em;
    protected EntityTransaction tx;

    @BeforeAll
    public static void beforeAll() {
        emf = Persistence.createEntityManagerFactory("itmd4515testPU");

    }

    @BeforeEach
    public void beforeEach() {
        //before each testcase, we create standard test data to work with
        em = emf.createEntityManager(); //created the maanger
        tx = em.getTransaction(); //created the transaction
        Inventory inventory = new Inventory("TEST DATA", LocalDate.of(2024, 1, 1), WindowType.FLOAT, 100, 250.0);
        tx.begin();
        em.persist(inventory);//this tells the manager to save the object "inventory" to database/also meant to create a table and insert it into database
        tx.commit();

        System.out.println("beforeEach with inventory:" + inventory.toString());
    }

    

    @AfterEach
    public void afterEach() {
        try {
            Inventory inventory = em.createQuery("select i from Inventory i where i.name = 'TEST DATA'", Inventory.class).getSingleResult();
            System.out.println("afterEach with inventory:" + inventory.toString());

            tx.begin();
            em.remove(inventory);
            tx.commit();
        } catch (jakarta.persistence.NoResultException e) {
            System.out.println("No inventory found for cleanup.");
        } finally {
            em.close();
        }
    }

    @AfterAll
    public static void afterAll() {

        emf.close();
    }

}

