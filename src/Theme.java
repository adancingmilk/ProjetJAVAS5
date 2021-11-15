import java.util.ArrayList;
import java.util.Scanner;
public class Theme {

    protected ArrayList<String> listTheme;
    protected int indicator;

    public Theme(ArrayList<String> listTheme){
        this.listTheme = listTheme;
    }

    public int selectTheme(String theme){
        if (!listTheme.contains(theme)){
            System.out.println("Theme isn't in the list");
            return -1;
        }
        else{
            return listTheme.indexOf(theme);
        }
    }

    public ArrayList<String> selectFiveTheme(int theme1, int theme2, int theme3, int theme4, int theme5){
        ArrayList<String> themes = new ArrayList<String>();
        themes.add(listTheme.get(theme1));
        themes.add(listTheme.get(theme2));
        themes.add(listTheme.get(theme3));
        themes.add(listTheme.get(theme4));
        themes.add(listTheme.get(theme5));
        return themes;
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
