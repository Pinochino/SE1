public class Excercise3 {

    public static int totalArray(int[] a){
        int sum = 0;
        if (a.length == 0) {
//            throw new RuntimeException("The array is null");
            return 0;
        }
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return  sum;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5};
        int result = totalArray(a);

        System.out.println(result);
    }


}
