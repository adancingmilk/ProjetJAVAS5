package questions;

import themes.Theme;

public class Question_VF extends Question {
    private String reponse;

    public Question_VF(int d, String description, String nomTheme, int num, String rep) {
        super(d, description, nomTheme, num);
        this.reponse = rep;
    }
    @Override
    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
