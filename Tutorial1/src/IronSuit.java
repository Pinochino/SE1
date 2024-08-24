public class IronSuit extends Vehicle {

    public IronSuit(String name, Double width, Double height, Integer seatingCapacity, Double length, Double weight) {
        super(name, width, height, seatingCapacity, length, weight);
    }



    public static String fly() {
        return "Hanoi . . . . . . . . . . . . . . . Da Nang";
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        // 0.3 second
        try {
            int millis = 300;
            Thread.sleep(millis);
            System.out.println(fly());

        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }



}
