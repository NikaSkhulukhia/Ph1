public class RAM {
    private String brand;
    private int capacity;

    public RAM(String brand, int capacity) {
        this.brand = brand;
        this.capacity = capacity;
    }

    public RAM() {
    }

    @Override
    public String toString() {
        return "RAM{" +
                "brand='" + brand + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
