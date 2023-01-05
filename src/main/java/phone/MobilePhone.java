package phone;

import enums.BatteryType;
import exceptions.*;
import interfaces.IUpdate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import person.Person;
import phonehardware.Battery;
import phonehardware.Camera;
import phonehardware.Display;
import operationalsystem.OS;
import phonedata.Number;
import java.util.Objects;
import java.util.function.BinaryOperator;

public class MobilePhone extends Phone implements IUpdate {
    private static final Logger LOGGER = LogManager.getLogger();
    private String name;
    private Camera cameraFront;
    private Camera cameraRear;
    private Display display;
    private OS OS;

    public MobilePhone(String name, String brand, String serialNumber, Number phoneNumber, Person ownerPerson) {
        this.name = name;
        setBrand(brand);
        setSerialNumber(serialNumber);
        setPhoneNumber(phoneNumber);
        setOwnerPerson(ownerPerson);
    }

    public MobilePhone() {
    }

    @Override
    public void startCall(Phone receiverPhone) {
        try {
            super.startCall(receiverPhone);
            String phTempName = getName();
            LOGGER.trace("<" + phTempName + ">: " + "Call started");
            LOGGER.trace("<" + phTempName + ">: " + "Call start date: " + getCurrentCall().getCallStartDate().toString());
            LOGGER.trace("<" + phTempName + ">: " + "Caller number: " + getPhoneNumber().getFullNumber());
            LOGGER.trace("<" + phTempName + ">: " + "Receiver number: " + receiverPhone.getPhoneNumber().getFullNumber());
        } catch (PhoneNotFoundException e) {
            LOGGER.error(e.getMessage());
            LOGGER.debug("receiver phone: " + receiverPhone.toString());
        } catch (PhoneAlreadyOnCallException e) {
            LOGGER.error(e.getMessage());
            LOGGER.debug("isOnCall: " + isOnCall());
            LOGGER.debug("currentCall: " + getCurrentCall());
            LOGGER.debug("receiver isOnCall: " + receiverPhone.isOnCall());
            LOGGER.debug("receiver currentCall: " + receiverPhone.getCurrentCall());
        }
    }

    public void endCall() {
        try {
            super.endCall();
            String phTempName = getName();
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

    public void sendMessage(Phone receiverPhone, String messageText) {
        try {
            super.sendMessage(receiverPhone, messageText);
            String phTempName = getName();
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

    // time must be greater than zero
    // battery life increases by 1 for each minute(time)
    @Override
    public void charge(int time) throws IncorrectTimeException, BatteryNotFoundException {
        BinaryOperator<Integer> addInts = (x, y) -> x + y;
        if (time < 0) {
            throw new IncorrectTimeException("Time must be greater than zero!", "negative time");
        } else if (getBattery() == null) {
            throw new BatteryNotFoundException("No battery installed! Please insert the battery!", "battery is null");
        } else {
            int batteryCurrentLife = getBattery().getLife();
            int batteryNewLife = addInts.apply(batteryCurrentLife, time);//batteryCurrentLife + time;
            if (batteryNewLife > 100)
                batteryNewLife = 100;
            try {
                getBattery().setLife(batteryNewLife);
            } catch (IncorrectBatteryLifeException e) {
                LOGGER.error(e.getMessage());
            }
            String phTempName = getName();
            LOGGER.trace("<" + phTempName + ">: " + "Phone.Phone charged");
            LOGGER.trace("<" + phTempName + ">: " + "Charging time: " + time);
            LOGGER.trace("<" + phTempName + ">: " + "Battery current life: " + getBattery().getLife());
        }
    }

    @Override
    public void changeBattery(BatteryType type, String brand, int capacity) {
        setBattery(new Battery());
        getBattery().setType(type);
        getBattery().setBrand(brand);
        try {
            getBattery().setCapacity(capacity);
        } catch (IncorrectCapacityException e) {
            LOGGER.error(e.getMessage());
        }
        String phTempName = getName();
        LOGGER.trace("<" + phTempName + ">: " + "PhoneParts.Battery change successful");
        LOGGER.trace("<" + phTempName + ">: " + "PhoneParts.Battery type: " + type);
        LOGGER.trace("<" + phTempName + ">: " + "PhoneParts.Battery brand: " + brand);
        LOGGER.trace("<" + phTempName + ">: " + "PhoneParts.Battery capacity: " + capacity);
        LOGGER.trace("<" + phTempName + ">: " + "PhoneParts.Battery current life: " + getBattery().getLife());
    }

    // reset memory, OS, current call, last call, last message, isOnCall
    @Override
    public void reset() {
        setOnCall(false);
        setCurrentCall(null);
        setLastCall(null);
        setLastMessageSent(null);
        setLastMessageReceived(null);
        if (getMemory() != null)
            getMemory().reset();
        if (OS != null)
            OS.reset();

        String phTempName = getName();
        LOGGER.trace("<" + phTempName + ">: " + "Reset successful");
    }

    @Override
    public void update() throws OSNotFoundException {
        String phTempName = getName();
        if (OS == null) {
            throw new OSNotFoundException("Update not successful, no OS installed", "OS is null");
        } else {
            OS.update();
            LOGGER.trace("<" + phTempName + ">: " + "Update successful");
            LOGGER.trace("<" + phTempName + ">: " + "PhoneSoftware.OS new version: " + OS.getVersion());
        }
    }

    @Override
    public String toString() {
        return "Phone.MobilePhone{" +
                "name='" + name + '\'' +
                ", brand='" + getBrand() + '\'' +
                ", serialNumber='" + getSerialNumber() + '\'' +
                ", phoneNumber=" + getPhoneNumber() +
                ", ownerPerson=" + getOwnerPerson() +
                ", battery=" + getBattery() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        MobilePhone that = (MobilePhone) o;
        return Objects.equals(name, that.name)
                && Objects.equals(cameraFront, that.cameraFront)
                && Objects.equals(cameraRear, that.cameraRear)
                && Objects.equals(display, that.display)
                && Objects.equals(OS, that.OS)
                && Objects.equals(getSerialNumber(), that.getSerialNumber())
                && Objects.equals(getBrand(), that.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cameraFront, cameraRear, display, OS, getSerialNumber(), getBrand());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Camera getCameraFront() {
        return cameraFront;
    }

    public void setCameraFront(Camera cameraFront) {
        this.cameraFront = cameraFront;
    }

    public Camera getCameraRear() {
        return cameraRear;
    }

    public void setCameraRear(Camera cameraRear) {
        this.cameraRear = cameraRear;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public OS getSoftware() {
        return OS;
    }

    public void setSoftware(OS OS) {
        this.OS = OS;
    }
}
