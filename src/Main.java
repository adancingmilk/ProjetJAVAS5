import jeu.Jeu;
import joueurs.Joueur;
import joueurs.Joueurs;
import questions.Questions;
import themes.Themes;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenue dans le jeu des Questions-Réponses !");
        //1. INITIALISATION THEMES
        Themes themesJeu = new Themes(); //Place une liste de thèmes dans une instance de Thèmes
        themesJeu.genererThemes(); //Génère les 10 thèmes

        //2. INITIALISATION JOUEURS
        Joueur[] tabJoueurs = new Joueur[4]; //Tableau de 4 joueurs
        Joueurs joueurs = new Joueurs(tabJoueurs);
        joueurs.genererJoueurs(4); //Génère 4 joueurs

        //3. INITIALISATION QUESTIONS POUR CHAQUE THÈME
        Questions questionsJeu = new Questions();
        questionsJeu.genererQuestions(); //Génère les questions de TOUS les thèmes

        //4. DÉROULEMENT PHASE 1
        Jeu jeu = new Jeu(4, questionsJeu, themesJeu, joueurs);
        jeu.Phase1();

        jeu.selectJoueurNextPhase(); //Sélection des joueurs pour la phase suivante

        //5. DÉROULEMENT PHASE 2
        jeu.Phase2();

        //5.1 SÉLECTION 6 THÈMES

        //5.2 CHAQUE JOUEUR CHOISI THÈME DE SON CHOIX PARMI CEUX SÉLECTIONNÉS

        //5.3 POSER AU MOINS 2 QUESTIONS MOYENNES PAR JOUEUR

        //5.4 SCORE JOUEUR +3 SI BONNE RÉPONSE

        //5.4 ÉLIMINATION DES JOUEURS AYANT LE PLUS FAIBLE SCORE À LA FIN DE LA PHASE 2 POUR GARDER QUW 2 JOUEURS

        //6. DÉROULEMENT PHASE 3
        jeu.Phase3();
        //6.1 SÉLECTION 3 THÈMES

        //6.2 POSER AU MOINS 2 QUESTIONS DIFFICILES PAR JOUEUR

        //6.3 SCORE JOUEUR +5 SI BONNE RÉPONSE

        //6.4 GAGNANT = CELUI AYANT LE MEILLEUR SCORE LORS DE LA PHASE 3
    }
}
