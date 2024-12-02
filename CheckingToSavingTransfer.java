import java.util.Scanner;
public class CheckingToSavingTransfer {

    double checkingBalance;
    double savingBalance;

    public CheckingToSavingTransfer(double checkingBalance, double savingBalance){
        this.checkingBalance = checkingBalance;
        this.savingBalance = savingBalance;

        Scanner scanner = new Scanner(System.in);
        String approval = "N";
        double amount = 0;

        while (approval.equalsIgnoreCase("N")) {

            do {
                System.out.println("Enter an amount to transfer:");
                try {
                    amount = scanner.nextDouble();
                }catch (Exception InputMismatchException) {
                    System.out.println("Please try again.\tEnter a valid number. ");
                    new CheckingToSavingTransfer(checkingBalance, savingBalance);
                }

            }while(Double.isNaN(amount) || Double.isInfinite(amount));
                System.out.println("Are you sure you want to transfer " + amount + " to your savings account? (Y/N)");
                approval = scanner.next();

        }
        transfer(amount);
        scanner.close();
    }




        public void transfer ( double amount){
        if (amount > checkingBalance) {
            System.out.println("You do not have enough funds to process this transfer.");
        } else {
            checkingBalance -= amount;
            savingBalance += amount;
            System.out.println("Successful transfer.");
            System.out.println("New checking balance is: " + checkingBalance);
            System.out.println("New saving balance is: " + savingBalance);
        }
    }


}
