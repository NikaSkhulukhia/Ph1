package phonehardware;

import enums.BatteryType;
import exceptions.IncorrectBatteryLifeException;
import exceptions.IncorrectCapacityException;

import java.util.Objects;

public class Battery extends PhoneParts{
    private BatteryType type;
    private int capacity; // greater than zero, default 1000
    private int life; // greater or equal to 0 AND less or equal to 100, default 100

    public Battery(String brand, BatteryType type, int capacity, int life) throws IncorrectCapacityException, IncorrectBatteryLifeException {
        if (capacity <= 0) {
            throw new IncorrectCapacityException("capacity must be greater than zero!", "incorrect capacity");
        } else if (life < 0 || life > 100) {
            throw new IncorrectBatteryLifeException("life must be between 0 - 100 !", "incorrect battery life");
        } else {
            setBrand(brand);
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
        return true;
    }

    @Override
    public String toString() {
        String result = type.getDescription() + " battery, with volume of "
                + capacity + " mAH, made by " + getBrand() + ".";
        result += " Currently charged for " + life + "%.";
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


    public BatteryType getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setType(BatteryType type) {
        this.type = type;
    }

    public void setCapacity(int capacity) throws IncorrectCapacityException {
        if (capacity <= 0) {
            throw new IncorrectCapacityException("capacity must be greater than zero!", "incorrect capacity");
        } else {
            this.capacity = capacity;
        }
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) throws IncorrectBatteryLifeException {
        if (life < 0 || life > 100) {
            throw new IncorrectBatteryLifeException("life must be between 0 - 100 !", "incorrect battery life");
        } else {
            this.life = life;
        }
    }


}
