package carwash;

import simulator.*;
import random.*;

/**
 * Main class for running the car wash simulation.
 */
public class Main {
    /**
     * The main method that sets up and runs the simulation.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {

        long seed = 1234;
        double lambda = 2.0;
        double fastLower = 2.8;
        double fastUpper = 4.6;
        double slowLower = 3.5;
        double slowUpper = 6.7;

        ExponentialRandomStream arrivalRandom = new ExponentialRandomStream( lambda, seed);
        UniformRandomStream fastRandom = new UniformRandomStream(fastLower, fastUpper, seed);
        UniformRandomStream slowRandom = new UniformRandomStream(slowLower, slowUpper, seed);

        CarwashState state = new CarwashState(2, 2, 5, fastRandom, slowRandom, arrivalRandom);

        EventQueue queue = new EventQueue();
        CarwashView view = new CarwashView(state, fastLower, fastUpper, slowLower, slowUpper, lambda, seed);

        state.addView(view);

        queue.insert(new StartEvent(0.0));
        queue.insert(new StopEvent(15.0));

        Simulator simulator = new Simulator(state, queue);
        simulator.run();
    }
    
}
