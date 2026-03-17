package carwash;

import simulator.Event;
import simulator.EventQueue;
import simulator.State;

/**
 * Represents the stop event of the simulation.
 */
class StopEvent extends Event {
    /**
     * Creates a new StopEvent at the specified time.
     * @param time the stop time
     */
    StopEvent(double time){
        super(time);
    }

    /**
     * Executes the stop event, stopping the simulation.
     * @param s the current state
     * @param q the event queue
     */
    @Override
    public void execute(State s, EventQueue q){
        s.setCurrentTime(this.getTime());

        s.stop();

        s.notifyObservers(this);
    }
}
