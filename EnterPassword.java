import java.util.*;

public class EnterPassword {
    private List<User> users = new ArrayList<>();

    public boolean introLogIn(boolean attempt) {

        Scanner scanner = new Scanner(System.in);
//        new Password();

        for(int i=0; i<=4; i++){

            System.out.println("\t\t Please enter your username: ");
            String username = scanner.nextLine();

            System.out.println("\t\t Please enter your password: ");
            String passwd = scanner.nextLine();

            User newUser = new User(username, passwd);

            Optional<User> findUser = users.stream()
                    .filter(user -> user.getUsername().equals(newUser.getUsername()) && user.getPassword().equals(newUser.getPassword()))
                    .findAny();


            if (findUser.isPresent()){
                System.out.println("Welcome!\n");
                System.out.println("\t\t How can we help you today? \n");
                break;
            }else if (i==4){
                System.out.println("Too many attempts! Please wait... ");

                attempt = false;
            } else {
                System.out.println("Wrong username/password combination, please try again... ");
            }

        }
        return attempt;
    }

    private void generateDefaultUser() {
        this.users.add(new User("pepe@gmail.com", "Pepe"));
    }

    public void accountCreation(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\tLet's create your account first then...\n\nPlease enter below information you would like to create:\n");
        System.out.println("\t\t Please enter your username: ");
        String username = scanner.nextLine();

        System.out.println("\t\t Please enter your password: ");
        String passwd = scanner.nextLine();

        this.users.add(new User(username, passwd));

        System.out.println("\t\t\t User created!");
    }

    public EnterPassword(){
        generateDefaultUser();

//        introLogIn(true);


    }

}