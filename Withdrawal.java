import java.util.Scanner;

public class Withdrawal{

    Scanner scnr = new Scanner(System.in);
    Withdrawal object;

public Withdrawal(){


    System.out.print("Balance: ");
    double balance=scnr.nextDouble();
    String option;
    do{ System.out.print("Amount: ");
        double amount= scnr.nextDouble();
        boolean checkAmountRun =object.checkAmount(amount);
        amount = object.checkAmount(amount,scnr);
        object.showNewAmount(checkAmountRun,amount);
        object.display(balance,amount);
        balance = object.withdraw(balance,amount);
        System.out.println("Exit|Withdraw");
        option=scnr.next();
    } while(option.equalsIgnoreCase("Withdraw"));


}

    public double withdraw(double balance, double amount){

        double newBalance=0;

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
        if (checkAmountRun) System.out.println("New amount: "+amount);
    }

    public void display(double balance, double amount){
        if (balance<amount){
            System.out.println("Insufficient balance to withdraw");
            System.out.println("Balance's unchanged: "+withdraw(balance,amount));
        } else {
            System.out.println(amount+"$ is withdrew from account.");
            System.out.println("New balance: "+withdraw(balance,amount)); }
    }


}
