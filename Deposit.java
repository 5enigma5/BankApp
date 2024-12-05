import java.util.Scanner;

public class Deposit {


    public static void deposit_Checking(User activeUser) {

        Scanner scan = new Scanner(System.in);
        double total = 0;
        double amount;
        String approval;
        System.out.println("How much do you want to deposit? (e.g., 100.00)");
        amount = scan.nextDouble();
        while (!checkIfDecimal(amount)) {
            amount = scan.nextDouble();

        }

        System.out.printf("Confirm to deposit $%.2f into your Checking Account (Y/N).", amount);
        approval = scan.next();

        if (checkIfApproved(approval)) {
            total = activeUser.getCheckingBalance() + amount;
            System.out.printf("You have successfully deposited $%.2f into your Checking Account\n", amount);
            System.out.printf("Your new balance is $%.2f.%n", total);
            activeUser.setCheckingBalance(total);

        } else {
            System.out.println("Transaction Cancelled");
            System.out.println("Returning Back to Main Menu");
        }
    }

    public static double deposit_Saving(double amount, double balance) {
        double total = amount + balance;
        System.out.printf("You have successfully deposited $" + "%.2f", amount + "into your Savings Account");
        return total;
    }

    public static void checkBalance(double C_balance, double S_balance) {
        System.out.println("||||Your current balance||||");
        System.out.printf("Checking: " + "%.2f", C_balance);
        System.out.println("");
        System.out.printf("Savings: " + "%.2f", S_balance);
    }

    public static boolean confirm() {
        return true;
    }

    public static boolean checkIfDecimal(double amount) {
        String input = "" + amount;

        int start = input.indexOf('.');
        if (input.length() - start - 1 == 2 || input.length() - start - 1 == 1) {
            return true;
        } else {
            System.out.println("ERROR: Please enter an amount with exactly two decimal places.");
            return false;
        }
    }

    public static boolean checkIfApproved(String input) {
        Scanner scan = new Scanner(System.in);
        boolean repeat = true;
        boolean isApproved = false;
        while (repeat) {
            if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")) {
                isApproved = true;
                repeat = false;
            } else if (input.equalsIgnoreCase("n") || input.equalsIgnoreCase("No")) {
                isApproved = false;
                repeat = false;
            } else {
                System.out.println("ERROR: invalid approval. PLease re-enter(Y/N)");
                input = scan.next();
                repeat = true;
            }
        }
        return isApproved;

    }
}
