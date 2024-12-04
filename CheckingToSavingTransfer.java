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
                System.out.print("Enter an amount to transfer: $");
                try {
                    amount = scanner.nextDouble();
                }catch (Exception InputMismatchException) {
                    System.out.println("Something went wrong. Please try again");
                }
            }while(Double.isNaN(amount) || Double.isInfinite(amount));
                System.out.printf("Are you sure you want to transfer $%.2f to your savings account? (Y/N)\n", amount);
                approval = scanner.next();

        }
        transfer(amount);
    }




        public void transfer (double amount ){
        if (amount > User.getCheckingBalance()) {
            System.out.println("You do not have enough funds to process this transfer.");
        } else {
            checkingBalance = User.getCheckingBalance() - amount;
            savingBalance =User.getSavingBalance() + amount;
            System.out.println("Successful transfer!");
            System.out.printf("New checking balance is: $%.2f\n",checkingBalance);
            System.out.printf("New saving balance is: $%.2f\n",savingBalance);
            User newUser = new User("","");
            newUser.setCheckingBalance(checkingBalance);
            newUser.setSavingBalance(savingBalance);
        }

    }


}
