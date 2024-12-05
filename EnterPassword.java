import java.util.*;

public class EnterPassword {

    private List<User> users;


    public Optional<User> introLogIn() {

        Scanner scanner = new Scanner(System.in);
//       new Password();

        for (int i = 0; i <= 4; i++) {

            System.out.println("\t\t Please enter your username: ");
            String username = scanner.nextLine();

            System.out.println("\t\t Please enter your password: ");
            String passwd = scanner.nextLine();

            User newUser = new User(username, passwd);

            Optional<User> findUser = users.stream()
                    .filter(user -> user.getUsername().equals(newUser.getUsername()) && user.getPassword().equals(newUser.getPassword()))
                    .findAny();

            if (findUser.isPresent()) {
                System.out.println("Welcome!\n");
                System.out.println("\t\t   How can we help you today? \n");
                return findUser;
            } else if (i == 4) {
                System.out.println("Too many attempts... Sorry, Shutting down for security");
                System.exit(0);
            } else {
                System.out.println("Wrong username/password combination, please try again... ");
            }

        }
        return Optional.empty();
    }

    public Optional<User> accountCreation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\t\t\tLet's create your account first...\n\n\t   Please register your information below:\n");
        System.out.println("\t\t Please enter your username: ");
        String username = scanner.nextLine();

        System.out.println("\t\t Please enter your password: ");
        String passwd = scanner.nextLine();

        User newUser = new User(username, passwd);
        this.users.add(newUser);
        newUser.setCheckingBalance(500);

        System.out.println("\t\t\t User created!\n Welcome!\n");
        System.out.println("\t\tHere are $500 for starting a Checking account with us.\n" +
                "\t\t\tYou also now have a Savings account ready to use!\n");
        return Optional.of(newUser);
    }

    public EnterPassword(List<User> users) {
        this.users = users;

        //        generateDefaultUser();

//        introLogIn(true);


    }

}