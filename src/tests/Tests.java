package tests;

import questions.*;

//Classe de tests
public class Tests {
    public static void main(String[] args) {
        System.out.println("TESTS DES DIFFÉRENTES FONCTIONS");
        //Création de différentes questions
        Question mathQ5 = new Question_RC(2, "Qui est à l'origine de la loi de Gravitation ?", "Mathématiques", 1, "Newton");
        Question mathQ6 = new Question_VF(2, "Robert May est l'auteur de la théorie du chaos", "Mathématiques", 2, "V");
        String[] reps_mathQ7 = { "Dijkstra", "Pythagore", "Warshall" };
        Question mathQ7 = new Question_QCM(2, "Quel algorithme permet de trouver le plus court chemin d'un graphe ?", "Mathématiques", 3, reps_mathQ7, "1");

        //Cération d'un ensemble de questions
        Questions questions = new Questions();
        questions.add(mathQ5);
        questions.add(mathQ6);
        questions.add(mathQ7);

        System.out.println("AFFICHAGE DES QUESTIONS CRÉÉES");
        for(Question q : questions) {
            System.out.println(q);
            System.out.println();
        }
    }
}
