package carwash;

import random.ExponentialRandomStream;
import random.UniformRandomStream;
import simulator.State;

public class CarwashState extends State {
    
    private int fastWash;
    private int slowWash;
    private final int maxQueueSize;

    private double totalIdleTime;
    private double totalQueueTime;

    private int rejectedCars;
    private int enteredCars;
    private final CarQueue carQueue;
    private final CarFactory carFactory;

    private final UniformRandomStream fastRandom;
    private final UniformRandomStream slowRandom;
    private final ExponentialRandomStream arrivalRandom;

    public CarwashState(int fastWash, int slowWash, int maxQueueSize, UniformRandomStream fastRandom, UniformRandomStream slowRandom, ExponentialRandomStream arrivalRandom) {

        this.fastWash = fastWash;
        this.slowWash = slowWash;
        this.maxQueueSize = maxQueueSize;

        this.totalIdleTime = 0.0;
        this.totalQueueTime = 0.0;
        this.rejectedCars = 0;
        this.enteredCars = 0;

        this.carQueue = new CarQueue();
        this.carFactory = new CarFactory();

        this.fastRandom = fastRandom;
        this.slowRandom = slowRandom;
        this.arrivalRandom = arrivalRandom;

    } 

    @Override
    public void setCurrentTime(double newTime) {
        double timeDelta = newTime - this.getCurrentTime();
        this.totalIdleTime += timeDelta * (this.fastWash + this.slowWash);
        this.totalQueueTime += timeDelta * this.carQueue.getSize();
        super.setCurrentTime(newTime);
    }

    public ExponentialRandomStream getArrivalRandom() {
        return this.arrivalRandom;
    }

    public UniformRandomStream getFastRandom() {
        return this.fastRandom;
    }

    public UniformRandomStream getSlowRandom() {
        return this.slowRandom;
    }

    public CarFactory getCarFactory() {
        return this.carFactory;
    }

    public CarQueue getCarQueue() {
        return this.carQueue;
    }

    public int getMaxQueueSize() {
        return this.maxQueueSize;
    }


    
    public int getAvailableFastWash() {
        return this.fastWash;
    }

    public int getAvailableSlowWash() {
        return this.slowWash;
    }

    public void occupyFastWash() {
        this.fastWash--;
    }

    public void occupySlowWash() {
        this.slowWash--;
    }

    public void freeFastWash() {
        this.fastWash++;
    }

    public void freeSlowWash() {
        this.slowWash++;
    }



    public void addRejectedCar() {
        this.rejectedCars++;
    }

    public int getRejectedCars() {
        return this.rejectedCars;
    }

    public void addEnteredCar() {
        this.enteredCars++;
    }

    public int getEnteredCars() {
        return this.enteredCars;
    }

    public void addIdleTime(double time) {
        this.totalIdleTime += time;
    }

    public double getTotalIdleTime() {
        return this.totalIdleTime;
    }

    public void addQueueTime(double time) {
        this.totalQueueTime += time;
    }

    public double getTotalQueueTime() {
        return this.totalQueueTime;
    }

    public double getCurrentId() {
        return this.carFactory.getCurrentId();
    }
}
