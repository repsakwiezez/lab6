package carwash;

import simulator.Event;
import simulator.EventQueue;
import simulator.State;

class LeaveEvent extends Event {

    private Car car;
    private boolean isFastWash;

    LeaveEvent(double time, Car car, boolean isFastWash) {
        super(time);
        this.car = car;
        this.isFastWash = isFastWash;
    }

    @Override
    public void execute(State s, EventQueue q) {
        s.setCurrentTime(this.getTime());
        CarwashState state = (CarwashState) s;

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
        s.notifyObservers(this);
    }

    Car getCar() {
        return this.car;
    }

    boolean isFastWash() {
        return this.isFastWash;
    }
}
