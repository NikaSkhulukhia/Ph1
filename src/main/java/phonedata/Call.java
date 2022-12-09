package phonedata;

import person.Person;
import phone.Phone;

import java.util.Date;
import java.util.Objects;

public final class Call {
     private Number callerNumber;
     private Number receiverNumber;
     private Person callerPerson;
     private Person receiverPerson;
     private Phone callerPhone;
     private Phone receiverPhone;
     private Date callStartDate;
     private Date callEndDate;

    public Call(Number callerNumber, Number receiverNumber, Phone callerPhone, Phone receiverPhone) {
        this.callerNumber = callerNumber;
        this.receiverNumber = receiverNumber;
        this.callerPhone = callerPhone;
        this.receiverPhone = receiverPhone;
    }

    public Call() {
    }

    @Override
    public String toString() {
        return "PhoneData.Call{" +
                "callerNumber=" + callerNumber +
                ", receiverNumber=" + receiverNumber +
                ", callerPerson=" + callerPerson +
                ", receiverPerson=" + receiverPerson +
                ", callerPhone=" + callerPhone +
                ", receiverPhone=" + receiverPhone +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        Call call = (Call) o;
        return Objects.equals(callerNumber, call.callerNumber) && Objects.equals(receiverNumber, call.receiverNumber)
                && Objects.equals(callerPerson, call.callerPerson) && Objects.equals(receiverPerson, call.receiverPerson)
                && Objects.equals(callerPhone, call.callerPhone) && Objects.equals(receiverPhone, call.receiverPhone)
                && Objects.equals(callStartDate, call.callStartDate) && Objects.equals(callEndDate, call.callEndDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(callerNumber, receiverNumber, callerPerson, receiverPerson, callerPhone,
                receiverPhone, callStartDate, callEndDate);
    }

    public Number getCallerNumber() {
        return callerNumber;
    }

    public void setCallerNumber(Number callerNumber) {
        this.callerNumber = callerNumber;
    }

    public Number getReceiverNumber() {
        return receiverNumber;
    }

    public void setReceiverNumber(Number receiverNumber) {
        this.receiverNumber = receiverNumber;
    }

    public Person getCallerPerson() {
        return callerPerson;
    }

    public void setCallerPerson(Person callerPerson) {
        this.callerPerson = callerPerson;
    }

    public Person getReceiverPerson() {
        return receiverPerson;
    }

    public void setReceiverPerson(Person receiverPerson) {
        this.receiverPerson = receiverPerson;
    }

    public Phone getCallerPhone() {
        return callerPhone;
    }

    public void setCallerPhone(Phone callerPhone) {
        this.callerPhone = callerPhone;
    }

    public Phone getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(Phone receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public Date getCallStartDate() {
        return callStartDate;
    }

    public void setCallStartDate(Date callStartDate) {
        this.callStartDate = callStartDate;
    }

    public Date getCallEndDate() {
        return callEndDate;
    }

    public void setCallEndDate(Date callEndDate) {
        this.callEndDate = callEndDate;
    }
}
