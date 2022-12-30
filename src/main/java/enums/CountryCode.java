package enums;

public enum CountryCode
{
    EGYPT("20"),
    CANADA("1"),
    GEORGIA("995");

    private final String code;

    CountryCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
