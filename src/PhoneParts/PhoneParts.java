package PhoneParts;

public abstract class PhoneParts {
    private String serialNumber;
    private String brand;
    private String name;
    /*
    health score of the product. to rate how damaged/usable the product is.
    must be greater or equal to zero.
     */
    private int health;
    /*
    can be used to generate phone part usability status for isUsable method.
     */
    private int healthLimitForStatus;

    public PhoneParts() {
    }

    /*
    abstract, boolean method.
    child classes should return true if the part is usable for phone (not damaged, broken...)
    or false otherwise.
     */
    public abstract boolean isUsable();

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException("Health must be greater or equal to zero");
        } else {
            this.health = health;
        }
    }

    public int getHealthLimitForStatus() {
        return healthLimitForStatus;
    }

    public void setHealthLimitForStatus(int healthLimitForStatus) {
        this.healthLimitForStatus = healthLimitForStatus;
    }

    @Override
    public String toString() {
        return "PhoneParts.PhoneParts{" +
                "serialNumber='" + serialNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", health=" + health +
                ", healthLimitForStatus=" + healthLimitForStatus +
                '}';
    }
}
