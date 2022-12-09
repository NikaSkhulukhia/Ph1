package exceptions;

public class OSNotFoundException extends Exception {
    private String desc;

    public OSNotFoundException(String message, String desc) {
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
