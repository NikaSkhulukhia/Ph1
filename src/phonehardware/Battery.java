package phonehardware;

import java.util.Objects;

public class Battery extends PhoneParts{
    private String type;
    private int capacity; // greater than zero, default 1000
    private int life; // greater or equal to 0 AND less or equal to 100, default 100

    public Battery(String brand, String type, int capacity, int life) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be greater than zero!");
        } else if (life < 0 || life > 100) {
            throw new IllegalArgumentException("life must be between 0 - 100 !");
        } else {
            this.setBrand(brand);
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
    public boolean isUsable() {
        return false;
    }

    @Override
    public String toString() {
        String result = "This is " + this.type + " battery, with volume of "
                + this.capacity + " mAH, made by " + this.getBrand() + ".";
        result += " Currently it is charged for " + this.life + "%.";
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        Battery battery = (Battery) o;
        return capacity == battery.capacity
                && life == battery.life
                && Objects.equals(type, battery.type)
                && Objects.equals(getBrand(), battery.getBrand())
                && Objects.equals(getSerialNumber(), battery.getSerialNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, capacity, life, getSerialNumber(), getBrand());
    }


    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
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
