import java.util.Scanner;

public class Withdrawal{
    private User activeUser;

    Scanner scnr = new Scanner(System.in);
    double balance;
    double amount;
    String input;
    String option;

    public Withdrawal(User activeUser){

        this.activeUser = activeUser;

        System.out.println("Would you like to withdrawal from your checking or savings?\n");
        System.out.println("\t\t\t" +
                "	Select a choice\n" +
                        " " +
        "    Checking      Saving	    Back\n"+
	    "     : A :         : W :	    : D :\n");
        
        input = scnr.next();
        
        if(input.equalsIgnoreCase("A") && Character.isLetter(input.charAt(0))){

            System.out.printf("Current Checking Balance: $%.2f\n",this.activeUser.getCheckingBalance());

            do {
                System.out.print("\nAmount: $");
                try {
                    amount = scnr.nextDouble();
                }catch (Exception InputMismatchException){
                    System.out.println("Something went wrong. Please try again.");
                    break;
                }
                boolean checkAmountRun = checkAmount(amount);
                amount = checkAmount(amount, scnr);
                showNewAmount(checkAmountRun, amount);
                displayChecking(this.activeUser.getCheckingBalance(), amount);
                balance = withdrawChecking(balance, amount);

                System.out.println("Exit|Withdraw");
                option = scnr.next();
            } while (option.equalsIgnoreCase("Withdraw"));
            
        } else if (input.equalsIgnoreCase("W") && Character.isLetter(input.charAt(0))) {

            System.out.printf("Current Saving Balance: $%.2f\n",this.activeUser.getSavingBalance());
            do {
                System.out.print("\nAmount: $");
                double amount = scnr.nextDouble();

                boolean checkAmountRun = checkAmount(amount);
                amount = checkAmount(amount, scnr);
                showNewAmount(checkAmountRun, amount);
                displaySaving(this.activeUser.getSavingBalance(), amount);
                balance = withdrawSaving(balance, amount);

                System.out.println("Exit|Withdraw");
                option = scnr.next();
            } while (option.equalsIgnoreCase("Withdraw"));
            
        } else if (input.equalsIgnoreCase("D") && Character.isLetter(input.charAt(0))) {

            System.out.println("this is back");

        }else{

            System.out.println("Invalid input");
        }



}

    public double withdrawChecking(double balance, double amount){

        double newBalance;

        if (balance<amount){
            newBalance=balance;
        } else {
            newBalance=balance-amount;
        }
        return newBalance;
    }
    public double withdrawSaving(double balance, double amount){

        double newBalance;

        if (balance<amount){
            newBalance=balance;
        } else {
            newBalance=balance-amount;
        }
        return newBalance;
    }

    public double checkAmount(double amount, Scanner scnr){

        while (amount<=0){

            System.out.print("Amount cannot be negative or zero, choose different amount: ");
            amount = scnr.nextDouble();

        }
        return amount;
    }


    public boolean checkAmount(double amount) {

        boolean checkAmountRun=false;
        if (amount<=0) checkAmountRun=true;
        return checkAmountRun;

    }

    public void showNewAmount(boolean checkAmountRun,double amount){
        if (checkAmountRun) System.out.printf("New amount: $%.2f\n",amount);
    }

    public void displayChecking(double balance, double amount){
        if (balance<amount){
            System.out.println("Insufficient balance to withdraw");
            System.out.println("Balance's unchanged: "+withdrawChecking(balance,amount));
        } else {
            System.out.printf("$%.2f is withdrew from checking account.\n",amount);
            System.out.printf("New balance: $%.2f\n",withdrawChecking(balance,amount));
            this.activeUser.setCheckingBalance(withdrawChecking(balance,amount));
        }
    }
    public void displaySaving(double balance, double amount){
        if (balance<amount){
            System.out.println("Insufficient balance to withdraw");
            System.out.println("Balance's unchanged: "+withdrawSaving(balance,amount));
        } else {
            System.out.printf("$%.2f is withdrew from savings account.\n",amount);
            System.out.printf("New balance: $%.2f\n",withdrawSaving(balance,amount));
            this.activeUser.setSavingBalance(withdrawSaving(balance,amount));
        }

    }


}
