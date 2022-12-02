package interfaces;

import phone.Phone;

public interface ICall {
    /*
    Start call (if possible) to another device
     */
    void startCall(Phone receiverPhone);

    /*
    End current call (if exists)
     */
    void endCall();
}
