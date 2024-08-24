public class Car extends Vehicle{
    private String owner;

    public Car(String name, Double width, Double height, Integer seatingCapacity, Double length, Double weight, String owner) {
        super(name, width, height, seatingCapacity, length, weight);
        this.owner = owner;
    }

    public Car() {
    }

    public Car(String registrationNumber) {
        if ( validateRegistrationNumber(registrationNumber)) {
            super.setRegistrationNumber(registrationNumber);
        }
    }
    public Car(String name, Double width, Double height, Integer seatingCapacity, Double length, Double weight) {
        super(name, width, height, seatingCapacity);

        if (validateLength(length)) {
            super.setLength(length);
        }
        if (validateWeight(weight)){
            this.setWeight(weight);
        }
    }

    public boolean validateWeight(double weight)  {
        return weight > 1000 && weight < 2000;

    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean validateLength(double length) {
        return length > 1.5 && length < 3.5;
    }

    public boolean validateRegistrationNumber(String registrationNumber){
        return  registrationNumber.trim().length()>6 && registrationNumber.trim().length() < 10;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
