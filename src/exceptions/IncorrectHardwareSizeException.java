package exceptions;

public class IncorrectHardwareSizeException extends Exception {
    private String desc;

    public IncorrectHardwareSizeException(String message, String desc) {
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
