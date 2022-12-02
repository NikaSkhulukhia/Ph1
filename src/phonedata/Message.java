package phonedata;

import person.Person;
import phone.Phone;

import java.util.Date;

public class Message {
    private Number messageSenderNumber;
    private Number messageReceiverNumber;
    private Person messageSenderPerson;
    private Person messageReceiverPerson;
    private Phone messageSenderPhone;
    private Phone messageReceiverPhone;
    private Date messageSendDate;
    private String messageText;

    public Message(Number messageSenderNumber, Number messageReceiverNumber, Phone messageSenderPhone, Phone messageReceiverPhone) {
        this.messageSenderNumber = messageSenderNumber;
        this.messageReceiverNumber = messageReceiverNumber;
        this.messageSenderPhone = messageSenderPhone;
        this.messageReceiverPhone = messageReceiverPhone;
    }

    public Message() {
    }

    @Override
    public String toString() {
        return "PhoneData.Message{" +
                "messageSenderNumber=" + messageSenderNumber +
                ", messageReceiverNumber=" + messageReceiverNumber +
                ", messageSenderPerson=" + messageSenderPerson +
                ", messageReceiverPerson=" + messageReceiverPerson +
                ", messageSenderPhone=" + messageSenderPhone +
                ", messageReceiverPhone=" + messageReceiverPhone +
                ", messageSendDate=" + messageSendDate +
                ", messageText='" + messageText + '\'' +
                '}';
    }

    public Number getMessageSenderNumber() {
        return messageSenderNumber;
    }

    public void setMessageSenderNumber(Number messageSenderNumber) {
        this.messageSenderNumber = messageSenderNumber;
    }

    public Number getMessageReceiverNumber() {
        return messageReceiverNumber;
    }

    public void setMessageReceiverNumber(Number messageReceiverNumber) {
        this.messageReceiverNumber = messageReceiverNumber;
    }

    public Person getMessageSenderPerson() {
        return messageSenderPerson;
    }

    public void setMessageSenderPerson(Person messageSenderPerson) {
        this.messageSenderPerson = messageSenderPerson;
    }

    public Person getMessageReceiverPerson() {
        return messageReceiverPerson;
    }

    public void setMessageReceiverPerson(Person messageReceiverPerson) {
        this.messageReceiverPerson = messageReceiverPerson;
    }

    public Phone getMessageSenderPhone() {
        return messageSenderPhone;
    }

    public void setMessageSenderPhone(Phone messageSenderPhone) {
        this.messageSenderPhone = messageSenderPhone;
    }

    public Phone getMessageReceiverPhone() {
        return messageReceiverPhone;
    }

    public void setMessageReceiverPhone(Phone messageReceiverPhone) {
        this.messageReceiverPhone = messageReceiverPhone;
    }

    public Date getMessageSendDate() {
        return messageSendDate;
    }

    public void setMessageSendDate(Date messageSendDate) {
        this.messageSendDate = messageSendDate;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
