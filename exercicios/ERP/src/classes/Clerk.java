package classes;

public non-sealed class Clerk extends Employee{

    public static void setBalance(int paymentAmount) {
        Account.setBalance(paymentAmount);
        Account.addFinancialEntry("Pagamento registrado: R$" + paymentAmount);
    }
    
    public static int getBalance() {
        return Account.getBalance();
    }

    public Clerk(String name, String email, String password) {
        this.name = name;
        this.emailObj.setEmail(email);
        this.password = password;
        this.isAdmin = false; // Clerks are not considered admins
    }

}
