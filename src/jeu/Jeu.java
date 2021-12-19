//CLASSE CONTENANT LES FONCTIONS ET VARIABLES NÉCESSAIRES AU FONCTIONNEMENT DU JEU DANS MAIN.JAVA
package jeu;

import joueurs.Joueur;
import joueurs.JoueurScoreComparator;
import joueurs.Joueurs;
import questions.*;
import themes.Theme;
import themes.Themes;

import java.util.*;

public class Jeu implements Phase {
    private final int nbJ;
    private final Questions questions;
    private final Themes themes;
    private final Joueurs joueurs;
    private final List<Joueur> participants;
    private final boolean debug;

    public Jeu(int nbJ, Questions questions, Themes themes, Joueurs joueurs, boolean debug){
        this.participants = new ArrayList<>();
        this.questions = questions;
        this.themes = themes;
        this.joueurs = joueurs;
        this.nbJ = nbJ;
        this.debug = debug;
    }

    @Override
    public void Phase1() {
        System.out.println("- - - DÉBUT PHASE 1 - - -");
        Joueur player;
        for (int i = 0; i < nbJ ; i++){ //On pioche un nombre de joueur en fonction du nombre de participants autorisé dans le jeu
            player = joueurs.selectJoueur(); //SELECTION ALEATOIRE
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
                repondreQuestion(question, participant, 1); //Chaque joueur répond à une question à tour de rôle
            }
        }

        this.triclassement();

        //On détermine le joueur ayant le score le plus faible de la Phase 1 (joueur éliminé)
        Joueur joueurElimine = selectJoueurElimineP1();
        joueurElimine.majEtat(2); //On passe l'état du joueur au score le plus faible sur E (Éliminé)

        System.out.println("Classement générale de la phase 1 : ");
        this.classement();

