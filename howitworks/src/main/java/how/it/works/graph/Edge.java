package how.it.works.graph;

/**
 * Created by I311682 on 3/20/18.
 */
public class Edge {
    private Vertex destination;
    private int weight;


    public Vertex getDestination() {
        return destination;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
