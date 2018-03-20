package how.it.works.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by I311682 on 3/20/18.
 */
public class Dijkstra {

    public static void main(String[] args) {

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");

        List<Vertex> graph = new ArrayList();
        graph.add(a);
        graph.add(b);
        graph.add(c);
        graph.add(d);
        graph.add(e);

        initializeSingleSource(graph, a);

        List<Vertex> sequence = new ArrayList();

        PriorityQueue<Vertex> queue = new PriorityQueue(Comparator.comparingInt(Vertex::getDistance));
        queue.add(a);
        queue.add(b);
        queue.add(c);
        queue.add(d);
        queue.add(e);

        while (!queue.isEmpty()) {
            Vertex min = queue.poll();
            sequence.add(min);


        }

    }

    private static void initializeSingleSource(List<Vertex> graph, Vertex a) {
        for (Vertex v : graph) {
            v.setDistance(Integer.MAX_VALUE);
            v.setPre(null);
        }
        a.setDistance(0);
    }
}
