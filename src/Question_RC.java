public class Question_RC extends Question {
    private String reponse;

    public Question_RC(int d, String description, String type, int num, String rep) {
        super(d, description, type, num);
        this.reponse = rep;
    }

    public void setReponse(String rep){
        this.reponse = rep;
    }
    public String getReponse(){
        return this.reponse;
    }
    @Override
    public String toString(){
        return super.toString() + "\n La bonne réponse de la question : " + this.reponse;
    }
}
