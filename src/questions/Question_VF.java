package questions;
public class Question_VF extends Question {
    private String reponse;

    protected Question_VF(int d, String description, String type, int num, String rep) {
        super(d, description, type, num);
        this.reponse = rep;
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
