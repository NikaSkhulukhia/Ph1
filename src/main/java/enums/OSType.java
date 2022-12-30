package enums;

public enum OSType {
    ANDROID("Android"),
    IOS("iOS"),
    WINDOWS("Windows");

    private final String name;

    OSType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
