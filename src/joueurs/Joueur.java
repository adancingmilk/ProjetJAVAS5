package joueurs;

import questions.Question;
import questions.Question_QCM;
import questions.Question_VF;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Joueur {
    private int numero;
    private String nom;
    private int score;
    private final String[] etats = { "G", "SG", "E", "A" }; //Gagnant, Super-Gagnant, Éliminé, En Attente
    private String etatActuel;
    private String theme1P2; //Thème sélectionné par le joueur lors de la phase 2
    private String theme2P2; //2nd thème sélectionné par le joueur lors de la phase 2

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
    public String selectionTheme(List<String> themesP2) {
        Scanner sc = new Scanner(System.in); //Ouverture d'un nouveau scanner
        boolean valide = false; //Validité de la réponse
        String rep ="";

        while(!valide) {
            System.out.print("Entrez un thème que vous souhaitez : ");
            rep = sc.next();
            for(String theme : themesP2) {
                if(Objects.equals(rep, theme)) {
                    valide = true;
                    break;
                }
            }
            if(!valide)
                System.out.println("[ERR] Le thème saisi n'est pas dans la liste. Réessayez.");
        }

        sc.close();
        theme1P2 = rep;
        return rep; //Retourne le thème sélectionné par le joueur
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

    public String getTheme1P2() {
        return theme1P2;
    }
    public void setTheme1P2(String theme1P2) {
        this.theme1P2 = theme1P2;
    }
}
