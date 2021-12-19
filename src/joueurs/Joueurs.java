package joueurs;

import java.util.Random;

public class Joueurs {
    Joueur[] joueurs;

    //Constructeur principal
    public Joueurs(Joueur[] joueurs) {
        this.joueurs = joueurs;
    }

    //Selectionne un joueur aléatoirement selon la taille du tableau de joueurs
    public Joueur selectJoueur() {
        Random rand = new Random(); //Génère un nouveau random
        int joueurSelectionne = rand.nextInt(joueurs.length);

        return joueurs[joueurSelectionne]; //Retourne le joueur sélectionné
    }

    //Génère des joueurs selon le nombre donné en paramètre
    public void genererJoueurs(int nbJoueurs) {
        int indexJoueur = 0;
        if(nbJoueurs >= 4 && nbJoueurs <= 20) {
            String[] tabNomJoueur = { "J", "0" };
            String nomJoueur;
            int numJoueur = 100;

            for(int i = 0; i < nbJoueurs; i++) {
                indexJoueur++;
                //Génère un nom de joueur allant de J1 à J20 selon le nombre de joueur
                tabNomJoueur[1] = Integer.toString(indexJoueur);
                nomJoueur = tabNomJoueur[0] + tabNomJoueur[1];

                joueurs[i] = new Joueur(nomJoueur, numJoueur); //Ajoute un nouveau joueur de nom JXX et de numéro XXX

                numJoueur+=10; //Ajoute 10 au numéro
            }
        } else {
            System.out.println("[ERR] Nombre joueur incorrect.");
        }
    }

    @Override
    public String toString() {
        String s = "";

        //Chaque joueur contenu dans le tableau
        for(Joueur j : joueurs) {
            s += j.toString() + "\n";
        }

        return s;
    }

    public Joueur[] getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(Joueur[] joueurs) {
        this.joueurs = joueurs;
    }
}
