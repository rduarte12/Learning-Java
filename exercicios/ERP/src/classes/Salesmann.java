package classes;

public non-sealed class Salesmann extends Employee {

    public static void setSalesReport(String salesReport, int value) {
        Account.setSalesReport(salesReport, value);  
    }

    public static String getSalesReport() {
        return Account.getSalesReport();
    }

    public Salesmann(String name, String email, String password) {
        this.name = name;
        this.emailObj.setEmail(email);
        this.password = password;
        this.isAdmin = false; // Salesmen are not considered admins
    }

    @Override
    Employee newEmployee(Employee employee) {
        if (employee instanceof Salesmann) {
            this.name = getName();
            this.emailObj.setEmail(getEmail());
            this.password = getPassword();
            this.isAdmin = false; 

            return this;
        }

        return null;
    }



}
