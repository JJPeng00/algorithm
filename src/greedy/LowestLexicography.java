package greedy;

import java.util.*;

public class LowestLexicography {

    public static String fullyArranged(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        List<String> allResults = new LinkedList<>();
        Set<Integer> usedIndex = new HashSet<>();
        notUsedStringsArrange(strs, allResults, "", usedIndex);
        String lowestResult = allResults.get(0);
        for (String result : allResults) {
            if (result.compareTo(lowestResult) < 0) {
                lowestResult = result;
            }
        }
        return lowestResult;
    }

    private static void notUsedStringsArrange(String[] strs, List<String> allResults, String curCombination, Set<Integer> usedIndex) {
        if (usedIndex.size() == strs.length) {
            allResults.add(curCombination);
        } else {
            for (int i = 0; i < strs.length; i++) {
                if (!usedIndex.contains(i)) {
                    curCombination += strs[i];
                    usedIndex.add(i);
                    notUsedStringsArrange(strs, allResults, curCombination, usedIndex);
                    usedIndex.remove(i);
                }
            }
        }
    }


    public static class MyStringComparator implements Comparator<String > {
        @Override
        public int compare(String a, String b) {
            return (a+b).compareTo(b+a);
        }
    }
    public static String greedyArrange(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, new MyStringComparator());
        String result = "";
        for (String str : strs) {
            result += str;
        }
        return result;
    }

    // for test
    public static String generateRandomString(int strLen) {
        char[] ans = new char[(int) (Math.random() * strLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            int value = (int) (Math.random() * 5);
            ans[i] = (Math.random() <= 0.5) ? (char) (65 + value) : (char) (97 + value);
        }
        return String.valueOf(ans);
    }

    // for test
    public static String[] generateRandomStringArray(int arrLen, int strLen) {
        String[] ans = new String[(int) (Math.random() * arrLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = generateRandomString(strLen);
        }
        return ans;
    }

    // for test
    public static String[] copyStringArray(String[] arr) {
        String[] ans = new String[arr.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = String.valueOf(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int arrLen = 6;
        int strLen = 5;
        int testTimes = 100000;
        String[] arr = generateRandomStringArray(arrLen, strLen);
        System.out.println("先打印一个生成的字符串");
        for (String str : arr) {
            System.out.print(str + ",");
        }
        System.out.println();
        System.out.println("test begin");
        for (int i = 0; i < testTimes; i++) {
            String[] arr1 = generateRandomStringArray(arrLen, strLen);
            String[] arr2 = copyStringArray(arr1);
            if (!fullyArranged(arr1).equals(greedyArrange(arr2))) {
                for (String str : arr1) {
                    System.out.print(str + ",");
                }
                System.out.println();
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }
}
