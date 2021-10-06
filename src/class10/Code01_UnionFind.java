package class10;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Code01_UnionFind {
    public static class Node<T>{
        public T value;
        public Node(T value){
            this.value = value;
        }
    }

    public static class UnionFindSet<T>{
        HashMap<T, Node> nodes = new HashMap<>();
        HashMap<Node<T>, Node<T>> represent = new HashMap<>();
        HashMap<Node<T>, Integer> setSize = new HashMap<>();

        public UnionFindSet(List<T> list) {
            for (T cur : list){
                Node<T> node = new Node(cur);
                nodes.put(cur, node);
                represent.put(node, node);
                setSize.put(node, 1);
            }
        }

        public boolean isSameSet(T a, T b){
            if (!nodes.containsKey(a) || !nodes.containsKey(b)){
                return false;
            }
            return findRepresent(nodes.get(a)) == findRepresent(nodes.get(b));
        }

        private Node findRepresent(Node cur){
            Stack<Node> stack = new Stack<>();
            while (cur != represent.get(cur)){
                stack.push(cur);
                cur = represent.get(cur);
            }

            while (!stack.isEmpty()){
                represent.put(stack.pop(), cur);
            }
            return cur;
        }

        public void union(T a, T b){
            if (nodes.containsKey(a) && nodes.containsKey(b)){
                Node<T> aRepresent = represent.get(nodes.get(a));
                Node<T> bRepresent = represent.get(nodes.get(b));
                if (aRepresent != bRepresent) {
                    int aSetSize = setSize.get(aRepresent);
                    int bSetSize = setSize.get(bRepresent);
                    Node<T> big = aSetSize > bSetSize ? aRepresent : bRepresent;
                    Node<T> small = aSetSize > bSetSize ? bRepresent : aRepresent;
                    represent.put(small, big);
                    setSize.put(big, aSetSize + bSetSize);
                    setSize.remove(small);
                }
            }
        }
    }
}
