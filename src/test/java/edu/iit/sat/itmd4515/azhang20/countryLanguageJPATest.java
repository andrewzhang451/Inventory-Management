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
import java.sql.SQLException;
import java.time.LocalDate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 *
 * @author andrewz
 */
public class countryLanguageJPATest {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;
    
    
    @BeforeAll
    public static void beforeAll() {
        emf = Persistence.createEntityManagerFactory("itmd4515testPU");
        
    }

    @BeforeEach
    public void beforeEach()  {
        //before each testcase, we create standard test data to work with
        em = emf.createEntityManager(); //created the maanger
        tx = em.getTransaction(); //created the transaction
        Inventory inventory = new Inventory("TEST DATA", LocalDate.of(2020, 12, 12),WindowType.FLOAT);
        tx.begin();
        em.persist(inventory);//this tells the manager to save the object "inventory" to database/also meant to create a table and insert it into database
        tx.commit();
    }

    @Test
    public void createTest()  {
        //assert that you COULD read such val
        //if could read, then create was successful

    }

    @Test
    public void readTest() throws SQLException {

    }
    
    @Test
    public void updateTest() {
        //read back from database and assert
        //then will update something and save it to database
        //then I will read back from database again and assert
        //that the update was saved from database
 
    }

    @Test
    public void deleteTest()  {
  
    }

    @AfterEach
    public void afterEach()  {
        em.close();
    }

    @AfterAll
    public static void afterAll() {
        emf.close();
    }

}
