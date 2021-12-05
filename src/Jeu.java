import questions.Question;
import questions.Question_RC;
import questions.Questions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class Jeu implements Phase{
    private Questions listQ;
    private Themes listThemes;
    private Joueurs listPlayer;
    private Joueur[] participants;
    private ArrayList<Integer> indiceThemesJouer;

    public Jeu(){
        this.participants = new Joueur[3];
    }

    public Jeu(int nbJ, Questions listQ, Themes listThemes, Joueurs listPlayer){
        this.participants = new Joueur[nbJ];
        this.listQ = listQ;
        this.listThemes = listThemes;
        this.listPlayer = listPlayer;
    }

    @Override
    public void Phase1() {

        for (int i = 0; i < participants.length ; i++){ //On pioche un nombre de joueur en fonction du nombre de participants autorisé dans le jeu
            participants[i] = listPlayer.selectJoueur();
        }
        int indiceTheme = listThemes.selectTheme(); //On pioche un thème au hasard du jeu
        indiceThemesJouer.add(indiceTheme); //Le thème jouer lors de la phase 1 on le note

        ArrayList<Question> listeQuestions = listQ.getlistQuestions(); //On récupère la liste des questions du thème de l'indice selectionné
        ArrayList<String> listeTheme = listThemes.getListTheme();

        ArrayList<Question> listeQduTheme = null;

        for(int i = 0 ; i < listeQuestions.size() ; i++){ //On récupère toutes les questions qui ont comme thème selectionné et on le stock dans listQduTheme
            if (Objects.equals(listeQuestions.get(i).getTheme(), listeTheme.get(indiceTheme))){
                listeQduTheme.add(listQ.getlistQuestions().get(i));
            }
        }

        String repJoueur = "";
        for (int i = 0 ; i < listeQduTheme.size(); i++){
            for(int j = 0 ; j < participants.length ; j++){
                System.out.println("Joueur : " + participants[i].getNom() + " Veuillez répondre à la question suivante : ");
                System.out.println("\n" + listeQduTheme.get(i).toString());
                repJoueur = participants[i].saisie(listeQduTheme.get(i));
                if (Objects.equals(repJoueur, listeQduTheme.get(i).getReponse())){
                    System.out.println("Bonne réponse !");
                    int score = participants[i].getScore();
                    participants[i].setScore(score + 2);
                }
                else{
                    System.out.println("Mauvaise réponse");
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
        System.out.println("Passons à la phase 2, voici le joueur éliminé : " + joueurElimine.toString());
    }

    @Override
    public void Phase2() {

    }

    @Override
    public void Phase3() {

    }

    @Override
    public void selectJoueurNextPhase() {

    }

    public Questions getListQ(){
        return this.listQ;
    }
    public Themes getListThemes(){
        return this.listThemes;
    }
    public Joueurs getListPlayer(){
        return this.listPlayer;
    }
    public Joueur[] getParticipants() {
        return participants;
    }
    public ArrayList<Integer> getIndiceThemesJouer() {
        return indiceThemesJouer;
    }
    public void setListQ(Questions listQ){
        this.listQ = listQ;
    }
    public void setIndiceThemesJouer(ArrayList<Integer> indiceThemesJouer) {
        this.indiceThemesJouer = indiceThemesJouer;
    }
    public void setListPlayer(Joueurs listPlayer) {
        this.listPlayer = listPlayer;
    }
    public void setListThemes(Themes listThemes) {
        this.listThemes = listThemes;
    }
    public void setParticipants(Joueur[] participants) {
        this.participants = participants;
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
    public static void main(String[] args) {
//        Question Q1 = new Question_RC(1,"1+1=2","Math",1, "Vrai");
//        Questions listQ = new Questions();
//        listQ.addQuestion(Q1);
//        System.out.println(listQ.selectQuestion(1));

        //1. INITIALISATION THEMES
        ArrayList<String> listThemes = new ArrayList<String>();
        genererThemes(listThemes);

        Themes themes = new Themes(listThemes); //Place la liste des thèmes dans une instance de Thèmes

        //2. INITIALISATION JOUEURS
        Joueur[] tabJoueurs = new Joueur[4]; //Tableau de 4 joueurs
        Joueurs joueurs = new Joueurs(tabJoueurs);
        joueurs.genererJoueurs(4); //Génère 4 joueurs

        //3. INITIALISATION QUESTIONS POUR CHAQUE THÈME
        Questions listQ = new Questions();
        listQ.genererQuestions(); //Génère les questions de TOUS les thèmes

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
}
