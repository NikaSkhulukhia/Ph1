package phonedata;

import person.Person;
import phone.Phone;

import java.time.LocalDate;
import java.util.Objects;

public final class Message {
    private Number messageSenderNumber;
    private Number messageReceiverNumber;
    private Person messageSenderPerson;
    private Person messageReceiverPerson;
    private Phone messageSenderPhone;
    private Phone messageReceiverPhone;
    private LocalDate messageSendDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        Message message = (Message) o;
        return Objects.equals(messageSenderNumber, message.messageSenderNumber)
                && Objects.equals(messageReceiverNumber, message.messageReceiverNumber)
                && Objects.equals(messageSenderPerson, message.messageSenderPerson)
                && Objects.equals(messageReceiverPerson, message.messageReceiverPerson)
                && Objects.equals(messageSenderPhone, message.messageSenderPhone)
                && Objects.equals(messageReceiverPhone, message.messageReceiverPhone)
                && Objects.equals(messageSendDate, message.messageSendDate)
                && Objects.equals(messageText, message.messageText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageSenderNumber, messageReceiverNumber, messageSenderPerson,
                messageReceiverPerson, messageSenderPhone, messageReceiverPhone, messageSendDate, messageText);
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

    public LocalDate getMessageSendDate() {
        return messageSendDate;
    }

    public void setMessageSendDate(LocalDate messageSendDate) {
        this.messageSendDate = messageSendDate;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
