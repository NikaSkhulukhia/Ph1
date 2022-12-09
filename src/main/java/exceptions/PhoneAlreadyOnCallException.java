package exceptions;

public class PhoneAlreadyOnCallException extends Exception{
    private String desc;

    public PhoneAlreadyOnCallException(String message, String desc) {
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
