package simulator;

public class Simulator {
    private State state;
    private EventQueue queue;

    public Simulator(State state, EventQueue queue) {
        this.state = state;
        this.queue = queue;
    }

    public void run() {
        while (!state.isStopFlag() && !queue.isEmpty()) {
            Event currentEvent = queue.next();
            currentEvent.execute(state, queue);
        }
    }
}
