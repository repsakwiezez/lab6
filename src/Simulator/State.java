package simulator;

/**
 * Base class for simulation states, managing time and observers.
 */
public class State {

    private double currentTime;

    private boolean stopFlag;

    private View view;

    /**
     * Creates a new State with initial time 0 and stop flag false.
     */
    public State() {
        this.currentTime = 0.0;
        this.stopFlag = false;
        this.view = null;
    }

    /**
     * Returns the current simulation time.
     * @return the current time
     */
    public double getCurrentTime() {
        return currentTime;
    }

    /**
     * Returns true if the simulation should stop.
     * @return the stop flag
     */
    public boolean isStopFlag() {
        return stopFlag;
    }

    /**
     * Sets the current time, must be >= current time.
     * @param newTime the new time
     * @throws IllegalArgumentException if newTime < currentTime
     */
    public void setCurrentTime(double newTime) {
        if (newTime < currentTime) {
            throw new IllegalArgumentException("Time cannot go backwards.");
        }
        this.currentTime = newTime;
    }

    /**
     * Sets the stop flag to true.
     */
    public void stop() {
        this.stopFlag = true;
    }

    /**
     * Adds a view to be notified of state changes (single observer).
     * @param view the view to add
     */
    public void addView(View view) {
        this.view = view;
    }

    /**
     * Notifies the registered view of an event.
     * @param e the event
     */
    public void notifyObservers(Event e) {
        if (this.view != null) {
            this.view.update(this, e);
        }
    }
}
