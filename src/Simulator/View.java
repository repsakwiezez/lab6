package simulator;

/**
 * Base class for views that observe the simulation state.
 */
public class View {
    /**
     * Called when the state changes. Subclasses should override this.
     * @param s the state
     * @param e the event
     */
    public void update(State s, Event e) {
    }
}
