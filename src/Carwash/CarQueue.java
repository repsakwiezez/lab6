package carwash;

import java.util.LinkedList;

/**
 * A queue for cars waiting in the car wash.
 */
public class CarQueue {
    private LinkedList<Car> fifoQueue;

    /**
     * Creates a new empty CarQueue.
     */
    CarQueue() {
        fifoQueue = new LinkedList<>();
    }

    /**
     * Adds a car to the end of the queue.
     * @param c the car to add
     */
    void enqueue(Car c) {
        fifoQueue.addLast(c);
    }

    /**
     * Removes and returns the car from the front of the queue.
     * @return the car from the front, or null if empty
     */
    Car dequeue() {
        return this.fifoQueue.pollFirst();
    }

    /**
     * Checks if the queue is empty.
     * @return true if empty, false otherwise
     */
    boolean isEmpty() {
        return this.fifoQueue.isEmpty();
    }

    /**
     * Returns the number of cars in the queue.
     * @return the size of the queue
     */
    int getSize() {
        return this.fifoQueue.size();
    }


}
