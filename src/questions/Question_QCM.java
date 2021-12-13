package questions;
import themes.Theme;

import java.util.Arrays;
import java.util.Scanner;

public class Question_QCM extends Question {
    private String[] reponses;

    public Question_QCM(int d, String description, String nomTheme, int num, String[] reponses, String bonneRep) {
        super(d, description, nomTheme, num, bonneRep);
        this.reponses = reponses;
    }

    //Affiche les différentes réponses possibles de la question
    public void afficherPropositions() {
        String propositions = "";
        for(int i = 0; i < reponses.length; i++) {
            propositions += i+1 + ". (" + reponses[i] + ") ";
        }
        System.out.println(propositions);
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
