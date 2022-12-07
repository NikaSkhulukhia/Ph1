package interfaces;

import exceptions.BatteryLowException;
import exceptions.BatteryNotFoundException;
import exceptions.PhoneNotFoundException;
import phone.Phone;

public interface IMessage {
    /*
    Send message (if possible) to another device
     */
    void sendMessage(Phone receiverPhone, String messageText) throws PhoneNotFoundException, BatteryNotFoundException, BatteryLowException;
}
