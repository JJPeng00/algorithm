package class01;

public class Code06_BSAwesome {
    public static void main(String[] args) {
        int[] arr = {5};
        int index = process(arr);
        System.out.println("index:" + index);
    }

    private static int process(int[] arr) {
        if (arr == null || arr.length < 1){
            return -1;
        } else if (arr.length == 1){
            return 0;
        }
        //先判断左右两边为最小值的情况
        int L = 0;
        int R = arr.length - 1;
        if (arr[0] < arr[1]){
            return 0;
        }else if (arr[R-1] > arr[R]){
            return R;
        }

        //通过二分找到局部最小值
        int mid = 0;
        while (L <= R){
            mid = L + ((R-L)>>1);
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]){
                return mid;
            } else if (arr[mid] > arr[mid - 1]){
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return mid;
    }
}
