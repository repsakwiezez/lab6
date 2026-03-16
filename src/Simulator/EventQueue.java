package simulator;

import java.util.PriorityQueue;

public class EventQueue {

    private PriorityQueue<Event> queue;

    public EventQueue() {
        this.queue = new PriorityQueue<>();
    }

    public void insert(Event e) {
        queue.add(e);
        
    }

    public Event next() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
