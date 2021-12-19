package questions;

import themes.Theme;

public abstract class Question {
    protected int difficulte;
    protected String description;
    protected final Theme theme;
    protected int num;

    protected Question(int difficulte, String description, String nomTheme, int num){
        this.difficulte = difficulte;
        this.description = description;
        this.theme = new Theme(nomTheme);
        this.num = num;
    }

    protected Question(){
        this(0,"", "",0);
    }
    public void supprDescription(){
        this.description = "";
    }
    public void setNum(int num){
        this.num = num;
    }
    public int getNum(){
        return this.num;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public int getDifficulte(){
        return this.difficulte;
    }
    public void setDifficulte(int d){
        this.difficulte = d;
    }

    public String getReponse(){
        return "";
    }

    public Theme getTheme() {
        return theme;
    }

    @Override
    public String toString() {
        return "Difficulté de la question : " + this.difficulte + "\n questions.Question : " + this.description
                + "\n Numéro de la question : " + this.num + "\n Type de la question : " + this.theme;
    }
}
