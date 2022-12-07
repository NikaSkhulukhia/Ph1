import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import person.Person;
import phone.MobilePhone;
import phone.Phone;
import phone.StationaryPhone;
import phonedata.Number;
import phonehardware.Battery;
import operationalsystem.OS;


public class Main {
    private static final Logger logger = LogManager.getLogger();
    /*\
    Main method to run the phone application and simulate calls.
    Rules for phone call/message:
    1. Phone.Phone can not start a call if the battery life is less or equal to 5%
    2. phone can not start or receive a call if it is already in another call
    3. after the call battery life is decreased by 1% for both involved phones
    4. phone can not send a message if the battery life is less or equal to 2%
     */
    public static void main(String[] args) {
        System.out.println("<MAIN>: Starting simulation of the Phone.Phone app...");
        System.out.println("<MAIN>: . . .");

        // initialize numbers, phones and owners
        Number number1 = new Number("AT&T", "1", "054565465");
        Person person1 = new Person("Alice", "Smith", "245245", null, number1, null);
        Phone phone1 = new MobilePhone("Alice's S22","Samsung", "03r303f", number1, person1);
        Number number2 = new Number("Verizon", "577", "4534563456");
        Person person2 = new Person("Bob", "Peterson", "2345677654", null, number2, null);
        Phone phone2 = new MobilePhone("Bob's iPhone","iPhone", "86h68h6", number2, person2);
        Number number3 = new Number("Beeline", "56", "8383388");
        Person person3 = new Person("Tom", "Black", "987654", null, number3, null);
        //MobilePhone phone3 = new MobilePhone("Tom's Sony 11","Sony", "1kn31n", number3, person3);
        Phone phone3 = new StationaryPhone();
        phone3.setOwnerPerson(person3);
        phone3.setPhoneNumber(number3);


        // create essential parts for phones
        Battery bat1 = new Battery("Samsung", "removable", 3000, 100);
        Battery bat2 = new Battery("iPhone", "removable", 4000, 44);
        Battery bat3 = new Battery("Sony", "removable", 5000, 100);
        phone1.setBattery(bat1);
        phone2.setBattery(bat2);
        phone3.setBattery(bat3);

        // create software
        OS soft1 = new OS("android", 11);
        OS soft2 = new OS("iOS", 14);
        OS soft3 = new OS("android", 12);
        //phone1.setSoftware(soft1);
        //phone2.setSoftware(soft2);
        //phone3.setSoftware(soft3);

        // simulate call and message methods
        phone1.startCall(phone2);
        phone1.startCall(phone3);
        phone3.startCall(phone1);
        phone1.endCall();
        phone3.startCall(phone2);
        phone2.sendMessage(phone1, "Hi, will call after lecture.");
        phone1.changeBattery("non-removable", "Samsung", 2000);
        phone2.charge(10);
        phone3.reset();
       // phone3.update();

        System.out.println("<MAIN>: Ending simulation of the Phone.Phone app...");
        System.out.println("<MAIN>: . . .");
    }
}