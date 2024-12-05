import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        generateDefaultUser(users);
        WelcomePage welcomePage;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            welcomePage = new WelcomePage(users);
            users.add(welcomePage.activeUser.get());

            while (true) {
                System.out.println("\t\t\t\t\t    Select a choice\n\n\t Transfer     Withdrawal\tDeposit \t  Help\t\t Exit\n\t  : A :  \t\t: W :\t\t : D :\t\t : S :\t\t : F :\n");

                String answer = scanner.next().toUpperCase();
                boolean exit = false;

                switch (answer) {
                    case "A":
                        new CheckingToSavingTransfer(welcomePage.activeUser.get());
                        break;
                    case "W":
                        new Withdrawal(welcomePage.activeUser.get());
                        break;
                    case "D":
                        Deposit.deposit_Checking(welcomePage.activeUser.get());
                        break;
                    case "S":
                        Service service = new Service(welcomePage.activeUser.get());
                        break;
                    case "F":
                        System.out.println("Thank you for using our app.");
                        exit = true;
                        break;
                    default:
                        System.out.println("\t\tPlease try again\n\n\t(Enter a 'A','W','D','S' or 'F')\n");

                }

                if (exit) break;
            }
        }


    }

    private static void generateDefaultUser(List<User> users) {
        users.add(new User("Pepe", "Pepe"));
        users.add(new User("roberto", "manolo"));
    }
}