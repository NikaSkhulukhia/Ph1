package interfaces;

import exceptions.OSNotFoundException;

public interface IUpdate {
    /*
    update the device settings, OS and soft to the new version.
     */
    void update() throws OSNotFoundException;
}
