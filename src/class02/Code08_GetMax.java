package class02;

public class Code08_GetMax {
    public static int getMax(int[] arr, int L, int R){
        if (L == R){
            return arr[L];
        }
        int mid = L + ((R-L)>>1);
        int leftMax = getMax(arr, L, mid);
        int rightMax = getMax(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }
    public static void main(String[] args) {
        int[] arr = {1,5,9,3,6,4,2,8,7,3,100,188,199,522,520};
        int max = getMax(arr, 0, arr.length-1);
        System.out.println(max);
    }
}
