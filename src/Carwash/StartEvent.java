package carwash;

import simulator.Event;
import simulator.EventQueue;
import simulator.State;

class StartEvent extends Event {

    StartEvent(double time){
        super(time);
    }

    @Override
    public void execute(State s, EventQueue q) {
        s.setCurrentTime(this.getTime());

        CarwashState carWashState = (CarwashState) s;

        s.notifyObservers(this);
    }
}
