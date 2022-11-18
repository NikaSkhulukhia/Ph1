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
        System.out.println("Hello world!");
        Battery lion1 = new Battery();
        lion1.setBrand("iPhone");
        lion1.setType("nonremovable");
        lion1.setCapacity(3000);
        lion1.setLife(35);
        System.out.println(lion1.toString());

        RAM rm1 = new RAM("asd", 6);
        System.out.println(rm1.toString());
    }
}