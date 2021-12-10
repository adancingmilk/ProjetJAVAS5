import joueurs.Joueur;
import joueurs.Joueurs;
import questions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Jeu implements Phase{
    private int nbJ;
    private Questions questions;
    private Themes themes;
    private Joueurs joueurs;
    private ArrayList<Joueur> participants;
    private List<Integer> indicesThemesJouer;

    public Jeu(){
    }

    public Jeu(int nbJ, Questions questions, Themes listThemes, Joueurs joueurs){
        this.participants = new ArrayList<>();
        this.questions = questions;
        this.themes = listThemes;
        this.joueurs = joueurs;
        this.indicesThemesJouer = new ArrayList<>();
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
        indicesThemesJouer.add(indiceTheme); //Le thème jouer lors de la phase 1 on le note

        List<Question> listeQuestions = questions.getQuestions(); //On récupère la liste des questions du thème de l'indice selectionné
        ArrayList<String> listeTheme = themes.getThemes();

        ArrayList<Question> listeQduTheme = new ArrayList<Question>();

        for(int i = 0 ; i < listeQuestions.size() ; i++){ //On récupère toutes les questions qui ont comme thème selectionné et on le stock dans listQduTheme
            if (Objects.equals(listeQuestions.get(i).getTheme(), listeTheme.get(indiceTheme))){
                listeQduTheme.add(questions.getQuestions().get(i));
            }
        }
        String repJoueur = "";
        for (Question question : listeQduTheme) {
            for (Joueur participant : participants) {
                System.out.println("Joueur : " + participant.getNom() + "\nVeuillez répondre à la question suivante : ");
                System.out.println(question.getDescription());
                if (question instanceof Question_QCM){
                    String propositions = "";
                    int i = 1;
                    for(String s : ((Question_QCM) question).getChoix()){
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
        System.out.println("Thème utilisé lors de la phase 1 : " + this.themes.getThemes().get(indiceTheme) + "\n");
    }

    @Override
    public void Phase2() {
        ArrayList<String> listeThemeP2 = themes.selectMultipleThemeRandomly(6); //Sélectionne 6 thèmes aléatoirement

        System.out.println("Thèmes sélectionnés pour cette phase :");
        for(String theme : listeThemeP2)
            System.out.println(theme);

        //SÉLECTION DU THÈME POUR CHAQUE JOUEUR À TOUR DE RÔLE
        for(Joueur participant : participants) {
            participant.setTheme1P2(participant.selectionTheme(listeThemeP2)); //Chaque joueur sélectionne un thème sur lequel il veut être interrogé
            System.out.println(participant.getNom() + " a sélectionné le thème " + participant.getTheme1P2());
        }

        //INITIALISATION DES QUESTIONS

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
    public Themes getListThemes(){
        return this.themes;
    }
    public Joueurs getJoueurs(){
        return this.joueurs;
    }
    public List<Joueur> getParticipants() {
        return participants;
    }
    public List<Integer> getIndicesThemesJouer() {
        return indicesThemesJouer;
    }
    public void setQuestions(Questions questions){
        this.questions = questions;
    }
    public void setIndicesThemesJouer(ArrayList<Integer> indicesThemesJouer) {
        this.indicesThemesJouer = indicesThemesJouer;
    }
    public void setJoueurs(Joueurs joueurs) {
        this.joueurs = joueurs;
    }
    public void setListThemes(Themes listThemes) {
        this.themes = listThemes;
    }
    public void setParticipants(ArrayList<Joueur> participants) {
        this.participants = participants;
    }

    public static void main(String[] args) {
        //1. INITIALISATION THEMES
        ArrayList<String> listThemes = new ArrayList<String>();

        Themes themes = new Themes(listThemes); //Place la liste des thèmes dans une instance de Thèmes
        themes.genererThemes(); //Génère les 10 thèmes

        //2. INITIALISATION JOUEURS
        Joueur[] tabJoueurs = new Joueur[4]; //Tableau de 4 joueurs
        Joueurs joueurs = new Joueurs(tabJoueurs);
        joueurs.genererJoueurs(4); //Génère 4 joueurs

        //3. INITIALISATION QUESTIONS POUR CHAQUE THÈME
        Questions listQ = new Questions();
        listQ.genererQuestions(); //Génère les questions de TOUS les thèmes

        //4. DÉROULEMENT PHASE 1
        Jeu jeu = new Jeu(4, listQ, themes, joueurs);
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
