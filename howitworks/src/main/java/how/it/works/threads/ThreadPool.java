package how.it.works.threads;

import java.util.List;

public class ThreadPool {
    private Jqueue<Task> queue = new Jqueue<>();


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
