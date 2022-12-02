package Interfaces;

import Phone.Phone;

public interface IMessage {
    /*
    Send message (if possible) to another device
     */
    void sendMessage(Phone receiverPhone, String messageText);
}
