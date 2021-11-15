import java.util.List;
public class Question_RC extends Question {
    private String reponse;

    public Question_RC(int d, String description, String rep) {
        super(d, description);
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
        return super.toString()+ "\n La bonne réponse à la question est : " + this.reponse;
    }
}
