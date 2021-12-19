package themes;

import java.util.*;

public class Themes implements Iterable<Theme> {

    protected List<Theme> themes;     // The list of the themes
    protected List<Integer> indicator;    // Position, indicator of each theme

    public Themes(){
        this.themes = new ArrayList<>();
    }

    public int selectTheme(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a theme: ");
        String theme= reader.nextLine();
        reader.close(); //We ask the user a theme
        if (!themes.contains(theme)){
            System.out.println("themes.Theme isn't in the list");
            return -1;
        }
        else{
            this.indicator.add(themes.indexOf(theme));
            return themes.indexOf(theme);
        }  // We verify if the theme is in the list, if yes we return the indicator of the theme
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

    //Méthode utile dans le Sujet1, mais pas dans le Sujet2
    public List<Theme> selectFiveTheme(int theme1, int theme2, int theme3, int theme4, int theme5){
        List<Theme> themes = new ArrayList<>();
        themes.add(this.themes.get(theme1));
        themes.add(this.themes.get(theme2));
        themes.add(this.themes.get(theme3));
        themes.add(this.themes.get(theme4));
        themes.add(this.themes.get(theme5));
        this.indicator.add(theme1);
        this.indicator.add(theme2);
        this.indicator.add(theme3);
        this.indicator.add(theme4);
        this.indicator.add(theme5);

        return themes;
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

    public List<String> selectMultipleTheme(int n) {
        List<String> themes = new ArrayList<>();
        int i = 0;
        while (i < n) {
            Scanner reader = new Scanner(System.in);
            System.out.println("Enter a theme: ");
            String theme = reader.nextLine();
            reader.close(); //We ask the user a theme
            if (!this.themes.contains(theme)) {
                System.out.println("themes.Theme isn't in the list");
            } else {
                this.indicator.add(this.themes.indexOf(theme));
                themes.add(theme);
                i++;
            }// We verify if the theme is in the list, if yes we return the indicator of the theme and add the theme to the final list
        }
        return themes;
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
