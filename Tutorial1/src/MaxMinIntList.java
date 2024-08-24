import java.util.ArrayList;

public class MaxMinIntList {

    private ArrayList<Double> arrayList;

    public ArrayList<Double> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Double> arrayList) {
        this.arrayList = arrayList;
    }

    private static Double min(ArrayList<Double> arrayList) {
        Double minNumber = arrayList.get(0);
        for (int i = 0; i < arrayList.size(); i++) {
            if (minNumber > arrayList.get(i)){
               minNumber = arrayList.get(i);
            }
        }
        return minNumber;
    }

    private static Double max(ArrayList<Double> arrayList) {
        Double minNumber = arrayList.get(0);
        for (int i = 0; i < arrayList.size(); i++) {
            if (minNumber < arrayList.get(i)){
                minNumber = arrayList.get(i);
            }
        }
        return minNumber;
    }


        public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<>(3);
        list.add(4.0);
        list.add(1.2);
        list.add(5.6);
        Double a = min(list);
            Double b = max(list);

            System.out.println(a);
            System.out.println(b);

    }
}
