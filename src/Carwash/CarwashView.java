package carwash;

import simulator.View;

public class CarwashView extends View {

    @Override
    public void update(State state) {
        CarwashState carsState = (CarwashState) state;

            System.out.println(carsState.funktion());
    }
}