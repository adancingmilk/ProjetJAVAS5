package joueurs;

import java.util.Comparator;

//Classe permettant de comparer les scores de deux joueurs
public class JoueurScoreComparator implements Comparator<Joueur> {

    @Override
    public int compare(Joueur j1, Joueur j2) {
        return j1.getScore() - j2.getScore();
    }
}
