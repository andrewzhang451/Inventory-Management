
import edu.iit.sat.itmd4515.azhang20.domain.Inventory;
import edu.iit.sat.itmd4515.azhang20.domain.WindowType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.time.LocalDate;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author AndrewZ
 *
 * Summary: -this file will set up connection with database -create an instance
 * of the object -save object to database
 *
 */
public class Week5Demo {

    public static void main(String... args) {

        //instantiated a new object that holds the ID=999l and value=windows
        Inventory inventory = new Inventory("windowFloat", LocalDate.of(2020, 12, 12),WindowType.FLOAT);

        //here we create a tool that help manage our database connection with our connection (itmd4515testPU)
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("itmd4515testPU");

        //this creates an Entity Manager
        EntityManager em = emf.createEntityManager();

        System.out.println("before persist: " + inventory.toString());

        //this is like a trasnaction ("save" session) before we save data to database
        EntityTransaction tx = em.getTransaction();//tx will be used to begin and finish(commit) the session

        tx.begin();
        em.persist(inventory);//this tells the manager to save the object "inventory" to database
        inventory.setName("bullet-proof glass");
        tx.commit();

        System.out.println("After persist: " + inventory.toString());
    }
}

//CRUD_functions:
//EntityManager.persist();      --> create
//EntityManager.find();         --> read
//EntityManager.merge();        --> update
//EntityManager.remove();       --> delete
