package interfaces;

import phone.Phone;

/*
This functional interface could be used to represent a function that takes two phone objects
and two additional arguments of types T and U, and returns a result of type R.
It could be used to, for example, calculate the total weight of two phones.
 */
@FunctionalInterface
public interface IPhoneBiFunction<T, U, R> {
    R apply(Phone phone1, Phone phone2, T arg1, U arg2);
}