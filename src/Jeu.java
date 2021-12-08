import joueurs.Joueur;
import joueurs.Joueurs;
import questions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Jeu implements Phase{
    private int nbJ;
    private Questions listQ;
    private Themes listThemes;
    private Joueurs listPlayer;
    private List<Joueur> participants;
    private List<Integer> indiceThemesJouer;

    public Jeu(){
    }

    public Jeu(int nbJ,Questions listQ, Themes listThemes, Joueurs listPlayer){
        this.participants = new ArrayList();
        this.listQ = listQ;
        this.listThemes = listThemes;
        this.listPlayer = listPlayer;
        this.indiceThemesJouer = new ArrayList();
        this.nbJ = nbJ;
    }

    @Override
    public void Phase1() {
        Joueur player = new Joueur();
        for (int i = 0; i < nbJ ; i++){ //On pioche un nombre de joueur en fonction du nombre de participants autorisé dans le jeu
            player = listPlayer.selectJoueur();
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
        int indiceTheme = 0; //On pioche un thème au hasard du jeu
        indiceThemesJouer.add(indiceTheme); //Le thème jouer lors de la phase 1 on le note

        ArrayList<Question> listeQuestions = listQ.getListQuestions(); //On récupère la liste des questions du thème de l'indice selectionné
        ArrayList<String> listeTheme = listThemes.getListTheme();

        ArrayList<Question> listeQduTheme = new ArrayList<Question>();

        for(int i = 0 ; i < listeQuestions.size() ; i++){ //On récupère toutes les questions qui ont comme thème selectionné et on le stock dans listQduTheme
            if (Objects.equals(listeQuestions.get(i).getTheme(), listeTheme.get(indiceTheme))){
                listeQduTheme.add(listQ.getListQuestions().get(i));
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
                    for(String s : question.getReponses()){
                        propositions +=  i++ + ". (" + s.toString() + ") ";
                    };
                    System.out.println(propositions);
                }
                else if (question instanceof Question_VF){
                    System.out.println("Vrai(V) ou Faux(F) ?");
                }
                repJoueur = participant.saisie(question);
                if (Objects.equals(repJoueur, question.getReponse())) {
                    System.out.println("Bonne réponse !");
                    int score = participant.getScore();
                    participant.setScore(score + 2);
                } else {
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
        ArrayList<String> listeThemeP2 = listThemes.selectMultipleThemeRandomly(6); //Sélectionne 6 thèmes aléatoirement
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
        participants.removeIf(participant -> participant.getEtatActuel() == "E");
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
    public List<Joueur> getParticipants() {
        return participants;
    }
    public List<Integer> getIndiceThemesJouer() {
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
        Jeu QuestionReponse = new Jeu(4, listQ, themes, joueurs);
        QuestionReponse.Phase1();

        QuestionReponse.selectJoueurNextPhase(); //Sélection des joueurs pour la phase suivante

        //5. DÉROULEMENT PHASE 2
        QuestionReponse.Phase2();

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
