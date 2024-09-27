import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class First10Primes {

    public static boolean firstPrimes(int a) {
        if (a < 1){
            return  false;
        }
        for (int i = 2; i <= a / 2 ; i++) {
            if (a % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int number = 2;

        while (arrayList.size() < 10){
            if (firstPrimes(number)){
             arrayList.add(number);
            }
            number++;
        }

        System.out.println("The prime array: ");
       for (int prime : arrayList){
           System.out.print(prime + " ");
       }
    }
}
