package exceptions;

public class IncorrectCapacityException extends Exception {
    private String desc;

    public IncorrectCapacityException(String message, String desc) {
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
