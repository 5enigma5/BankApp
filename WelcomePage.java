import java.util.Optional;
import java.util.Scanner;

public class WelcomePage {
    public Optional<User> activeUser;

    boolean hasAccount;
    static boolean accountMade = false;
    static double balance;
    boolean validAnswer = false;
    String userAnswer;
    Scanner input = new Scanner(System.in);


    public WelcomePage() {

        System.out.println("\t  Welcome to the Bank App!\n");
        System.out.println("  Do you have an account with us?\n");
        hasAccount = hasAccount();

        EnterPassword pwdManagement = new EnterPassword();

        if (hasAccount) {
            System.out.println("Please enter your account's username and password to continue");
            Optional<User> activeUser = pwdManagement.introLogIn();

            if (activeUser.isPresent()) {
                this.activeUser = activeUser;
            }
        } else {
            pwdManagement.accountCreation();
            accountMade = true;
        }
    }

    public boolean hasAccount() {

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
                        System.out.println("Thank you for using our app.");
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
