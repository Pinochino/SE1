import java.util.Scanner;

public class Exercise5 {

    public static void divide(int[] a, int[] b) throws IndexOutOfBoundsException {
        if (a.length != b.length) {
            throw new IndexOutOfBoundsException("Arrays must be of the same length.");
        }

        for (int i = 0; i < a.length; i++) {
            if (b[i] == 0) {
                throw new ArithmeticException("Cannot divide by zero.");
            }
            b[i] = a[i] / b[i];
            System.out.print("The result is: " + b[i]);
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Length of array: ");
        int n = sc.nextInt();


        int[] a = new int[n];
        int[] b = new int[n];


        System.out.println("The element of array a: ");
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println("The element of array b: ");
        for (int i = 0; i < b.length; i++) {
            b[i] = sc.nextInt();
        }

        try {
            divide(a, b);
        } catch (ArithmeticException | IndexOutOfBoundsException e) {
            System.out.println("Error is: " + e.getMessage());
        }
    }


}
