import java.util.ArrayList;
import java.util.Scanner;
public class Theme {

    protected ArrayList<String> listTheme;
    protected ArrayList<Integer> indicator;

    public Theme(ArrayList<String> listTheme,ArrayList<Integer> indicator, int phase){
        switch(phase){

            case 1:
                this.listTheme = listTheme;
                break;

            case 2:
                this.listTheme = listTheme;
                for (int i = 0; i<= indicator.size(); i++){
                    listTheme.remove(listTheme.get(indicator.get(i)));
                }

            case 3:
                this.listTheme = listTheme;
                for (int i = 0; i<= indicator.size(); i++){
                    listTheme.remove(listTheme.get(indicator.get(i)));
                }
        }
    }

    public Theme(ArrayList<String> listTheme){
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
        reader.close();
        if (!listTheme.contains(theme)){
            System.out.println("Theme isn't in the list");
            return -1;
        }
        else{
            this.indicator.add(listTheme.indexOf(theme));
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
        this.indicator.add(theme1);
        this.indicator.add(theme2);
        this.indicator.add(theme3);
        this.indicator.add(theme4);
        this.indicator.add(theme5);

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
