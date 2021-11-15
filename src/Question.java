public abstract class Question {
    protected int difficulte;
    protected String description;

    protected Question(int d, String description){
        this.difficulte = d;
        this.description = description;
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
        return "Difficulté de la question : " + this.difficulte + "\n Question : " + this.description;
    }
}
