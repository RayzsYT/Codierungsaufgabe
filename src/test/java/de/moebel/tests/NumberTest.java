package de.moebel.tests;

import org.junit.jupiter.api.*;
import de.moebel.utils.*;

public class NumberTest {

    @Test
    @DisplayName("Character -> Number")
    public void characterToNumber() {
        int sum = StringToNumber.getSumByCharacters('c');
        Assertions.assertEquals(sum, 3);
    }

    @Test
    @DisplayName("Multiple Characters -> Number")
    public void charactersToNumber() {
        int sum = StringToNumber.getSumByCharacters('a', 'b', 'c');
        Assertions.assertEquals(sum, 6);
    }

    @Test
    @DisplayName("Name -> Number")
    public void nameToNumber() {
        int sum = StringToNumber.getSumByString("Anna");
        Assertions.assertEquals(sum, 30);
    }

    @Test
    @DisplayName("Text -> Number")
    public void textToNumber() {
        // 'Ö' & '.' are not part of the english alphabet. Therefore, those two would have a value of 0.
        int sum = StringToNumber.getSumByString("Anna kauft Möbel bei moebel.de.");
        Assertions.assertEquals(sum, 198);
    }
}
