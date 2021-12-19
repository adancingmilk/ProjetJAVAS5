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
        Jeu jeu = new Jeu(4, questionsJeu, themesJeu, joueurs, false); //Debug désactivé pour jouer le jeu de manière manuelle
        jeu.Phase1();

        jeu.selectJoueurNextPhase(); //Sélection des joueurs pour la phase suivante

        //5. DÉROULEMENT PHASE 2
        jeu.Phase2();

        //6. DÉROULEMENT PHASE 3
        jeu.Phase3();
    }
}
