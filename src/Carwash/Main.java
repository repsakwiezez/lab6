package carwash;

import simulator.*;
import random.*;

public class Main {
    public static void main(String[] args) {

        long seed = 1234;
        ExponentialRandomStream arrivalRandom = new ExponentialRandomStream( 2.0, seed);
        UniformRandomStream fastRandom = new UniformRandomStream(2.8, 4.6, seed);
        UniformRandomStream slowRandom = new UniformRandomStream(3.5, 6.7, seed);

        CarwashState state = new CarwashState(2, 3, 5, fastRandom, slowRandom, arrivalRandom);

        EventQueue queue = new EventQueue();
        CarwashView view = new CarwashView(state);

        state.addView(view);

        queue.insert(new StartEvent(0.0));
        queue.insert(new StopEvent(15.0));

        Simulator simulator = new Simulator(state, queue, view);
        simulator.run();
    }
    
}
