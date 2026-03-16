package carwash;

class CarFactory {
    private int currentId = 0;

    Car createCar(double arrivalTime) {
        Car newCar = new Car(currentId, arrivalTime);
        currentId++;
        return newCar;
    }

    double getCurrentId() {
        return this.currentId;
    }
}
