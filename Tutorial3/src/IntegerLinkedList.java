import java.util.*;

public class IntegerLinkedList extends LinkedList<Integer> {


    public  class EvenIterator implements Iterator<Integer>{
        private int currentIndex = 0;

        public EvenIterator(){

        }

        @Override
        public boolean hasNext() {
            while (currentIndex < size()){
                if (get(currentIndex) % 2 == 0){
                    return true;
                }
                currentIndex++;
            }
            return false;
        }

        @Override
        public Integer next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
                Integer nextEven = get(currentIndex);
                currentIndex++;
            return nextEven;
        }


    }

    public  EvenIterator evenIterator(){
        return  new EvenIterator();
    }

    public static void main(String[] args) {
      IntegerLinkedList integers = new IntegerLinkedList();

      integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        integers.add(7);

        EvenIterator evenIterator = integers.evenIterator();

        System.out.println("Even elements in the list: ");
        while (evenIterator.hasNext()){
        Integer currentIndex = evenIterator.next();
        if (currentIndex > 2){
            System.out.println(currentIndex);
        }
    }

    }
}
