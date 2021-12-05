import java.util.List;

public class Jeu {
    public static void main(String[] args) {
        Question Q1 = new Question_RC(1,"1+1=2","Math",1, "Vrai");
        Questions listQ = new Questions();
        listQ.addQuestion(Q1);
        System.out.println(listQ.selectQuestion(1));
    }
}
