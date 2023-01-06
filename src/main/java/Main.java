import enums.BatteryType;
import enums.CountryCode;
import enums.OSType;
import exceptions.*;
import interfaces.IPhoneAction;
import interfaces.IPhoneBiFunction;
import interfaces.IPhoneBiPredicate;
import operationalsystem.OS;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import person.Person;
import phone.MobilePhone;
import phone.Phone;
import phone.StationaryPhone;
import phonedata.Call;
import phonedata.Message;
import phonedata.Number;
import phonehardware.Battery;
import phonehardware.Processor;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Main {
    private static final Logger LOGGER = LogManager.getLogger();
    /*\
    Main method to run the phone application and simulate calls/messages.
     */
    public static void main(String[] args) {
        // lambda function to end the current call
        IPhoneAction endCallAction = Phone::endCall;
        // lambda function to get total weight of 2 phones
        IPhoneBiFunction<Double, Double, Double> totalWeightFunction = (p1, p2, weight1, weight2)
                -> p1.getWeight() + weight1 + p2.getWeight() + weight2;
        /*
         compare the battery life of two phones: The batteryLifeComparisonFunction lambda expression takes
         two phone objects and two battery life thresholds as inputs,
         and returns true if both phones have a battery life greater than the corresponding threshold,
         and false otherwise.
         */
        IPhoneBiPredicate<Integer, Integer> batteryLifeComparisonFunction = (p1, p2, minLife1, minLife2)
                -> p1.getBattery().getLife() > minLife1 && p2.getBattery().getLife() > minLife2;

        // START SIMULATION
        LOGGER.trace("START simulation of the Phone app...");

        // initialize numbers, phones and owners
        Number number1 = new Number("AT&T", "1", "054565465", CountryCode.CANADA);
        Person person1 = new Person("Alice", "Smith", "245245", null, number1, null);
        Phone phone1 = new MobilePhone("Alice's S22", "Samsung", "03r303f", number1, person1);
        Number number2 = new Number("Verizon", "577", "4534563456", CountryCode.EGYPT);
        Person person2 = new Person("Bob", "Peterson", "2345677654", null, number2, null);
        Phone phone2 = new MobilePhone("Bob's iPhone", "iPhone", "86h68h6", number2, person2);
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
            endCallAction.performAction(phone1);
            // phone1.endCall();
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

        // get total weight of phone 1 and phone2
        phone1.setWeight(111);
        phone2.setWeight(105);
        double additionalWeight1 = 0.5; // assume this is the weight of a phone case
        double additionalWeight2 = 0.3; // assume this is the weight of a phone case
        double totalWeight = totalWeightFunction.apply(phone1, phone2, additionalWeight1, additionalWeight2);
        LOGGER.trace("Total weight of phones: " + totalWeight + " g");

        // check battery lives of 2 phones to make a call
        int batteryLifeThreshold1 = 1;
        int batteryLifeThreshold2 = 1;

        boolean bothPhonesHaveSufficientBatteryLife = batteryLifeComparisonFunction.test(phone1, phone2,
                batteryLifeThreshold1, batteryLifeThreshold2);

        if (bothPhonesHaveSufficientBatteryLife) {
            LOGGER.trace("Both phones have sufficient battery life.");
            try {
                phone2.startCall(phone1);
            } catch (PhoneNotFoundException e) {
                LOGGER.error(e.getMessage());
            } catch (PhoneAlreadyOnCallException e) {
                LOGGER.error(e.getMessage());
            }
        }

        // examine call logs for phone1 using streams
        // To find the longest call in the call log
        Call longestCall = phone1.getCallLog().stream()
                .max(Comparator.comparing(Call::getCallDuration))
                .orElse(null);
        LOGGER.trace("longest call is: " + longestCall.toString());

        // To find the phone owner with the most number of calls in the call log:
        Person ownerWithMostCalls = phone1.getCallLog().stream()
                .collect(Collectors.groupingBy(Call::getCallerPerson, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
        LOGGER.trace("owner of most calls is: " + ownerWithMostCalls.getFirstName() + " " + ownerWithMostCalls.getLastName());

        // To find the total duration of all calls in the call log
        long totalCallDuration = phone1.getCallLog().stream()
                .mapToLong(Call::getCallDuration)
                .sum();
        LOGGER.trace("total call duration is: " + totalCallDuration);

        // To filter the call log to only include calls made to a specific phone number
        Number targetNumber = new Number("AT&T", "1", "054565465", CountryCode.CANADA);
        List<Call> callsToNumber = phone1.getCallLog().stream()
                .filter(c -> c.getReceiverNumber().equals(targetNumber))
                .collect(Collectors.toList());

        // Get the total number of calls made
        long totalCalls = phone1.getCallLog().stream().count();

        // examine messages log for phone 1
        // use the stream method 'filter' to filter the list of messages based on certain criteria,
        LocalDate startDate = LocalDate.of(2022, 1, 1);
        LocalDate endDate = LocalDate.of(2022, 12, 31);
        List<Message> messagesWithinDateRange = phone1.getMessages().stream()
                .filter(message -> message.getMessageSendDate().isAfter(startDate) && message.getMessageSendDate()
                        .isBefore(endDate))
                .collect(Collectors.toList());

        // use the stream method 'map', to get a list of just the message texts
        List<String> messageBodies = phone1.getMessages().stream()
                .map(Message::getMessageText)
                .collect(Collectors.toList());

        // use the stream method 'sorted' to sort the list of messages based on a certain field.
        List<Message> sortedMessages = phone1.getMessages().stream()
                .sorted(Comparator.comparing(Message::getMessageSendDate))
                .collect(Collectors.toList());



        // END SIMULATION
        LOGGER.trace("END simulation of the Phone app....");


//        File fileToRead = new File("src/main/resources/fileToRead");
//        File fileToWrite = new File("src/main/resources/fileToWrite");
//        try {
//            String fileContent = FileUtils.readFileToString(fileToRead, "UTF-8").toLowerCase();
//            Map<Object, Integer> wordsMap = Arrays.stream(fileContent.split(" "))
//                    .collect(Collectors.toMap(w -> w, w -> 1, Integer::sum));
//            FileUtils.writeStringToFile(fileToWrite, wordsMap.toString(), "UTF-8");
//        } catch (IOException e) {
//            LOGGER.error("Problem with the file");
//        }
    }
}