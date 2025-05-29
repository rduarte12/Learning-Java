public class SpecialCredit {
    private int creditLimit;
    private int creditUsed;
    private boolean creditStatus;
    private Account account;

    public SpecialCredit(Account account) {
        this.account = account;
        if (account.getBalance() < 500) {
            this.creditLimit = 50;
            this.creditStatus = true;
        } else if (account.getBalance() >= 500) {
            this.creditLimit = account.getBalance()/2;
            this.creditStatus = true;
        } else {
            this.creditLimit = 0;
            this.creditStatus = false;
        }
    }

    
    
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }



    public int getCreditUsed() {
        return creditUsed;
    }

    public void setCreditUsed(int creditUsed) {
        this.creditUsed = creditUsed;
    }


    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    public boolean isCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(boolean creditStatus) {
        this.creditStatus = creditStatus;
    }


    
}
