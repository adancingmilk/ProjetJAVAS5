package jeu;

import joueurs.Joueur;
import joueurs.Joueurs;
import questions.*;
import themes.Theme;
import themes.Themes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Jeu implements Phase {
    private int nbJ;
    private Questions questions;
    private Themes themes;
    private Joueurs joueurs;
    private List<Joueur> participants;
    private List<Integer> indiceThemesJouer;

    public Jeu(){
    }

    public Jeu(int nbJ, Questions questions, Themes themes, Joueurs joueurs){
        this.participants = new ArrayList<>();
        this.questions = questions;
        this.themes = themes;
        this.joueurs = joueurs;
        this.indiceThemesJouer = new ArrayList<>();
        this.nbJ = nbJ;
    }

    @Override
    public void Phase1() {
        Joueur player = new Joueur();
        for (int i = 0; i < nbJ ; i++){ //On pioche un nombre de joueur en fonction du nombre de participants autorisé dans le jeu
            player = joueurs.selectJoueur();
            boolean doublon = false;
            for (Joueur J : participants){
                if(player.getNumero() == J.getNumero()){
                    doublon = true;
                    i--;
                }
            }
            if(!doublon){
                participants.add(player);
            }
        }
        int indiceTheme = this.themes.selectRandomTheme(); //On pioche un thème au hasard du jeu
        indiceThemesJouer.add(indiceTheme); //Le thème joué lors de la phase 1 on le note

        List<Question> questionsP1 = questions.getQuestions(); //On récupère la liste des questions du thème de l'indice selectionné
        List<Theme> themesP1 = themes.getThemes();

        List<Question> questionsDuTheme = new ArrayList<>();

        for(int i = 0; i < questionsP1.size() ; i++){ //On récupère toutes les questions qui ont comme thème selectionné et on le stock dans listQduTheme
            if (questionsP1.get(i).getTheme().equals(themesP1.get(indiceTheme))) {
                questionsDuTheme.add(questions.getQuestions().get(i));
            }
        }
        String repJoueur = "";
        for (Question question : questionsDuTheme) {
            for (Joueur participant : participants) {
                System.out.println("Joueur : " + participant.getNom() + "\nVeuillez répondre à la question suivante : ");
                System.out.println(question.getDescription());
                if (question instanceof Question_QCM){
                    String propositions = "";
                    int i = 1;
                    for(String s : question.getReponses()){
                        propositions +=  i++ + ". (" + s.toString() + ") ";
                    };
                    System.out.println(propositions);
                }
                else if (question instanceof Question_VF){
                    System.out.println("Vrai(V) ou Faux(F) ?");
                }
                repJoueur = participant.saisie(question);
                if (Objects.equals(repJoueur.toUpperCase(), question.getReponse().toUpperCase())) {
                    System.out.println("Bonne réponse ! \n");
                    int score = participant.getScore();
                    participant.setScore(score + 2);
                } else {
                    System.out.println("Mauvaise réponse \n");
                }
            }
        }
        Joueur joueurElimine = new Joueur();
        for (Joueur participant : participants) {
            if (joueurElimine.getScore() > participant.getScore()) {
                joueurElimine = participant;
            }
        }

        joueurElimine.setEtatActuel("E");
        System.out.println(participants);
        System.out.println("Passons à la phase 2, voici le joueur éliminé : " + joueurElimine.toString());
        System.out.println("Thème utilisé lors de la phase 1 : " + this.themes.getThemes().get(indiceTheme).getNom() + "\n");
        themes.remove(themesP1.get(indiceTheme)); //On supprime le thème de cette manche des thèmes du jeu
    }

    @Override
    public void Phase2() {
        List<Theme> themesP2 = themes.selectMultipleThemeRandomly(6); //Sélectionne 6 thèmes aléatoirement

        System.out.println("Thèmes sélectionnés pour cette phase :");
        for(Theme theme : themesP2)
            System.out.println(theme);

        //SÉLECTION DES 2 THÈMES DE CHAQUE JOUEUR À TOUR DE RÔLE
        for(Joueur participant : participants) {
            participant.selectionThemeP2(themesP2); //Chaque joueur sélectionne 2 thèmes sur lesquels il veut être interrogé
        }

        /*int nbThemes = 6;
        ArrayList<String> listeThemeP2;
        ArrayList<Question> questionsP2 = new ArrayList<>();
        for (int i = 0; i < nbThemes; i++) {
            int indiceTheme = this.themes.selectRandomTheme(); //On pioche un thème au hasard du jeu
            while (indiceThemesJouer.indexOf(indiceTheme) != -1) {
                indiceTheme = this.themes.selectRandomTheme();
            }
            indiceThemesJouer.add(indiceTheme); //Le thème jouer, on le note
            List<Question> listeQuestions = questions.getQuestions(); //On récupère la liste des questions du thème de l'indice selectionné
            List<String> listeTheme = themes.getThemes();

            for (int n = 0; i < listeQuestions.size(); i++) { //On récupère toutes les questions qui ont comme thème selectionné et on le stock dans listQduTheme
                if (Objects.equals(listeQuestions.get(i).getNom(), listeTheme.get(indiceTheme))) {
                    questionsP2.add(questions.getQuestions().get(i));
                }
            }
        } */
    }

    @Override
    public void Phase3() {

    }

    @Override
    public void selectJoueurNextPhase() {
        //Si l'état d'un participant est E (Éliminé), alors on le supprime des participants
        participants.removeIf(participant -> Objects.equals(participant.getEtatActuel(), "E"));
    }

    public Questions getQuestions(){
        return this.questions;
    }
    public Themes getThemes(){
        return this.themes;
    }
    public Joueurs getJoueurs(){
        return this.joueurs;
    }
    public List<Joueur> getParticipants() {
        return participants;
    }
    public List<Integer> getIndiceThemesJouer() {
        return indiceThemesJouer;
    }
    public void setQuestions(Questions questions){
        this.questions = questions;
    }
    public void setIndiceThemesJouer(ArrayList<Integer> indiceThemesJouer) {
        this.indiceThemesJouer = indiceThemesJouer;
    }
    public void setJoueurs(Joueurs joueurs) {
        this.joueurs = joueurs;
    }
    public void setThemes(Themes themes) {
        this.themes = themes;
    }
    public void setParticipants(ArrayList<Joueur> participants) {
        this.participants = participants;
    }

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

            //6.1 SÉLECTION 3 THÈMES

            //6.2 POSER AU MOINS 2 QUESTIONS DIFFICILES PAR JOUEUR

            //6.3 SCORE JOUEUR +5 SI BONNE RÉPONSE

            //6.4 GAGNANT = CELUI AYANT LE MEILLEUR SCORE LORS DE LA PHASE 3
    }
}
