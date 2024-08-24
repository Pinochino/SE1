public class Excersice4 {

    public static void combine(int[] a, int[] b){
        int sum = 0;

        int[] c = {};
        for (int i = 0; i < b.length; i++) {
            sum += b[i];
        }

        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] * sum;
        }

        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + "");
        }
    }

    public static void main(String[] args) {

    }
}
