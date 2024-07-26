package de.moebel;

import de.moebel.utils.*;
import java.util.Scanner;

/**
 * This class is the main-class and also the first class the jar interact with at the very beginning.
 * In here it's decided whether the method should be executed only once, or repeatedly.
 * @author Alihan
 */

public class Main {

    /**
     * This is the first method being called when the jar has been executed.
     *
     * @param args The used arguments when the jar has been executed.
     */

    public static void main(String[] args) {
        final int length = args.length -1;
        final Timer timer = new Timer();

        /*
        Direct use:
            If the jar has been executed with arguments at the end, this part of the code will be used.
            In here, the jar generates a result according to the given arguments and stops the process directly after.
         */

        if(length != -1) {
            printResult(timer, String.join( " ", args));
            return;
        }

        /*
        Repeatable use:
            If there is no argument, this part of the code will be executed instead.
            In here, the user can generate results multiple times in an endless loop.
         */

        System.out.println("Type in your name or text:");
        System.out.print("> ");

        Scanner scanner = new Scanner(System.in);
        String line;

        // Checks if someone has pressed enter
        while(scanner.hasNext()) {
            line = scanner.nextLine();

            // Do nothing and repeat the loop when the line is empty or blank to avoid future issues.
            if(line.isBlank() || line.isEmpty()) continue;

            printResult(timer, line);
            System.out.print("> ");
        }

    }

    /**
     *
     * @param timer From the Timer-class to calculate how long the process took.
     * @param text The input text to get the accumulated value from.
     */
    private static void printResult(Timer timer, String text) {
        System.out.println("Input: " + text);

        timer.startTimer();
        int sum = StringToNumber.getSumByString(text);

        System.out.println("Result: " + sum + " (in " + timer.stopAndGet() + "ms)");
    }
}