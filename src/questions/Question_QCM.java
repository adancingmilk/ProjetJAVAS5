package questions;
import java.util.Scanner;

public class Question_QCM extends Question {

    private String[] reponses = new String[3];
    private int bonneRep;

    public Question_QCM(int d, String description, String type, int num, String[] reponses, int bonneRep) {
        super(d, description, type, num);
        this.reponses = reponses;
        this.bonneRep = bonneRep;
    }

    public void repondre(){
        boolean valid = false;
        while(!valid) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Saisir la bonne réponse à la question (1, 2, ou 3) :");
            int rep = scanner.nextInt();
            if ((rep <= 0) || (rep > 3)) {
                System.out.println("La réponse n'est pas valide");
            } else {
                valid = true;
                this.bonneRep = rep;
            }
        }
    }
    public void setReponses(String[] reponses){
        this.reponses = reponses;
    }
    public String[] getReponses(){
        return this.reponses;
    }

    @Override
    public String toString(){
        String bonneReponse = "";
        for(int i = 0; i < reponses.length; i++) {
            if(bonneRep == i) {
                bonneReponse = reponses[i];
            }

        }
        return super.toString() + "\n La bonne réponse de la question : " + bonneReponse;
    }
}
