public class User {
    private String username;
    private String password;
    private double checkingBalance;
    private double savingBalance;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    // Balance Getter and Setter


    public void setCheckingBalance(double balanceAmount) {
        if (balanceAmount >= 0) {
            checkingBalance = balanceAmount;
        } else throw new IllegalArgumentException("Balance can't be negative");
    }

    public void setSavingBalance(double balanceAmount) {
        if (balanceAmount >= 0) {
            savingBalance = balanceAmount;
        } else throw new IllegalArgumentException("Balance can't be negative");
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.checkingBalance = 500;
        this.savingBalance = 0;
    }
}
