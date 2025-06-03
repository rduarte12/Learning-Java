import java.util.Scanner;

public class Calculator {
    private static Scanner scanner = new Scanner(System.in);

    // Private constructor to prevent instantiation
    private Calculator() {
        // This constructor is intentionally empty
    }

    public static TaxCalculator clothes() {
        System.out.print("Clothe price:");
        double price = scanner.nextDouble();
        return new Clothes(price);
    }

    public static TaxCalculator food() {
        System.out.print("Food price:");
        double price = scanner.nextDouble();
        return new Food(price);
    }

    public static TaxCalculator health() {
        System.out.print("Healthcare price:");
        double price = scanner.nextDouble();
        return new Health(price);
    }

    public static TaxCalculator culture() {
        System.out.print("Culture price:");
        double price = scanner.nextDouble();
        return new Culture(price);
    }

}
