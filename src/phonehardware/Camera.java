package phonehardware;

import java.util.Objects;

public class Camera extends PhoneParts{
    private boolean hasFlash; // does it have flashlight or not.
    private int MP; // MegaPixels, greater than zero, default 1
    private String type;

    public Camera(boolean hasFlash, int MP, String type) {
        if (MP <= 0) {
            throw new IllegalArgumentException("MP must be greater than zero!");
        }
        else {
            this.hasFlash = hasFlash;
            this.MP = MP;
            this.type = type;
        }
    }

    public Camera() {
        this.MP = 1;
    }

    @Override
    public boolean isUsable() {
        return false;
    }

    @Override
    public String toString() {
        return "PhoneParts.Camera{" +
                "hasFlash=" + hasFlash +
                ", MP=" + MP +
                ", type='" + type + '\'' +
                ", brand='" + "" + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        Camera camera = (Camera) o;
        return hasFlash == camera.hasFlash
                && MP == camera.MP
                && Objects.equals(type, camera.type)
                && Objects.equals(getBrand(), camera.getBrand())
                && Objects.equals(getSerialNumber(), camera.getSerialNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(hasFlash, MP, type, getSerialNumber(), getBrand());
    }

    public boolean getHasFlash() {
        return hasFlash;
    }

    public int getMP() {
        return MP;
    }

    public void setMP(int MP) {
        if (MP <= 0) {
            throw new IllegalArgumentException("MP must be greater than zero!");
        }
        else {
            this.MP = MP;
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
