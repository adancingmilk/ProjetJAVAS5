package questions;

import themes.Theme;

public abstract class Question {
    protected int difficulte;
    protected String description;
    protected final Theme theme;
    protected int num;
    protected String reponse;
    protected String[] reponses;

    protected Question(int difficulte, String description, String nomTheme, int num, String reponse){
        this.difficulte = difficulte;
        this.description = description;
        this.theme = new Theme(nomTheme);
        this.num = num;
        this.reponse = reponse;
    }

    protected Question(){
        this(0,"", "",0,"");
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

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public String getReponse() {
        return reponse;
    }

    public String[] getReponses() {
        return reponses;
    }

    public void setReponses(String[] reponses) {
        this.reponses = reponses;
    }

    public Theme getTheme() {
        return theme;
    }

    @Override
    public String toString() {
        return "Difficulté de la question : " + this.difficulte + "\n questions.Question : " + this.description
                + "\n Numéro de la question : " + this.num + "\n Type de la question : " + this.theme + "\n La réponse à la question est : " + this.reponse;
    }
}
