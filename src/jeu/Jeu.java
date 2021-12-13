//CLASSE CONTENANT LES FONCTIONS ET VARIABLES NÉCESSAIRES AU FONCTIONNEMENT DU JEU DANS MAIN.JAVA
package jeu;

import joueurs.Joueur;
import joueurs.JoueurScoreComparator;
import joueurs.Joueurs;
import questions.*;
import themes.Theme;
import themes.Themes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Jeu implements Phase {
    private final int nbJ;
    private final Questions questions;
    private final Themes themes;
    private final Joueurs joueurs;
    private final List<Joueur> participants;

    public Jeu(int nbJ, Questions questions, Themes themes, Joueurs joueurs){
        this.participants = new ArrayList<>();
        this.questions = questions;
        this.themes = themes;
        this.joueurs = joueurs;
        this.nbJ = nbJ;
    }

    @Override
    public void Phase1() {
        System.out.println("- - - DÉBUT PHASE 1 - - -");
        Joueur player;
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

        for (Question question : questionsP1) {
            for (Joueur participant : participants) {
                repondreQuestion(question, participant); //Chaque joueur répond à une question à tour de rôle
            }
        }

        //On détermine le joueur ayant le score le plus faible de la Phase 1 (joueur éliminé)
        Joueur joueurElimine = selectJoueurElimineP1();

        joueurElimine.majEtat(2); //On passe l'état du joueur au score le plus faible sur E (Éliminé)
        System.out.println(participants);
        System.out.println("[INFO] Le joueur suivant a été éliminé : " + joueurElimine);
        System.out.println("[INFO] Suppression du thème utilisé en phase 1 (" + themeSelP1 + ")");
        themes.remove(themeSelP1); //On supprime le thème de cette phase des thèmes du jeu
        System.out.println("- - - FIN PHASE 1 - - - \n");
    }

    @Override
    public void Phase2() {
        System.out.println("- - - DÉBUT PHASE 2 - - -");
        Themes themesP2 = themes.selectMultipleThemeRandomly(participants.size()*2); //Sélectionne 2*nbJoueurs thèmes aléatoirement

        //SÉLECTION DES 2 THÈMES DE CHAQUE JOUEUR À TOUR DE RÔLE ET ATTRIBUTION DES QUESTIONS
        for(Joueur participant : participants) {
            if(themesP2.getThemes().size() != 2) { //Tant qu'il ne reste pas 2 thèmes dans themesP2
                System.out.println("Thèmes sélectionnables :");
                for(Theme theme : themesP2)
                    System.out.println(theme);
                participant.selectionThemeP2(themesP2); //Chaque joueur sélectionne 2 thèmes sur lesquels il veut être interrogé
                participant.addQuestionsP2(questions); //Filtre les questions en fonction des thèmes sélectionnés par le joueur et les ajoutent aux questions sélectionnées
                for(Theme t : participant.getThemesP2sel())
                    themesP2.remove(t); //On supprime les thèmes choisis par le joueur de la liste
            } else {
                System.out.println("Il ne reste que 2 thèmes. Ils sont donc attribués automatiquement au joueur " + participant.getNom() + ". \n");
                participant.setThemesP2sel(themesP2); //Il ne reste que 2 thèmes dans themesP2, donc attribués automatiquement
                participant.addQuestionsP2(questions);
            }
        }

        //Fixe le nombre de questions posées basées sur la taille de la liste des questions du joueur 1 (par défaut)
        int nbQuestions = participants.get(0).getQuestionsP2().getQuestions().size();

        //ON POSE LES QUESTIONS
        for(int i = 0; i < nbQuestions; i++) {
            for(int j = 0; j < 2; j++) { //On pose deux questions à chaque joueur à chaque tour
                for(Joueur participant : participants) {
                    if(participant.getQuestionsP2().getQuestions().size() <= 0) {
                        Question qRandom = participant.getRandomQuestionP2(); //Pioche une question au hasard parmi celles du joueur
                        repondreQuestion(qRandom, participant);
                    } else
                        break; // Si la taille de la liste de question du joueur est inférieur ou égal à zéro, alors on arrête de poser des questions
                }
            }
        }

        //On détermine les 2 joueurs ayant les scores les plus élevés de la Phase 2, et on met l'état des autres joueurs sur Éliminé (E)
        participants.sort(new JoueurScoreComparator()); //On classe les joueurs par ordre croissant de score
        Collections.reverse(participants); //On inverse l'ordre des joueurs, donc on passe en ordre décroissant de score

        //On passe les deux joueurs ayant le meilleur score et on élimine les autres
        System.out.println("[INFO] Le(s) joueur(s) suivant(s) ont été éliminé(s) : ");
        for(int i = 2; i < participants.size(); i++) {
            participants.get(i).majEtat(2); //On passe l'état des joueur aux scores les plus faibles sur E (Éliminé)
            System.out.println(participants.get(i));
        }
        System.out.println(participants);

        for(Theme t : themesP2)
            themes.remove(t); //On supprime tous les thèmes utilisés lors de la Phase 2

        System.out.println("[INFO] Les thèmes utilisés lors de cette phase ont été supprimés.");
        System.out.println("- - - FIN PHASE 2 - - - \n");
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

    //Détermine et élimine un joueur
    public Joueur selectJoueurElimineP1() {
        Joueur joueurElimine = new Joueur();
        for (Joueur participant : participants) {
            if (joueurElimine.getScore() > participant.getScore())
                joueurElimine = participant;
        }

        return joueurElimine;
    }

    //Méthode demandant à un joueur de répondre à une question
    public void repondreQuestion(Question q, Joueur j) {
        String repJoueur;

        System.out.println("Joueur " + j.getNom() + ", veuillez répondre à la question suivante :");
        System.out.println(q.getDescription());
        if (q instanceof Question_QCM)
            ((Question_QCM) q).afficherPropositions(); //On affiche les propositions de la question QCM
        else if (q instanceof Question_VF)
            System.out.println("Vrai(V) ou Faux(F) ?");

        repJoueur = j.saisie(q); //Répondre à la question
        if (Objects.equals(repJoueur.toUpperCase(), q.getReponse().toUpperCase())) {
            System.out.println("Bonne réponse ! \n");
            j.majScore(2); //On met à jour le score du joueur (Phase 2 donc +3)
        } else
            System.out.println("Mauvaise réponse. \n");
    }
}
