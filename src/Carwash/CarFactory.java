package carwash;

/**
 * Factory class for creating Car objects.
 */
class CarFactory {
    private int currentId = 0;

    /**
     * Creates a new Car with the next available id and the specified arrival time.
     * @param arrivalTime the arrival time of the car
     * @return the created Car
     */
    Car createCar(double arrivalTime) {
        Car newCar = new Car(currentId, arrivalTime);
        currentId++;
        return newCar;
    }

    /**
     * Returns the current id counter.
     * @return the current id
     */
    double getCurrentId() {
        return this.currentId;
    }
}
