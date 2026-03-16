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
        
        double nextArrivalTime = this.getTime() + state.getArrivalRandom().next();
        Car nextCar = state.getCarFactory().createCar(nextArrivalTime);
        q.insert(new ArriveEvent(nextArrivalTime, nextCar));

        if(state.getAvailibleFastWash() > 0){
            state.occupyFastWash();
            double leaveTime = this.getTime() + state.getFastRandom().next();
            q.insert(new LeaveEvent(leaveTime, this.car, true));
        }

    }
    
}
