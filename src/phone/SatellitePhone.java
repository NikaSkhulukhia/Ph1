package phone;

import interfaces.IUpdate;
import phonedata.*;
import phonehardware.*;
import phonesoftware.Software;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

public class SatellitePhone extends Phone implements IUpdate {
    private String nearestSatelliteSerialNumber;
    private Keyboard keyboard;
    private Software software;

    public SatellitePhone(String nearestSatelliteSerialNumber, Keyboard keyboard) {
        this.nearestSatelliteSerialNumber = nearestSatelliteSerialNumber;
        this.keyboard = keyboard;
    }

    public SatellitePhone() {
    }

    @Override
    public void startCall(Phone receiverPhone) {
        super.startCall(receiverPhone);
        System.out.println("<" + this.getBrand() + "-" + this.getSerialNumber() + ">: " + "PhoneData.Call started");
            System.out.println("<" + this.getBrand() + "-" + this.getSerialNumber() + ">: " + "PhoneData.Call start date: "
                    + getCurrentCall().getCallStartDate().toString());
            System.out.println("<" + this.getBrand() + "-" + this.getSerialNumber() + ">: " + "Caller number: "
                    + this.getPhoneNumber().getFullNumber());
            System.out.println("<" + this.getBrand() + "-" + this.getSerialNumber() + ">: " + "Receiver number: "
                    + receiverPhone.getPhoneNumber().getFullNumber());
            System.out.println("<" + this.getBrand() + "-" + this.getSerialNumber() + ">: . . . ");
    }

    @Override
    public void endCall() {
        super.endCall();
            System.out.println("<" + this.getSerialNumber() + ">: " + "PhoneData.Call Ended");
            System.out.println("<" + this.getSerialNumber() + ">: " + "PhoneData.Call start date: " + this.getLastCall().getCallStartDate().toString());
            System.out.println("<" + this.getSerialNumber() + ">: " + "PhoneData.Call start date: " + this.getLastCall().getCallEndDate().toString());
            System.out.println("<" + this.getSerialNumber() + ">: " + "Caller number: " + this.getLastCall().getCallerNumber().getFullNumber());
            System.out.println("<" + this.getSerialNumber() + ">: " + "Receiver number: " + this.getLastCall().getReceiverNumber().getFullNumber());
            System.out.println("<" + this.getSerialNumber() + ">: . . . ");
    }

    @Override
    public void sendMessage(Phone receiverPhone, String messageText) {
            super.sendMessage(receiverPhone, messageText);
            System.out.println("<" + this.getSerialNumber() + ">: " + "PhoneData.Message sent");
            System.out.println("<" + this.getSerialNumber() + ">: " + "message send date: " + this.getLastMessageSent().getMessageSendDate().toString());
            System.out.println("<" + this.getSerialNumber() + ">: " + "Sender number: " + this.getLastMessageSent().getMessageSenderNumber().getFullNumber());
            System.out.println("<" + this.getSerialNumber() + ">: " + "Receiver number: " + this.getLastMessageSent().getMessageReceiverNumber().getFullNumber());
            System.out.println("<" + this.getSerialNumber() + ">: " + "PhoneData.Message text: " + this.getLastMessageSent().getMessageText());
            System.out.println("<" + this.getSerialNumber() + ">: . . . ");

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
        if (this.software == null) {
            System.out.println("<Satelite phone>: " + "Update not successful, no software installed");
        } else {
            this.software.update();
            // simulate/print reset
            System.out.println("<Satelite phone>: " + "Update successful");
            System.out.println("<Satelite phone>: " + "PhoneSoftware.Software new version: " + this.software.getVersion());
            System.out.println("<Satelite phone>: . . . ");
        }
        
    }

    @Override
    public String toString() {
        return "Phone.SatellitePhone{" +
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
