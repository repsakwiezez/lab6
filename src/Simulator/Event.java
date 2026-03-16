package simulator;
public abstract class Event implements Comparable<Event>{
    
    private double eventTime;

    public Event(double time) {
        if (time < 0) {
            throw new IllegalArgumentException("Event time cannot be negative.");
        }
        this.eventTime = time;
    }

    public double getTime() {
        return eventTime;
    }

    public double getEventTime() {
        return eventTime;
    }

    public abstract void execute(State s, EventQueue q);

    @Override
    public int compareTo(Event o) {
        return Double.compare(this.getEventTime(), o.getEventTime());
    }
}
