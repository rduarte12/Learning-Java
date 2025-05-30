package utils;

import classes.Account;
import classes.Clerk;
import classes.Email;
import classes.Employee;
import classes.Manager;
import classes.Salesmann;
import java.util.ArrayList;
import java.util.Scanner;

public record UtilMethods() {

    private static final String INVALID_OPTION_MSG = "Opção inválida. Tente novamente.";

    public static int solicitarInteiro(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            if (scanner.hasNextInt()) {
                int valor = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
                return valor;
            } else {
                System.out.println("Por favor, digite um número inteiro válido.");
                scanner.next(); // descarta entrada inválida
            }
        }
    }

    public static String solicitarString(Scanner scanner, String mensagem) {
        String entrada;
        do {
            System.out.print(mensagem);
            entrada = scanner.nextLine();
            if (entrada.trim().isEmpty()) {
                System.out.println("O campo não pode ser vazio.");
            } else if (!entrada.matches("[a-zA-ZÀ-ÿ ]+")) { // permite espaços
                System.out.println("Digite apenas letras.");
                entrada = "";
            }
        } while (entrada.trim().isEmpty());
        return entrada;
    }

    //Create a method to creat a new employee
    public static void creatEmployee(Scanner scanner, ArrayList<Employee> employees) {
        System.out.println("Criando novo funcionário...");
        String name = solicitarString(scanner, "Digite o nome do funcionário: ");
        String email = isValidEmail(scanner);
        System.out.println("");
        String password = solicitarString(scanner, "Digite a senha do funcionário: ");
        System.out.println("\n");

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Selecione o tipo de funcionário:");
            System.out.println("1. Gerente");
            System.out.println("2. Vendedor");
            System.out.println("3. Caixa");
            System.out.println("4. Voltar");
            int option = solicitarInteiro(scanner, "Opção: ");
            switch (option) {
                case 1 -> /*Manager */ {
                    Employee manager = new Manager(name, email, password);
                    employees.add(manager);
                    System.out.println("Gerente criado com sucesso: " + manager.getClass().getSimpleName());
                    isRunning = false;
                }
                case 2 -> /*Salesman */ {
                    Employee salesman = new Salesmann(name, email, password);
                    employees.add(salesman);
                    System.out.println("Vendedor criado com sucesso: " + salesman.getClass().getSimpleName());
                    isRunning = false;
                }
                case 3 -> /*Clerk */ {
                    Employee clerk = new Clerk(name, email, password);
                    employees.add(clerk);
                    System.out.println("Caixa criado com sucesso: " + clerk.getClass().getSimpleName());
                    isRunning = false;
                }
                case 4 -> {
                    System.out.println("Voltando ao menu principal...");
                    isRunning = false;
                }

                default -> System.out.println(INVALID_OPTION_MSG);
                
            }
        }   
    }

    public static Employee findEmployee(Scanner scanner, ArrayList<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado. Por favor, crie um funcionário primeiro.");
            return null;
        } else {
            System.out.println("Procurando funcionário...");
            String email = isValidEmail(scanner);
            String password = solicitarString(scanner, "Digite a senha do funcionário: ");
            for (Employee employee : employees) {
                if (employee.getEmail().equalsIgnoreCase(email) && employee.getPassword().equals(password)) {
                    System.out.println("Funcionário encontrado: " + employee.getName());
                    // Aqui você pode adicionar lógica adicional para o que acontece após encontrar o funcionário
                    return employee;
                }
            }
            
            System.out.println("Funcionário não encontrado. Verifique o email e a senha e tente novamente.");
            return null;
        }
    }
    
    public static void  acessarEmployee(Scanner scanner, ArrayList<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado. Por favor, crie um funcionário primeiro.");
            return;
        }
        Employee employeeFound = findEmployee(scanner, employees);

        switch (employeeFound) {
            case Manager manager -> menuManager(scanner, manager, employees);
            case Salesmann salesman -> menuSalesman(scanner, salesman);
            case Clerk clerk -> menuClerk(scanner, clerk);
            case null -> System.out.println("Acesso negado. Funcionário não encontrado.");
            default -> System.out.println("Tipo de funcionário desconhecido.");
        }
    }

    public static void menuManager(Scanner scanner, Manager manager, ArrayList<Employee> employees) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Menu Gerente:");
            System.out.println("1. Gerar relatório financeiro");
            System.out.println("2. Gerar relatório de vendas");
            System.out.println("3. Criar novo funcionário");
            System.out.println("4. Sair");
            int option = solicitarInteiro(scanner, "Opção: ");

            switch (option) {
                case 1 -> {
                    String financialReport = Manager.getFinancialReport();
                    System.out.println("Relatório financeiro: " + financialReport);
                }
                case 2 -> {
                    String salesReport = Manager.getSalesRepo();
                    System.out.println("Relatório de vendas: " + salesReport);
                }
                case 3 -> {
                    creatEmployee(scanner, employees); // Passa a lista de funcionários para criar um novo);
                }
                case 4 -> {
                    System.out.println("Saindo do menu Gerente...");
                    isRunning = false;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
       }
    }

    public static void menuSalesman(Scanner scanner, Salesmann salesman) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Menu Vendedor:");
            System.out.println("1. Registrar venda");
            System.out.println("2. Ver relatório de vendas");
            System.out.println("3. Sair");
            int option = solicitarInteiro(scanner, "Opção: ");

            switch (option) {
                case 1 -> {
                    String saleDetails = solicitarString(scanner, "Digite os detalhes da venda: ");
                    int salePrice = solicitarInteiro(scanner, "Digite o valor da venda: ");
                    Account.addSaleToReport(saleDetails, salePrice);
                    System.out.println("Venda registrada com sucesso.");
                }
                case 2 -> {
                    String salesReport = Salesmann.getSalesReport();
                    System.out.println("Relatório de vendas: " + salesReport);
                }
                case 3 -> {
                    System.out.println("Saindo do menu Vendedor...");
                    isRunning = false;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    public static void menuClerk(Scanner scanner, Clerk clerk) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Menu Caixa:");
            System.out.println("1. Registrar pagamento");
            System.out.println("2. Ver relatório financeiro");
            System.out.println("3. Sair");

            int option = solicitarInteiro(scanner, "Opção: ");
            switch (option) {
                case 1 -> {
                    int paymentAmount = solicitarInteiro(scanner, "Digite o valor do pagamento: ");
                    Clerk.setBalance(paymentAmount);
                    System.out.println("Pagamento registrado com sucesso.");
                }
                case 2 -> {
                    int balance = Clerk.getBalance();
                    System.out.println("Saldo atual: " + balance);
                }
                case 3 -> {
                    System.out.println("Saindo do menu Caixa...");
                    isRunning = false;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static String isValidEmail(Scanner scanner) {
    while (true) {
        System.out.print("Digite o email do funcionário: ");
        String emailInput = scanner.nextLine();
        Email emailObj = new Email();
        try {
            emailObj.setEmail(emailInput); // Vai lançar exceção se for inválido
            System.out.println("Email válido: " + emailObj.getEmail());
            return emailObj.getEmail();
        } catch (IllegalArgumentException e) {
            System.out.println("Email inválido: " + e.getMessage());
        }
    }
}
        
}
