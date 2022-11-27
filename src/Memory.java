import java.util.Objects;

public class Memory extends PhoneParts{
    private int capacity; // Memory total volume, must be greater than zero. default 4
    private int volumeUsed; // greater or equal to zero. default 0
    private int volumeFree; // greater or equal to zero. default same as capacity

    public Memory(String brand, int capacity, int volumeUsed) {
        if (capacity == 0)
            throw new IllegalArgumentException("capacity must be greater than zero!");
        else if (volumeUsed < 0){
            throw new IllegalArgumentException("volumeUsed must be greater or equal to zero!");
        } else if (volumeUsed > capacity) {
            throw new IllegalArgumentException("volumeUsed must be less or equal to total capacity!");
        } else {
            setBrand(brand);
            this.capacity = capacity;
            this.volumeUsed = volumeUsed;
            this.volumeFree = this.capacity - this.volumeUsed;
        }
    }

    public Memory(){
        this.capacity = 4;
        this.volumeUsed = 0;
        this.volumeFree = this.capacity;
    }

    @Override
    public boolean isUsable() {
        return false;
    }

    @Override
    public String toString() {
        return "Memory{" +
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
        this.volumeUsed = 0;
        this.volumeFree = this.capacity;
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

    public int getVolumeUsed() {
        return volumeUsed;
    }

    public void setVolumeUsed(int volumeUsed) {
        if (this.capacity == 0)
            throw new IllegalArgumentException("You must set total capacity greater than zero first!");
        else if (volumeUsed < 0){
            throw new IllegalArgumentException("volumeUsed must be greater or equal to zero!");
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
}
