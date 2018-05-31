package how.it.works.threads;

public class Worker extends Thread {
    private final Jqueue<Task> queue;

    public Worker(Jqueue<Task> queue) {
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
