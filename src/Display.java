public class Display {
    private String brand;
    private String type;
    private String resolution;
    private double size; // greater than zero, default 1

    public Display(String brand, String type, String resolution, double size) {
        if (size <= 0){
            throw new IllegalArgumentException("size must be greater than zero!");
        } else {
            this.brand = brand;
            this.type = type;
            this.resolution = resolution;
            this.size = size;
        }
    }

    public Display() {
        this.size = 1;
    }

    @Override
    public String toString() {
        return "Display{" +
                "brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", resolution='" + resolution + '\'' +
                ", size=" + size +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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
