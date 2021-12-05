package questions;
import java.util.Scanner;

public class Question_VF extends Question {

    private String reponse;
    protected Question_VF(int d, String description, String type, int num, String rep) {
        super(d, description, type, num);
        this.reponse= rep;
    }
    public void repondre(){
        boolean valid = false;
        while(!valid) {
            System.out.println("Saisir la réponse à la question :");
            Scanner scanner = new Scanner(System.in);
            String response = scanner.nextLine();
            if ((response.equals("vrai")) || (response.equals("faux"))) {
                valid = true;
                this.reponse = response;
            } else {
                System.out.println("La réponse n'est pas valable, choisissez vrai ou faux :");
            }
        }
    }

    public void setReponse(String rep){
        this.reponse = rep;
    }
    public String getReponse(){
        return this.reponse;
    }
    @Override
    public String toString(){
        return super.toString() + "\n La bonne réponse de la question : " + this.reponse;
    }
}
