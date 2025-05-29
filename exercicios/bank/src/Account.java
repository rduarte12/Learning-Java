public class Account {
    private String name;
    private String password;
    private int balance;
    private SpecialCredit specialCredit;

    public Account(String name, String password) {
        this.name = name;
        this.password = password;
        this.balance = 0; // Default balance is set to 0
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
