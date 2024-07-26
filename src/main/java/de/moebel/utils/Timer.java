package de.moebel.utils;

/**
 * This class calculates the time a method requires for a specific task.
 * @author Alihan
 */

public class Timer {

    private long start;

    /**
     * Creates an instance and starts the timer automatically.
     */
    public Timer() {
        startTimer();
    }

    /**
     * Start the timer.
     */
    public void startTimer() {
        this.start = System.currentTimeMillis();
    }

    /**
     * Calculates and returns the time from the start until now.
     *
     * @return The time in milliseconds.
     */
    public long stopAndGet() {
        return System.currentTimeMillis() - this.start;
    }
}
