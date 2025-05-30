package classes;

public non-sealed class Salesmann extends Employee {

    public static void setSalesReport(String saleDetails, int salePrice) {
        Account.addSaleToReport(saleDetails, salePrice); 
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
}
