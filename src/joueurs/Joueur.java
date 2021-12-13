package joueurs;

import questions.Question;
import questions.Question_QCM;
import questions.Question_VF;
import questions.Questions;
import themes.Theme;
import themes.Themes;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Joueur {
    private int numero;
    private String nom;
    private int score;
    private final String[] etats = { "G", "SG", "E", "A" }; //Gagnant, Super-Gagnant, Éliminé, En Attente
    private String etatActuel;

    //Variables de la phase 2
    private Themes themesP2sel; //Thème sélectionné par le joueur lors de la phase 2
    private Questions questionsP2; //Questions de la phase 2 du joueur

    //Constructeur principal
    public Joueur(String nom, int numero) {
        this.numero = numero;
        this.nom = nom;
        this.score = 0;
        this.etatActuel = "A";
    }
    public Joueur(){
        this.numero = 0;
        this.nom = "";
        this.score = 9999;
    }

    //Méthode pour que le joueur saisisse la réponse à une question
    public String saisie(Question q) {
        Scanner sc = new Scanner(System.in); //Ouverture du scanner
        int valide = 0;
        String rep;

        do {
            //L'utilisateur saisi sa réponse. 1, 2, ou 3 si QCM, V ou F si VF, une phrase si RC
            System.out.println("[INFO] Veuillez saisir votre réponse: ");
            rep = sc.next();

            //Si le joueur a saisi une réponse
            if(rep != null) {
                if(q instanceof Question_VF) {
                    String repUp = rep.toUpperCase();

                    //Si la réponse est null, ou qu'elle n'est pas égale à V ou F, ressaisir la réponse
                    if(repUp.equals("V") || repUp.equals("F")){
                        valide = 1;
                        return repUp;}
                    else {
                        System.out.println("[ERR] Saisie X incorrecte.");}
                } else if(q instanceof Question_QCM) {
                    //Si la réponse est null, ou qu'elle n'est pas égale à 1, 2 ou 3, ressaisir la réponse
                    if(rep.equals("1") || rep.equals("2") || rep.equals("3"))
                        valide =1;
                    else
                        System.out.println("[ERR] Saisie incorrecte.");
                } else { //Si c'est une réponse courte et qu'elle a été saisi, alors elle est valide
                    valide = 1;
                }
            } else
                System.out.println("[ERR] Vous n'avez rien saisi.");

        } while(valide == 0); //Tant que ce que saisi le joueur n'est pas valide, on reste dans cette boucle

        //sc.close(); //Fermeture du scanner
        sc.reset();
        return rep;
    }

    //Met à jour le score en fonction de la phase
    public void majScore(int phase) {
        switch (phase) {
            case 1:
                score += 2;
                break;
            case 2:
                score += 3;
                break;
            case 3:
                score += 5;
                break;
            default:
                break;
        }
    }

    //Méthode de sélection d'un thème lors de la phase 2
    public void selectionThemeP2(Themes themesP2) {
        Scanner sc = new Scanner(System.in); //Ouverture d'un nouveau scanner
        themesP2sel = new Themes();
        boolean valide = false; //Validité de la réponse
        String rep ="";

        System.out.println(nom + ", veuillez choisir deux thèmes pour cette phase.");

        for(int i = 0; i < 2; i++) { //2 thèmes à choisir
            System.out.println("Entrez le " + (i+1) + "e thème que vous souhaitez : ");
            while(!valide) { //Tant que le thème écrit par l'utilisateur n'existe pas dans la liste fournie en paramètres, on demande à l'utilisateur de recommencer
                rep = sc.next();
                for(Theme theme : themesP2) {
                    if(Objects.equals(rep.toUpperCase(), theme.getNom().toUpperCase())) { //On passe la réponse du joueur ainsi que le thème en UPPERCASE pour ne pas prendre la casse en compte
                        valide = true;
                        themesP2sel.add(new Theme(theme.getNom())); //On fixe le ième thème sélectionné par le joueur pour la jeu.Phase 2 (2 thèmes à choisir)
                        break;
                    }
                }
                if(!valide)
                    System.out.println("[ERR] Le thème saisi n'est pas dans la liste. Réessayez.");
            }
            valide = false; //On remet valide sur faux pour sélectionner le second thème
        }

        //Affiche les 2 thèmes sélectionnés par le joueur
        System.out.println("Vous avez choisi les thèmes " + themesP2sel.getThemes().get(0).getNom() + " et " + themesP2sel.getThemes().get(1).getNom() + ".");

        sc.reset();
    }

    //Sélectionne une question aléatoirement puis la supprime de la liste des questions du joueur et la retourne
    public Question getRandomQuestionP2() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(questionsP2.getQuestions().size());

        Question selectedQuestion = questionsP2.getQuestions().get(randomIndex);
        questionsP2.remove(randomIndex); //On supprime la question des questions du joueur, mais elle reste en mémoire grâce à selectedQuestion

        return selectedQuestion;
    }

    //Sélectionne les questions de la Phase 2
    public void addQuestionsP2(Questions questions) {
        questionsP2 = new Questions();
        for(Question q : questions) {
            for(Theme t : themesP2sel) {
                if(q.getTheme() == t) //Si le thème d'une question est le même que celui d'un des thèmes sélectionné par le joueur, alors on l'ajoute aux questionsP2
                    questionsP2.add(q);
            }
        }
    }

    @Override
    public String toString() {
        return "JOUEUR" + nom.toUpperCase() +
                "\n| NUM: " + numero +
                "\n| SCORE: " + score +
                "\n| ETAT: " + etatActuel + "\n";
    }

    //Met à jour l'état selon celui précisé en paramètres
    //0 = G | 1 = SG | 2 = E | 3 = A
    public void majEtat(int etat) {
        for(int i = 0; i < etats.length; i++) {
            if(etat == i)
                etatActuel = etats[i];
        }
    }

    //GETTERS & SETTERS
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public String getEtatActuel() {
        return etatActuel;
    }
    public void setEtatActuel(String etatActuel) {
        this.etatActuel = etatActuel;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String[] getEtats() {
        return etats;
    }

    public Themes getThemesP2sel() {
        return themesP2sel;
    }
    public void setThemesP2sel(Themes themesP2sel) {
        this.themesP2sel = themesP2sel;
    }

    public Questions getQuestionsP2() {
        return questionsP2;
    }
    public void setQuestionsP2(Questions questionsP2) {
        this.questionsP2 = questionsP2;
    }
}
