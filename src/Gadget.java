public interface Gadget {
    void Charge(int time);
    void ChangeBattery(String type, String brand, int capacity);
    void Reset();
    void Update();
}
