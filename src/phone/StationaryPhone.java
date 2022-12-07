package phone;

import phonedata.Call;
import phonedata.Message;
import phonehardware.Keyboard;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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
            super.startCall(receiverPhone);
            System.out.println("<" + this.getBrand() + "-" + this.getSerialNumber() + ">: " + "PhoneData.Call started");
            System.out.println("<" + this.getBrand() + "-" + this.getSerialNumber() + ">: " + "PhoneData.Call start date: "
                    + getCurrentCall().getCallStartDate().toString());
            System.out.println("<" + this.getBrand() + "-" + this.getSerialNumber() + ">: " + "Caller number: "
                    + this.getPhoneNumber().getFullNumber());
            System.out.println("<" + this.getBrand() + "-" + this.getSerialNumber() + ">: " + "Receiver number: "
                    + receiverPhone.getPhoneNumber().getFullNumber());
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
    public String toString() {
        return "Phone.StationaryPhone{" +
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
