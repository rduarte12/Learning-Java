package classes;

public non-sealed class Manager extends Employee {

    //gerar relatorio financeiro
    public static String getFinancialReport() {
        return Account.getFinancialReport();
    }

    public static String getSalesRepo() {
        return Account.getSalesReport();
    }    

    //gerar relatorio de vendas


    public Manager(String name, String email, String password) {
        this.emailObj.setEmail(email);
        this.name = name;
        this.password = password;
        this.isAdmin = true; // Managers are considered admins
    }

}
