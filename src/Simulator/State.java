package simulator;

import java.util.ArrayList;
import java.util.List;

public class State {
    
    private double currentTime;

    private boolean stopFlag;

    private final List<View> views;

    public State() {
        this.currentTime = 0.0;
        this.stopFlag = false;
        this.views = new ArrayList<>();
    }

    public double getCurrentTime() {
        return currentTime;
    }

    public boolean isStopFlag() {
        return stopFlag;
    }

    public void setCurrentTime(double newTime) {
        if (newTime < currentTime) {
            throw new IllegalArgumentException("Time cannot go backwards.");
        }
        this.currentTime = newTime;
    }

    public void stop() {
        this.stopFlag = true;
    }

    public void addView(View view) {
        if (view != null) {
            this.views.add(view);
        }
    }

    public void notifyViews() {
        for (View view : views) {
            view.update(this);
        }
    }
}
