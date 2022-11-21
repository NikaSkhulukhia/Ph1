import java.security.PrivateKey;
import java.util.Date;
import java.time.*;

public class Phone implements Gadget{
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

    public Phone(String brand, String serialNumber, Number phoneNumber, Person ownerPerson) {
        this.brand = brand;
        this.serialNumber = serialNumber;
        this.phoneNumber = phoneNumber;
        this.ownerPerson = ownerPerson;
    }

    public Phone() {
    }

    public void StartCall(Number receiverNumber) {

    }

    public void StartCall(Phone receiverPhone) {

    }

    public void EndCall() {
        if (!this.isOnCall || this.currentCall == null) {
            System.out.println("<PHONE>: no current call to end!");
        } else {
            Date currentDate = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());

            // end call for receiver
            Number receiverNumber = this.currentCall.getReceiverNumber();
            receiverNumber.getPhone().currentCall.setCallEndDate(currentDate);
            receiverNumber.getPhone().lastCall = receiverNumber.getPhone().currentCall;
            receiverNumber.getPhone().currentCall = null;
            receiverNumber.getPhone().isOnCall = false;

            // end call for this phone
            this.currentCall.setCallEndDate(currentDate);
            this.lastCall = this.currentCall;
            this.currentCall = null;
            this.isOnCall = false;
        }
    }

    public void SendMessage(Number receiverNumber, String messageText) {
        if (receiverNumber == null) {
            throw new IllegalArgumentException("Receiver number must not be null!");
        } else if (this.battery != null && this.battery.getLife() <= 2){
            System.out.println("<PHONE>: Can not send the message, charge your phone!");
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
        }
    }

    // time must be greater than zero
    // battery life increases by 1 for each minute(time)
    @Override
    public void Charge(int time) throws IllegalAccessException {
        if (time < 0) {
            throw new IllegalArgumentException("Time must be greater than zero!");
        } else if (this.battery == null){
            throw new IllegalAccessException("No battery installed! Please insert the battery!");
        } else {
            int batteryCurrentLife = this.battery.getLife();
            int batteryNewLife = batteryCurrentLife + time;
            if (batteryNewLife > 100)
                batteryNewLife = 100;
            this.battery.setLife(batteryNewLife);
        }
    }

    @Override
    public void ChangeBattery(String type, String brand, int capacity) {
        this.battery = new Battery();
        this.battery.setType(type);
        this.battery.setBrand(brand);
        this.battery.setCapacity(capacity);
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
            this.memory.Reset();
        if (this.software != null)
            this.software.Reset();
    }

    @Override
    public String toString() {
        return super.toString();
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
