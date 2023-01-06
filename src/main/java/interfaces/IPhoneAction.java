package interfaces;

import exceptions.CallNotFoundException;
import phone.Phone;

/*
PhoneAction: a functional interface that represents an action that can be performed on a Phone object.
It could be used to define lambda expressions for methods such as startCall, endCall, or sendMessage.
 */
@FunctionalInterface
public interface IPhoneAction {
    void performAction(Phone phone) throws CallNotFoundException;
}

