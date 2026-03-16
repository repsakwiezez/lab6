package carwash;

import simulator.View;
import simulator.State;
import simulator.Event;

public class CarwashView extends View {

public CarwashView(CarwashState state) {
        System.out.println("Fast machines" + state.getAvailableFastWash());
        System.out.println("Slow machines" + state.getAvailableSlowWash());

        System.out.println("Queue size" + state.getMaxQueueSize());
        System.out.println("----------------------------------------");
        System.out.println("Time  Event   Id  Fast  Slow  IdleTime  QueueTime  QueueSize  Rejected");
    }

    @Override
    public void update(State s, Event e) {
        CarwashState state = (CarwashState) s;

        String timeStr = String.format("%5.2f", state.getCurrentTime());

        if (e instanceof StartEvent){
            System.out.println(timeStr + " Start");
        }
        else if (e instanceof StopEvent){
            System.out.printf("%s Stop   -     -     -    %6.2f    %6.2f          %d         %d\n", 
                timeStr, state.getTotalIdleTime(), state.getTotalQueueTime(), 
                state.getCarQueue().getSize(), state.getRejectedCars());

            System.out.println("---------------------------------");
            System.out.printf("Total idle machine time: %.2f\n", state.getTotalIdleTime());
            System.out.printf("Total queueing time: %.2f\n", state.getTotalQueueTime());
            System.out.println("Rejected cars: " + state.getRejectedCars());
        }
        else if (e instanceof ArriveEvent) {
            ArriveEvent arrive = (ArriveEvent) e;
            System.out.printf("%s Arrive  %2d    %d     %d    %6.2f    %6.2f          %d         %d\n", 
                timeStr, arrive.getCar().getId(), state.getAvailableFastWash(), state.getAvailableSlowWash(),
                state.getTotalIdleTime(), state.getTotalQueueTime(), state.getCarQueue().getSize(), state.getRejectedCars());
        } 
        else if (e instanceof LeaveEvent) {
            LeaveEvent leave = (LeaveEvent) e;
            System.out.printf("%s Leave   %2d    %d     %d    %6.2f    %6.2f          %d         %d\n", 
                timeStr, leave.getCar().getId(), state.getAvailableFastWash(), state.getAvailableSlowWash(),
                state.getTotalIdleTime(), state.getTotalQueueTime(), state.getCarQueue().getSize(), state.getRejectedCars());
        }
    }
}