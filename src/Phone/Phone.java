package Phone;

import Interfaces.ICall;
import Interfaces.ICharge;
import Interfaces.IMessage;
import Person.*;
import PhoneData.Number;
import PhoneParts.*;
import PhoneData.*;

import java.util.Date;

public abstract class Phone implements ICall, IMessage, ICharge {
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

    public abstract void startCall(Phone receiverPhone);
    public abstract void endCall();
    public abstract void sendMessage(Phone receiverPhone, String messageText);

    public abstract void charge(int time);
    public abstract void changeBattery(String type, String brand, int capacity);
    public abstract void reset();
    public abstract void update();

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
