import java.util.Date;

public class Person {
    private String firstName;
    private String lastName;
    private String idNumber;
    private Date birthDate;
    private Number phoneNumber;
    private Phone phone;

    public Person(String firstName, String lastName, String idNumber, Date birthDate, Number phoneNumber, Phone phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.phone = phone;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", birthDate=" + birthDate +
                ", phoneNumber=" + phoneNumber +
                ", phone=" + phone +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Number getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Number phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
