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

        Question histQ1 = new Question_RC(1,"En quelle année a débuté la 1ère guerre mondiale","Histoire",1,"1914");
        Question histQ2 = new Question_VF(1,"Les gaulois mangeaient du sanglier", "Histoire", 2, "F");
        Question histQ3 = new Question_VF(1,"Les pyramides ont été construites après l'époque de la renaissance", "Histoire", 3, "F");
        Question histQ4 = new Question_RC(2, "De quelle période historique date le mythe du chat noir (Voir un chat noir porte malheur)", "Histoire", 4, "Moyen-âge");
        String[] reps_histQ5 = { "1789", "1935", "1614" };
        Question histQ5 = new Question_QCM(2,"Quand a eu lieu la grande révolution française ?", "Histoire", 5, reps_histQ5,"1");
        Question histQ6 = new Question_RC(2,"Combien d'années a duré la guerre de cent ans ?","Histoire",6,"116");
        Question histQ7 = new Question_RC(2, "Dans quelle période la peste noire a-t-elle frappé ?","Histoire",7,"Moyen-âge");
        String[] reps_histQ8 = { "Bataille de Waterloo", "Guerre de sécession", "Seconde guerre mondiale" };
        Question histQ8 = new Question_QCM(3, "De quelle guerre/bataille provient le terme : OK ?",  "Histoire",8,reps_histQ8,"2");
        Question histQ9 = new Question_RC(3,"Comment l'Egypte s'appelait elle ?","Histoire",9,"Taouy");
        Question histQ10 = new Question_VF(3,"Le chien de Napoléon Bonaparte s'appelait Milou", "Histoire", 10, "V");

        addQuestion(histQ1);
        addQuestion(histQ2);
        addQuestion(histQ3);
        addQuestion(histQ4);
        addQuestion(histQ5);
        addQuestion(histQ6);
        addQuestion(histQ7);
        addQuestion(histQ8);
        addQuestion(histQ9);
        addQuestion(histQ10);

        //3. GÉOGRAPHIE
        //4. JEUX-VIDÉO
        Question jvQ1 = new Question_RC(1,"Quel est le nom du fameux personnage de nintendo effectuant le métier de plombier et ayant une moustanche et des habits rouges et bleus?","Jeux-Vidéo",1,"Mario");
        Question jvQ2 = new Question_RC(1,"Comment s'appelle le hérisson bleu de SEGA ?","Jeux-Vidéo",2,"Sonic");
        Question jvQ3 = new Question_VF(1,"Bowser est l'ennemi juré de Sonic","Jeux-Vidéo",3,"F");
        String[] reps_jvQ4 = {"Potali","Eclali","Noctali"};
        Question jvQ4 = new Question_QCM(2,"Parmi ces noms, lequel est une des évolutions d'évoli ?","Jeux-Vidéos",4,reps_jvQ4, "3");
        String[] reps_jvQ5 = {"1970","1965","1984"};
        Question jvQ5 = new Question_QCM(2,"En quelle année les premières bornes d'arcades ont été installées ?","Jeux-Vidéos",5,reps_jvQ5, "1");
        Question jvQ6 = new Question_VF(2,"Les premiers jeux vidéos sur téléphones mobiles sont sortis en 1997","Jeux-Vidéo",6,"F");
        Question jvQ7 = new Question_VF(2,"La gameboy a été inventée en 1989","Jeux-Vidéo",7,"V");
        String[] reps_jvQ8 = {"2008","1995","1853"};
        Question jvQ8 = new Question_QCM(3,"Quand le premier jeu en 3D sur PlayStation est-il édité ?","Jeux-Vidéos",8,reps_jvQ8, "2");
        Question jvQ9 = new Question_RC(3,"Dans quel pays les jeux vidéos sont-ils installés sur des machines en premier ","Jeux-Vidéo",9,"Etats-Unis");
        Question jvQ10 = new Question_RC(3,"En quelle année le premier jeu vidéo a-t-il été créé ?","Jeux-Vidéo",10,"1962");

        addQuestion(jvQ1);
        addQuestion(jvQ2);
        addQuestion(jvQ3);
        addQuestion(jvQ4);
        addQuestion(jvQ5);
        addQuestion(jvQ6);
        addQuestion(jvQ7);
        addQuestion(jvQ8);
        addQuestion(jvQ9);
        addQuestion(jvQ10);

        //5. ANIMAUX

        Question animauxQ1 = new Question_RC(1,"Combien de pattes a une araignée","Animaux",1,"8");
        Question animauxQ2 = new Question_RC(1,"Quel animal a le plus grand cou","Animaux",2,"Girafe");
        String[] reps_animauxQ3 = {"Il sait voler","il entend les insectes sous le sable","il a besoin d'énormément d'eau"};
        Question animauxQ3 = new Question_QCM(1,"Quelle est la particularité du fennec ?","Animaux",3,reps_animauxQ3, "2");
        String[] reps_animauxQ4 ={"60","100","200"};
        Question animauxQ4 = new Question_QCM(2,"Jusqu'à combien de fois la sauterelle peut-elle sauter sa taille ?","Animaux",4,reps_animauxQ4, "3");
        Question animauxQ5 = new Question_VF(2,"Certains nids de termites atteignent 5m de hauteur.","Animaux",5,"V");
        Question animauxQ6 = new Question_VF(2,"L'éléphant peut entendre avec ses pattes","Animaux",6,"V");
        String[] reps_animauxQ7 ={"Orque","Espadon","Dauphin"};
        Question animauxQ7 = new Question_QCM(2,"Quel est l'animal le plus rapide dans l'eau ?","Animaux",7,reps_animauxQ7,"2");
        Question animauxQ8 = new Question_VF(3,"La bécasse d'amérique est l'oiseau le plus lent du monde", "Animaux",8,"V");
        Question animauxQ9 = new Question_RC(3, "Quel est l'angle de vision d'un lapin ?","Animaux", 9,"340°");
        String[] reps_animauxQ10 = {"2cm","25cm","55cm"};
        Question animauxQ10 = new Question_QCM(3,"Quelle est la taille d'un bébé kangourou lors de sa naissance ?","Animaux",10,reps_animauxQ10, "1");

        addQuestion(animauxQ1);
        addQuestion(animauxQ2);
        addQuestion(animauxQ3);
        addQuestion(animauxQ4);
        addQuestion(animauxQ5);
        addQuestion(animauxQ6);
        addQuestion(animauxQ7);
        addQuestion(animauxQ8);
        addQuestion(animauxQ9);
        addQuestion(animauxQ10);

        //6. SPORT
        //7. LA LANGUE FRANÇAISE
        Question frQ1 = new Question_RC(1,"Quel est le pronom personnel sujet de la 2ème personne du singulier","La langue française",1,"tu");
        Question frQ2 = new Question_VF(1 , "Ils croivent est la conjugaison correcte du verbe croire à la 3eme personne du pluriel","La langue française", 2,"F");
        Question frQ3 = new Question_RC(1, "Conjuguer le verbe aimer à la 2eme personne du pluriel","La langue française", 3,"Vous aimez");
        Question frQ4 = new Question_RC(2,"De combien de manière peut-on prononcer la lettre s ?","La langue française",4,"3");
        Question frQ5 = new Question_VF(2, "On peut écrire le son phonétique 's' de 12 manières différents","La langue française", 5 , "V");
        String[] reps_frQ6 = {"Paris","Limoges","Rennes"};
        Question frQ6 = new Question_QCM(2,"Dans quelle ville est né Molière ?","La langue française",6,reps_frQ6,"1");
        Question frQ7 = new Question_VF(2,"Il est correct de dire 'Des balles rouges vives","La langue française, ", 7, "F");
        Question frQ8 = new Question_VF(3, "Des fois et parfois sont synonymes","La langue française", 8 , "F");
        String[] reps_frQ9 = {"J,R,P","J,K,V","L,W,C"};
        Question frQ9 = new Question_QCM(3,"Dans quelle ville est né Molière ?","La langue française",9,reps_frQ9,"2");
        Question frQ10 = new Question_VF(3 ,"Il est correct de dire : Après qu'il soit parti","La langue française",10,"F");

        addQuestion(frQ1);
        addQuestion(frQ2);
        addQuestion(frQ3);
        addQuestion(frQ4);
        addQuestion(frQ5);
        addQuestion(frQ6);
        addQuestion(frQ7);
        addQuestion(frQ8);
        addQuestion(frQ9);
        addQuestion(frQ10);

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

