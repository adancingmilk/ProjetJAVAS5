package questions;
import java.util.Arrays;
import java.util.Scanner;

public class Question_QCM extends Question {
    private String[] reponses;

    public Question_QCM(int d, String description, String type, int num, String[] reponses, String bonneRep) {
        super(d, description, type, num, bonneRep);
        this.reponses = reponses;
    }
    @Override
    public String[] getReponses() {
        return reponses;
    }
    @Override
    public void setReponses(String[] reponses) {
        this.reponses = reponses;
    }

    @Override
    public String toString() {
        return super.toString() + "Voici les réponses proposés : " + Arrays.toString(reponses);
    }
}
