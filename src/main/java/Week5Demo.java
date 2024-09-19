
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author AndrewZ
 */
public class Week5Demo {
    public static void main(String...args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("itmd4515testPU");
        
        //this creates an Entity Manager
        EntityManager em = emf.createEntityManager();
        
    }
}
