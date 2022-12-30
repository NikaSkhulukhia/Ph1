package phonehardware;

import enums.DisplayType;

import java.util.Objects;

public class Display extends PhoneParts {
    private DisplayType type;
    private String resolution;
    private double size;

    public Display(String brand, DisplayType type, String resolution, double size) {
            setBrand(brand);
            this.type = type;
            this.resolution = resolution;
            this.size = size;
    }

    public Display() {
    }

    @Override
    public boolean isUsable() {
        return true;
    }

    @Override
    public String toString() {
        return "PhoneParts.Display{" +
                "brand='" + getBrand() + '\'' +
                ", type='" + type.getLongName() + '\'' +
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

    public DisplayType getType() {
        return type;
    }

    public void setType(DisplayType type) {
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
        this.size = size;
    }
}
