package phonedata;

import enums.CountryCode;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public final class Number {
    private static final String PRE_INDEX = "+"; // constant symbol '+'
    private CountryCode countryCode;
    private String brand; // carrier name
    private String index; // carrier index number
    private String number; // owner personal phone number

    public Number(String brand, String index, String number, CountryCode countryCode) {
        this.brand = brand;
        this.index = index;
        this.number = number;
        this.countryCode = countryCode;
    }

    public Number() {
    }

    /*
    number is built by pre-index ("+"), index (numeric string like: "577"), number (numeric string like: 12344325)
     */
    public String getFullNumber(){

        return PRE_INDEX + StringUtils.SPACE + countryCode.getCode() + StringUtils.SPACE + getIndex()
                + StringUtils.SPACE + getNumber();
        }

    @Override
    public String toString() {
        return "Number{" +
                "countryCode=" + countryCode +
                ", brand='" + brand + '\'' +
                ", index='" + index + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return true;
        Number number1 = (Number) o;
        return Objects.equals(brand, number1.brand) && Objects.equals(index, number1.index) && Objects.equals(number, number1.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, index, number);
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

    public CountryCode getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(CountryCode countryCode) {
        this.countryCode = countryCode;
    }
}
