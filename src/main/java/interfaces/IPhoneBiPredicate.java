package interfaces;

import phone.Phone;

/*
This functional interface defines a single abstract method, test,
which takes two phone objects and two generic inputs as arguments and returns a boolean value.
The types of the two generic inputs are specified using type parameters T and U.
 */
@FunctionalInterface
public interface IPhoneBiPredicate<T, U> {
    boolean test(Phone phone1, Phone phone2, T t, U u);
}
