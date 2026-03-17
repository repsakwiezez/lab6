package carwash;

import simulator.Event;
import simulator.EventQueue;
import simulator.State;

/**
 * Represents the start event of the simulation.
 */
class StartEvent extends Event {

    /**
     * Creates a new StartEvent at the specified time.
     * @param time the start time
     */
    StartEvent(double time){
        super(time);
    }

    /**
     * Executes the start event, scheduling the first arrival.
     * @param s the current state
     * @param q the event queue
     */
    @Override
    public void execute(State s, EventQueue q) {
        s.setCurrentTime(this.getTime());
        CarwashState carWashState = (CarwashState) s;

        double firstArrivalTime = this.getTime() + carWashState.getArrivalRandom().next();

        Car firstCar = carWashState.getCarFactory().createCar(firstArrivalTime);

        q.insert(new ArriveEvent(firstArrivalTime, firstCar));

        s.notifyObservers(this);
    }
}
