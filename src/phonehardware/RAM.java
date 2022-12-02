package phonehardware;

import java.util.Objects;

public class RAM extends PhoneParts{
    private int capacity; // greater than zero. default 2

    public RAM(String brand, int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be greater than zero!");
        } else {
            setBrand(brand);
            this.capacity = capacity;
        }
    }

    public RAM() {
        this.capacity = 2;
    }

    @Override
    public boolean isUsable() {
        return false;
    }

    @Override
    public String toString() {
        return "PhoneParts.RAM{" +
                "brand='" + getBrand() + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        RAM ram = (RAM) o;
        return capacity == ram.capacity
                && Objects.equals(getSerialNumber(), ram.getSerialNumber())
                && Objects.equals(getBrand(), ram.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(capacity, getSerialNumber(), getBrand());
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
