package exceptions;

public class IncorrectTimeException extends Exception {
    private String desc;

    public IncorrectTimeException(String message, String desc) {
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
