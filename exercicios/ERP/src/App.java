import classes.Employee;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        // Initialize the list of employees
        ArrayList<Employee> employees = new ArrayList<>();
        
        try {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Bem-vindo ao Duart Crm! /n");

            boolean isRunning = true;
            while (isRunning) {
                System.out.println("Selecione uma opção:");
                System.out.println("1. Criar novo funcionário");
                System.out.println("2. Acessar usuário existente");
                System.out.println("3. Sair");
                int option = utils.UtilMethods.solicitarInteiro(scanner, "Opção: ");
                switch (option) {
                    case 1 -> utils.UtilMethods.creatEmployee(scanner, employees);
                    case 2 -> utils.UtilMethods.acessarEmployee(scanner, employees);
                    case 3 -> {
                        System.out.println("Saindo do sistema...");
                        isRunning = false;
                    }
                    default -> System.out.println("Opção inválida. Tente novamente.");
                }
            }
            
        }catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }
}
