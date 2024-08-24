import java.util.Scanner;

public class Exercise3 {

    public static int totalArray(int[] a) {
        int sum = 0;
        if (a.length == 0) {
//            throw new RuntimeException("The array is null");
            return 0;
        }
        for (int j : a) {
            sum += j;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Length of array: ");
        int n = sc.nextInt();
        int[] a = new int[n];

        System.out.println("The element in array: ");
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        int result = totalArray(a);
        System.out.println("The total of array is" + result);
    }


}
