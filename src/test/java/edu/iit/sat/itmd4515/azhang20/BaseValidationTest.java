package edu.iit.sat.itmd4515.azhang20;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author AndrewZ
 */
public abstract class BaseValidationTest {

    /**
     *
     */
    protected static Validator validator;

    /**
     *
     */
    @BeforeAll
    public static void setupValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
}
