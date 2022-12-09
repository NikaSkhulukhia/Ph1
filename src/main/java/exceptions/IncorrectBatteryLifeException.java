package exceptions;

public class IncorrectBatteryLifeException extends Exception {
    private String desc;

    public IncorrectBatteryLifeException(String message, String desc) {
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
