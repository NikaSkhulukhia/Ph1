import enums.BatteryType;
import enums.CountryCode;
import enums.OSType;
import exceptions.*;
import operationalsystem.OS;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import person.Person;
import phone.MobilePhone;
import phone.Phone;
import phone.StationaryPhone;
import phonedata.Number;
import phonehardware.Battery;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.StringTokenizer;


public class Main {
    private static final Logger LOGGER = LogManager.getLogger();
    /*\
    Main method to run the phone application and simulate calls/messages.
     */
    public static void main(String[] args) {
        LOGGER.trace("START simulation of the Phone app...");

        // initialize numbers, phones and owners
        Number number1 = new Number("AT&T", "1", "054565465", CountryCode.CANADA);
        Person person1 = new Person("Alice", "Smith", "245245", null, number1, null);
        Phone phone1 = new MobilePhone("Alice's S22","Samsung", "03r303f", number1, person1);
        Number number2 = new Number("Verizon", "577", "4534563456", CountryCode.EGYPT);
        Person person2 = new Person("Bob", "Peterson", "2345677654", null, number2, null);
        Phone phone2 = new MobilePhone("Bob's iPhone","iPhone", "86h68h6", number2, person2);
        Number number3 = new Number("Beeline", "56", "8383388", CountryCode.GEORGIA);
        Person person3 = new Person("Tom", "Black", "987654", null, number3, null);
        //MobilePhone phone3 = new MobilePhone("Tom's Sony 11","Sony", "1kn31n", number3, person3);
        Phone phone3 = new StationaryPhone();
        phone3.setOwnerPerson(person3);
        phone3.setPhoneNumber(number3);


        // create essential hardware for phones
        Battery bat1;
        bat1 = null;
        try {
            bat1 = new Battery("Samsung", BatteryType.LIPO, 3000, 100);
        } catch (IncorrectCapacityException e) {
            LOGGER.error(e.getMessage());
        } catch (IncorrectBatteryLifeException e) {
            LOGGER.error(e.getMessage());
        }
        Battery bat2;
        bat2 = null;
        try {
            bat2 = new Battery("iPhone", BatteryType.LIION, 4000, 44);
        } catch (IncorrectCapacityException e) {
            LOGGER.error(e.getMessage());
        } catch (IncorrectBatteryLifeException e) {
            LOGGER.error(e.getMessage());
        }
        Battery bat3;
        bat3 = null;
        try {
            bat3 = new Battery("Sony", BatteryType.NIMH, 5000, 100);
        } catch (IncorrectCapacityException e) {
            LOGGER.error(e.getMessage());
        } catch (IncorrectBatteryLifeException e) {
            LOGGER.error(e.getMessage());
        }
        phone1.setBattery(bat1);
        phone2.setBattery(bat2);
        phone3.setBattery(bat3);

        // create OS
        try {
            OS soft1 = new OS(OSType.ANDROID, 11);
        } catch (IncorrectOSVersionException e) {
            LOGGER.error(e.getMessage());
        }
        try {
            OS soft2 = new OS(OSType.IOS, 14);
        } catch (IncorrectOSVersionException e) {
            LOGGER.error(e.getMessage());
        }
        try {
            OS soft3 = new OS(OSType.WINDOWS, 12);
        } catch (IncorrectOSVersionException e) {
            LOGGER.error(e.getMessage());
        }
        //phone1.setSoftware(soft1);
        //phone2.setSoftware(soft2);
        //phone3.setSoftware(soft3);

        // simulate call and message methods
        try {
            phone1.startCall(phone2);
        } catch (PhoneNotFoundException e) {
            LOGGER.error(e.getMessage());
        } catch (PhoneAlreadyOnCallException e) {
            LOGGER.error(e.getMessage());
        }
        try {
            phone1.startCall(phone3);
        } catch (PhoneNotFoundException e) {
            LOGGER.error(e.getMessage());
        } catch (PhoneAlreadyOnCallException e) {
            LOGGER.error(e.getMessage());
        }
        try {
            phone3.startCall(phone1);
        } catch (PhoneNotFoundException e) {
            LOGGER.error(e.getMessage());
        } catch (PhoneAlreadyOnCallException e) {
            LOGGER.error(e.getMessage());
        }
        try {
            phone1.endCall();
        } catch (CallNotFoundException e) {
            LOGGER.error(e.getMessage());
        }
        try {
            phone3.startCall(phone2);
        } catch (PhoneNotFoundException e) {
            LOGGER.error(e.getMessage());
        } catch (PhoneAlreadyOnCallException e) {
            LOGGER.error(e.getMessage());
        }
        try {
            phone2.sendMessage(phone1, "Hi, will call after lecture.");
        } catch (PhoneNotFoundException e) {
            LOGGER.error(e.getMessage());
        } catch (BatteryNotFoundException e) {
            LOGGER.error(e.getMessage());
        } catch (BatteryLowException e) {
            LOGGER.error(e.getMessage());
        }
        LOGGER.trace("Change battery for phone1.");
        LOGGER.trace("phone1 old battery: " + phone1.getBattery().toString());
        phone1.changeBattery(BatteryType.LIION, "Samsung", 2000);
        LOGGER.trace("phone1 new battery: " + phone1.getBattery().toString());
        try {
            phone2.charge(10);
        } catch (IncorrectTimeException e) {
            LOGGER.error(e.getMessage());
        } catch (BatteryNotFoundException e) {
            LOGGER.error(e.getMessage());
        }
        phone3.reset();
        // phone3.update();
        LOGGER.trace("Get phone1 call log");
        phone1.getCallLog().forEach(c -> LOGGER.trace(c.getCallerNumber().getFullNumber() + " TO "
               + c.getReceiverNumber().getFullNumber()));
        LOGGER.trace("Get phone2 call log");
        phone2.getCallLog().forEach(c -> LOGGER.trace(c.getCallerNumber().getFullNumber() + " TO "
                + c.getReceiverNumber().getFullNumber()));
        LOGGER.trace("Get phone3 call log");
        phone3.getCallLog().forEach(c -> LOGGER.trace(c.getCallerNumber().getFullNumber() + " TO "
                + c.getReceiverNumber().getFullNumber()));
        LOGGER.trace("END simulation of the Phone app....");


//        File fileToRead = new File("src/main/resources/fileToRead");
//        File fileToWrite = new File("src/main/resources/fileToWrite");
//        try {
//            String fileContent = FileUtils.readFileToString(fileToRead, "UTF-8").toLowerCase();
//            HashMap<String, Integer> wordsMap = new HashMap<>();
//            String[] words = fileContent.split(" ");
//            for (String word : words) {
//                Integer temp = (wordsMap.get(word) == null) ? wordsMap.put(word, 1) : wordsMap.put(word, wordsMap.get(word) + 1);
//            }
//            FileUtils.writeStringToFile(fileToWrite, wordsMap.toString(), "UTF-8");
//        } catch (IOException e) {
//            LOGGER.error("Problem with the file");
//        }
    }
}