public class Body {
    private double length; // greater than zero, default 1
    private double width; // greater than zero, default 1
    private double height; // greater than zero, default 1
    private double weight; // greater than zero, default 1
    private String build;

    public Body(double length, double width, double height, double weight, String build) {
        if (width <= 0){
            throw new IllegalArgumentException("width must be greater than zero!");
        }
        else if (height <= 0){
            throw new IllegalArgumentException("height must be greater than zero!");
        }
        else if (weight <= 0){
            throw new IllegalArgumentException("weight must be greater than zero!");
        }
        else if (length <= 0){
            throw new IllegalArgumentException("length must be greater than zero!");
        }
        else {
            this.length = length;
            this.width = width;
            this.height = height;
            this.weight = weight;
            this.build = build;
        }
    }

    public Body() {
        this.length = 1;
        this.weight = 1;
        this.width = 1;
        this.height = 1;
    }

    @Override
    public String toString() {
        return "Body{" +
                "length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", weight=" + weight +
                ", build='" + build + '\'' +
                '}';
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (length <= 0){
            throw new IllegalArgumentException("length must be greater than zero!");
        } else {
            this.length = length;
        }
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width <= 0){
            throw new IllegalArgumentException("width must be greater than zero!");
        } else {
            this.width = width;
        }
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height <= 0){
            throw new IllegalArgumentException("height must be greater than zero!");
        } else {
            this.height = height;
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight <= 0){
            throw new IllegalArgumentException("weight must be greater than zero!");
        } else {
            this.weight = weight;
        }
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }
}
