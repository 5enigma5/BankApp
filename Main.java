public class Main {


    public static void main(String[] args) {


        WelcomePage welcomePage = new WelcomePage();
        new ChoiceSelect(welcomePage.activeUser.get());


    }
}