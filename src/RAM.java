public class RAM {
    private String brand;
    private int capacity; // greater than zero. default 2

    public RAM(String brand, int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be greater than zero!");
        } else {
            this.brand = brand;
            this.capacity = capacity;
        }
    }

    public RAM() {
        this.capacity = 2;
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
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be greater than zero!");
        } else {
            this.capacity = capacity;
        }
    }
}
