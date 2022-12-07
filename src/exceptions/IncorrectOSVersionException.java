package exceptions;

public class IncorrectOSVersionException extends Exception {
    private String desc;

    public IncorrectOSVersionException(String message, String desc) {
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
