package how.it.works.threads;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ThreadPool {
    private BlockingQueue<Task> queue = new LinkedBlockingDeque<>();


    public ThreadPool(int size) {
        for (int i = 0; i < size; i++) {
            Worker w = new Worker(queue);
            w.start();
        }
    }

    public void execute(List<Task> tasks) {
        tasks.forEach((task -> queue.offer(task)));
    }
}
