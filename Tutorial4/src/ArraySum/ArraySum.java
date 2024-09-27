package ArraySum;

public class ArraySum {

    public static Integer arraySum(int[] arr) throws Exception {
        int sum = 0;

        if (arr == null) {
            throw new Exception("Array is null");
        }

        if (arr.length == 0) {
            throw new Exception("Array is empty");
        }

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
