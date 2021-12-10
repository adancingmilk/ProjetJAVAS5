package questions;
import java.util.Arrays;

public class Question_QCM extends Question {
    private String[] choix;
    private String reponse;

    public Question_QCM(int d, String description, String type, int num, String[] choix, String bonneRep) {
        super(d, description, type, num);
        this.choix = choix;
        this.reponse = bonneRep;
    }

    public String[] getChoix() {
        return choix;
    }
    public void setChoix(String[] choix) {
        this.choix = choix;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }
    @Override
    public String getReponse() {
        return reponse;
    }

    @Override
    public String toString() {
        return super.toString() + "Voici les réponses proposés : " + Arrays.toString(choix);
    }
}
