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

        //3. INITIALISATION QUESTIONS POUR CHAQUE THÈME

        //4. DÉROULEMENT PHASE 1

            //4.1 SELECTION 1 THÈME

            //4.2 POSER AU MOINS 1 QUESTION FACILE PAR JOUEUR

            //4.3 SCORE JOUEUR +2 SI BONNE RÉPONSE

            //4.4 ÉLIMINATION DU JOUEUR AYANT LE PLUS FAIBLE SCORE À LA FIN DE LA PHASE 1

        //5. DÉROULEMENT PHASE 2

            //5.1 SÉLECTION 6 THÈMES

            //5.2 CHAQUE JOUEUR CHOISI THÈME DE SON CHOIX PARMI CEUX SÉLECTIONNÉS

            //5.3 POSER AU MOINS 2 QUESTIONS MOYENNES PAR JOUEUR

            //5.4 SCORE JOUEUR +3 SI BONNE RÉPONSE

            //5.4 ÉLIMINATION DES JOUEURS AYANT LE PLUS FAIBLE SCORE À LA FIN DE LA PHASE 2 POUR GARDER QUW 2 JOUEURS

        //6. DÉROULEMENT PHASE 3

            //6.1 SÉLECTION 3 THÈMES

            //6.2 POSER AU MOINS 2 QUESTIONS DIFFICILES PAR JOUEUR

            //6.3 SCORE JOUEUR +5 SI BONNE RÉPONSE

            //6.4 GAGNANT = CELUI AYANT LE MEILLEUR SCORE LORS DE LA PHASE 3
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
