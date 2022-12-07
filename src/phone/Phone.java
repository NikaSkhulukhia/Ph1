package phone;

import exceptions.*;
import interfaces.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import person.*;
import phonedata.Number;
import phonehardware.*;
import phonedata.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public abstract class Phone implements ICall, IMessage, ICharge, IReset {
    private static final Logger LOGGER = LogManager.getLogger();
    private String brand;
    private String serialNumber;
    private boolean isOnCall;
    private double length;
    private double width;
    private double height;
    private double weight;
    private String build;
    private Number phoneNumber;
    private Person ownerPerson;
    private Date releaseDate;
    private Call currentCall;
    private Call lastCall;
    private Message lastMessageSent;
    private Message lastMessageReceived;
    private Battery battery;
    private Processor processor;
    private RAM ram;
    private Memory memory;

    public Phone() {
    }

    public abstract void charge(int time) throws IncorrectTimeException, BatteryNotFoundException;
    public abstract void changeBattery(String type, String brand, int capacity);
    public abstract void reset();

    public void startCall(Phone receiverPhone) throws PhoneNotFoundException, PhoneAlreadyOnCallException {
            if (receiverPhone == null) {
                throw new PhoneNotFoundException("Receiver phone must not be null!", "phone is null");
            } else if (this.isOnCall() || this.getCurrentCall() != null) {
                throw new PhoneAlreadyOnCallException("Can not start the call, caller phone already in another call!", "phone already on call");
            } else if (receiverPhone.isOnCall() || receiverPhone.getCurrentCall() != null) {
                throw new PhoneAlreadyOnCallException("Can not start the call, receiver phone already in another call!", "phone already on call");
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
            }
    }
    public void endCall() throws CallNotFoundException {
        if (!this.isOnCall() || this.getCurrentCall() == null) {
            throw new CallNotFoundException("No current call to end!", "call not found");
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
        }
    }
    public void sendMessage(Phone receiverPhone, String messageText) throws PhoneNotFoundException, BatteryNotFoundException, BatteryLowException {
        if (receiverPhone == null) {
            throw new PhoneNotFoundException("Receiver phone must not be null!", "phone is null");
        } else if (this.getBattery() == null) {
            throw new BatteryNotFoundException("Can not send the message, battery not installed", "battery is null");
        } else if(this.getBattery().getLife() <= 2){
            throw new BatteryLowException("Can not send the message, charge phone", "battery low");
        }
        else {
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
        }
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

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }
}