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
    private final CarQueue carQueue;
    private final CarFactory carFactory;

    private final UniformRandomStream fastRandom;
    private final UniformRandomStream slowRandom;
    private final ExponentialRandomStream arrivalRandom;

    public CarwashState(int fastWash, int slowWash, int maxQueueSize; UniformRandomStream fastRandom, UniformRandomStream slowrandom, ExponentialRandomStream arrivalRandom) {

        this.fastWash = fastWash;
        this.slowWash = slowWash;
        this.maxQueueSize = maxQueueSize;

        this.totalIdleTime = 0.0;
        this.totalQueueTime = 0.0;
        this.rejectedCars = 0;

        this.carQueue = new CarQueue();
        this.carFactory = new CarFactory();

        this.fastRandom = fastRandom;
        this.slowRandom = slowRandom;
        this.arrivalRandom = arrivalRandom;

    } 
}
