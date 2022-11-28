import java.util.Objects;

public class StationaryPhone extends Phone{
    private Keyboard keyboard;
    private boolean hasWire;

    public StationaryPhone(Keyboard keyboard, boolean hasWire) {
        this.keyboard = keyboard;
        this.hasWire = hasWire;
    }

    public StationaryPhone() {
    }

    @Override
    public void startCall(Phone receiverPhone) {

    }

    @Override
    public void endCall() {

    }

    @Override
    public void sendMessage(Phone receiverPhone, String messageText) {

    }


    @Override
    public void charge(int time) {

    }

    @Override
    public void changeBattery(String type, String brand, int capacity) {

    }

    @Override
    public void reset() {

    }

    @Override
    public void update() {

    }

    @Override
    public String toString() {
        return "StationaryPhone{" +
                "keyboard=" + getSerialNumber() +
                "keyboard=" + getBrand() +
                "keyboard=" + getOwnerPerson() +
                "keyboard=" + keyboard +
                ", hasWire=" + hasWire +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        StationaryPhone that = (StationaryPhone) o;
        return hasWire == that.hasWire
                && Objects.equals(keyboard, that.keyboard)
                && Objects.equals(getBrand(), that.getBrand())
                && Objects.equals(getSerialNumber(), that.getSerialNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyboard, hasWire, getBrand(), getSerialNumber());
    }
}
