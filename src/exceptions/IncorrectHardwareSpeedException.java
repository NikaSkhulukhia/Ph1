package exceptions;

public class IncorrectHardwareSpeedException extends Exception {
    private String desc;

    public IncorrectHardwareSpeedException(String message, String desc) {
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
