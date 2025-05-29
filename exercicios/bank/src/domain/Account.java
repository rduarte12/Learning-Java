package domain;

public class Account {
    private String name;
    private String password;
    private int balance;
    private SpecialCredit specialCredit;

    public Account(String name, String password, int balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.specialCredit = new SpecialCredit(this);
    }

    public void setSpecialCredit(SpecialCredit specialCredit) {
        this.specialCredit = specialCredit;
    }

    public SpecialCredit getSpecialCredit() {
        return specialCredit;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

    
}
