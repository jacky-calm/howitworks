package how.it.works.threads;

import java.util.LinkedList;
import java.util.List;

public class Jqueue<T> {

    List<T> elements = new LinkedList<>();

    private Object takeMutex = new Object();


    public T take() throws InterruptedException {
        synchronized (takeMutex) {
            while (elements.size() == 0) {
                System.out.println(Thread.currentThread().getId() + " is waiting to take ...");
                takeMutex.wait();

            }
            return elements.remove(0);
        }
    }

    public void offer(T t) {
        synchronized (takeMutex) {
            elements.add(t);
            System.out.println(Thread.currentThread().getId() + " is notifying to take ...");
            takeMutex.notify();
        }
    }
}
