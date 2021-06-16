package Main;

import java.util.ArrayList;

public class ProcessingQueue {
    ArrayList<Barcode> queue;

    public ProcessingQueue() {
        queue = new ArrayList<Barcode>();
    }

    // appends an item to the end of the queue
    public void addItem(Barcode code) {
        queue.add(code);
    }

    // gets the first item from the queue
    public Barcode getItem() {
        return queue.get(0);
    }

    // removes the first item from the queue
    public void removeItem() {
        queue.remove(0);
    }

    // returns true if the queue is empty
    public boolean isQueueEmpty() {
        return queue.isEmpty();
    }

    // returns how many elements are in the queue
    public int queueSize() {
        return queue.size();
    }
}
