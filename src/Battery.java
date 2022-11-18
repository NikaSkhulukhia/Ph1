public class Battery {
    private String brand;
    private String type;
    private int capacity; // greater than zero, default 1000
    private int life; // greater or equal to 0 AND less or equal to 100, default 100

    public Battery(String brand, String type, int capacity, int life) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be greater than zero!");
        } else if (life < 0 || life > 100) {
            throw new IllegalArgumentException("life must be between 0 - 100 !");
        } else {
            this.brand = brand;
            this.type = type;
            this.capacity = capacity;
            this.life = life;
        }
    }

    public Battery(){
        this.capacity = 1000;
        this.life = 100;
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
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be greater than zero!");
        } else {
            this.capacity = capacity;
        }
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        if (life < 0 || life > 100) {
            throw new IllegalArgumentException("life must be between 0 - 100 !");
        } else {
            this.life = life;
        }
    }
}
