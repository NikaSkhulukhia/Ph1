package interfaces;

import exceptions.CallNotFoundException;
import exceptions.PhoneAlreadyOnCallException;
import exceptions.PhoneNotFoundException;
import phone.Phone;

public interface ICall {
    /*
    Start call (if possible) to another device
     */
    void startCall(Phone receiverPhone) throws PhoneNotFoundException, PhoneAlreadyOnCallException;

    /*
    End current call (if exists)
     */
    void endCall() throws CallNotFoundException;
}
