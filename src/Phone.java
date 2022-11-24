import java.security.PrivateKey;
import java.util.Date;
import java.time.*;

public class Phone implements Gadget {
    private String name;
    private String brand;
    private String serialNumber;
    private boolean isOnCall;
    private Number phoneNumber;
    private Person ownerPerson;
    private Date releaseDate;
    private Call currentCall;
    private Call lastCall;
    private Message lastMessageSent;
    private Message lastMessageReceived;
    private Battery battery;
    private Body body;
    private Camera cameraFront;
    private Camera cameraRear;
    private Display display;
    private Memory memory;
    private Processor processor;
    private RAM ram;
    private Software software;

    public Phone(String name, String brand, String serialNumber, Number phoneNumber, Person ownerPerson) {
        this.name = name;
        this.brand = brand;
        this.serialNumber = serialNumber;
        this.phoneNumber = phoneNumber;
        this.ownerPerson = ownerPerson;
    }

    public Phone() {
    }

    // Phone can not start a call if the battery life is less or equal to 5%
    // phone can not start or receive a call if it is already in another call
    public void startCall(Number receiverNumber) {
        if (receiverNumber == null) {
            throw new IllegalArgumentException("Receiver number must not be null!");
        } else if (this.battery == null || this.battery.getLife() <= 5) {
            System.out.println("<" + this.getName() + ">: " + "Can not start the call, charge your phone!");
            System.out.println("<" + this.getName() + ">: . . . ");
        } else if (this.isOnCall || this.currentCall != null) {
            System.out.println("<" + this.getName() + ">: " + "Can not start the call, phone already in another call!");
            System.out.println("<" + this.getName() + ">: . . . ");
        } else if (receiverNumber.getPhone() == null) {
            System.out.println("<" + this.getName() + ">: " + "Can not start the call, phone is turned off or out of coverage area!");
            System.out.println("<" + this.getName() + ">: . . . ");
        } else if (receiverNumber.getPhone().isOnCall || receiverNumber.getPhone().currentCall != null) {
            System.out.println("<" + this.getName() + ">: " + "Can not start the call, receiver phone already in another call!");
            System.out.println("<" + this.getName() + ">: . . . ");
        } else {
            Date currentDate = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
            Phone receiverPhone = receiverNumber.getPhone();
            Call currentCall = new Call();
            currentCall.setCallStartDate(currentDate);
            currentCall.setCallerNumber(this.phoneNumber);
            currentCall.setCallerPhone(this);
            currentCall.setCallerPerson(this.ownerPerson);
            currentCall.setReceiverNumber(receiverNumber);
            currentCall.setReceiverPhone(receiverPhone);
            currentCall.setReceiverPerson(receiverNumber.getOwner());
            receiverPhone.currentCall = currentCall;
            receiverPhone.isOnCall = true;
            this.currentCall = currentCall;
            this.isOnCall = true;

            // simulate/print start call
            System.out.println("<" + this.getName() + ">: " + "Call started");
            System.out.println("<" + this.getName() + ">: " + "Call start date: " + currentCall.getCallStartDate().toString());
            System.out.println("<" + this.getName() + ">: " + "Caller number: " + this.phoneNumber.getFullNumber());
            System.out.println("<" + this.getName() + ">: " + "Receiver number: " + receiverNumber.getFullNumber());
            System.out.println("<" + this.getName() + ">: . . . ");
        }
    }

