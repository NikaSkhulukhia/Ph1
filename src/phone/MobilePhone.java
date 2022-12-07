package phone;

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

public class MobilePhone extends Phone implements IUpdate {
    private static final Logger logger = LogManager.getLogger();
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

    // Phone.Phone can not start a call if the battery life is less or equal to 5%
    // phone can not start or receive a call if it is already in another call
    public void startCall(Phone receiverPhone) {
            super.startCall(receiverPhone);
            System.out.println("<" + this.getName() + ">: " + "PhoneData.Call started");
            System.out.println("<" + this.getName() + ">: " + "PhoneData.Call start date: " + getCurrentCall().getCallStartDate().toString());
            System.out.println("<" + this.getName() + ">: " + "Caller number: " + this.getPhoneNumber().getFullNumber());
            System.out.println("<" + this.getName() + ">: " + "Receiver number: " + receiverPhone.getPhoneNumber().getFullNumber());
            System.out.println("<" + this.getName() + ">: . . . ");
            logger.error("test error");
            logger.info("test info");
            logger.debug("test debug");
            logger.trace("test trace");
    }

    // after the call battery life is decreased by 1% for both involved phones
    public void endCall() {
        super.endCall();
        System.out.println("<" + this.getName() + ">: " + "PhoneData.Call Ended");
        System.out.println("<" + this.getName() + ">: " + "PhoneData.Call start date: " + this.getLastCall().getCallStartDate().toString());
        System.out.println("<" + this.getName() + ">: " + "PhoneData.Call start date: " + this.getLastCall().getCallEndDate().toString());
        System.out.println("<" + this.getName() + ">: " + "Caller number: " + this.getLastCall().getCallerNumber().getFullNumber());
        System.out.println("<" + this.getName() + ">: " + "Receiver number: " + this.getLastCall().getReceiverNumber().getFullNumber());
        System.out.println("<" + this.getName() + ">: . . . ");
    }

    //phone can not send a message if the battery life is less or equal to 2%
    public void sendMessage(Phone receiverPhone, String messageText) {
        super.sendMessage(receiverPhone, messageText);
            System.out.println("<" + this.getName() + ">: " + "PhoneData.Message sent");
            System.out.println("<" + this.getName() + ">: " + "message send date: " + this.getLastMessageSent().getMessageSendDate().toString());
            System.out.println("<" + this.getName() + ">: " + "Sender number: " + this.getLastMessageSent().getMessageSenderNumber().getFullNumber());
            System.out.println("<" + this.getName() + ">: " + "Receiver number: " + this.getLastMessageSent().getMessageReceiverNumber().getFullNumber());
            System.out.println("<" + this.getName() + ">: " + "PhoneData.Message text: " + this.getLastMessageSent().getMessageText());
            System.out.println("<" + this.getName() + ">: . . . ");
    }

    // time must be greater than zero
    // battery life increases by 1 for each minute(time)
    @Override
    public void charge(int time) {
        if (time < 0) {
            throw new IllegalArgumentException("Time must be greater than zero!");
        } else if (this.getBattery() == null) {
            throw new IllegalArgumentException("No battery installed! Please insert the battery!");
        } else {
            int batteryCurrentLife = this.getBattery().getLife();
            int batteryNewLife = batteryCurrentLife + time;
            if (batteryNewLife > 100)
                batteryNewLife = 100;
            this.getBattery().setLife(batteryNewLife);
        }
        // simulate/print charge
        System.out.println("<" + this.getName() + ">: " + "Phone.Phone charged");
        System.out.println("<" + this.getName() + ">: " + "Charging time: " + time);
        System.out.println("<" + this.getName() + ">: " + "PhoneParts.Battery current life: " + this.getBattery().getLife());
        System.out.println("<" + this.getName() + ">: . . . ");
    }

    @Override
    public void changeBattery(String type, String brand, int capacity) {
        this.setBattery(new Battery());
        this.getBattery().setType(type);
        this.getBattery().setBrand(brand);
        this.getBattery().setCapacity(capacity);

        // simulate/print change battery
        System.out.println("<" + this.getName() + ">: " + "PhoneParts.Battery change successful");
        System.out.println("<" + this.getName() + ">: " + "PhoneParts.Battery type: " + type);
        System.out.println("<" + this.getName() + ">: " + "PhoneParts.Battery brand: " + brand);
        System.out.println("<" + this.getName() + ">: " + "PhoneParts.Battery capacity: " + capacity);
        System.out.println("<" + this.getName() + ">: " + "PhoneParts.Battery current life: " + this.getBattery().getLife());
        System.out.println("<" + this.getName() + ">: . . . ");
    }

    // reset memory, OS, current call, last call, last message, isOnCall
    @Override
    public void reset() {
        this.setOnCall(false);
        this.setCurrentCall(null);
        this.setLastCall(null);
        this.setLastMessageSent(null);
        this.setLastMessageReceived(null);
        if (this.getMemory() != null)
            this.getMemory().reset();
        if (this.OS != null)
            this.OS.reset();

        // simulate/print reset
        System.out.println("<" + this.getName() + ">: " + "Reset successful");
        System.out.println("<" + this.getName() + ">: . . . ");
    }

    @Override
    public void update() {
        if (this.OS == null) {
            System.out.println("<" + this.getName() + ">: " + "Update not successful, no OS installed");
        } else {
            this.OS.update();
            // simulate/print reset
            System.out.println("<" + this.getName() + ">: " + "Update successful");
            System.out.println("<" + this.getName() + ">: " + "PhoneSoftware.OS new version: " + this.OS.getVersion());
            System.out.println("<" + this.getName() + ">: . . . ");
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
