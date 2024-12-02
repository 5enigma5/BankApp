import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WelcomePage {


    boolean hasAccount;
   //List<String> userAnswer;
    String userAnswer;
    boolean validAnswer = false;
    Scanner input = new Scanner(System.in);


    public WelcomePage() {

        System.out.println("\t  Welcome to the Bank App!\n");
        System.out.println("  Do you have an account with us?\n");
        hasAccount = hasAccount();

        EnterPassword pwdManagement = new EnterPassword();

        if (hasAccount) {
            System.out.println("Please enter your account's password to continue");
            pwdManagement.introLogIn(true);
        }else{
            pwdManagement.accountCreation();
        }

    }

    public boolean hasAccount(){

    while (!validAnswer) {

        System.out.println("\t\tSelect a choice\n\t   Yes     No\t Exit\n\t  : A :  : W :\t: D :\n");
        userAnswer = input.nextLine().toUpperCase();

        if (((userAnswer.length() == 1) && Character.isLetter(userAnswer.charAt(0)))) {

            switch (userAnswer) {
                case "A":
                    hasAccount = true;
                    validAnswer = true;
                    break;
                case "W":
                    hasAccount = false;
                    validAnswer = true;
                    break;
                case "D":
                    System.out.println("Thank you for using our app");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\t\tPlease try again\n\n\t Enter a 'A','W' or 'D'\n");
            }

        } else {

            System.out.println("\t\tPlease try again\n\n\t Enter a 'A','W' or 'D'\n");

            }

        }

            return hasAccount;
    }



}
