import java.util.Scanner;
import java.util.ArrayList;

public class App {

    static Account findAccount(String name, String password, ArrayList<Account> accounts) {
        for (Account account : accounts) {
            if (account.getName().equals(name) && account.getPassword().equals(password)) {
                return account;
            }
        }
        return null;
    }

    static void createAccount(Scanner scanner, ArrayList<Account> accounts) {
        System.out.print("Nome: ");
        String name = scanner.next();
        System.out.print("Senha: ");
        String password = scanner.next();
        System.out.print("Saldo inicial: ");
        int initialBalance = scanner.nextInt();
        accounts.add(new Account(name, password, initialBalance));
        System.out.println("Conta criada com sucesso!");
    }

    static void consultarSaldo(Scanner scanner, ArrayList<Account> accounts) {
        System.out.print("Nome: ");
        String name = scanner.next();
        System.out.print("Senha: ");
        String password = scanner.next();
        Account acc = findAccount(name, password, accounts);
        if (acc != null) {
            System.out.println("Saldo: " + acc.getBalance());
        } else {
            System.out.println("Conta não encontrada ou credenciais incorretas.");
        }
    }

    static void depositar(Scanner scanner, ArrayList<Account> accounts) {
        System.out.print("Nome: ");
        String name = scanner.next();
        System.out.print("Senha: ");
        String password = scanner.next();
        Account acc = findAccount(name, password, accounts);
        if (acc != null) {
            System.out.print("Valor do depósito: ");
            int valor = scanner.nextInt();
            acc.setBalance(acc.getBalance() + valor);
            System.out.println("Depósito realizado! Novo saldo: " + acc.getBalance());
        } else {
            System.out.println("Conta não encontrada ou credenciais incorretas.");
        }
    }

    static void sacar(Scanner scanner, ArrayList<Account> accounts) {
        System.out.print("Nome: ");
        String name = scanner.next();
        System.out.print("Senha: ");
        String password = scanner.next();
        Account acc = findAccount(name, password, accounts);
        if (acc != null) {
            System.out.print("Valor do saque: ");
            int valor = scanner.nextInt();
            if (valor <= acc.getBalance()) {
                acc.setBalance(acc.getBalance() - valor);
                System.out.println("Saque realizado! Novo saldo: " + acc.getBalance());
            } else {
                System.out.println("Saldo insuficiente.");
            }
        } else {
            System.out.println("Conta não encontrada ou credenciais incorretas.");
        }
    }

    static void pagarBoleto(Scanner scanner, ArrayList<Account> accounts) {
        System.out.print("Nome: ");
        String name = scanner.next();
        System.out.print("Senha: ");
        String password = scanner.next();
        Account acc = findAccount(name, password, accounts);
        if (acc != null) {
            System.out.print("Valor do boleto: ");
            int valor = scanner.nextInt();
            if (valor <= acc.getBalance()) {
                acc.setBalance(acc.getBalance() - valor);
                System.out.println("Boleto pago com sucesso! Novo saldo: " + acc.getBalance());
            } else if (acc.getSpecialCredit() != null && valor <= (acc.getBalance() + acc.getSpecialCredit().getCreditLimit())) {
                acc.getSpecialCredit().setCreditUsed(acc.getSpecialCredit().getCreditUsed() + valor);
                acc.setBalance(0);
                System.out.println("Boleto pago com limite especial! Novo saldo: " + acc.getBalance() + "Limite usado: " + acc.getSpecialCredit().getCreditUsed());
            } else {
                System.out.println("Saldo insuficiente e limite especial não disponível.");
            }
        } else {
            System.out.println("Conta não encontrada ou credenciais incorretas.");
        }             
    }

    static void consultarLimiteEspecial(Scanner scanner, ArrayList<Account> accounts) {
        System.out.print("Nome: ");
        String name = scanner.next();
        System.out.print("Senha: ");
        String password = scanner.next();
        Account acc = findAccount(name, password, accounts);
        if (acc != null) {
            if (acc.getSpecialCredit() != null) {
                System.out.println("Limite Especial: " + acc.getSpecialCredit().getCreditLimit());
                System.out.println("Limite Usado: " + acc.getSpecialCredit().getCreditUsed());
                System.out.println("Status do Limite: " + (acc.getSpecialCredit().isCreditStatus() ? "Ativo" : "Inativo"));
            } else {
                System.out.println("Conta não possui limite especial.");
            }
        }
    }
        
    

    // Adicione métodos para boleto, limite especial, etc.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("Welcome to MyBank!");
            System.out.println("""
                1. Criar Conta
                2. Consultar Saldo
                3. Depositar
                4. Sacar
                5. Pagar boleto
                6. Consultar Limite Especial
                7. Sair
            """);
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> createAccount(scanner, accounts);
                case 2 -> consultarSaldo(scanner, accounts);
                case 3 -> depositar(scanner, accounts);
                case 4 -> sacar(scanner, accounts);
                case 5 -> pagarBoleto(scanner, accounts);
                case 6 -> consultarLimiteEspecial(scanner, accounts);
                case 7 -> running = false;
                default -> System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }
}
