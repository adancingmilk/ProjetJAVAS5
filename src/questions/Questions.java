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
        //3. GÉOGRAPHIE
        Question geoQ1 = new Question_VF(1, "Le Portugal est un pays anglophone ?", "Géographie", 1, "F");
        String[] reps_geoQ2 = { "Europe", "Amérique", "Asie" };
        Question geoQ2 = new Question_QCM(1, "Sur quel continent se trouve la Colombie ?", "Géographie", 2, reps_geoQ2, "2");
        Question geoQ3 = new Question_RC(1, "Quel fleuve passe par Paris ?", "Géographie", 3, "Seine");
        Question geoQ4 = new Question_VF(2, "L'océan Pacifique est le plus grand océan ?", "Géographie", 4, "F");
        Question geoQ5 = new Question_RC(2, "Quel est le plus grand pays du monde ?", "Géographie", 5, "Russie");
        String[] reps_geoQ6 = { "5432", "4809", "8848" };
        Question geoQ6 = new Question_QCM(2, "Quelle est l'altitude du mont Everest (en m) ?", "Géographie", 6, reps_geoQ6, "3");
        Question geoQ7 = new Question_RC(2, "Quelle est la capital de l'australie ?", "Géographie", 7, "Canberra");
        Question geoQ8 = new Question_RC(3, "Comment le Malawi s'appelait en 1950 ?", "Géographie", 8, "Nyassaland");
        String[] reps_geoQ9 = { "540 000", "620 000", "510 000" };
        Question geoQ9 = new Question_QCM(3, "Quelle est la superficie de la France (en km) ?", "Géographie", 9, reps_geoQ9, "1");
        Question geoQ10 = new Question_VF(3, "Rovaniemi, la ville du Père noël se trouve en Norvège ?", "Géographie", 10, "F");

        addQuestion(geoQ1);
        addQuestion(geoQ2);
        addQuestion(geoQ3);
        addQuestion(geoQ4);
        addQuestion(geoQ5);
        addQuestion(geoQ6);
        addQuestion(geoQ7);
        addQuestion(geoQ8);
        addQuestion(geoQ9);
        addQuestion(geoQ10);

        //4. JEUX-VIDÉO
        //5. ANIMAUX
        //6. SPORT
        String[] reps_sportQ1 = { "Allemagne", "Brésil", "France" };
        Question sportQ1 = new Question_QCM(1, "Qui sont les champions du monde en titre (au foot) ?", "Sport", 1, reps_sportQ1, "3");
        Question sportQ2 = new Question_VF(1, "Il y a 4 anneaux olympiques ?", "Sport", 2, "F");
        Question sportQ3 = new Question_RC(1, "Quel est le record du 100m (en s) ?", "Sport", 3, "9.58");
        Question sportQ4 = new Question_VF(2, "Un match de handball dure 60 min ?", "Sport", 4, "V");
        String[] reps_sportQ5 = { "42", "45", "47" };
        Question sportQ5 = new Question_QCM(2, "Quelle est la distance d'un marathon (en km) ?", "Sport", 5, reps_sportQ5, "1");
        String[] reps_sportQ6 = { "baseball", "sumo", "Basket" };
        Question sportQ6 = new Question_QCM(2, "Quel est le sport national au Japon ?", "Sport", 6, reps_sportQ5, "2");
        Question sportQ7 = new Question_RC(2, "Combien de Grands chelems Roger Federer possede-t-il ?", "Sport", 7, "20");
        Question sportQ8 = new Question_RC(3, "Quel est le seul pays d’Amérique du Sud qui accueille un Grand Prix de Formule 1 ? ?", "Sport", 8, "Brésil");
        String[] reps_sportQ9 = { "1992", "1976", "1984" };
        Question sportQ9 = new Question_QCM(3, "En quelle année le badminton est devenu une discipline olympique ?", "Sport", 9, reps_sportQ5, "1");
        Question sportQ10 = new Question_VF(3, "Le plus long match de baseball a duré 7h20 ?", "Sport", 10, "V");

        addQuestion(sportQ1);
        addQuestion(sportQ2);
        addQuestion(sportQ3);
        addQuestion(sportQ4);
        addQuestion(sportQ5);
        addQuestion(sportQ6);
        addQuestion(sportQ7);
        addQuestion(sportQ8);
        addQuestion(sportQ9);
        addQuestion(sportQ10);
        //7. LA LANGUE FRANÇAISE
        //8. CULTURE JAPONAISE
        String[] reps_JapQ1 = { "Osaka", "Tokyo", "Shibuya" };
        Question JapQ1 = new Question_QCM(1, "Quelle est la capitale du Japon ?", "Culture_Japonaise", 1, reps_JapQ1, "2");
        Question JapQ2 = new Question_VF(1, "Le Japon est en Europe ?", "Culture_Japonaise", 2, "F");
        Question JapQ3 = new Question_RC(1, "Quelle est la monnaie au Japon ?", "Culture_Japonaise", 3, "Yen");
        Question JapQ4 = new Question_VF(2, "Les Japonais utilisent des kanjis ?", "Culture_Japonaise", 4, "V");
        String[] reps_JapQ5 = { "4", "5", "7" };
        Question JapQ5 = new Question_QCM(2, "Quelle est la durée de la golden week au Japon (en jours) ?", "Culture_Japonaise", 5, reps_JapQ5, "1");
        String[] reps_JapQ6 = { "Oni", "Yokai", "Akuma" };
        Question JapQ6 = new Question_QCM(2, "Quelle est le nom donné aux esprits au Japon ?", "Culture_Japonaise", 6, reps_JapQ5, "2");
        Question JapQ7 = new Question_RC(2, "En quelle année se sont déroulés les Jeux-Olympiques au Japon ?", "Culture_Japonaise", 7, "2021");
        Question JapQ8 = new Question_RC(3, "Par qui Jiraiya s'est-il fait mordre dans son conte ?", "Culture_Japonaise", 8, "Orochimaru");
        String[] reps_JapQ9 = { "Kendo", "Hojojutsu", "Kyudo" };
        Question JapQ9 = new Question_QCM(3, "Quelle est le nom de la pratique de l'arc au Japon ?", "Culture_Japonaise", 9, reps_JapQ5, "3");
        Question JapQ10 = new Question_VF(3, "Le titre de l'hymne japonias est : Kimi ga yo ?", "Culture_Japonaise", 10, "V");


        addQuestion(JapQ1);
        addQuestion(JapQ2);
        addQuestion(JapQ3);
        addQuestion(JapQ4);
        addQuestion(JapQ5);
        addQuestion(JapQ6);
        addQuestion(JapQ7);
        addQuestion(JapQ8);
        addQuestion(JapQ9);
        addQuestion(JapQ10);
        //9. NOURRITURE
        String[] reps_nourQ1 = { "yaourt", "fromage", "carotte" };
        Question nourQ1 = new Question_QCM(1, "Qui n'est pas un produit laitier ?", "nourriture", 1, reps_sportQ1, "3");
        Question nourQ2 = new Question_VF(1, "Le sushi est un plat Japonais ?", "nourriture", 2, "V");
        Question nourQ3 = new Question_RC(1, "Quelle est la nourriture préférée d'Obelix ?", "nourriture", 3, "Sanglier");
        Question nourQ4 = new Question_VF(2, "Le caviar provient du Thon ?", "nourriture", 4, "F");
        String[] reps_nourQ5 = { "échelle de scoville", "échelle de richter", "double décimètre" };
        Question nourQ5 = new Question_QCM(2, "Comment mesure-t-on la force d'un piment ?", "nourriture", 5, reps_sportQ5, "1");
        Question nourQ6 = new Question_VF(2, "Le sucre a une durée de conservation infinie ?", "nourriture", 6, "V");
        Question nourQ7 = new Question_RC(2, "Quel est l'ingrédient principal du guacamole ?", "nourriture", 7, "Avocat");
        Question nourQ8 = new Question_RC(3, "Quel est le terme qui désigne le fait de saupoudrer de farine ?", "nourriture", 8, "Singer");
        String[] reps_nourQ9 = { "30", "35", "40" };
        Question nourQ9 = new Question_QCM(3, "Quel est le diamètre idéal d'une pizza ?", "nourriture", 9, reps_sportQ5, "1");
        Question nourQ10 = new Question_VF(3, "L’arachibutyrophobie désigne la peur du beurre d’arachide. ?", "nourriture", 10, "V");

        addQuestion(nourQ1);
        addQuestion(nourQ2);
        addQuestion(nourQ3);
        addQuestion(nourQ4);
        addQuestion(nourQ5);
        addQuestion(nourQ6);
        addQuestion(nourQ7);
        addQuestion(nourQ8);
        addQuestion(nourQ9);
        addQuestion(nourQ10);
        //10.INFORMATIQUE
        String[] reps_infoQ1 = { "HTML", "Java", "python" };
        Question infoQ1 = new Question_QCM(1, "Quel est le langage utilisé pour créer un site web ?", "informatique", 1, reps_sportQ1, "1");
        Question infoQ2 = new Question_VF(1, "On utilise un navigateur pour aller sur internet ?", "informatique", 2, "V");
        Question infoQ3 = new Question_RC(1, "Quel est l'élément le plus important d'un ordinateur ?", "informatique", 3, "Processeur");
        Question infoQ4 = new Question_VF(2, "On utilise l'USB pour se connecter à internet ?", "informatique", 4, "F");
        String[] reps_infoQ5 = { "IP", "MAC", "mail" };
        Question infoQ5 = new Question_QCM(2, "Avec quelle adresse vérifie-t-on qu'un ordianateur est connecté à internet ?", "informatique", 5, reps_sportQ5, "1");
        Question infoQ6 = new Question_VF(2, "Un return affiche le résultat dans la console ?", "informatique", 6, "F");
        Question infoQ7 = new Question_RC(2, "Comment traduire tant que ?", "informatique", 7, "while");
        Question infoQ8 = new Question_RC(3, "Qui est le créateur de Java ?", "informatique", 8, "James Gosling");
        String[] reps_infoQ9 = { "apprendre", "donner", "réutiliser" };
        Question infoQ9 = new Question_QCM(3, "Qu'est ce que l'héritage ?", "informatique", 9, reps_sportQ5, "3");
        Question infoQ10 = new Question_VF(3, "Les package java.nio2 existe ?", "informatique", 10, "F");

        addQuestion(infoQ1);
        addQuestion(infoQ2);
        addQuestion(infoQ3);
        addQuestion(infoQ4);
        addQuestion(infoQ5);
        addQuestion(infoQ6);
        addQuestion(infoQ7);
        addQuestion(infoQ8);
        addQuestion(infoQ9);
        addQuestion(infoQ10);
        //2. HISTOIRE
        //4. JEUX-VIDÉO
        //5. ANIMAUX
        //7. LA LANGUE FRANÇAISE
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

