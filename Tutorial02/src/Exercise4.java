public class Exercise4 {

    public static int[] combine(int[] a, int[] b) {
        int sum = 0;

        for (int j : b) {
            sum += j;
        }

        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] * sum;
        }

        return a;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {4, 5};

        int[] result = combine(a, b);

        for (int j : result) {
            System.out.println(j);
        }
    }
}