    // after the call battery life is decreased by 1% for both involved phones
    public void endCall() {
        if (!this.isOnCall || this.currentCall == null) {
            System.out.println("<" + this.getName() + ">: " + "No current call to end!");
            System.out.println("<" + this.getName() + ">: . . . ");
        } else {
            Date currentDate = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());

            // end call for receiver
            Number receiverNumber = this.currentCall.getReceiverNumber();
            receiverNumber.getPhone().currentCall.setCallEndDate(currentDate);
            receiverNumber.getPhone().lastCall = receiverNumber.getPhone().currentCall;
            receiverNumber.getPhone().currentCall = null;
            receiverNumber.getPhone().isOnCall = false;
            int receiverBatteryNewLife = receiverNumber.getPhone().battery.getLife() - 1;
            receiverNumber.getPhone().battery.setLife(receiverBatteryNewLife);

            // end call for this phone
            this.currentCall.setCallEndDate(currentDate);
            this.lastCall = this.currentCall;
            this.currentCall = null;
            this.isOnCall = false;
            int thisBatteryNewLife = this.battery.getLife() - 1;
            this.battery.setLife(thisBatteryNewLife);

            // simulate/print end call
            System.out.println("<" + this.getName() + ">: " + "Call Ended");
            System.out.println("<" + this.getName() + ">: " + "Call start date: " + this.lastCall.getCallStartDate().toString());
            System.out.println("<" + this.getName() + ">: " + "Call start date: " + this.lastCall.getCallEndDate().toString());
            System.out.println("<" + this.getName() + ">: " + "Caller number: " + this.lastCall.getCallerNumber().getFullNumber());
            System.out.println("<" + this.getName() + ">: " + "Receiver number: " + this.lastCall.getReceiverNumber().getFullNumber());
            System.out.println("<" + this.getName() + ">: . . . ");
        }
    }

    //phone can not send a message if the battery life is less or equal to 2%
    public void sendMessage(Number receiverNumber, String messageText) {
        if (receiverNumber == null) {
            throw new IllegalArgumentException("Receiver number must not be null!");
        } else if (this.battery == null || this.battery.getLife() <= 2) {
            System.out.println("<" + this.getName() + ">: " + "Can not send the message, charge your phone!");
            System.out.println("<" + this.getName() + ">: . . . ");
        } else {
            Date currentDate = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
            Phone receiverPhone = receiverNumber.getPhone();
            Message message = new Message();
            message.setMessageSendDate(currentDate);
            message.setMessageText(messageText);
            message.setMessageSenderPhone(this);
            message.setMessageSenderNumber(this.phoneNumber);
            message.setMessageSenderPerson(this.ownerPerson);
            message.setMessageReceiverNumber(receiverNumber);
            message.setMessageReceiverPhone(receiverPhone);
            message.setMessageReceiverPerson(receiverNumber.getOwner());
            this.lastMessageSent = message;
            if (receiverPhone != null)
                receiverPhone.lastMessageReceived = message;

            // simulate/print send message
            System.out.println("<" + this.getName() + ">: " + "Message sent");
            System.out.println("<" + this.getName() + ">: " + "message send date: " + this.lastMessageSent.getMessageSendDate().toString());
            System.out.println("<" + this.getName() + ">: " + "Sender number: " + this.lastMessageSent.getMessageSenderNumber().getFullNumber());
            System.out.println("<" + this.getName() + ">: " + "Receiver number: " + this.lastMessageSent.getMessageReceiverNumber().getFullNumber());
            System.out.println("<" + this.getName() + ">: " + "Message text: " + this.lastMessageSent.getMessageText());
            System.out.println("<" + this.getName() + ">: . . . ");
        }
    }

    // time must be greater than zero
    // battery life increases by 1 for each minute(time)
    @Override
    public void charge(int time) {
        if (time < 0) {
            throw new IllegalArgumentException("Time must be greater than zero!");
        } else if (this.battery == null) {
            throw new IllegalArgumentException("No battery installed! Please insert the battery!");
        } else {
            int batteryCurrentLife = this.battery.getLife();
            int batteryNewLife = batteryCurrentLife + time;
            if (batteryNewLife > 100)
                batteryNewLife = 100;
            this.battery.setLife(batteryNewLife);
        }
        // simulate/print charge
        System.out.println("<" + this.getName() + ">: " + "Phone charged");
        System.out.println("<" + this.getName() + ">: " + "Charging time: " + time);
        System.out.println("<" + this.getName() + ">: " + "Battery current life: " + this.battery.getLife());
        System.out.println("<" + this.getName() + ">: . . . ");
    }

    @Override
    public void changeBattery(String type, String brand, int capacity) {
        this.battery = new Battery();
        this.battery.setType(type);
        this.battery.setBrand(brand);
        this.battery.setCapacity(capacity);

        // simulate/print change battery
        System.out.println("<" + this.getName() + ">: " + "Battery change successful");
        System.out.println("<" + this.getName() + ">: " + "Battery type: " + type);
        System.out.println("<" + this.getName() + ">: " + "Battery brand: " + brand);
        System.out.println("<" + this.getName() + ">: " + "Battery capacity: " + capacity);
        System.out.println("<" + this.getName() + ">: " + "Battery current life: " + this.battery.getLife());
        System.out.println("<" + this.getName() + ">: . . . ");
    }

    // reset memory, software, current call, last call, last message, isOnCall
    @Override
    public void reset() {
        this.isOnCall = false;
        this.currentCall = null;
        this.lastCall = null;
        this.lastMessageSent = null;
        this.lastMessageReceived = null;
        if (this.memory != null)
            this.memory.reset();
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
            System.out.println("<" + this.getName() + ">: " + "Software new version: " + this.software.getVersion());
            System.out.println("<" + this.getName() + ">: . . . ");
        }
    }

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", ownerPerson=" + ownerPerson +
                ", battery=" + battery +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public boolean isOnCall() {
        return isOnCall;
    }

    public void setOnCall(boolean onCall) {
        isOnCall = onCall;
    }

    public Number getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Number phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Person getOwnerPerson() {
        return ownerPerson;
    }

    public void setOwnerPerson(Person ownerPerson) {
        this.ownerPerson = ownerPerson;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Call getCurrentCall() {
        return currentCall;
    }

    public void setCurrentCall(Call currentCall) {
        this.currentCall = currentCall;
    }

    public Call getLastCall() {
        return lastCall;
    }

    public void setLastCall(Call lastCall) {
        this.lastCall = lastCall;
    }

    public Message getLastMessageSent() {
        return lastMessageSent;
    }

    public void setLastMessageSent(Message lastMessageSent) {
        this.lastMessageSent = lastMessageSent;
    }

    public Message getLastMessageReceived() {
        return lastMessageReceived;
    }

    public void setLastMessageReceived(Message lastMessageReceived) {
        this.lastMessageReceived = lastMessageReceived;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
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

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }
}
