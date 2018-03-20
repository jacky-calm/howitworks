package how.it.works.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by I311682 on 3/20/18.
 */
public class Vertex {
    private String label;
    private int distance;
    private Vertex pre;

    private List<Edge> edges = new ArrayList<>();


    public Vertex(String label) {
        this.label = label;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Vertex getPre() {
        return pre;
    }

    public void setPre(Vertex pre) {
        this.pre = pre;
    }

    public void addEdge(Vertex destination, int weight) {
        Edge e = new Edge();
        e.setDestination(destination);
        e.setWeight(weight);
        this.edges.add(e);
    }


}
