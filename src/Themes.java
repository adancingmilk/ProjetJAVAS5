
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Themes {

    protected ArrayList<String> listTheme;     // The list of the themes
    protected ArrayList<Integer> indicator;    // Position, indicator of each theme

    public Themes(ArrayList<String> listTheme){
        this.listTheme = listTheme;
    }

    public int selectTheme(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a theme: ");
        String theme= reader.nextLine();
        reader.close(); //We ask the user a theme
        if (!listTheme.contains(theme)){
            System.out.println("Theme isn't in the list");
            return -1;
        }
        else{
            this.indicator.add(listTheme.indexOf(theme));
            return listTheme.indexOf(theme);
        }  // We verify if the theme is in the list, if yes we return the indicator of the theme
    }
    public int selectRandomTheme(){
        return ThreadLocalRandom.current().nextInt(0,listTheme.size());
    }

    public ArrayList<String> selectFiveTheme(int theme1, int theme2, int theme3, int theme4, int theme5){
        ArrayList<String> themes = new ArrayList<String>();
        themes.add(listTheme.get(theme1));
        themes.add(listTheme.get(theme2));
        themes.add(listTheme.get(theme3));
        themes.add(listTheme.get(theme4));
        themes.add(listTheme.get(theme5));
        this.indicator.add(theme1);
        this.indicator.add(theme2);
        this.indicator.add(theme3);
        this.indicator.add(theme4);
        this.indicator.add(theme5);

        return themes; //this function was useful in subject n°1, "add 5 themes to the list"
    }

    public ArrayList<String> selectMultipleThemeRandomly(int n) {
        ArrayList<String> selectedThemes = new ArrayList<>();
        ArrayList<String> tempThemes = listTheme; //Thèmes temporaires pour ne pas impacter la liste principale de thèmes

        Random rand = new Random();
        int selectedThemeIndex;

        for(int i = 0; i < n; i++) {
            selectedThemeIndex = rand.nextInt(tempThemes.size()); //Sélectionne aléatoire un thème parmi les 10
            selectedThemes.add(tempThemes.get(selectedThemeIndex)); //Puis l'ajoute aux thèmes selectionnés
            tempThemes.remove(selectedThemeIndex); //Et on le supprime des thèmes temporaires pour ne pas sélectionner plusieurs fois le même thème
        }

        return selectedThemes;
    }

    public ArrayList<String> selectMultipleTheme(int n) {
        ArrayList<String> themes = new ArrayList<>();
        int i = 0;
        while (i < n) {
            Scanner reader = new Scanner(System.in);
            System.out.println("Enter a theme: ");
            String theme = reader.nextLine();
            reader.close(); //We ask the user a theme
            if (!listTheme.contains(theme)) {
                System.out.println("Theme isn't in the list");
            } else {
                this.indicator.add(listTheme.indexOf(theme));
                themes.add(theme);
                i++;
            }// We verify if the theme is in the list, if yes we return the indicator of the theme and add the theme to the final list
        }
        return themes;
    }

    //Ajoute les thèmes à l'ArrayList listThemes
    public void genererThemes() {
        listTheme.add("Mathématiques");
        listTheme.add("Histoire");
        listTheme.add("Géographie");
        listTheme.add("Jeux-Vidéo");
        listTheme.add("Animaux");
        listTheme.add("Sport");
        listTheme.add("La langue française");
        listTheme.add("Culture Japonaise");
        listTheme.add("Nourriture");
        listTheme.add("Informatique");
    }

    @Override
    public String toString(){
       String listThemes = "";
        for (int i = 0; i<=(listTheme.size()+1);i++){
            String a = "Thème : " + listTheme.get(i) + ", indicator : " + i + "\n";
            listThemes = listThemes + a;
        }
        return listThemes;
    }

    //GETTERS & SETTERS
    public ArrayList<String> getListTheme() {
        return listTheme;
    }
    public void setListTheme(ArrayList<String> listTheme) {
        this.listTheme = listTheme;
    }

    public ArrayList<Integer> getIndicator() {
        return indicator;
    }
    public void setIndicator(ArrayList<Integer> indicator) {
        this.indicator = indicator;
    }
}
