import java.util.ArrayList;
import java.util.Scanner;
public class Themes {

    protected ArrayList<String> listTheme;     // The list of the themes
    protected ArrayList<Integer> indicator;    // Position, indicator of each theme

    public Themes(ArrayList<String> listTheme){
        this.listTheme = listTheme;
    }



    public ArrayList<String> getListTheme() {
        return listTheme;
    }

    public ArrayList<Integer> getIndicator() {
        return indicator;
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

    public String toString(){
       String listThemes = "";
        for (int i = 0; i<=(listTheme.size()+1);i++){
            String a = "Thème : " + listTheme.get(i) + ", indicator : " + i + "\n";
            listThemes = listThemes + a;
        }
        return listThemes;
    }


}
