package questions;

public abstract class Question {
    protected int difficulte;
    protected String description;
    protected String theme;
    protected int num;


    protected Question(int difficulte, String description, String theme, int num){
        this.difficulte = difficulte;
        this.description = description;
        this.theme = theme;
        this.num = num;
    }
    protected Question(){
        this(0,"","",0);
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
    public void setType(String type){
        this.theme = type;
    }
    public String getType(){
        return this.theme;
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
    @Override
    public String toString() {
        return "Difficulté de la question : " + this.difficulte + "\n questions.Question : " + this.description
                + "\n Numéro de la question : " + this.num + "\n Type de la question : " + this.theme;
    }
}
