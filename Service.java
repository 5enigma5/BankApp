import java.util.Scanner;
public class Service {

    Scanner scnr = new Scanner(System.in);

    public Service() {

        System.out.println("What is your username?");
        String username = scnr.nextLine();
        System.out.println("Welcome " + username + " I am Alfred and will be providing information based on our many services. Which service would you like to access today? \n- Withdraw \n- Deposit \n- Transfer");
        String userInput = scnr.nextLine().toLowerCase();

        if (userInput.contains("withdraw")) {
            System.out.println("\nWithdraw will remove funds from your bank account.");
        }
        if (userInput.contains("deposit")) {
            System.out.println("\nDeposit will add funds to your bank account.");
        }
        if (userInput.contains("transfer")) {
            System.out.println("\nTransfer will move funds from checking to savings or vice versa.");
        }
    }
}