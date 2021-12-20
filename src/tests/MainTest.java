package tests;

import jeu.Jeu;
import joueurs.Joueur;
import joueurs.Joueurs;
import questions.Questions;
import themes.Themes;

//Classe permettant de jouer le jeu de manière automatique
public class MainTest {
    public static void main(String[] args) {
        System.out.println("[VERSION AUTO] Bienvenue dans le jeu des Questions-Réponses !");
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
        Jeu jeu = new Jeu(4, questionsJeu, themesJeu, joueurs, true); //Debug activé pour dire qu'on joue le jeu de manière automatique
        jeu.phase1();

        jeu.selectJoueurNextPhase(); //Sélection des joueurs pour la phase suivante

        //5. DÉROULEMENT PHASE 2
        jeu.phase2();

        //6. DÉROULEMENT PHASE 3
        jeu.phase3();
    }
}
