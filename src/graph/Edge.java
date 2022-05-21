package graph;

public class Edge {
    public int wigth;
    public Node from;
    public Node to;

    public Edge(int wigth, Node from, Node to) {
        this.wigth = wigth;
        this.from = from;
        this.to = to;
    }
}
