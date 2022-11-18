public class Processor {
    private String brand;
    private int coreNum; // greater than zero. default 1
    private double speed; // greater than zero. default 1

    public Processor(String brand, int coreNum, double speed) {
        if (coreNum <= 0) {
            throw new IllegalArgumentException("coreNum must be greater than zero!");
        } else if (speed <= 0) {
            throw new IllegalArgumentException("speed must be greater than zero!");
        } else {
            this.brand = brand;
            this.coreNum = coreNum;
            this.speed = speed;
        }
    }

    public Processor() {
        this.coreNum = 1;
        this.speed = 1;
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
        if (coreNum <= 0) {
            throw new IllegalArgumentException("coreNum must be greater than zero!");
        } else {
            this.coreNum = coreNum;
        }
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        if (speed <= 0) {
            throw new IllegalArgumentException("speed must be greater than zero!");
        } else {
            this.speed = speed;
        }
    }
}
