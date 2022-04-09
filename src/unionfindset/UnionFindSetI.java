package unionfindset;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UnionFindSetI {

    public static class Node<T> {
        T value;

        public Node(T value) {
            this.value = value;
        }
    }

    public static class UnionFindSet<T> {
        public HashMap<T, Node<T>> vNodeMap = new HashMap<>();
        public HashMap<Node<T>, Node<T>> nodeParentMap = new HashMap<>();
        public HashMap<Node<T>, Integer> nodeSetSizeMap = new HashMap<>();

        public UnionFindSet(List<T> values) {
            for (T value : values) {
                Node<T> node = new Node<>(value);
                vNodeMap.put(value, node);
                nodeParentMap.put(node, node);
                nodeSetSizeMap.put(node, 1);
            }
        }

        public Node<T> findRepresentNode(Node<T> cur) {
            Stack<Node<T>> path = new Stack<>();
            while (cur != nodeParentMap.get(cur)) {
                path.push(cur);
                cur = nodeParentMap.get(cur);
            }
            while (!path.isEmpty()) {
                nodeParentMap.put(path.pop(), cur);
            }
            return cur;
        }

        public boolean isSameSet(T a, T b) {
            if (!vNodeMap.containsKey(a) || !vNodeMap.containsKey(b)) {
                return false;
            }
            return findRepresentNode(vNodeMap.get(a)) == findRepresentNode(vNodeMap.get(b));
        }

        public void union(T a, T b) {
            if (!vNodeMap.containsKey(a) || !vNodeMap.containsKey(b)) {
                return;
            }
            Node<T> aRepresentNode = findRepresentNode(vNodeMap.get(a));
            Node<T> bRepresentNode = findRepresentNode(vNodeMap.get(b));
            if (aRepresentNode != bRepresentNode) {
                Integer aSetSize = nodeSetSizeMap.get(aRepresentNode);
                Integer bSetSize = nodeSetSizeMap.get(bRepresentNode);
                Node<T> bigSetRepresentNode = aSetSize >= bSetSize ? aRepresentNode : bRepresentNode;
                Node<T> smallSetRepresentNode = aRepresentNode == bigSetRepresentNode ? bRepresentNode : bRepresentNode;
                nodeParentMap.put(smallSetRepresentNode, bigSetRepresentNode);
                nodeSetSizeMap.put(bigSetRepresentNode, nodeSetSizeMap.get(bigSetRepresentNode) + nodeSetSizeMap.get(smallSetRepresentNode));
                nodeSetSizeMap.remove(smallSetRepresentNode);
            }
        }

        public int getSetSize() {
            return nodeSetSizeMap.size();
        }
    }

    public static void main(String[] args) {
        List<String> list = Stream.of("a", "b", "c").collect(Collectors.toList());
        UnionFindSet unionFindSet = new UnionFindSet(list);
        System.out.println(unionFindSet.isSameSet("a", "b"));
        unionFindSet.union("a", "b");
        System.out.println(unionFindSet.isSameSet("a", "b"));
        System.out.println(unionFindSet.isSameSet("b", "c"));
        System.out.println(unionFindSet.isSameSet("a", "c"));
    }
}
