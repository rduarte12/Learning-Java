// Exemplo de alteração na classe Account.java
package classes;

public class Account {

    // Usar StringBuilder para construir os relatórios
    private static StringBuilder financialReportContent = new StringBuilder();
    private static StringBuilder salesReportContent = new StringBuilder();
    private static int balance;

    // Construtor privado para evitar instanciação, já que é tudo estático
    private Account() {}

    public static String getFinancialReport() {
        // Adiciona o saldo ao final do relatório financeiro consolidado
        return "--- Relatório Financeiro Consolidado ---\n" +
               financialReportContent.toString() +
               "Saldo Atual da Empresa: " + balance + "\n" +
               "----------------------------------------\n";
    }

    // Método para adicionar uma entrada genérica ao relatório financeiro
    public static void addFinancialEntry(String entry) {
        financialReportContent.append(entry).append("\n");
    }

    public static String getSalesReport() {
        return "--- Relatório de Vendas Consolidado ---\n" +
               salesReportContent.toString() +
               "---------------------------------------\n";
    }

    // Método para adicionar uma venda ao relatório de vendas e atualizar o saldo
    public static void addSaleToReport(String saleDetails, int price) {
        String saleEntry = "Detalhes: " + saleDetails + ", Valor: R$" + price;
        salesReportContent.append(saleEntry).append("\n");
        setBalance(price); // Adiciona o valor da venda ao saldo
        addFinancialEntry("Venda registrada: " + saleEntry); // Registra a venda também no relatório financeiro
    }

    public static int getBalance() {
        return balance;
    }

    // Modificado para refletir adições (ou subtrações, se 'amount' for negativo)
    public static void setBalance(int amount) {
        Account.balance += amount;
        // Poderia adicionar uma entrada ao relatório financeiro aqui também, se desejado
        // addFinancialEntry("Ajuste de saldo: R$" + amount + ". Novo saldo: " + Account.balance);
    }
}