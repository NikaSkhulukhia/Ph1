public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Battery lion1 = new Battery();
        lion1.setBrand("iPhone");
        lion1.setType("nonremovable");
        lion1.setCapacity(3000);
        lion1.setLife(35);
        System.out.println(lion1.toString());
    }
}