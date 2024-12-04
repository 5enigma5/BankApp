public class User {
    private String username;
    private String password;
    private static double checkingBalance;
    private static double savingBalance;


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


    public static double getCheckingBalance() {
        return checkingBalance;
    }

    public static double getSavingBalance() {
        return savingBalance;
    }


    public void setCheckingBalance(double balanceAmount) {
         if (balanceAmount >= 0) {
            checkingBalance = balanceAmount;
         }else throw new IllegalArgumentException("Balance cant be negative");


    }    public void setSavingBalance(double balanceAmount) {
         if (balanceAmount >= 0) {
            savingBalance = balanceAmount;
         }else throw new IllegalArgumentException("Balance cant be negative");

    }




    public User(String username, String password) {
        this.username = username;
        this.password = password;
        checkingBalance = getCheckingBalance();
        savingBalance = getSavingBalance();
    }
}
