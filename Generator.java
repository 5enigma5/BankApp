import java.util.Random;

public class Generator {


    Random random = new Random();
    boolean randomBool;
    int count = 0;



    public void setRandomNumber(){
        this.randomBool = random.nextBoolean() ;

        if (randomBool){
            //System.out.println(" True! :) ");
        }else{
            //System.out.println(" False :( ");
        }
    count++;
    }

}
