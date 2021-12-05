package questions;

import java.util.Objects;
import java.util.Scanner;

public class Question_RC extends Question {
    private String reponse;

    public Question_RC(int d, String description, String type, int num, String rep) {
        super(d, description, type, num);
        this.reponse = rep;
    }

    public Question_RC(){
        super();
        this.reponse = "";
    }

    public String repondre(){
        String rep = "";
        while (Objects.equals(rep, "")){
            System.out.println("Veuillez saisir votre réponse à la question");
            try (Scanner sc = new Scanner(System.in)){
                rep = sc.next();
            }
        }
        return rep;
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
