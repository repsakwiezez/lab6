package simulator;

import java.util.PriorityQueue;

/**
 * A priority queue for events, ordered by time.
 */
public class EventQueue {

    private PriorityQueue<Event> queue;

    /**
     * Creates a new empty EventQueue.
     */
    public EventQueue() {
        this.queue = new PriorityQueue<>();
    }

    /**
     * Inserts an event into the queue.
     * @param e the event to insert
     */
    public void insert(Event e) {
        queue.add(e);
        
    }

    /**
     * Removes and returns the next event.
     * @return the next event, or null if empty
     */
    public Event next() {
        return queue.poll();
    }

    /**
     * Checks if the queue is empty.
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
