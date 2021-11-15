import java.util.Arrays;
import java.util.Random;

public class Joueurs {
    Joueur[] tabJoueurs;

    //Constructeur principal
    public Joueurs(Joueur[] joueurs) {
        this.tabJoueurs = joueurs;
    }

    //Selectionne un joueur aléatoirement selon la taille du tableau de joueurs
    public Joueur selectJoueur() {
        Random rand = new Random();
        int joueurSelectionne = rand.nextInt(tabJoueurs.length);

        return tabJoueurs[joueurSelectionne]; //Retourne le joueur sélectionné
    }

    //Génère des joueurs selon le nombre donné en paramètre
    public void genererJoueurs(int nbJoueurs) {
        if(nbJoueurs >= 4 && nbJoueurs <= 20) {
            String[] tabNomJoueur = { "J", "0" };
            String nomJoueur;
            int numJoueur = 100;

            for(int i = 0; i < nbJoueurs; i++) {
                //Génère un nom de joueur allant de J1 à J20 selon le nombre de joueur
                tabNomJoueur[1] = String.valueOf(i++);
                nomJoueur = tabNomJoueur[0] + tabNomJoueur[1];

                tabJoueurs[i] = new Joueur(nomJoueur, numJoueur); //Ajoute un nouveau joueur de nom JXX et de numéro XXX

                numJoueur+=10; //Ajoute 10 au numéro
            }
        } else {
            System.out.println("[ERR] Nombre joueur incorrect.");
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("JOUEURS\n");

        //Chaque joueur contenu dans le tableau
        for(Joueur j : tabJoueurs) {
            s.append(j.toString()).append("\n");
        }

        return s.toString();
    }
}
