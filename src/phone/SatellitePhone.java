package phone;

import exceptions.*;
import interfaces.IUpdate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import phonehardware.*;
import operationalsystem.OS;

import java.util.Objects;

public class SatellitePhone extends Phone implements IUpdate {
    private static final Logger LOGGER = LogManager.getLogger();
    private String nearestSatelliteSerialNumber;
    private Keyboard keyboard;
    private OS OS;

    public SatellitePhone(String nearestSatelliteSerialNumber, Keyboard keyboard) {
        this.nearestSatelliteSerialNumber = nearestSatelliteSerialNumber;
        this.keyboard = keyboard;
    }

    public SatellitePhone() {
    }

    @Override
    public void startCall(Phone receiverPhone) {
        try {
            super.startCall(receiverPhone);
            String phTempName = this.getBrand() + "-" + this.getSerialNumber();
            LOGGER.trace("<" + phTempName + ">: " + "PhoneData.Call started");
            LOGGER.trace("<" + phTempName + ">: " + "PhoneData.Call start date: "
                    + getCurrentCall().getCallStartDate().toString());
            LOGGER.trace("<" + phTempName + ">: " + "Caller number: "
                    + this.getPhoneNumber().getFullNumber());
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
            String phTempName = this.getBrand() + "-" + getSerialNumber();
            LOGGER.trace("<" + phTempName + ">: " + "Call Ended");
            LOGGER.trace("<" + phTempName + ">: " + "Call start date: " + this.getLastCall().getCallStartDate().toString());
            LOGGER.trace("<" + phTempName + ">: " + "Call start date: " + this.getLastCall().getCallEndDate().toString());
            LOGGER.trace("<" + phTempName + ">: " + "Caller number: " + this.getLastCall().getCallerNumber().getFullNumber());
            LOGGER.trace("<" + phTempName + ">: " + "Receiver number: " + this.getLastCall().getReceiverNumber().getFullNumber());
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
            String phTempName = this.getBrand() + "-" + this.getSerialNumber();
            LOGGER.trace("<" + phTempName + ">: " + "Message sent");
            LOGGER.trace("<" + phTempName + ">: " + "Message send date: " + this.getLastMessageSent().getMessageSendDate().toString());
            LOGGER.trace("<" + phTempName + ">: " + "Sender number: " + this.getLastMessageSent().getMessageSenderNumber().getFullNumber());
            LOGGER.trace("<" + phTempName + ">: " + "Receiver number: " + this.getLastMessageSent().getMessageReceiverNumber().getFullNumber());
            LOGGER.trace("<" + phTempName + ">: " + "Message text: " + this.getLastMessageSent().getMessageText());
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
    public void update() throws OSNotFoundException {
        String phTempName = this.getBrand() + "-" + this.getSerialNumber();
        if (this.OS == null) {
            throw new OSNotFoundException("Update not successful, no OS installed", "OS is null");
        } else {
            this.OS.update();
            LOGGER.trace("<" + phTempName + ">: " + "Update successful");
            LOGGER.trace("<" + phTempName + ">: " + "PhoneSoftware.OS new version: " + this.OS.getVersion());
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
