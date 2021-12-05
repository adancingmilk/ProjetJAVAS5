package questions;
import java.util.Scanner;

public class Question_QCM extends Question {

    private int reponse;

    public Question_QCM(int d, String description, String type, int num, int rep) {
        super(d, description, type, num);
        this.reponse = rep;
    }

    public void repondre(){
        boolean valid = false;
        while(!valid) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Saisir la bonne réponse à la question");
            int rep = scanner.nextInt();
            if ((rep <= 0) || (rep > 3)) {
                System.out.println("La réponse n'est pas valide");
            } else {
                valid = true;
                this.reponse = rep;
            }
        }
    }
    public void setReponse(int rep){
        this.reponse = rep;
    }
    public int getReponse(){
        return this.reponse;
    }
    @Override
    public String toString(){
        return super.toString() + "\n La bonne réponse de la question : " + this.reponse;
    }
}
