import java.util.ArrayList;
import java.util.Scanner;

public class ChoiceSelect {

    private User activeUser;

    byte counter = 0;
    ArrayList<String> userAnswer = new ArrayList<>();
    boolean validInput;

                                  /*  Boolean to check valid Input
                                    inside switch to loop back default  */


    public boolean choiceSelect() {

        Scanner sc = new Scanner(System.in);
        validInput = false;

        while (!validInput) {

            caseSelect();
            userAnswer.add(sc.next().toUpperCase());// explodes here

            if ((userAnswer.get(counter).length() == 1) && Character.isLetter(userAnswer.get(counter).charAt(0))) {

                caseChoice();
                counter++;

            } else {

                System.out.println("\t\tPlease try again\n\n\t Enter a 'A','W','D' or 'F'\n");
                userAnswer.removeLast();
            }
        }
        return true;

    }// Ends choiceSelect method


    //Constructor for practice :)
    public ChoiceSelect(User activeUser) {
        this.activeUser = activeUser;

        for (int i = 0; i < 4; i++) {

            if (choiceSelect() && i < 3) {
                System.out.println("\n\t\t\tCan we help you with anything else today?\n\t\t\t\t\t  Please choose again.\n");

            } else {
                System.out.println("\t\tFor security reasons you cannot continue\n");

            }
        }
    }


    public void caseChoice() {


        switch (userAnswer.get(counter).charAt(0)) {
            case 'A':
                validInput = true;
                new CheckingToSavingTransfer(this.activeUser);
                break;
            case 'W':
                new Withdrawal(this.activeUser);
                validInput = true;
                break;
            case 'D':
                Deposit.deposit_Checking(this.activeUser);
                validInput = true;
                break;
            case 'S':
                Service service = new Service(this.activeUser);
                validInput = true;
                break;
            case 'F':
                System.out.println("Thank you for using our app.");
                System.exit(1);
                break;


            default:
                System.out.println("\t\tPlease try again\n\n\t(Enter a 'A','W','D','S' or 'F')\n");

        }

    }


    public void caseSelect() {

        System.out.println("\t\t\t\t\t    Select a choice\n\n\t Transfer     Withdrawal\tDeposit \t  Help\t\t Exit\n\t  : A :  \t\t: W :\t\t : D :\t\t : S :\t\t : F :\n");


        //this works :)
    }
} //End of class










