package de.moebel;

import de.moebel.utils.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int length = args.length -1;
        final Timer timer = new Timer();

        /*
        Direct use:
            If the jar has been executed with arguments at the end, this part of the code will be used.
            In here, the jar generates a result according to the given arguments and stops the process directly after.
         */

        if(length > 0) {
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
        while(scanner.hasNext()) {
            printResult(timer, scanner.nextLine());
            System.out.print("> ");
        }

    }

    private static void printResult(Timer timer, String text) {
        System.out.println("Input: " + text);

        timer.startTimer();
        int sum = StringToNumber.getSumByString(text);

        System.out.println("Result: " + sum + " (in " + timer.stopAndGet() + "ms)");
    }
}