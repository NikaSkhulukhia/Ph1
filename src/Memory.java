public class Memory {
    private String brand;
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
            this.brand = brand;
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
    public String toString() {
        return "Memory{" +
                "brand='" + brand + '\'' +
                ", capacity=" + capacity +
                ", volumeUsed=" + volumeUsed +
                ", volumeFree=" + volumeFree +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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
