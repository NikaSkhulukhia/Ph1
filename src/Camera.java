public class Camera {
    private boolean hasFlash;
    private int MP; // greater than zero, default 1
    private String type;
    private String brand;

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
