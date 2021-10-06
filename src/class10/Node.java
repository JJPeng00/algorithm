package class10;

import java.util.LinkedList;

public class Node {
    public int id;//点的编号
    public int in;//入度
    public int out;//出度
    public LinkedList<Node> nexts;//直接邻居，本节点可直接到达的下一个节点
    public LinkedList<Edge> edges;//从本节点出发的边

    public Node(int id) {
        this.id = id;
        in = 0;
        out = 0;
        nexts = new LinkedList<>();
        edges = new LinkedList<Edge>();
    }
}
