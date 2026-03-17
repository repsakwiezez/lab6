package simulator;

/**
 * The main simulator class that runs the simulation.
 */
public class Simulator {
    private State state;
    private EventQueue queue;

    /**
     * Creates a new Simulator with the given state and event queue.
     * @param state the simulation state
     * @param queue the event queue
     */
    public Simulator(State state, EventQueue queue) {
        this.state = state;
        this.queue = queue;
    }

    /**
     * Runs the simulation until stopped or queue is empty.
     */
    public void run() {
        while (!state.isStopFlag() && !queue.isEmpty()) {
            Event currentEvent = queue.next();
            currentEvent.execute(state, queue);
        }
    }
}
