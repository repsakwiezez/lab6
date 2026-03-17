package simulator;

/**
 * Abstract base class for simulation events.
 */
public abstract class Event implements Comparable<Event>{
    
    private double eventTime;

    /**
     * Creates a new Event at the specified time.
     * @param time the event time
     * @throws IllegalArgumentException if time is negative
     */
    public Event(double time) {
        if (time < 0) {
            throw new IllegalArgumentException("Event time cannot be negative.");
        }
        this.eventTime = time;
    }

    /**
     * Returns the event time.
     * @return the event time
     */
    public double getTime() {
        return eventTime;
    }

    /**
     * Executes the event.
     * @param s the current state
     * @param q the event queue
     */
    public abstract void execute(State s, EventQueue q);

    /**
     * Compares this event to another based on time.
     * @param o the other event
     * @return comparison result
     */
    @Override
    public int compareTo(Event o) {
        return Double.compare(this.getTime(), o.getTime());
    }
}
