import java.util.Scanner;

public class EnterPassword {


    public boolean introLogIn(boolean attempt) {

        Scanner scanner = new Scanner(System.in);
        Password password = new Password();

        for(int i=0; i<=4; i++){

            System.out.println("\t\t Please enter your password: ");
            String word = scanner.nextLine();

            if (!password.Password(word)){
                System.out.println("Welcome!\n");
                System.out.println("\t\t How can we help you today? \n");
                break;
            }else if (i==4){
                System.out.println("Too many attempts! Please wait... ");
                attempt = false;
            }

        }
        return attempt;
    }

    public EnterPassword(){


        introLogIn(true);


    }

}