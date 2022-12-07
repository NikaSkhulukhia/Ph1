package exceptions;

public class BatteryNotFoundException extends Exception {
    private String desc;

    public BatteryNotFoundException(String message, String desc) {
        super(message);
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
