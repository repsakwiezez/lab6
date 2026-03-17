package carwash;

import random.ExponentialRandomStream;
import random.UniformRandomStream;
import simulator.State;

/**
 * Represents the state of the car wash simulation.
 */
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

    /**
     * Creates a new CarwashState with the specified parameters.
     * @param fastWash number of fast wash machines
     * @param slowWash number of slow wash machines
     * @param maxQueueSize maximum queue size
     * @param fastRandom random stream for fast wash times
     * @param slowRandom random stream for slow wash times
     * @param arrivalRandom random stream for arrival times
     */
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

    /**
     * Sets the current time and updates idle and queue times.
     * @param newTime the new current time
     */
    @Override
    public void setCurrentTime(double newTime) {
        double timeDelta = newTime - this.getCurrentTime();
        this.totalIdleTime += timeDelta * (this.fastWash + this.slowWash);
        this.totalQueueTime += timeDelta * this.carQueue.getSize();
        super.setCurrentTime(newTime);
    }

    /**
     * Returns the arrival random stream.
     * @return the arrival random stream
     */
    public ExponentialRandomStream getArrivalRandom() {
        return this.arrivalRandom;
    }

    /**
     * Returns the fast wash random stream.
     * @return the fast random stream
     */
    public UniformRandomStream getFastRandom() {
        return this.fastRandom;
    }

    /**
     * Returns the slow wash random stream.
     * @return the slow random stream
     */
    public UniformRandomStream getSlowRandom() {
        return this.slowRandom;
    }

    /**
     * Returns the car factory.
     * @return the car factory
     */
    public CarFactory getCarFactory() {
        return this.carFactory;
    }

    /**
     * Returns the car queue.
     * @return the car queue
     */
    public CarQueue getCarQueue() {
        return this.carQueue;
    }

    /**
     * Returns the maximum queue size.
     * @return the max queue size
     */
    public int getMaxQueueSize() {
        return this.maxQueueSize;
    }


    
    /**
     * Returns the number of available fast wash machines.
     * @return available fast washes
     */
    public int getAvailableFastWash() {
        return this.fastWash;
    }

    /**
     * Returns the number of available slow wash machines.
     * @return available slow washes
     */
    public int getAvailableSlowWash() {
        return this.slowWash;
    }

    /**
     * Occupies a fast wash machine.
     */
    public void occupyFastWash() {
        this.fastWash--;
    }

    /**
     * Occupies a slow wash machine.
     */
    public void occupySlowWash() {
        this.slowWash--;
    }

    /**
     * Frees a fast wash machine.
     */
    public void freeFastWash() {
        this.fastWash++;
    }

    /**
     * Frees a slow wash machine.
     */
    public void freeSlowWash() {
        this.slowWash++;
    }



    /**
     * Increments the count of rejected cars.
     */
    public void addRejectedCar() {
        this.rejectedCars++;
    }

    /**
     * Returns the number of rejected cars.
     * @return rejected cars count
     */
    public int getRejectedCars() {
        return this.rejectedCars;
    }

    /**
     * Increments the count of entered cars.
     */
    public void addEnteredCar() {
        this.enteredCars++;
    }

    /**
     * Returns the number of entered cars.
     * @return entered cars count
     */
    public int getEnteredCars() {
        return this.enteredCars;
    }

    /**
     * Adds to the total idle time.
     * @param time the time to add
     */
    public void addIdleTime(double time) {
        this.totalIdleTime += time;
    }

    /**
     * Returns the total idle time.
     * @return total idle time
     */
    public double getTotalIdleTime() {
        return this.totalIdleTime;
    }

    /**
     * Adds to the total queue time.
     * @param time the time to add
     */
    public void addQueueTime(double time) {
        this.totalQueueTime += time;
    }

    /**
     * Returns the total queue time.
     * @return total queue time
     */
    public double getTotalQueueTime() {
        return this.totalQueueTime;
    }

    /**
     * Returns the current id from the car factory.
     * @return current id
     */
    public double getCurrentId() {
        return this.carFactory.getCurrentId();
    }
}
