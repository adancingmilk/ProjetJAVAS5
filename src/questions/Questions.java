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
        Question mathQ2 = new Question_QCM(1, "Quelle est (environ) la valeur du nombre PI ?", "Mathématiques", 2, reps_mathQ2, "3");
        String[] reps_mathQ3 = { "A^3 + B^3 = C^3", "A^2 + B^2 = C^2", "A^2 + B^2 + C^2 = D^2" };
        Question mathQ3 = new Question_QCM(1, "Quelle est la formule correcte du théorème de pythagore ?", "Mathématiques", 3, reps_mathQ3, "2");
        Question mathQ4 = new Question_RC(2, "À quel nombre est liée la suite de Fibonacci ?", "Mathématiques", 4, "Nombre d'or");
        Question mathQ5 = new Question_RC(2, "Qui est à l'origine de la loi de Gravitation ?", "Mathématiques", 5, "Newton");
        Question mathQ6 = new Question_VF(2, "Robert May est l'auteur de la théorie du chaos", "Mathématiques", 6, "V");
        String[] reps_mathQ7 = { "Dijkstra", "Pythagore", "Warshall" };
        Question mathQ7 = new Question_QCM(2, "Quel algorithme permet de trouver le plus court chemin d'un graphe ?", "Mathématiques", 7, reps_mathQ7, "1");
        Question mathQ8 = new Question_RC(3, "Comment s'appelle le symbole de la division ?", "Mathématiques", 8, "Obélus");
        String[] reps_mathQ9 = { "John Napier", "Robert May", "Claude Shannon" };
        Question mathQ9 = new Question_QCM(3, "Qui a popularisé les logarithmes ?", "Mathématiques", 9, reps_mathQ9, "1");
        Question mathQ10 = new Question_VF(3, "René Descartes fut né le 13 Mars 1595", "Mathématiques", 10, "F");

        addQuestion(mathQ1);
        addQuestion(mathQ2);
        addQuestion(mathQ3);
        addQuestion(mathQ4);
        addQuestion(mathQ5);
        addQuestion(mathQ6);
        addQuestion(mathQ7);
        addQuestion(mathQ8);
        addQuestion(mathQ9);
        addQuestion(mathQ10);
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

    public ArrayList<Question> getListQuestions() {
        return listQuestions;
    }

    public void setListQuestions(ArrayList<Question> listQuestions) {
        this.listQuestions = listQuestions;
    }

}

