package enums;

public enum BatteryType {

    /* Nickel Cadmium (NiCd): This type of battery is most often only used in older cell phones.
    It is the least powerful.
     */
    NICD("Nickel Cadmium"),
    /* Nickel Metal Hybrid (NiMH): Nickel batteries are more powerful than the NiCd batteries.
    They are usually only used in older cell phones, as well.
     */
    NIMH("Nickel Metal"),
    /* Lithium Ion (Li-ion): Li-ion batteries are more common types.
    They are consistently used in today’s phones and are even more powerful than the NiMH battery.
     */
    LIION("Lithium Ion"),
    /* Lithium Polymer (LiPo): Like the NiMH’s upgrade over the NiCd,
    the LiPo is an upgraded form of the lithium battery when compared to the Li-ion.
    It has the greatest power of all the battery types mentioned here.
     */
    LIPO("Lithium Polymer");

    private final String description;

    BatteryType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
