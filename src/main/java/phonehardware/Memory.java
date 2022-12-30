package phonehardware;

import enums.FlashStorageType;
import exceptions.IncorrectCapacityException;
import exceptions.IncorrectHardwareVolumeException;

import java.util.Objects;

public class Memory extends PhoneParts{
    private int capacity; // PhoneParts.Memory total volume, must be greater than zero. default 4
    private int volumeUsed; // greater or equal to zero. default 0
    private int volumeFree; // greater or equal to zero. default same as capacity
    private FlashStorageType type;

    public Memory(String brand, int capacity, int volumeUsed, FlashStorageType type)
            throws IncorrectCapacityException, IncorrectHardwareVolumeException {
        if (capacity == 0)
            throw new IncorrectCapacityException("capacity must be greater than zero!", "incorrect capacity");
        else if (volumeUsed < 0){
            throw new IncorrectHardwareVolumeException("volumeUsed must be greater or equal to zero!", "incorrect volume");
        } else if (volumeUsed > capacity) {
            throw new IncorrectHardwareVolumeException("volumeUsed must be less or equal to total capacity!", "incorrect volume");
        } else {
            setBrand(brand);
            this.capacity = capacity;
            this.volumeUsed = volumeUsed;
            this.volumeFree = this.capacity - this.volumeUsed;
            this.type = type;
        }
    }

    public Memory(){
        capacity = 4;
        volumeUsed = 0;
        volumeFree = capacity;
    }

    @Override
    public boolean isUsable() {
        return true;
    }

    @Override
    public String toString() {
        return "PhoneParts.Memory{" +
                "brand='" + getBrand() + '\'' +
                ", capacity=" + capacity +
                ", volumeUsed=" + volumeUsed +
                ", volumeFree=" + volumeFree +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        Memory memory = (Memory) o;
        return capacity == memory.capacity
                && volumeUsed == memory.volumeUsed
                && volumeFree == memory.volumeFree
                && Objects.equals(getSerialNumber(), memory.getSerialNumber())
                && Objects.equals(getBrand(), memory.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(capacity, volumeUsed, volumeFree, getSerialNumber(), getBrand());
    }

    public void reset() {
        volumeUsed = 0;
        volumeFree = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) throws IncorrectCapacityException {
        if (capacity <= 0) {
            throw new IncorrectCapacityException("capacity must be greater than zero!");
        } else {
            this.capacity = capacity;
        }
    }

    public int getVolumeUsed() {
        return volumeUsed;
    }

    public void setVolumeUsed(int volumeUsed) throws IncorrectCapacityException, IncorrectHardwareVolumeException {
        if (this.capacity == 0)
            throw new IncorrectCapacityException("You must set total capacity greater than zero first!");
        else if (volumeUsed < 0){
            throw new IncorrectHardwareVolumeException("volumeUsed must be greater or equal to zero!");
        } else if (volumeUsed > this.capacity) {
            throw new IllegalArgumentException("volumeUsed must be less or equal to total capacity!");
        } else {
            this.volumeUsed = volumeUsed;
            this.volumeFree = this.capacity - this.volumeUsed;
        }
    }

    public int getVolumeFree() {
        return volumeFree;
    }

    public FlashStorageType getType() {
        return type;
    }

    public void setType(FlashStorageType type) {
        this.type = type;
    }
}
