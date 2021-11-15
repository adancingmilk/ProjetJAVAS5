import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Joueur {
    private int numero;
    private String nom;
    private int score;
    private String[] etats = { "G", "SG", "E", "A" }; //Gagnant, Super-Gagnant, Éliminé, En Attente
    private String etatActuel;

    //Constructeur principal
    public Joueur(String nom, int numero) {
        this.numero = numero;
        this.nom = nom;
        this.score = 0;
    }

    //Méthode pour que le joueur saisisse la réponse à une question
    public String saisie(Question q) {
        Scanner sc = new Scanner(System.in); //Ouverture du scanner
        int valide = 0;
        String rep;

        do {
            //L'utilisateur saisi sa réponse. 1, 2, ou 3 si QCM, V ou F si VF, une phrase si RC
            System.out.println("[INFO] Veuillez saisir votre réponse: ");
            rep = sc.nextLine();

            //Si le joueur a saisi une réponse
            if(rep != null) {
                if(q instanceof Question_VF) {
                    //Si la réponse est null, ou qu'elle n'est pas égale à V ou F, ressaisir la réponse
                    if(!rep.equals("V") || !Objects.equals(rep, "F"))
                        System.out.println("[ERR] Saisie incorrecte.");
                    else
                        valide = 1;
                } else if(q instanceof Question_QCM) {
                    //Si la réponse est null, ou qu'elle n'est pas égale à 1, 2 ou 3, ressaisir la réponse
                    if(!rep.equals("1") || !Objects.equals(rep, "2") || !Objects.equals(rep, "3"))
                        System.out.println("[ERR] Saisie incorrecte.");
                    else
                        valide = 1;
                } else { //Si c'est une réponse courte et qu'elle a été saisi, alors elle est valide
                    valide = 1;
                }
            } else
                System.out.println("[ERR] Vous n'avez rien saisi.");

        } while(valide == 0); //Tant que ce que saisi le joueur n'est pas valide, on reste dans cette boucle

        sc.close(); //Fermeture du scanner
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

    @Override
    public String toString() {
        return "JOUEUR" + nom.toUpperCase() +
                "\n| NUM: " + numero +
                "\n| SCORE: " + score +
                "\n| ETAT: " + etatActuel;
    }

    //Met à jour l'état selon celui précisé en paramètres
    //0 = G | 1 = SG | 2 = E | 3 = A
    public void majEtat(int etat) {
        for(int i = 0; i < etats.length; i++) {
            if(etat == i)
                etatActuel = etats[i];
        }
    }
}
