public class Battery {
    private String brand;
    private String type;
    private int capacity;
    private int life;

    public Battery(String brand, String type, int capacity, int life) {
        this.brand = brand;
        this.type = type;
        this.capacity = capacity;
        this.life = life;
    }

    public Battery(){

    }

    @Override
    public String toString() {
        String result = "This is " + this.type + " battery, with volume of "
                + this.capacity + " mAH, made by " + this.brand + ".";
        result += " Currently it is charged for " + this.life + "%.";
        return result;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
