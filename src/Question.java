public abstract class Question {
    protected int difficulte;
    protected String description;
    protected String reponse;
    protected String type;

    protected Question(int d, String description, String reponse, String type){
        this.difficulte = d;
        this.description = description;
        this.reponse = reponse;
        this.type = type;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setReponse(String rep){
        this.reponse = rep;
    }
    public String getReponse(){
        return this.reponse;
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
        return "Difficulté de la question : " + this.difficulte + "\n Question : " + this.description
                + "\n La bonne réponse à la question est : " + this.reponse;
    }
}
