package carwash;

import simulator.Event;
import simulator.EventQueue;
import simulator.State;

 class ArriveEvent extends Event { 
    private Car car;

    ArriveEvent(double time, Car car) {
        super(time);
        this.car = car;
    }

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

    public Car getCar() {
        return this.car;
    }
}
