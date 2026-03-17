package carwash;

import simulator.Event;
import simulator.EventQueue;
import simulator.State;

/**
 * Represents an event where a car arrives at the car wash.
 */
 class ArriveEvent extends Event { 
    private Car car;

    /**
     * Creates a new ArriveEvent with the specified time and car.
     * @param time the time of the event
     * @param car the car arriving
     */
    ArriveEvent(double time, Car car) {
        super(time);
        this.car = car;
    }

    /**
     * Executes the arrive event, handling car arrival logic.
     * @param s the current state
     * @param q the event queue
     */
    @Override
    public void execute(State s, EventQueue q){
        s.setCurrentTime(this.getTime());
        CarwashState state = (CarwashState) s;

        s.notifyObservers(this);

        double nextArrivalTime = this.getTime() + state.getArrivalRandom().next();
        Car nextCar = state.getCarFactory().createCar(nextArrivalTime);
        q.insert(new ArriveEvent(nextArrivalTime, nextCar));

        if(state.getAvailableFastWash() > 0){
            state.addEnteredCar();
            state.occupyFastWash();
            double leaveTime = this.getTime() + state.getFastRandom().next();
            q.insert(new LeaveEvent(leaveTime, this.car, true));
        } else if(state.getAvailableSlowWash() > 0){
            state.addEnteredCar();
            state.occupySlowWash();
            double leaveTime = this.getTime() + state.getSlowRandom().next();
            q.insert(new LeaveEvent(leaveTime, this.car, false));
        } else if (state.getCarQueue().getSize() < state.getMaxQueueSize()) {
            state.addEnteredCar();
            state.getCarQueue().enqueue(this.car);
        }else {
            state.addRejectedCar();
        }
    }

    /**
     * Returns the car associated with this event.
     * @return the car
     */
    public Car getCar() {
        return this.car;
    }
}
