package edu.iit.sat.itmd4515.azhang20;

import edu.iit.sat.itmd4515.azhang20.domain.Inventory;
import edu.iit.sat.itmd4515.azhang20.domain.WindowType;
import jakarta.validation.ConstraintViolation;
import java.time.LocalDate;
import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 
 */
public class InventoryValidationTest extends BaseValidationTest {

    @BeforeEach
    public void beforeEach() {
    }

    @Test
    public void validInventoryTest() {
        Inventory inventory = new Inventory("WindowName", LocalDate.of(2024, 1, 1), WindowType.FLOAT, 100, 250.0);
        System.out.println("Valid Inventory: " + inventory.toString());

        Set<ConstraintViolation<Inventory>> violations = validator.validate(inventory);

        assertEquals(0, violations.size());
    }

    @Test
    public void invalidBlankNameTest() {
        Inventory inventory = new Inventory("", LocalDate.of(2024, 1, 1), WindowType.FLOAT, 100, 250.0); 

        System.out.println("Testing invalid blank name: " + inventory.toString());

        Set<ConstraintViolation<Inventory>> violations = validator.validate(inventory);

        violations.forEach(violation -> System.out.println("Validation message: " + violation.getMessage()));

        assertEquals(1, violations.size());

        assertEquals("must not be blank", violations.iterator().next().getMessage());
    }

    @Test
    public void invalidFutureProductionDateTest() {
        Inventory inventory = new Inventory("WindowName", LocalDate.of(2025, 1, 1), WindowType.FLOAT, 100, 250.0);

        System.out.println("Testing invalid future production date: " + inventory.toString());

        Set<ConstraintViolation<Inventory>> violations = validator.validate(inventory);

        violations.forEach(violation -> System.out.println("Validation message: " + violation.getMessage()));

        assertEquals(1, violations.size());

        assertEquals("must be a date in the past or in the present", violations.iterator().next().getMessage());
    }

    @AfterEach
    public void afterEach() {
    }
}
