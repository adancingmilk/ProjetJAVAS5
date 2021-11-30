import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public Question selectQuestion(int difficulte){
        ArrayList<Integer> listIndice = new ArrayList<Integer>();

        for(int i = 0; i < listQuestions.size(); i++){
            if(listQuestions.get(i).getDifficulte() == difficulte){
                listIndice.add(i);
            }
        }
        int randomIndex = (int) (Math.random() * (listIndice.size() - 0 + 1 ) + 0);
        return listQuestions.get(randomIndex);
    }
}

