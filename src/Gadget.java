public interface Gadget {
    void Charge(int time) throws IllegalAccessException;
    void ChangeBattery(String type, String brand, int capacity);
    void reset();
}
