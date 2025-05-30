package classes;

public class Account {

    private static String financialReport;
    private static String salesReport;
    private static int balance;
    public  Account() {
        // Private constructor to prevent instantiation
    }


    public static String getFinancialReport() {
        return (financialReport == null ? "" : financialReport) + getBalance() + "/n";
    }

    public static void setFinancialReport(String financialReport) {
        Account.financialReport = (Account.financialReport == null ? "" : Account.financialReport) + "/n" + financialReport + "/n";
    }

    public static String getSalesReport() {
        return salesReport;
    }

    public static void setSalesReport(String salesReport, int price) {
        Account.salesReport = (Account.salesReport == null ? "" : Account.salesReport) + "/n" + salesReport + price + "/n";
        setBalance(price);
    }

    public static int getBalance() {
        return balance;
    }

    public static void setBalance(int balance) {
        Account.balance += balance;
    }




}
