import java.util.Objects;

public class SatellitePhone extends Phone{
    private String nearestSatelliteSerialNumber;
    private Keyboard keyboard;

    public SatellitePhone(String nearestSatelliteSerialNumber, Keyboard keyboard) {
        this.nearestSatelliteSerialNumber = nearestSatelliteSerialNumber;
        this.keyboard = keyboard;
    }

    public SatellitePhone() {
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
        return "SatellitePhone{" +
                "nearestSatelliteSerialNumber='" + nearestSatelliteSerialNumber + '\'' +
                ", keyboard=" + keyboard +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        SatellitePhone that = (SatellitePhone) o;
        return Objects.equals(nearestSatelliteSerialNumber, that.nearestSatelliteSerialNumber)
                && Objects.equals(keyboard, that.keyboard)
                && Objects.equals(getSerialNumber(), that.getSerialNumber())
                && Objects.equals(getBrand(), that.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nearestSatelliteSerialNumber, keyboard, getSerialNumber(), getBrand());
    }

    public String getNearestSatelliteSerialNumber() {
        return nearestSatelliteSerialNumber;
    }

    public void setNearestSatelliteSerialNumber(String nearestSatelliteSerialNumber) {
        this.nearestSatelliteSerialNumber = nearestSatelliteSerialNumber;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }
}
