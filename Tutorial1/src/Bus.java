public class Bus extends Vehicle{

    private int[] routes;

    public int[] getRoutes() {
        return routes;
    }

    public Bus(String registrationNumber) {
        if ( validateRegistrationNumber(registrationNumber)) {
            super.setRegistrationNumber(registrationNumber);
        }
    }

    public Bus(String name, Double width, Double height, Integer seatingCapacity, Double length, Double weight) {
        super(name, width, height, seatingCapacity);
        if (validateLength(length)) {
            super.setLength(length);
        }
        if (validateWeight(weight)){
            this.setWeight(weight);
        }
    }

    public Bus() {
    }

    public boolean validateWeight(Double weight){
        return weight > 5000.0 && weight < 20000.0;

    }

    public boolean validateLength(Double length) {
        return length > 4.0 && length < 10.0;
    }

    public boolean validateRegistrationNumber(String registrationNumber){
        return  registrationNumber.trim().length()>6 && registrationNumber.trim().length() < 10;
    }

    public void setRoutes(int[] routes) {
        this.routes = routes;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        Bus a = new Bus("honda", 10.0, 25.0, 29, 8.0, 10000.0 );
        System.out.println(a);
    }
}
