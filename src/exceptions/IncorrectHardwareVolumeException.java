package exceptions;

public class IncorrectHardwareVolumeException extends Exception {
    private String desc;

    public IncorrectHardwareVolumeException(String message, String desc) {
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
