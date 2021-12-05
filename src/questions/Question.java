package questions;

public abstract class Question {
    protected int difficulte;
    protected String description;
    protected String type;
    protected int num;


    protected Question(int d, String description, String type, int num){
        this.difficulte = d;
        this.description = description;
        this.type = type;
        this.num = num;
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
        this.type = type;
    }
    public String getType(){
        return this.type;
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
                + "\n Numéro de la question : " + this.num + "\n Type de la question : " + this.type;
    }
}
