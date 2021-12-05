import questions.Question;
import questions.Question_RC;
import questions.Questions;

import java.util.ArrayList;

public class Jeu {
    public static void main(String[] args) {
        Question Q1 = new Question_RC(1,"1+1=2","Math",1, "Vrai");
        Questions listQ = new Questions();
        listQ.addQuestion(Q1);
        System.out.println(listQ.selectQuestion(1));

        //1. INITIALISATION THEMES
        ArrayList<String> listThemes = new ArrayList<String>();
        genererThemes(listThemes);

        Themes themes = new Themes(listThemes); //Place la liste des thèmes dans une instance de Thèmes

        //2. INITIALISATION JOUEURS
        Joueur[] tabJoueurs = new Joueur[4]; //Tableau de 4 joueurs
        Joueurs joueurs = new Joueurs(tabJoueurs);
        joueurs.genererJoueurs(4); //Génère 4 joueurs


    }

    //Ajoute les thèmes à l'ArrayList listThemes
    public static void genererThemes(ArrayList<String> listThemes) {
        listThemes.add("Mathématiques");
        listThemes.add("Histoire");
        listThemes.add("Géographie");
        listThemes.add("Jeux-Vidéo");
        listThemes.add("Animaux");
        listThemes.add("Sport");
        listThemes.add("La langue française");
        listThemes.add("Culture Japonaise");
        listThemes.add("Nourriture");
        listThemes.add("Informatique");
    }
}
