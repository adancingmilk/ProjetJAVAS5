package questions;

public class Question_RC extends Question {
    private String reponse;

    public Question_RC(int d, String description, String type, int num, String rep) {
        super(d, description, type, num);
        this.reponse = rep;
    }
    public Question_RC(){
        super();
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }
    @Override
    public String getReponse() {
        return reponse;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
