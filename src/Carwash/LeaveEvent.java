package carwash;

import simulator.Event;
import simulator.EventQueue;
import simulator.State;

/**
 * Represents an event where a car leaves the car wash.
 */
class LeaveEvent extends Event {

    private Car car;
    private boolean isFastWash;

    /**
     * Creates a new LeaveEvent with the specified time, car, and wash type.
     * @param time the time of the event
     * @param car the car leaving
     * @param isFastWash true if fast wash, false if slow
     */
    LeaveEvent(double time, Car car, boolean isFastWash) {
        super(time);
        this.car = car;
        this.isFastWash = isFastWash;
    }

    /**
     * Executes the leave event, freeing the wash machine and handling queue.
     * @param s the current state
     * @param q the event queue
     */
    @Override
    public void execute(State s, EventQueue q) {
        s.setCurrentTime(this.getTime());
        CarwashState state = (CarwashState) s;

        s.notifyObservers(this);

        if (!state.getCarQueue().isEmpty()){
            Car nextCar = state.getCarQueue().dequeue();

            double leaveTime;
            if (this.isFastWash) {
                leaveTime = this.getTime() + state.getFastRandom().next();
                q.insert(new LeaveEvent(leaveTime, nextCar, true));
            } else {
                leaveTime = this.getTime() + state.getSlowRandom().next();
                q.insert(new LeaveEvent(leaveTime, nextCar, false));
            }
        } else {
            if (this.isFastWash) {
                state.freeFastWash();
            } else {
                state.freeSlowWash();
            }
        }
    }

    /**
     * Returns the car leaving.
     * @return the car
     */
    Car getCar() {
        return this.car;
    }

    /**
     * Returns true if it's a fast wash.
     * @return true if fast wash
     */
    boolean isFastWash() {
        return this.isFastWash;
    }
}
