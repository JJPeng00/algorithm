package class10;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Code01_MergeUser {
    public static class Node<T>{
        public T value;
        public Node(T value){
            this.value = value;
        }
    }

    public static class UnionFindSet<T>{
        HashMap<T, Code01_UnionFind.Node> nodes = new HashMap<>();
        HashMap<Code01_UnionFind.Node<T>, Code01_UnionFind.Node<T>> represent = new HashMap<>();
        HashMap<Code01_UnionFind.Node<T>, Integer> setSize = new HashMap<>();

        public UnionFindSet(List<T> list) {
            for (T cur : list){
                Code01_UnionFind.Node<T> node = new Code01_UnionFind.Node(cur);
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

        private Code01_UnionFind.Node findRepresent(Code01_UnionFind.Node cur){
            Stack<Code01_UnionFind.Node> stack = new Stack<>();
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
                Code01_UnionFind.Node<T> aRepresent = represent.get(nodes.get(a));
                Code01_UnionFind.Node<T> bRepresent = represent.get(nodes.get(b));
                if (aRepresent != bRepresent) {
                    int aSetSize = setSize.get(aRepresent);
                    int bSetSize = setSize.get(bRepresent);
                    Code01_UnionFind.Node<T> big = aSetSize > bSetSize ? aRepresent : bRepresent;
                    Code01_UnionFind.Node<T> small = aSetSize > bSetSize ? bRepresent : aRepresent;
                    represent.put(small, big);
                    setSize.put(big, aSetSize + bSetSize);
                    setSize.remove(small);
                }
            }
        }

        public int getUnionSetSize(){
            return setSize.size();
        }
    }

    public static class User {
        public String a;
        public String b;
        public String c;

        public User(String a, String b, String c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static int mergeUsers(List<User> Users) {
        UnionFindSet<User> unionFindSet = new UnionFindSet<>(Users);
        HashMap<String, User> mapA = new HashMap<>();
        HashMap<String, User> mapB = new HashMap<>();
        HashMap<String, User> mapC = new HashMap<>();
        for (User user : Users) {
            if (mapA.containsKey(user.a)){
                unionFindSet.union(user, mapA.get(user.a));
            } else {
                mapA.put(user.a, user);
            }
            if (mapA.containsKey(user.b)){
                unionFindSet.union(user, mapA.get(user.b));
            } else {
                mapA.put(user.b, user);
            }
            if (mapA.containsKey(user.c)){
                unionFindSet.union(user, mapA.get(user.c));
            } else {
                mapA.put(user.c, user);
            }
        }
        return unionFindSet.getUnionSetSize();
    }

}
