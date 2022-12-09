package exceptions;

public class BatteryLowException extends Exception {
    private String desc;

    public BatteryLowException(String message, String desc) {
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
