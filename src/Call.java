public class Call {
     private Number callerNumber;
     private Number receiverNumber;
     private Person callerPerson;
     private Person receiverPerson;
     private Phone callerPhone;
     private Phone receiverPhone;

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
        return "Call{" +
                "callerNumber=" + callerNumber +
                ", receiverNumber=" + receiverNumber +
                ", callerPerson=" + callerPerson +
                ", receiverPerson=" + receiverPerson +
                ", callerPhone=" + callerPhone +
                ", receiverPhone=" + receiverPhone +
                '}';
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
}
