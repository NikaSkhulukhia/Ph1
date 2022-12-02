package PhoneData;

import Person.Person;
import Phone.Phone;

public class Number {
    private static final String PRE_INDEX = "+"; // constant symbol '+'
    private String brand;
    private String index;
    private String number;

    public Number(String brand, String index, String number, Person owner, Phone phone) {
        this.brand = brand;
        this.index = index;
        this.number = number;
    }

    public Number() {
    }

    /*
    number is built by pre-index ("+"), index (numeric string like: "577"), number (numeric string like: 12344325)
     */
    public String getFullNumber(){
        return this.PRE_INDEX + " " + this.index + " " + this.number;
    }

    @Override
    public String toString() {
        return "PhoneData.Number{" +
                "brand='" + brand + '\'' +
                ", index='" + index + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
