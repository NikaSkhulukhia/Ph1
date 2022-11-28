import java.util.Arrays;
import java.util.Objects;

public class Keyboard extends PhoneParts{
    private String[] buttons;

    public Keyboard(String[] buttons) {
        this.buttons = buttons;
    }

    public Keyboard() {
    }

    @Override
    public boolean isUsable() {
        return false;
    }

    @Override
    public String toString() {
        return "Keyboard{" +
                "brand=" + getBrand() +
                "serial=" + getSerialNumber() +
                "buttons=" + Arrays.toString(buttons) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        Keyboard keyboard = (Keyboard) o;
        return Arrays.equals(buttons, keyboard.buttons)
                && Objects.equals(getBrand(), keyboard.getBrand())
                && Objects.equals(getSerialNumber(), keyboard.getSerialNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(buttons, getSerialNumber(), getBrand());
    }

    public String[] getButtons() {
        return buttons;
    }

    public void setButtons(String[] buttons) {
        this.buttons = buttons;
    }
}
