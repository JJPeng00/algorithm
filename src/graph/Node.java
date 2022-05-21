package graph;

import java.util.ArrayList;

public class Node {
    public int value;

    public int in;
    public int out;
    //其实只要记录从这个节点出发的边就可以,但是在某些算法中不会使用到边的信息，如果广度优先遍历和深度优先遍历都只需要直到当前节点的之后的节点
    //即广度优先遍历中只需要直到value和、nexts属性就可以
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}
