import java.util.Scanner;
import java.util.ArrayList;



public class App {
    
    static Account findAccount(String name, String password, ArrayList<Account> accounts) {
        for (Account account : accounts) {
            if (account.getName().equals(name) && account.getPassword().equals(password)) {
                return account;
            }
        }
        return null; // Return null if no matching account is found
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();
        
        boolean running = true;
        while (running) {
            System.out.println("Welcome to MyBank!");
            System.out.println("""
                    1. Creat Account
                    2. Consultar Saldo
                    3. Depositar
                    4. Sacar
                    5. Pagar boleto
                    6. Consultar Limite Especial
                    7. Sair
                    """);

            System.out.print("Escolha uma opção: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Creating a new account...");

                    System.out.print("Enter your name: ");
                    String name = scanner.next();
                    
                    System.out.print("Enter your password: ");
                    String password = scanner.next();
                    
                    System.out.print("Enter your initial balance: ");
                    int initialBalance = scanner.nextInt();
                    
                    Account newAccount = new Account(name, password);
                    newAccount.setBalance(initialBalance);
                    accounts.add(newAccount);
                    System.out.println("Account created successfully!");
                    break;

                case 2:

                    System.out.print("Enter your name: ");
                    String consultName = scanner.next();
                    System.out.print("Enter your password: ");
                    String consultPassword = scanner.next();

                    Account consultAccount = findAccount(consultName, consultPassword, accounts);
                    if (consultAccount != null) {
                        System.out.println("Your balance is: " + consultAccount.getBalance());
                    } else {
                        System.out.println("Account not found or incorrect credentials.");
                    }

                    break;
                
                case 3: 
                    
                    System.out.print("Enter your name: ");
                    String consulName = scanner.next();
                    System.out.print("Enter your password: ");
                    String consulPassword = scanner.next();

                    Account consulAccount = findAccount(consulName, consulPassword, accounts);
                    if (consulAccount != null) {
                        System.out.print("Enter the amount to deposit: ");
                        int depositAmount = scanner.nextInt();
                        consulAccount.setBalance(consulAccount.getBalance() + depositAmount);
                        System.out.println("Deposit successful! New balance: " + consulAccount.getBalance());
                    } else {
                        System.out.println("Account not found or incorrect credentials.");
                    }
                    break;

                case 4:

                    System.out.print("Enter your name: ");
                    String consul2Name = scanner.next();
                    System.out.print("Enter your password: ");
                    String consul2Password = scanner.next();
                    
                    Account consulAccount2 = findAccount(consul2Name, consul2Password, accounts);
                    
                    if (consulAccount2 != null) {
                        System.out.print("Enter the amount to withdraw: ");
                        int withdrawAmount = scanner.nextInt();

                        if (withdrawAmount <= consulAccount2.getBalance()) {
                            consulAccount2.setBalance(consulAccount2.getBalance() - withdrawAmount);
                            System.out.println("Withdrawal successful! New balance: " + consulAccount2.getBalance());
                        } else if (withdrawAmount > consulAccount2.getBalance() && (consulAccount2.getBalance() - withdrawAmount) >= consulAccount2.get ) {}
                        
                    }


                    
                
            }
        }
    
}
