package carwash;

/**
 * Represents a car in the car wash simulation.
 */
class Car {
    private int id;
    private double arrivalTime;

    /**
     * Creates a new Car with the specified id and arrival time.
     * @param id the unique id of the car
     * @param arrivalTime the time the car arrived
     */
    Car(int id, double arrivalTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
    }

    /**
     * Returns the id of the car.
     * @return the car id
     */
    int getId() {
        return id;
    }

    /**
     * Returns the arrival time of the car.
     * @return the arrival time
     */
    double getArrivalTime() {
        return arrivalTime;
    }
}
