package class10;

public class GraphGenerator {
    public static Graph createGraph(Integer[][] matrix){
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++){
            int wight = matrix[i][0];
            int fromId = matrix[i][1];
            int toId = matrix[i][2];

            //根据一条边构建出与这条边相关联的点
            if (!graph.nodes.containsKey(fromId)){
                graph.nodes.put(fromId, new Node(fromId));
            }
            if (!graph.nodes.containsKey(toId)){
                graph.nodes.put(toId, new Node(toId));
            }

            Node fromNode = graph.nodes.get(fromId);
            Node toNode = graph.nodes.get(toId);
            Edge edge = new Edge(wight, fromNode, toNode);

            fromNode.out++;
            fromNode.nexts.add(toNode);
            fromNode.edges.add(edge);
            toNode.in++;
            graph.edges.add(edge);
        }
        return graph;
    }
}
