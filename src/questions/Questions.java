package questions;

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

    //Génère 10 questions (3 faciles, 4 moyennes, 3 difficiles) par thème
    public void genererQuestions() {
        //1. THÈME MATHÉMATIQUES
        Question mathQ1 = new Question_VF(1, "1+1=2 ?", "Mathématiques", 1, "V");
        String[] reps_mathQ2 = { "3.15", "3.13", "3.14" };
        Question mathQ2 = new Question_QCM(1, "Quelle est (environ) la valeur du nombre PI ?", "Mathématiques", 2, reps_mathQ2, 3);
        //2. HISTOIRE
        //3. GÉOGRAPHIE
        //4. JEUX-VIDÉO
        //5. ANIMAUX
        //6. SPORT
        //7. LA LANGUE FRANÇAISE
        //8. CULTURE JAPONAISE
        //9. NOURRITURE
        //10.INFORMATIQUE
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

