package enums;

public enum FlashStorageType {
    /*
    eMMC
    The term eMMC is short for Embedded Multi-Media Card and had been one of the most common storage options
    for many years. In design, it is a package of flash memory, an MMC (multimedia card) interface
    and a flash memory controller integrated on the same silicon die.
    But with advancement in tech, it has been taken over by — UFS
    */
    EMMC("Embedded Multi-Media Card"),

    /*
    UFS
    Universal Flash Storage or UFS also consists of a high-speed serial interface between flash memory
    and the processor, the flash memory itself, and a controller but the difference lies in the underlying architecture.
    It not just boast better performance but also assures efficiency gains.
     */
    UFS("Universal Flash Storage");

    private final String name;

    FlashStorageType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
