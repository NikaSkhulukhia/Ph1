package Phone;

import Person.Person;
import PhoneData.Call;
import PhoneData.Message;
import PhoneParts.Battery;
import PhoneParts.Camera;
import PhoneParts.Display;
import PhoneSoftware.Software;
import PhoneData.Number;

import java.util.Date;
import java.time.*;
import java.util.Objects;

public class MobilePhone extends Phone {
    private String name;
    private Camera cameraFront;
    private Camera cameraRear;
    private Display display;
    private Software software;

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
        if (receiverPhone == null) {
            throw new IllegalArgumentException("Receiver phone must not be null!");
        } else if (this.getBattery() == null || this.getBattery().getLife() <= 5) {
            System.out.println("<" + this.getName() + ">: " + "Can not start the call, charge your phone!");
            System.out.println("<" + this.getName() + ">: . . . ");
        } else if (this.isOnCall() || this.getCurrentCall() != null) {
            System.out.println("<" + this.getName() + ">: " + "Can not start the call, phone already in another call!");
            System.out.println("<" + this.getName() + ">: . . . ");
        } else if (receiverPhone.isOnCall() || receiverPhone.getCurrentCall() != null) {
            System.out.println("<" + this.getName() + ">: " + "Can not start the call, receiver phone already in another call!");
            System.out.println("<" + this.getName() + ">: . . . ");
        } else {
            Date currentDate = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
            Call currentCall = new Call();
            currentCall.setCallStartDate(currentDate);
            currentCall.setCallerNumber(this.getPhoneNumber());
            currentCall.setCallerPhone(this);
            currentCall.setCallerPerson(this.getOwnerPerson());
            currentCall.setReceiverNumber(receiverPhone.getPhoneNumber());
            currentCall.setReceiverPhone(receiverPhone);
            currentCall.setReceiverPerson(receiverPhone.getOwnerPerson());
            receiverPhone.setCurrentCall(currentCall);
            receiverPhone.setOnCall(true);
            this.setCurrentCall(currentCall);
            this.setOnCall(true);

            // simulate/print start call
            System.out.println("<" + this.getName() + ">: " + "PhoneData.Call started");
            System.out.println("<" + this.getName() + ">: " + "PhoneData.Call start date: " + currentCall.getCallStartDate().toString());
            System.out.println("<" + this.getName() + ">: " + "Caller number: " + this.getPhoneNumber().getFullNumber());
            System.out.println("<" + this.getName() + ">: " + "Receiver number: " + receiverPhone.getPhoneNumber().getFullNumber());
            System.out.println("<" + this.getName() + ">: . . . ");
        }
    }

    // after the call battery life is decreased by 1% for both involved phones
    public void endCall() {
        if (!this.isOnCall() || this.getCurrentCall() == null) {
            System.out.println("<" + this.getName() + ">: " + "No current call to end!");
            System.out.println("<" + this.getName() + ">: . . . ");
        } else {
            Date currentDate = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());

            // end call for receiver
            Phone receiverPhone = this.getCurrentCall().getReceiverPhone();
            receiverPhone.getCurrentCall().setCallEndDate(currentDate);
            receiverPhone.setLastCall(receiverPhone.getCurrentCall());
            receiverPhone.setCurrentCall(null);
            receiverPhone.setOnCall(false);
            int receiverBatteryNewLife = receiverPhone.getBattery().getLife() - 1;
            receiverPhone.getBattery().setLife(receiverBatteryNewLife);

            // end call for this phone
            this.getCurrentCall().setCallEndDate(currentDate);
            this.setLastCall(this.getCurrentCall());
            this.setCurrentCall(null);
            this.setOnCall(false);
            int thisBatteryNewLife = this.getBattery().getLife() - 1;
            this.getBattery().setLife(thisBatteryNewLife);

            // simulate/print end call
            System.out.println("<" + this.getName() + ">: " + "PhoneData.Call Ended");
            System.out.println("<" + this.getName() + ">: " + "PhoneData.Call start date: " + this.getLastCall().getCallStartDate().toString());
            System.out.println("<" + this.getName() + ">: " + "PhoneData.Call start date: " + this.getLastCall().getCallEndDate().toString());
            System.out.println("<" + this.getName() + ">: " + "Caller number: " + this.getLastCall().getCallerNumber().getFullNumber());
            System.out.println("<" + this.getName() + ">: " + "Receiver number: " + this.getLastCall().getReceiverNumber().getFullNumber());
            System.out.println("<" + this.getName() + ">: . . . ");
        }
    }

    //phone can not send a message if the battery life is less or equal to 2%
    public void sendMessage(Phone receiverPhone, String messageText) {
        if (receiverPhone == null) {
            throw new IllegalArgumentException("Receiver phone must not be null!");
        } else if (this.getBattery() == null || this.getBattery().getLife() <= 2) {
            System.out.println("<" + this.getName() + ">: " + "Can not send the message, charge your phone!");
            System.out.println("<" + this.getName() + ">: . . . ");
        } else {
            Date currentDate = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
            Message message = new Message();
            message.setMessageSendDate(currentDate);
            message.setMessageText(messageText);
            message.setMessageSenderPhone(this);
            message.setMessageSenderNumber(this.getPhoneNumber());
            message.setMessageSenderPerson(this.getOwnerPerson());
            message.setMessageReceiverNumber(receiverPhone.getPhoneNumber());
            message.setMessageReceiverPhone(receiverPhone);
            message.setMessageReceiverPerson(receiverPhone.getOwnerPerson());
            this.setLastMessageSent(message);
            receiverPhone.setLastMessageReceived(message);

            // simulate/print send message
            System.out.println("<" + this.getName() + ">: " + "PhoneData.Message sent");
            System.out.println("<" + this.getName() + ">: " + "message send date: " + this.getLastMessageSent().getMessageSendDate().toString());
            System.out.println("<" + this.getName() + ">: " + "Sender number: " + this.getLastMessageSent().getMessageSenderNumber().getFullNumber());
            System.out.println("<" + this.getName() + ">: " + "Receiver number: " + this.getLastMessageSent().getMessageReceiverNumber().getFullNumber());
            System.out.println("<" + this.getName() + ">: " + "PhoneData.Message text: " + this.getLastMessageSent().getMessageText());
            System.out.println("<" + this.getName() + ">: . . . ");
        }
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

    // reset memory, software, current call, last call, last message, isOnCall
    @Override
    public void reset() {
        this.setOnCall(false);
        this.setCurrentCall(null);
        this.setLastCall(null);
        this.setLastMessageSent(null);
        this.setLastMessageReceived(null);
        if (this.getMemory() != null)
            this.getMemory().reset();
        if (this.software != null)
            this.software.reset();

        // simulate/print reset
        System.out.println("<" + this.getName() + ">: " + "Reset successful");
        System.out.println("<" + this.getName() + ">: . . . ");
    }

    @Override
    public void update() {
        if (this.software == null) {
            System.out.println("<" + this.getName() + ">: " + "Update not successful, no software installed");
        } else {
            this.software.update();
            // simulate/print reset
            System.out.println("<" + this.getName() + ">: " + "Update successful");
            System.out.println("<" + this.getName() + ">: " + "PhoneSoftware.Software new version: " + this.software.getVersion());
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
                && Objects.equals(software, that.software)
                && Objects.equals(getSerialNumber(), that.getSerialNumber())
                && Objects.equals(getBrand(), that.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cameraFront, cameraRear, display, software, getSerialNumber(), getBrand());
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

    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }
}
