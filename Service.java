import java.util.Scanner;
public class Service {

    private User activeUser;

    Scanner scnr = new Scanner(System.in);

    public Service(User activeUser) {

        this.activeUser = activeUser;

        System.out.println("Welcome " + activeUser.getUsername() + " I am Alfred and will be providing information based on our many services.");

        while (true) {
            System.out.println("Which service would you like to access today? \n: A : Withdraw \n: W : Deposit \n: D : Transfer");
            String userInput = scnr.nextLine();

        if (userInput.compareToIgnoreCase("withdraw") == 0 || userInput.compareToIgnoreCase("A")==0) {
            System.out.println("\nWithdraw will remove the funds from your bank accounts (Checking or Savings).");
            break;
        }
        if (userInput.compareToIgnoreCase("deposit") == 0 || userInput.compareToIgnoreCase("W")==0) {
            System.out.println("\nDeposit will add funds to your bank accounts (Checking or Savings).");
            break;
        }
        if (userInput.compareToIgnoreCase("transfer") == 0 || userInput.compareToIgnoreCase("D")==0) {
            System.out.println("\nTransfer will move funds from your Checking account right to your Savings account.");
            break;
        }else {
            System.out.println("I couldn't quite get that... Would you mind trying again?");
        }

        }

    }

    public void moreHelp(String userInput){

       /* System.out.println("Anything else you need help with?\n: A : Yes\n: W : No:\n");
        userInput = scnr.nextLine();
        if (userInput.compareToIgnoreCase("Yes") == 0 || userInput.compareToIgnoreCase("A")==0){

        }else{



        }*/


    }
}