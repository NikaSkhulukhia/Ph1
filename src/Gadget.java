public interface Gadget {
    void charge(int time);
    void changeBattery(String type, String brand, int capacity);
    void reset();
    void update();
}
