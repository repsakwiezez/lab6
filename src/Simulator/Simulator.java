package simulator;

public class Simulator {
    private State state;
    private EventQueue queue;
    private View view;

    public Simulator(State state, EventQueue queue, View view) {
        this.state = state;
        this.queue = queue;
        this.view = view;
    }

    public void run() {
        while (!state.isStopFlag() && !queue.isEmpty()) {
            Event currentEvent = queue.next();
            currentEvent.execute(state, queue);
        }
    }
}
