//CLASSE CONTENANT LES FONCTIONS ET VARIABLES NÉCESSAIRES AU FONCTIONNEMENT DU JEU DANS MAIN.JAVA
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
        System.out.println("- - - DÉBUT PHASE 1 - - -");
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

        Theme themeSelP1 = themes.selectRandomTheme(); //Thème sélectionné lors de la Phase 1
        System.out.println("[INFO] Thème sélectionné pour cette phase : " + themeSelP1);
        Questions questionsP1 = questions.getQuestionsTheme(themeSelP1); //On récupère la liste des questions du thème de la phase

        String repJoueur = "";
        for (Question question : questionsP1) {
            for (Joueur participant : participants) {
                System.out.println("Joueur : " + participant.getNom() + "\nVeuillez répondre à la question suivante : ");
                System.out.println(question.getDescription());
                if (question instanceof Question_QCM){
                    ((Question_QCM) question).afficherPropositions(); //On affiche les propositions de la question QCM
                }
                else if (question instanceof Question_VF){
                    System.out.println("Vrai(V) ou Faux(F) ?");
                }
                repJoueur = participant.saisie(question); //Répondre à la question
                if (Objects.equals(repJoueur.toUpperCase(), question.getReponse().toUpperCase())) {
                    System.out.println("Bonne réponse ! \n");
                    participant.majScore(1); //On met à jour le score du joueur
                } else {
                    System.out.println("Mauvaise réponse. \n");
                }
            }
        }

        //On détermine le joueur ayant le score le plus faible (joueur éliminé)
        Joueur joueurElimine = new Joueur();
        for (Joueur participant : participants) {
            if (joueurElimine.getScore() > participant.getScore()) {
                joueurElimine = participant;
            }
        }

        joueurElimine.majEtat(2); //On passe l'état du joueur au score le plus faible sur E (Éliminé)
        System.out.println(participants);
        System.out.println("Passons à la phase 2, voici le joueur éliminé : " + joueurElimine.toString());
        System.out.println("[INFO] Suppression du thème utilisé en phase 1 (" + themeSelP1 + ")");
        themes.remove(themeSelP1); //On supprime le thème de cette phase des thèmes du jeu
        System.out.println("- - - FIN PHASE 1 - - -");
    }

    @Override
    public void Phase2() {
        System.out.println("- - - DÉBUT PHASE 2 - - -");
        List<Theme> themesP2 = themes.selectMultipleThemeRandomly(participants.size()*2); //Sélectionne 2*nbJoueurs thèmes aléatoirement

        System.out.println("Thèmes sélectionnés pour cette phase :");
        for(Theme theme : themesP2)
            System.out.println(theme);

        //SÉLECTION DES 2 THÈMES DE CHAQUE JOUEUR À TOUR DE RÔLE
        for(Joueur participant : participants) {
            participant.selectionThemeP2(themesP2); //Chaque joueur sélectionne 2 thèmes sur lesquels il veut être interrogé
            for(Theme themesJoueur : participant.getThemesP2sel()) {

            }
        }



        System.out.println("- - - FIN PHASE 2 - - -");
    }

    @Override
    public void Phase3() {
        System.out.println("- - - DÉBUT PHASE 3 - - -");
        //CODE PHASE 3
        System.out.println("- - - FIN PHASE 3 - - -");
        System.out.println("- - - - - FIN DU JEU - - - - -");
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
}
