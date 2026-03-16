package carwash;

class Car {
    private int id;
    private double arrivalTime;

    Car(int id, double arrivalTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
    }

    int getId() {
        return id;
    }

    double getArrivalTime() {
        return arrivalTime;
    }
}
