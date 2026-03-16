package simulator;
public abstract class Event implements Comparable<Event>{
    
    private double eventTime;

    public double getTime() {
        return eventTime;
    }

    public double getEventTime() {
        return eventTime;
    }

    public abstract void excecute(State s, EventQueue q);

    @Override
    public int compareTo(Event o) {
        return Double.compare(this.getEventTime(), o.getEventTime());
    }
}
