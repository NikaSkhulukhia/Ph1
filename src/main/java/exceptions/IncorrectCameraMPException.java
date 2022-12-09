package exceptions;

public class IncorrectCameraMPException extends Exception {
    private String desc;

    public IncorrectCameraMPException(String message, String desc) {
        super(message);
        this.desc = desc;
    }

    public IncorrectCameraMPException(String message) {
        super(message);
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
