package carwash;

import simulator.Event;
import simulator.EventQueue;
import simulator.State;

class StopEvent extends Event {
    StopEvent(double time){
        super(time);
    }

    @Override
    public void execute(State s, EventQueue q){
        s.setCurrentTime(this.getTime());

        s.stop();

        s.notifyObservers(this);
    }
}
