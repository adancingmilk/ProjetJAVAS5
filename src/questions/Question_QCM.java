package questions;
import themes.Theme;

import java.util.Arrays;
public class Question_QCM extends Question {

    private final String[] choix;
    private String reponse;

    public Question_QCM(int d, String description, String nomTheme, int num, String[] choix,String rep) {
        super(d, description, nomTheme, num);
        this.choix = choix;
        this.reponse = rep;
    }

    //Affiche les différentes réponses possibles de la question
    public void afficherPropositions() {
        String propositions = "";
        for(int i = 0; i < choix.length; i++) {
            propositions += i+1 + ". (" + choix[i] + ") ";
        }
        System.out.println(propositions);
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
        return super.toString() + "Voici les réponses proposés : " + Arrays.toString(choix) + "\n La réponse à la question est : " + this.reponse;
    }
}
