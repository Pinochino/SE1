import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class FibonacciList {

    public static int fibonacciList(int a){
    if (a == 0) {
        return 0;
    } else if (a == 1) {
        return  1;
    } else {
        return fibonacciList(a - 1) + fibonacciList(a - 2)  ;

    }
    }

    public static void main(String[] args) {
        int a = 5;
       for (int i = 0; i < a; i++){
           System.out.print(fibonacciList(i) + " ");
       }
    }
}
