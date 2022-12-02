package phonehardware;

import java.util.Objects;

public class Display extends PhoneParts {
    private String type;
    private String resolution;
    private double size; // greater than zero, default 1

    public Display(String brand, String type, String resolution, double size) {
        if (size <= 0){
            throw new IllegalArgumentException("size must be greater than zero!");
        } else {
            setBrand(brand);
            this.type = type;
            this.resolution = resolution;
            this.size = size;
        }
    }

    public Display() {
        this.size = 1;
    }

    @Override
    public boolean isUsable() {
        return false;
    }

    @Override
    public String toString() {
        return "PhoneParts.Display{" +
                "brand='" + getBrand() + '\'' +
                ", type='" + type + '\'' +
                ", resolution='" + resolution + '\'' +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        Display display = (Display) o;
        return Double.compare(display.size, size) == 0
                && Objects.equals(type, display.type)
                && Objects.equals(resolution, display.resolution)
                && Objects.equals(this.getBrand(), display.getBrand())
                && Objects.equals(this.getSerialNumber(), display.getSerialNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, resolution, size, getSerialNumber(), getBrand());
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        if (size <= 0){
            throw new IllegalArgumentException("size must be greater than zero!");
        } else {
            this.size = size;
        }
    }
}
