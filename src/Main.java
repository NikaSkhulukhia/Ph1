public class Main {
    /*\
    Main method to run the phone application and simulate calls.
    Rules for phone call/message:
    1. Phone can not start a call if the battery life is less or equal to 5%
    2. phone can not start or receive a call if it is already in another call
    3. after the call battery life is decreased by 1% for both involved phones
    4. phone can not send a message if the battery life is less or equal to 2%
     */
    public static void main(String[] args) {
        System.out.println("<MAIN>: Starting simulation of the Phone app...");
        System.out.println("<MAIN>: . . .");

        // initialize numbers, phones and owners
        Number number1 = new Number("AT&T", "1", "054565465", null, null);
        Person person1 = new Person("Alice", "Smith", "245245", null, number1, null);
        Phone phone1 = new Phone("Alice's S22","Samsung", "03r303f", number1, person1);
        number1.setOwner(person1);
        number1.setPhone(phone1);
        person1.setPhone(phone1);
        Number number2 = new Number("Verizon", "577", "4534563456", null, null);
        Person person2 = new Person("Bob", "Peterson", "2345677654", null, number2, null);
        Phone phone2 = new Phone("Bob's iPhone","iPhone", "86h68h6", number2, person2);
        number2.setOwner(person2);
        number2.setPhone(phone2);
        person2.setPhone(phone2);
        Number number3 = new Number("Beeline", "56", "8383388", null, null);
        Person person3 = new Person("Tom", "Black", "987654", null, number3, null);
        Phone phone3 = new Phone("Tom's Sony 11","Sony", "1kn31n", number3, person3);
        number3.setOwner(person3);
        number3.setPhone(phone3);
        person3.setPhone(phone3);

        // create essential parts for phones
        Battery bat1 = new Battery("Samsung", "removable", 3000, 100);
        Battery bat2 = new Battery("iPhone", "removable", 4000, 44);
        Battery bat3 = new Battery("Sony", "removable", 5000, 100);
        phone1.setBattery(bat1);
        phone2.setBattery(bat2);
        phone3.setBattery(bat3);

        // create software
        Software soft1 = new Software("android", 11);
        Software soft2 = new Software("iOS", 14);
        Software soft3 = new Software("android", 12);
        phone1.setSoftware(soft1);
        phone2.setSoftware(soft2);
        phone3.setSoftware(soft3);

        // simulate call and message methods
        phone1.StartCall(number2);
        phone1.StartCall(number3);
        phone3.StartCall(number1);
        phone1.EndCall();
        phone3.StartCall(number2);
        phone2.SendMessage(number1, "Hi, will call after lecture.");
        phone1.ChangeBattery("nonremovable", "Samsung", 2000);
        phone2.Charge(10);
        phone3.Reset();
        phone3.Update();

        System.out.println("<MAIN>: Ending simulation of the Phone app...");
        System.out.println("<MAIN>: . . .");
    }
}