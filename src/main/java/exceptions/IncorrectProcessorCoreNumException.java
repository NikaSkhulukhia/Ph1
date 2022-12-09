package exceptions;

public class IncorrectProcessorCoreNumException extends Exception {
    private String desc;

    public IncorrectProcessorCoreNumException(String message, String desc) {
        super(message);
        this.desc = desc;
    }

    public IncorrectProcessorCoreNumException(String message) {
        super(message);
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
