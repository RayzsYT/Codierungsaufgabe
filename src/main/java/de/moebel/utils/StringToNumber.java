package de.moebel.utils;

import java.util.*;

/**
 * This class is for generating accumulated values of specific characters from the english alphabet.
 * @author Alihan
 */

public class StringToNumber {

    private static final Map<Character, Integer> CHARACTER_HASH = new HashMap<>();

    // Puts all letters/characters from A-Z into a HashMap with their given values.
    static {
        char currentChar = 'A'-1;
        int currentValue = 1;

        while(currentChar++ != 'Z')
            CHARACTER_HASH.put(currentChar, currentValue++);
    }

    /**
     *  This method automates the process to calculate each character
     *  with its connected value.
     *  This method in particular separates each letter of the String
     *  to simplify the process.
     *
     * @see #getSumByCharacters(char...) Executes this method with the String as charArray.
     * @param text Characters of the String that need to calculated.
     * @return The sum of all values with each character as an int.
     */
    public static int getSumByString(String text) {
        return getSumByCharacters(text.toCharArray());
    }

    /**
     *  This method automates the process to calculate each character
     *  with its connected value.
     *
     * @param characters Characters that need to calculated.
     * @return The sum of all values with each character as an int.
     */
    public static int getSumByCharacters(char... characters) {
        int sum = 0;

        // Loop through every given character and calculate its values with the sum.
        for (char character : characters)
            sum += getValueByCharacter(character);

        return sum;
    }

    /**
     * Check and validate the character if necessary.
     *
     * @param character The character that needs to be validated.
     * @return The value connected to that character.
     */
    public static char validateChar(char character) {

        // Returns 0 instead, if the character isn't in the english alphabet.
        if(!Character.isAlphabetic(character)) return '0';

        // Uppercases the letter, if it's lowercased.
        return Character.isLowerCase(character) ? Character.toUpperCase(character) : character;
    }

    /**
     * Returns the value of a character.
     *
     * @param character The character to get the value of.
     * @return Returns the value of the character as an integer.
     */
    public static int getValueByCharacter(char character) {
        return CHARACTER_HASH.getOrDefault(character,
                CHARACTER_HASH.getOrDefault(validateChar(character), 0)
        );
    }
}
