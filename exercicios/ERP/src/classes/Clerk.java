package classes;

public non-sealed class Clerk extends Employee{

    public static void setBalance(int balance) {
        Account.setBalance(balance);
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

    @Override
    Employee newEmployee(Employee employee) {
        if (employee instanceof Clerk) {
            this.name = getName();
            this.emailObj.setEmail(getEmail());
            this.password = getPassword();
            this.isAdmin = false;

            return this;
        }
        return null;
    }

}
