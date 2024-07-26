package de.moebel.tests;

import org.junit.jupiter.api.*;
import de.moebel.utils.*;

public class ValidationTest {

    @Test
    @DisplayName("Validation possible")
    public void successfulValidation() {
        Assertions.assertEquals(StringToNumber.validateChar('a'), 'A');
    }

    @Test
    @DisplayName("No validation possible")
    public void failedValidation() {
        Assertions.assertEquals(StringToNumber.validateChar(':'), '0');
    }

}
