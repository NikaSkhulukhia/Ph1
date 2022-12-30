package enums;

public enum DisplayType {
    /*
    LCD/IPS-LCDs
    LCD (Liquid Crystal Display) displays consist of a matrix of Liquid Crystals.
    Liquid Crystals do not emit light themselves and are reliant on some form of back-light
    to illuminate the whole display. As a result LCD displays can be very visible in direct sunlight.
    IPS-LCDs provide a superior viewing angle and better color reproduction than non IPS-LCDs
    due to the layout of the LCD's themselves. This has become a common display type for mid-range to high-end phones.
     */
    LCD ("LCD", "Liquid Crystal Display"),
    IPSLCD ("IPS-LCD", "In-Plane Switching Liquid Crystal Display"),
    /*
    OLED/AMOLED
    OLED & AMOLED utilizes 'organic' LEDs which emits light and in the majority of cases does away with
    the need for the back-light of an LCD display resulting in a potentially thinner panel.
    It provides less washed out 'blacks' with a better contrast ration and is highly visible in low light conditions.
    They consume less power as opposed to LCDs which always have the back-light on.
    When a pixel is 'black' on a OLED/AMOLED display the pixel is truly off.
     */
    OLED ("OLED", "Organic Light-Emitting Diode"),
    AMOLED ("AMOLED", "Active-Matrix Organic Light-Emitting Diode");

    private final String shortName;
    private final String LongName;

    DisplayType(String shortName, String longName) {
        this.shortName = shortName;
        LongName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public String getLongName() {
        return LongName;
    }
}
