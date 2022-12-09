package phone;

import exceptions.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import phonedata.Call;
import phonedata.Message;
import phonehardware.Keyboard;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

public class StationaryPhone extends Phone{
    private static final Logger LOGGER = LogManager.getLogger();
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
        try {
            super.startCall(receiverPhone);
            String phTempName = getBrand() + "-ST-" + getSerialNumber();
            LOGGER.trace("<" + phTempName + ">: " + "PhoneData.Call started");
            LOGGER.trace("<" + phTempName + ">: " + "PhoneData.Call start date: "
                    + getCurrentCall().getCallStartDate().toString());
            LOGGER.trace("<" + phTempName + ">: " + "Caller number: "
                    + getPhoneNumber().getFullNumber());
            LOGGER.trace("<" + phTempName + ">: " + "Receiver number: "
                    + receiverPhone.getPhoneNumber().getFullNumber());
            LOGGER.trace("<" + phTempName + ">: . . . ");
        } catch (PhoneNotFoundException e) {
            LOGGER.error(e.getMessage());
            LOGGER.debug("receiver phone: " + receiverPhone.toString());
        } catch (PhoneAlreadyOnCallException e) {
            LOGGER.error(e.getMessage());
            LOGGER.debug("isOnCall: " + isOnCall());
            LOGGER.debug("currentCall: " + getCurrentCall());
        }
    }

    @Override
    public void endCall() {
        try {
            super.endCall();
            String phTempName = getBrand() + "-ST-" + getSerialNumber();
            LOGGER.trace("<" + phTempName + ">: " + "Call Ended");
            LOGGER.trace("<" + phTempName + ">: " + "Call start date: " + getLastCall().getCallStartDate().toString());
            LOGGER.trace("<" + phTempName + ">: " + "Call start date: " + getLastCall().getCallEndDate().toString());
            LOGGER.trace("<" + phTempName + ">: " + "Caller number: " + getLastCall().getCallerNumber().getFullNumber());
            LOGGER.trace("<" + phTempName + ">: " + "Receiver number: " + getLastCall().getReceiverNumber().getFullNumber());
        } catch (CallNotFoundException e) {
            LOGGER.error(e.getMessage());
            LOGGER.debug("isOnCall: " + isOnCall());
            LOGGER.debug("currentCall: " + getCurrentCall());
        }
    }

    @Override
    public void sendMessage(Phone receiverPhone, String messageText) {
        try {
            super.sendMessage(receiverPhone, messageText);
            String phTempName = getBrand() + "-ST-" + getSerialNumber();
            LOGGER.trace("<" + phTempName + ">: " + "Message sent");
            LOGGER.trace("<" + phTempName + ">: " + "Message send date: " + getLastMessageSent().getMessageSendDate().toString());
            LOGGER.trace("<" + phTempName + ">: " + "Sender number: " + getLastMessageSent().getMessageSenderNumber().getFullNumber());
            LOGGER.trace("<" + phTempName + ">: " + "Receiver number: " + getLastMessageSent().getMessageReceiverNumber().getFullNumber());
            LOGGER.trace("<" + phTempName + ">: " + "Message text: " + getLastMessageSent().getMessageText());
        } catch (PhoneNotFoundException e) {
            LOGGER.error(e.getMessage());
            LOGGER.debug("receiver phone: " + receiverPhone.toString());
        } catch (BatteryNotFoundException e) {
            LOGGER.error(e.getMessage());
            LOGGER.debug("battery: " + getBattery().toString());
        } catch (BatteryLowException e) {
            LOGGER.error(e.getMessage());
            LOGGER.debug("battery: " + getBattery().toString());
            LOGGER.debug("battery life: " + getBattery().getLife());
        }
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
                "brand=" + getBrand() +
                "owner=" + getOwnerPerson() +
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
