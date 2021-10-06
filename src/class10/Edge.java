package class10;

public class Edge {
    public int wight;
    public Node from;
    public Node to;

    public Edge(int wight, Node from, Node to) {
        this.wight = wight;
        this.from = from;
        this.to = to;
    }
}
