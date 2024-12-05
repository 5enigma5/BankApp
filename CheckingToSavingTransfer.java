import java.util.InputMismatchException;
import java.util.Scanner;
public class CheckingToSavingTransfer {

    private User activeUser;


    public CheckingToSavingTransfer(User activeUser){
        this.activeUser = activeUser;

        Scanner scanner = new Scanner(System.in);
        String approval = "N";
        double amount = 0;

        while(approval.equalsIgnoreCase("N")) {

            while (true) {
                try {
                    System.out.print("Enter an amount to transfer: $");
                    amount = scanner.nextDouble();

                    if (amount <= 0) {
                        System.out.println("Please enter a positive amount.");
                        continue;
                    }

                    break;
                } catch (InputMismatchException e) {
                    scanner.nextLine();
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }

            System.out.printf("Are you sure you want to transfer $%.2f to your savings account? (Y/N)\n", amount);
            approval = scanner.next();

        }
        transfer(amount);
    }




        public void transfer (double amount ){
        if (amount > this.activeUser.getCheckingBalance()) {
            System.out.println("You do not have enough funds to process this transfer.");
        } else {
            this.activeUser.setCheckingBalance(this.activeUser.getCheckingBalance() - amount);
            this.activeUser.setSavingBalance(this.activeUser.getSavingBalance() + amount);
            System.out.println("Successful transfer!");
            System.out.printf("New checking balance is: $%.2f\n",this.activeUser.getCheckingBalance());
            System.out.printf("New saving balance is: $%.2f\n",this.activeUser.getSavingBalance());
        }

    }


}
