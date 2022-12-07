package exceptions;

public class IncorrectHardwareHealthException extends Exception {
    private String desc;

    public IncorrectHardwareHealthException(String message, String desc) {
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
