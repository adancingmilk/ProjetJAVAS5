import java.util.ArrayList;
import java.util.Random;

public class Questions {
    private ArrayList<Question> listQuestions;

    public Questions(ArrayList<Question> listQuestions){
        this.listQuestions = listQuestions;
    }
    public Questions(){
        this.listQuestions = new ArrayList<Question>();
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
        Random rand = new Random();
        int randomIndex = rand.nextInt(listIndice.size());
        return listQuestions.get(randomIndex);
    }
}

