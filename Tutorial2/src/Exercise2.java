import java.util.Scanner;

public class Exercise2 {

    public static int fact(int n) throws NonPositiveException {
        if (n < 0) {
            throw new NonPositiveException("fact(): Input is not positive: " + n);
        }
        if (n == 1 || n == 0) {
            return 1;
        }
        return fact(n - 1) * n;
    }

    public static int[] Bubble_Sort(int[] a) {
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    isSorted = false;
                }
            }
        }
        return a;
    }

    public static int search(int[] a, int x) throws NullPointerException, NotFoundException {

        try {
            int[] b = Bubble_Sort(a);

            if (b.length == 0) {
                throw new NullPointerException("The array is null");
            }

            for (int i = 0; i < b.length; i++) {
                if (a[i] == x) {
                    return i;
                }
            }
            throw new NotFoundException("Not found exception");

        } catch (Exception e) {
            throw new NullPointerException("x is not in array a: " + e.getMessage());
        }
    }


    public static int searchWhile(int[] a, int x) throws NotFoundException, IndexOutOfBoundsException {
        try {
            int[] b = Bubble_Sort(a);
            int i = 0;
            while (true) {
                i++;
                if (b[i] == x) {//b[2]==3
                    return i;
                }

            }

        } catch (IndexOutOfBoundsException e) {
            throw new NotFoundException("Not found the number");
        }
    }


    public static void main(String[] args) throws NotFoundException {
//        try {
//            int a = fact(5);
//            System.out.println(a);
//        } catch (NonPositiveException e) {
//            throw new RuntimeException(e);
//        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Length of array: ");
        int n = sc.nextInt();
        int[] a = new int[n];

        System.out.println("The element in array: ");
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        int[] b = Bubble_Sort(a);


        System.out.println("Please enter the number: ");
        int g = sc.nextInt();

        int result = searchWhile(b, g);
        System.out.println("The index in array is: " + result);


    }
}
