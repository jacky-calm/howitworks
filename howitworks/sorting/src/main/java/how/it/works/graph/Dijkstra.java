package how.it.works.graph;

import java.util.*;

/**
 * Created by I311682 on 3/20/18.
 */
public class Dijkstra {

    public static void main(String[] args) {

        List<Vertex> graph = buildGraph();

        initializeSingleSource(graph, graph.get(0));

        List<Vertex> sequence = new ArrayList();

        PriorityQueue<Vertex> queue = new PriorityQueue(Comparator.comparingInt(Vertex::getDistance));
        queue.addAll(graph);

        while (!queue.isEmpty()) {
            Vertex u = queue.poll();
            System.out.println(u.getLabel() + " d: " + u.getDistance());
            sequence.add(u);

            for (Edge e : u.getEdges()) {
                relax(u, e, queue);
            }
        }

        printPaths(sequence);

    }

    private static void printPaths(List<Vertex> sequence) {
        for (Vertex v : sequence) {
            System.out.println(v.getLabel() + " path =============");
            System.out.print(v.getLabel() + " (" + v.getDistance() + ") <- ");
            Vertex pre = v.getPre();
            while (pre != null) {
                System.out.print(pre.getLabel() + " (" + pre.getDistance() + ") <- ");
                pre = pre.getPre();
            }
            System.out.println();
        }
    }

    private static void relax(Vertex u, Edge e, PriorityQueue<Vertex> queue) {
        Vertex v = e.getDestination();
        int w = e.getWeight();
        if (v.getDistance() > u.getDistance() + w) {
            v.setDistance(u.getDistance() + w);
            v.setPre(u);
            queue.remove(v);
            queue.offer(v);
        }
    }

    private static List<Vertex> buildGraph() {
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

        a.addEdge(b, 10);
        a.addEdge(c, 3);

        b.addEdge(c, 1);
        b.addEdge(d, 2);

        c.addEdge(b, 4);
        c.addEdge(d, 8);
        c.addEdge(e, 3);

        d.addEdge(e, 7);

        e.addEdge(d, 9);

        return graph;
    }

    private static void initializeSingleSource(List<Vertex> graph, Vertex a) {
        for (Vertex v : graph) {
            v.setDistance(Integer.MAX_VALUE);
            v.setPre(null);
        }
        a.setDistance(0);
    }
}
