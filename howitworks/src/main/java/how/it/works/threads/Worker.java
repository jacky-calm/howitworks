package how.it.works.threads;

import java.util.concurrent.BlockingQueue;

public class Worker extends Thread {
    private final BlockingQueue<Task> queue;

    public Worker(BlockingQueue<Task> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while (true) {
            try {
                Task t = queue.take();
                t.execute();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
