package carwash;

import java.util.LinkedList;

public class CarQueue {
    private LinkedList<Car> fifoQueue;

    CarQueue() {
        fifoQueue = new LinkedList<>();
    }

    void enqueue(Car c) {
        fifoQueue.addLast(c);
    }

    Car dequeue() {
        return this.fifoQueue.pollFirst();
    }

    boolean isEmpty() {
        return this.fifoQueue.isEmpty();
    }

    int getSize() {
        return this.fifoQueue.size();
    }


}