        System.out.println("[INFO] Le joueur suivant a été éliminé : " + joueurElimine.getNom());
        System.out.println("[INFO] Suppression du thème utilisé en phase 1 (" + themeSelP1 + ")");
        themes.remove(themeSelP1); //On supprime le thème de cette phase des thèmes du jeu
        System.out.println("- - - FIN PHASE 1 - - - \n");
    }

    @Override
    public void Phase2() {
        System.out.println("- - - DÉBUT PHASE 2 - - -");
        Themes themesP2 = themes.selectMultipleThemeRandomly(participants.size()*2); //Sélectionne 2*nbJoueurs thèmes aléatoirement

        //SÉLECTION DES 2 THÈMES DE CHAQUE JOUEUR À TOUR DE RÔLE ET ATTRIBUTION DES QUESTIONS
        for(int i = 0; i < 2; i++) {
            for(Joueur participant : participants) {
                if(themesP2.getThemes().size() != 1) { //Tant qu'il ne reste pas 1 thème dans themesP2
                    System.out.println("Thèmes sélectionnables :");
                    for(Theme theme : themesP2)
                        System.out.println(theme);

                    if(debug) //Si le debug est activé, les thèmes sont ajoutés automatiquement
                        participant.selectionThemeAutoP2(themesP2); //Sélection des thèmes pour chaque joueur aléatoirement et automatiquement
                    else
                        participant.selectionThemeP2(themesP2); //Chaque joueur sélectionne 2 thèmes sur lesquels il veut être interrogé

                    participant.addQuestionsP2(questions); //Filtre les questions en fonction des thèmes sélectionnés par le joueur et les ajoutent aux questions sélectionnées
                    for(Theme t : participant.getThemesP2sel())
                        themesP2.remove(t); //On supprime les thèmes choisis par le joueur de la liste
                } else {
                    System.out.println("Il ne reste que 1 thème. Il est donc attribué automatiquement au joueur " + participant.getNom() + ". \n");
                    participant.getThemesP2sel().add(themesP2.getThemes().get(0)); //Il ne reste que 1 thème dans themesP2, donc attribués automatiquement
                    participant.addQuestionsP2(questions);
                }
            }
        }

        //Fixe le nombre de questions posées basées sur la taille de la liste des questions du joueur 1 (par défaut)
        int nbQuestions = participants.get(0).getQuestionsP2().getQuestions().size();
        System.out.println(nbQuestions);
        //ON POSE LES QUESTIONS
        for(Joueur participant : participants) { //On pose deux questions à chaque joueur à chaque tour
             for(int j = 0; j < 2; j++) {
                if(participant.getQuestionsP2().getQuestions().size() > 0) {
                    Question qRandom = participant.getRandomQuestionP2(); //Pioche une question au hasard parmi celles du joueur
                    repondreQuestion(qRandom, participant, 2);
                }
            }
        }

        //On détermine les 2 joueurs ayant les scores les plus élevés de la Phase 2, et on met l'état des autres joueurs sur Éliminé (E)
        this.triclassement();

        //On passe les deux joueurs ayant le meilleur score et on élimine les autres
        System.out.println("[INFO] Le(s) joueur(s) suivant(s) ont été éliminé(s) : ");
        for(int i = 2; i < participants.size(); i++) {
            participants.get(i).majEtat(2); //On passe l'état des joueur aux scores les plus faibles sur E (Éliminé)
            System.out.println(participants.get(i));
        }

        System.out.println("Classement générale de la phase 2 : ");
        this.classement();

        for(Theme t : themesP2)
            themes.remove(t); //On supprime tous les thèmes utilisés lors de la Phase 2
        System.out.println("[INFO] Les thèmes utilisés lors de cette phase ont été supprimés.");
        System.out.println("- - - FIN PHASE 2 - - - \n");
    }

    @Override
    public void Phase3() {
        System.out.println("- - - DÉBUT PHASE 3 - - -");
        Themes themesP3 = themes.selectMultipleThemeRandomly(3); //On sélectionne 3 thèmes vu qu'on sait qu'il y a plus que 2 joueurs
        Questions qDifficile = new Questions();
        System.out.println("[INFO] Thème sélectionnés pour cette manche : ");
        for(Theme t : themesP3){
            System.out.println(t.getNom());
        }
        for (Theme theme:themesP3) { //On récupère 2 questions de niveaux difficiles de manière aléatoire dans chaque Thème
            Questions qTheme = questions.getQuestionsTheme(theme);
            for (int i = 0 ; i < 2 ; i++){
                Question stock = qTheme.selectQuestion(3);
                qDifficile.add(stock);
            }
        }
        System.out.println("\n");
        for(int i = 0; i < qDifficile.getQuestions().size(); i++){ //On sait que les questions sont de 2 par 2 donc on alterne les questions posés à chaque joueur pour que chaque joueur puisse répondre à 1 questions difficile de chacun des 3 thèmes
            int indexJ = i%2;
            repondreQuestion(qDifficile.getQuestions().get(i),participants.get(indexJ),3);
        }

        Questions questionP3 = new Questions();
        Random rand = new Random();
        for (Theme theme:themesP3){ //On commence a poser les questions aléatoirement pour chaque thème
            questionP3 = questions.getQuestionsTheme(theme);
            for (int i = 0 ; i < questionP3.getQuestions().size() ; i++){ // 6 parce qu'on s'est dit qu'on allait posé 3 questions aléatoires dans chaque thème à chaque joueur en plus des 3 questions difficiles que chaque joueur a eu donc 3*2 = 6
                int j = i%2;
                int index = rand.nextInt(questionP3.getQuestions().size()); //On selectionne au hasard une question parmit les questions qu'on a
                Question questionpose = questionP3.getQuestions().get(index);
                repondreQuestion(questionpose,participants.get(j),3);
                questionP3.remove(index); //On retire la question de la liste qu'on possède pour ne pas avoir des doublons de questions
            }
        }
        System.out.println("- - - FIN PHASE 3 - - -");

        this.triclassement();
        Joueur supergagnant = participants.get(0);
        Joueur gagnant = participants.get(1);
        supergagnant.majEtat(1);
        gagnant.majEtat(0);
        System.out.println("Voici le podium : \n");
        this.classement();
        System.out.println("Le vainqueur de ce jeu est : " + supergagnant.getNom() + "\n" + "Numéro du joueur : " + supergagnant.getNumero());
        System.out.println("- - - - - FIN DU JEU - - - - -");
    }

    public void triclassement(){
        this.participants.sort(new JoueurScoreComparator()); //On classe les joueurs par ordre croissant de score
        Collections.reverse(this.participants); //On inverse l'ordre des joueurs, donc on passe en ordre décroissant de score
    }

    public void classement(){
        int i = 1;
        for(Joueur j : this.participants){
            System.out.println("Classement du joueur : " + i);
            System.out.println(j.toString());
            i++;
        }
    }

    @Override
    public void selectJoueurNextPhase() {
        //Si l'état d'un participant est E (Éliminé), alors on le supprime des participants
        this.participants.removeIf(participant -> Objects.equals(participant.getEtatActuel(), "E"));
    }

    //Détermine et élimine un joueur
    public Joueur selectJoueurElimineP1() {
        Joueur joueurElimine = new Joueur();
        for (Joueur participant : this.participants) {
            if (joueurElimine.getScore() > participant.getScore())
                joueurElimine = participant;
        }

        return joueurElimine;
    }

    //Méthode demandant à un joueur de répondre à une question
    public void repondreQuestion(Question q, Joueur j, int phase) {
        String repJoueur;

        System.out.println("Joueur " + j.getNom() + ", veuillez répondre à la question suivante :");
        System.out.println(q.getDescription());
        if (q instanceof Question_QCM)
            ((Question_QCM) q).afficherPropositions(); //On affiche les propositions de la question QCM
        else if (q instanceof Question_VF)
            System.out.println("Vrai(V) ou Faux(F) ?");

        //Si le debug est activé, alors la réponse est saisie automatiquement
        if(debug)
            repJoueur = j.saisieAuto(q); //Répondre à la question automatiquement
        else
            repJoueur = j.saisie(q); //Répondre à la question manuellement

        if (Objects.equals(repJoueur.toUpperCase(), q.getReponse().toUpperCase())) {
            System.out.println("Bonne réponse ! \n");
            j.majScore(phase); //On met à jour le score du joueur (Phase 1 = +2 de score, Phase 2 = +3, Phase 3 = +5)
        } else
            System.out.println("Mauvaise réponse. \n");
    }

}
