package how.it.works.threads;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

import static org.junit.Assert.*;

public class ThreadPoolTest {

    @Test
    public void execute() {

        ThreadPoolExecutor threadPoolExecutor;

        ThreadPool threadPool = new ThreadPool(3);

        TestTask t1 = new TestTask("t1");
        TestTask t2 = new TestTask("t2");
        TestTask t3 = new TestTask("t3");

        List<Task> tasks = new ArrayList<>();
        tasks.add(t1);
        tasks.add(t2);
        tasks.add(t3);

        threadPool.execute(tasks);
    }
}