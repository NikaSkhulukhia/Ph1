package phonehardware;

import exceptions.IncorrectHardwareSpeedException;
import exceptions.IncorrectProcessorCoreNumException;

import java.util.Objects;

public class Processor extends PhoneParts{
    private int coreNum; // greater than zero. default 1
    private double speed; // greater than zero. default 1

    public Processor(String brand, int coreNum, double speed) throws IncorrectProcessorCoreNumException, IncorrectHardwareSpeedException {
        if (coreNum <= 0) {
            throw new IncorrectProcessorCoreNumException("coreNum must be greater than zero!");
        } else if (speed <= 0) {
            throw new IncorrectHardwareSpeedException("speed must be greater than zero!");
        } else {
            setBrand(brand);
            this.coreNum = coreNum;
            this.speed = speed;
        }
    }

    public Processor() {
        coreNum = 1;
        speed = 1;
    }

    @Override
    public boolean isUsable() {
        return true;
    }

    @Override
    public String toString() {
        String result = "";
        result += "this is a " + coreNum + " core processor with ";
        result += speed + " GHz, made by " + getBrand() + ".";
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        Processor processor = (Processor) o;
        return coreNum == processor.coreNum
                && Double.compare(processor.speed, speed) == 0
                && Objects.equals(getSerialNumber(), processor.getSerialNumber())
                && Objects.equals(getBrand(), processor.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(coreNum, speed, getSerialNumber(), getBrand());
    }

    public int getCoreNum() {
        return coreNum;
    }

    public void setCoreNum(int coreNum) throws IncorrectProcessorCoreNumException {
        if (coreNum <= 0) {
            throw new IncorrectProcessorCoreNumException("coreNum must be greater than zero!");
        } else {
            this.coreNum = coreNum;
        }
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) throws IncorrectHardwareSpeedException {
        if (speed <= 0) {
            throw new IncorrectHardwareSpeedException("speed must be greater than zero!");
        } else {
            this.speed = speed;
        }
    }
}
