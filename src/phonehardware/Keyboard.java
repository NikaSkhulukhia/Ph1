package phonehardware;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Keyboard extends PhoneParts{
    private List<String> buttons = new ArrayList<>();

    public Keyboard(List<String> buttons) {
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
                "buttons=" + buttons +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        Keyboard keyboard = (Keyboard) o;
        return Objects.equals(buttons, keyboard.buttons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buttons);
    }

    public List<String> getButtons() {
        return buttons;
    }

    public void setButtons(List<String> buttons) {
        this.buttons = buttons;
    }
}
