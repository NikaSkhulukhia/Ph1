public class Number {
    private static final String PRE_INDEX = "+"; // constant symbol '+'
    private String brand;
    private String index;
    private String number;
    private Person owner;
    private Phone phone;

    public Number(String brand, String index, String number, Person owner, Phone phone) {
        this.brand = brand;
        this.index = index;
        this.number = number;
        this.owner = owner;
        this.phone = phone;
    }

    public Number() {
    }

    public String getFullNumber(){
        return this.PRE_INDEX + " " + this.index + " " + this.number;
    }

    @Override
    public String toString() {
        return "Number{" +
                "brand='" + brand + '\'' +
                ", index='" + index + '\'' +
                ", number='" + number + '\'' +
                ", owner=" + owner +
                ", phone=" + phone +
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

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
