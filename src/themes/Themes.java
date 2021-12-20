package themes;

import java.util.*;

public class Themes implements Iterable<Theme> {

    protected List<Theme> themes;     // The list of the themes
    protected List<Integer> indicator;    // Position, indicator of each theme

    public Themes(){
        this.themes = new ArrayList<>();
    }


    public void add(Theme theme) {
        themes.add(theme);
    }

    public void remove(Theme theme) { themes.remove(theme); }

    public Theme selectRandomTheme(){
        Random rand = new Random();
        int selectedThemeIndex = rand.nextInt(themes.size());
        return themes.get(selectedThemeIndex); //Retourne le thème sélectionné
    }


    public Themes selectMultipleThemeRandomly(int n) {
        Themes selectedThemes = new Themes();
        List<Theme> tempThemes = themes; //Thèmes temporaires pour ne pas impacter la liste principale de thèmes

        Random rand = new Random();
        int selectedThemeIndex;

        for(int i = 0; i < n; i++) {
            selectedThemeIndex = rand.nextInt(tempThemes.size()); //Sélectionne aléatoire un thème parmi les 10
            selectedThemes.add(tempThemes.get(selectedThemeIndex)); //Puis l'ajoute aux thèmes selectionnés
            tempThemes.remove(selectedThemeIndex); //Et on le supprime des thèmes temporaires pour ne pas sélectionner plusieurs fois le même thème
        }

        return selectedThemes;
    }

    //Ajoute les thèmes à List themes
    public void genererThemes() {
        themes.add(new Theme("Mathématiques"));
        themes.add(new Theme("Histoire"));
        themes.add(new Theme("Géographie"));
        themes.add(new Theme("Jeux-Vidéo"));
        themes.add(new Theme("Animaux"));
        themes.add(new Theme("Sport"));
        themes.add(new Theme("La langue française"));
        themes.add(new Theme("Culture Japonaise"));
        themes.add(new Theme("Nourriture"));
        themes.add(new Theme("Informatique"));
    }

    @Override
    public String toString(){
       String text = "";
        for (int i = 0; i < themes.size(); i++){
            String a = "Thème : " + themes.get(i).getNom() + ", indicator : " + i + "\n";
            text += a;
        }
        return text;
    }

    //GETTERS & SETTERS
    public List<Theme> getThemes() {
        return themes;
    }
    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }

    public List<Integer> getIndicator() {
        return indicator;
    }
    public void setIndicator(List<Integer> indicator) {
        this.indicator = indicator;
    }

    //Méthode permettant de faire une boucle directement sur la classe Themes au lieu de passer par un compromis hideux
    @Override
    public Iterator<Theme> iterator() {
        return themes.iterator();
    }
}
