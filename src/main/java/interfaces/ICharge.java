package interfaces;

import exceptions.BatteryNotFoundException;
import exceptions.IncorrectTimeException;

public interface ICharge {
    /*
    Charge the device (if possible) for the given amount of time.
     */
    void charge(int time) throws IncorrectTimeException, BatteryNotFoundException;
}
