import java.util.Scanner;

import domain.BankService;
import domain.SpecialCredit;

public class App {
    private static final String NOME_LABEL = "Nome: ";
    private static final String SENHA_LABEL = "Senha: ";
    private static final String SALDO_LABEL = "Saldo: ";
    private static final String CONTA_NAO_ENCONTRADA_MSG = "Conta não encontrada ou credenciais incorretas.";

    static int solicitarInteiro(Scanner scanner, String mensagem) {
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

    static String solicitarString(Scanner scanner, String mensagem) {
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

    static String[] solicitarCredenciais(Scanner scanner) {
        String name = solicitarString(scanner, NOME_LABEL);
        String password = solicitarInteiro(scanner, SENHA_LABEL) + ""; // Converte o inteiro para String
        return new String[]{name, password};
    }

    static void createAccount(Scanner scanner, BankService bankService) {
        String[] credenciais = solicitarCredenciais(scanner);
            int saldoInicial = solicitarInteiro(scanner, "Saldo inicial: ");
            boolean criada = bankService.createAccount(credenciais[0], credenciais[1], saldoInicial);
            if (criada) {
                System.out.println("Conta criada com sucesso!");
            } else {
                System.out.println("Conta já existe!");
            }
    } 

    static void consultarSaldo(Scanner scanner, BankService bankService) {
        String[] credenciais = solicitarCredenciais(scanner);
        Integer saldo = bankService.consultarSaldo(credenciais[0], credenciais[1]);
        if (saldo != null) {
            System.out.println(SALDO_LABEL + saldo);
        } else {
            System.out.println(CONTA_NAO_ENCONTRADA_MSG);
        }
    }

    static void depositar(Scanner scanner, BankService bankService) {
        String[] credenciais = solicitarCredenciais(scanner);
        int valor = solicitarInteiro(scanner, "Valor do depósito: ");
        boolean sucesso = bankService.depositar(credenciais[0], credenciais[1], valor);
        if (sucesso) {
            System.out.println("Depósito realizado!");
        } else {
            System.out.println(CONTA_NAO_ENCONTRADA_MSG);
        }
    }

    static void sacar(Scanner scanner, BankService bankService) {
        String[] credenciais = solicitarCredenciais(scanner);
        int valor = solicitarInteiro(scanner, "Valor do saque: ");
        boolean sucesso = bankService.sacar(credenciais[0], credenciais[1], valor);
        if (sucesso) {
            System.out.println("Saque realizado!");
        } else {
            System.out.println("Conta não encontrada ou saldo insuficiente.");
        }
    }

    static void pagarBoleto(Scanner scanner, BankService bankService) {
        String[] credenciais = solicitarCredenciais(scanner);
        int valor = solicitarInteiro(scanner, "Valor do boleto: ");
        boolean sucesso = bankService.pagarBoleto(credenciais[0], credenciais[1], valor);
        if (sucesso) {
            System.out.println("Boleto pago com sucesso!");
        } else {
            System.out.println("Conta não encontrada, saldo insuficiente ou limite especial não disponível.");
        }
    }

    static void consultarLimiteEspecial(Scanner scanner, BankService bankService) {
        String[] credenciais = solicitarCredenciais(scanner);
        SpecialCredit sc = bankService.consultarLimiteEspecial(credenciais[0], credenciais[1]);
        if (sc != null) {
            System.out.println("Limite Especial: " + sc.getCreditLimit());
            System.out.println("Limite Usado: " + sc.getCreditUsed());
            System.out.println("Status do Limite: " + (sc.isCreditStatus() ? "Ativo" : "Inativo"));
        } else {
            System.out.println("Conta não encontrada ou não possui limite especial.");
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            BankService bankService = new BankService();
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
                int opcao = solicitarInteiro(scanner, "Escolha uma opção: ");

                switch (opcao) {
                    case 1 -> createAccount(scanner, bankService);
                    case 2 -> consultarSaldo(scanner, bankService);
                    case 3 -> depositar(scanner, bankService);
                    case 4 -> sacar(scanner, bankService);
                    case 5 -> pagarBoleto(scanner, bankService);
                    case 6 -> consultarLimiteEspecial(scanner, bankService);
                    case 7 -> running = false;
                    default -> System.out.println("Opção inválida.");
                }
            }
        }
    }
}
