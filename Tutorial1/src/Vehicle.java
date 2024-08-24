public class Vehicle {

    private String name;
    private Double width;
    private Double height;
    private Integer seatingCapacity;
    private Double length;
    private Double weight;

    private String registrationNumber;

    public Vehicle() {
    }

    public Vehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Vehicle(String name, Double width , Double height, Integer seatingCapacity)  {
        if (validateName(name)) {
            this.name = name;
        }
        if (validateHeight(height)){
            this.height = height;
        }
        if (validateWidth(width)){
            this.width = width;
        }
        if (validateSeatingCapacity(seatingCapacity)) {
            this.seatingCapacity = seatingCapacity;
        }

    }

    public Vehicle(String name, Double width, Double height, Integer seatingCapacity, Double length, Double weight)  {
        if (validateName(name)) {
            this.name = name;
        }
        if (validateHeight(height)){
            this.height = height;
        }
        if (validateWidth(width)){
            this.width = width;
        }
        if (validateSeatingCapacity(seatingCapacity)) {
            this.seatingCapacity = seatingCapacity;
        }
        if (validateLength(length)) {
            this.length = length;
        }
        if (validateWeight(weight)) {
            this.weight = weight;
        }
    }



    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Integer getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(Integer seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public boolean validateName(String name)  {
        return !name.isEmpty() && name.length() < 100;

    }

    public boolean validateWidth(Double width) {
       return width > 0;
    }

    public boolean validateHeight(Double height)  {
       return height > 0;
    }

    public boolean validateLength(Double length) {
       return length > 0;
    }

    public boolean validateWeight(Double weight)  {
        return weight >  0;

    }

    public boolean validateSeatingCapacity(Integer seatingCapacity) {
        return seatingCapacity > 0;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", seatingCapacity=" + seatingCapacity +
                ", length=" + length +
                ", weight=" + weight +
                '}';
    }
}
