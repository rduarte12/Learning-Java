package domain;
import java.util.ArrayList;

public class BankService {
    
    private final ArrayList<Account> accounts = new ArrayList<>();

    public boolean createAccount(String name, String password, int initialBalance) {
        if (findAccount(name, password) == null) {
            accounts.add(new Account(name, password, initialBalance));
            return true;
        }
        return false; // Conta já existe
    }

    public Account findAccount(String name, String password) {
        for (Account acc : accounts) {
            if (acc.getName().equals(name) && acc.getPassword().equals(password)) {
                return acc;
            }
        }
        return null;
    }

    public Integer consultarSaldo(String name, String password) {
        Account acc = findAccount(name, password);
        if (acc != null) {
            return acc.getBalance();
        }
        return null;
    }

    public boolean depositar(String name, String password, int valor) {
        Account acc = findAccount(name, password);
        if (acc != null) {
            acc.setBalance(acc.getBalance() + valor);
            return true;
        }
        return false;
    }

    public boolean sacar(String name, String password, int valor) {
        Account acc = findAccount(name, password);
        if (acc != null && valor <= acc.getBalance()) {
            acc.setBalance(acc.getBalance() - valor);
            return true;
        }
        return false;
    }

    public boolean pagarBoleto(String name, String password, int valor) {
        Account acc = findAccount(name, password);
        if (acc != null) {
            if (valor <= acc.getBalance()) {
                acc.setBalance(acc.getBalance() - valor);
                return true;
            } else if (acc.getSpecialCredit() != null && valor <= (acc.getBalance() + acc.getSpecialCredit().getCreditLimit())) {
                acc.getSpecialCredit().setCreditUsed(acc.getSpecialCredit().getCreditUsed() + valor - acc.getBalance());
                acc.setBalance(0);
                return true;
            }
        }
        return false;
    }

    public SpecialCredit consultarLimiteEspecial(String name, String password) {
        Account acc = findAccount(name, password);
        if (acc != null) {
            return acc.getSpecialCredit();
        }
        return null;
    }

    // Getter para contas, caso precise listar ou manipular fora do serviço
    public ArrayList<Account> getAccounts() {
        return accounts;
    }
}