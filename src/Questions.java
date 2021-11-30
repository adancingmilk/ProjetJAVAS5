import java.util.List;
public class Questions {
    private List<Question> listQuestions;

    public Questions(List<Question> listQuestions){
        this.listQuestions = listQuestions;
    }
    public void addQuestion(Question Q){
        this.listQuestions.add(Q);
    }
    public void supprQuestion(int num){
        this.listQuestions.remove(num);
    }

}
