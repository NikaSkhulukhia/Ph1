public class Processor {
    private String brand;
    private int coreNum;
    private double speed;

    public Processor(String brand, int coreNum, double speed) {
        this.brand = brand;
        this.coreNum = coreNum;
        this.speed = speed;
    }

    public Processor() {
    }

    @Override
    public String toString() {
        String result = "";
        result += "this is a " + coreNum + " core processor with ";
        result += speed + " GHz, made by " + brand + ".";
        return result;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCoreNum() {
        return coreNum;
    }

    public void setCoreNum(int coreNum) {
        this.coreNum = coreNum;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
