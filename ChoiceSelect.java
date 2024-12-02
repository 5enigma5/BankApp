
import java.util.Arrays;
import java.util.Scanner;

public class ChoiceSelect {

    Generator generator = new Generator();
    Scanner sc = new Scanner(System.in);
    String[] userAnswer = new String[3];

    //byte counter = 0;

    boolean validInput;        /*  Boolean to check valid Input
                                    inside switch to loop back default  */


    public boolean choiceSelect() {


         // System.out.println("\t\tSelect a choice\n\t  : A :  : W :\t: D :\n");

        validInput = false;


        while (!validInput) {

        caseSelect();

             userAnswer[generator.count] = sc.next().toUpperCase();

            if ((userAnswer[generator.count].length() == 1) && Character.isLetter(userAnswer[generator.count].charAt(0))) {

                caseChoice();

            } else {

                System.out.println("\t\tPlease try again\n\n\t Enter a 'A','W' or 'D'\n");

            }

        }
        return true;

    }// Ends choiceSelect method


//Constructor for practice :)
    public ChoiceSelect() {


        for (int i = generator.count; i < 3; i++) {

            if (choiceSelect() && i < 2) {
                generator.setRandomNumber();
                System.out.println("\t  Can we help you with anything else today?\n\t  Please choose again\n");
            }else{
                generator.setRandomNumber();
                System.out.println("\t\tFor security reasons you cannot continue\n");

            }
        }

        //System.out.println(Arrays.toString(userAnswer));
    }



    public void caseChoice() {


            switch (userAnswer[generator.count].charAt(0)) {
                case 'A':
                validInput = true;
                CheckingToSavingTransfer checkingToSavingTransfer = new CheckingToSavingTransfer(5000,500);
                break;
                    case 'W':
                        Withdrawal withdrawal = new Withdrawal();
                        validInput = true;
                        break;
                            case 'D':
                                validInput = true;
                                break;
                case 'F':
                    System.out.println("Thank you for using our app");
                    System.exit(1);
                    break;


                default:
                System.out.println("\t\tPlease try again\n\n\t(Enter a 'A','W' or 'D')\n");

        }

    }


    public void caseSelect() {


        switch (userAnswer.toString()){
            case "A":
                if (userAnswer[1]== null) {
                    System.out.println("\t\tSelect a choice\n\t\t  : W :\t: D :\n");
                }else if ("W".equals(userAnswer[1])) {
                    System.out.println("\t\tSelect a choice\n\t\t\t: D :\n");
                }else {
                    System.out.println("\t\tSelect a choice\n\t\t\t: W :\n");
                }
                break;
                case "W":
                    if (userAnswer[1] == null) {
                        System.out.println("\t\tSelect a choice\n\t\t  : A :\t: D :\n");
                    }else if ("A".equals(userAnswer[1])) {
                        System.out.println("\t\tSelect a choice\n\t\t\t: D :\n");
                    }else {
                        System.out.println("\t\tSelect a choice\n\t\t\t: A :\n");
                    }
                    break;
                    case "D":
                        if (userAnswer[1] == null) {
                            System.out.println("\t\tSelect a choice\n\t\t  : A :\t: W :\n");
                        }else if ("A".equals(userAnswer[1])) {
                            System.out.println("\t\tSelect a choice\n\t\t\t: W :\n");
                        }else {
                            System.out.println("\t\tSelect a choice\n\t\t\t: A :\n");
                        }
                        break;
            default:
                //System.out.println("\t\tSelect a choice\n\t  : A :  : W :\t: D :\n");                   // THIS IS THE START MESSAGE
                System.out.println("\t\t\t Select a choice\n\t Transfer     Withdrawal\t Exit\n\t  : A :  \t\t: W :\t\t : D :\n");
        }








    //this works :)
           /* if ("A".equals(userAnswer[0])) {
                if (userAnswer[1]== null) {
                    System.out.println("\t\tSelect a choice\n\t\t  : W :\t: D :\n");
                }else if ("W".equals(userAnswer[1])) {
                    System.out.println("\t\tSelect a choice\n\t\t\t: D :\n");
                }else {
                    System.out.println("\t\tSelect a choice\n\t\t\t: W :\n");
                }
            } else if ("W".equals(userAnswer[0])) {
                if (userAnswer[1] == null) {
                    System.out.println("\t\tSelect a choice\n\t\t  : A :\t: D :\n");
                }else if ("A".equals(userAnswer[1])) {
                    System.out.println("\t\tSelect a choice\n\t\t\t: D :\n");
                }else {
                    System.out.println("\t\tSelect a choice\n\t\t\t: A :\n");
                }
            } else if ("D".equals(userAnswer[0])) {
                if (userAnswer[1] == null) {
                    System.out.println("\t\tSelect a choice\n\t\t  : A :\t: W :\n");
                }else if ("A".equals(userAnswer[1])) {
                    System.out.println("\t\tSelect a choice\n\t\t\t: W :\n");
                }else {
                    System.out.println("\t\tSelect a choice\n\t\t\t: A :\n");
                }
            } else {
                System.out.println("\t\tSelect a choice\n\t  : A :  : W :\t: D :\n");
            }*/

    }
} //End of class










