package unionfindset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeUsers {
    public static class User {
        String a;
        String b;
        String c;

        public User(String a, String b, String c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static int getDiffUserSum(List<User> users) {
        UnionFindSetI.UnionFindSet<User> unionFindSet = new UnionFindSetI.UnionFindSet(users);
        HashMap<String, User> aFieldUserMap = new HashMap<>();
        HashMap<String, User> bFieldUserMap = new HashMap<>();
        HashMap<String, User> cFieldUserMap = new HashMap<>();

        for (User user : users) {
            if (aFieldUserMap.containsKey(user.a)) {
                unionFindSet.union(user, aFieldUserMap.get(user.a));
            } else {
                aFieldUserMap.put(user.a, user);
            }
            if (bFieldUserMap.containsKey(user.b)) {
                unionFindSet.union(user, bFieldUserMap.get(user.b));
            } else {
                bFieldUserMap.put(user.b, user);
            }
            if (cFieldUserMap.containsKey(user.c)) {
                unionFindSet.union(user, cFieldUserMap.get(user.c));
            } else {
                cFieldUserMap.put(user.c, user);
            }
        }
        return unionFindSet.getSetSize();
    }

    public static void main(String[] args) {
        List<User> users = Stream.of(new User("1", "10", "13"), new User("2", "10", "200"), new User("1", "20", "300")).collect(Collectors.toList());
        System.out.println(getDiffUserSum(users));
    }
}
