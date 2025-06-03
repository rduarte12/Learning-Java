import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        TaxCalculator tax;
        try (var scanner = new Scanner(System.in)) {
            boolean isRunning = true;
            while (isRunning) {
                System.out.println("""
                        Welcome to the tax calculator!
                        1. Calculate tax : Food
                        2. Calculate tax : Healthcare and Well-being
                        3. Calculate tax : Clothing
                        4. Calculate tax : Culture and Entertainment
                        6. Calculate tax : Exit
                        """);

                System.out.print("Please select an option: ");
                int option = scanner.nextInt();
                if (option >= 1 && option <= 4) {   
                    tax = switch (option) {
                    case 1 -> Calculator.food();
                    case 2 -> Calculator.health();
                    case 3 -> Calculator.clothes();
                    case 4 -> Calculator.culture();
                    default -> throw new IllegalStateException("Unexpected value: " + option);
                    };
                    if (tax != null) {
                        System.out.printf("The tax for the selected item is: %.2f%n", tax.calculateTax());
                    }
                } else {

                    switch (option) {
                        case 6 -> isRunning = false;
                        default -> System.out.println("Invalid option. Please try again.");
                    }
                }
                
            }
        }

        
    }
}
