import java.util.ArrayList;
import java.util.Iterator;

public class OddAlphabetList {

    public static ArrayList<Character> findArray(ArrayList<Character> arrayList){
        for (char i = 'a'; i < 'z'; i++) {
            int code = (int) i;
            if (code % 2 != 0){
                arrayList.add(i);
            }
        }
        return arrayList;
    }

    public static void main(String[] args) {

        ArrayList<Character> b = new ArrayList<Character>();
        ArrayList<Character> result = findArray(b);
        Iterator<Character> iterator = result.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
    }
}
