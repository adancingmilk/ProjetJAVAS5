package questions;

import themes.Theme;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Questions implements Iterable<Question> {
    private List<Question> questions;

    public Questions(ArrayList<Question> listQuestions){
        this.questions = listQuestions;
    }
    public Questions(){
        this.questions = new ArrayList<>();
    }
    public void add(Question Q){
        this.questions.add(Q);
    }

    public void remove(int num){
        this.questions.remove(num);
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

        add(mathQ1);
        add(mathQ2);
        add(mathQ3);
        add(mathQ4);
        add(mathQ5);
        add(mathQ6);
        add(mathQ7);
        add(mathQ8);
        add(mathQ9);
        add(mathQ10);

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

        add(histQ1);
        add(histQ2);
        add(histQ3);
        add(histQ4);
        add(histQ5);
        add(histQ6);
        add(histQ7);
        add(histQ8);
        add(histQ9);
        add(histQ10);
        //2. ANIME

        //3. GÉOGRAPHIE
        Question geoQ1 = new Question_VF(1, "Le Portugal est un pays anglophone ?", "Géographie", 1, "F");
        String[] reps_geoQ2 = { "Europe", "Amérique", "Asie" };
        Question geoQ2 = new Question_QCM(1, "Sur quel continent se trouve la Colombie ?", "Géographie", 2, reps_geoQ2, "2");
        Question geoQ3 = new Question_RC(1, "Quel fleuve passe par Paris ?", "Géographie", 3, "Seine");
        Question geoQ4 = new Question_VF(2, "L'océan Pacifique est le plus grand océan ?", "Géographie", 4, "F");
        Question geoQ5 = new Question_RC(2, "Quel est le plus grand pays du monde ?", "Géographie", 5, "Russie");
        String[] reps_geoQ6 = { "5432", "4809", "8848" };
        Question geoQ6 = new Question_QCM(2, "Quelle est l'altitude du mont Everest (en m) ?", "Géographie", 6, reps_geoQ6, "3");
        Question geoQ7 = new Question_RC(2, "Quelle est la capitale de l'australie ?", "Géographie", 7, "Canberra");
        Question geoQ8 = new Question_RC(3, "Comment le Malawi s'appelait en 1950 ?", "Géographie", 8, "Nyassaland");
        String[] reps_geoQ9 = { "540 000", "620 000", "510 000" };
        Question geoQ9 = new Question_QCM(3, "Quelle est la superficie de la France (en km) ?", "Géographie", 9, reps_geoQ9, "1");
        Question geoQ10 = new Question_VF(3, "Rovaniemi, la ville du Père noël se trouve en Norvège ?", "Géographie", 10, "F");

        add(geoQ1);
        add(geoQ2);
        add(geoQ3);
        add(geoQ4);
        add(geoQ5);
        add(geoQ6);
        add(geoQ7);
        add(geoQ8);
        add(geoQ9);
        add(geoQ10);

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

        add(jvQ1);
        add(jvQ2);
        add(jvQ3);
        add(jvQ4);
        add(jvQ5);
        add(jvQ6);
        add(jvQ7);
        add(jvQ8);
        add(jvQ9);
        add(jvQ10);

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

        add(animauxQ1);
        add(animauxQ2);
        add(animauxQ3);
        add(animauxQ4);
        add(animauxQ5);
        add(animauxQ6);
        add(animauxQ7);
        add(animauxQ8);
        add(animauxQ9);
        add(animauxQ10);

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

        add(sportQ1);
        add(sportQ2);
        add(sportQ3);
        add(sportQ4);
        add(sportQ5);
        add(sportQ6);
        add(sportQ7);
        add(sportQ8);
        add(sportQ9);
        add(sportQ10);
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

        add(frQ1);
        add(frQ2);
        add(frQ3);
        add(frQ4);
        add(frQ5);
        add(frQ6);
        add(frQ7);
        add(frQ8);
        add(frQ9);
        add(frQ10);
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


        add(JapQ1);
        add(JapQ2);
        add(JapQ3);
        add(JapQ4);
        add(JapQ5);
        add(JapQ6);
        add(JapQ7);
        add(JapQ8);
        add(JapQ9);
        add(JapQ10);
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

        add(nourQ1);
        add(nourQ2);
        add(nourQ3);
        add(nourQ4);
        add(nourQ5);
        add(nourQ6);
        add(nourQ7);
        add(nourQ8);
        add(nourQ9);
        add(nourQ10);
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

        add(infoQ1);
        add(infoQ2);
        add(infoQ3);
        add(infoQ4);
        add(infoQ5);
        add(infoQ6);
        add(infoQ7);
        add(infoQ8);
        add(infoQ9);
        add(infoQ10);
    }

    public Question selectQuestion(int difficulte){
        List<Integer> listIndice = new ArrayList<Integer>();

        for(int i = 0; i < questions.size(); i++){
            if(questions.get(i).getDifficulte() == difficulte){
                listIndice.add(i);
            }
        }
        Random rand = new Random();
        int randomIndex = rand.nextInt(listIndice.size());
        return questions.get(randomIndex);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    //Retourne une liste contenant les questions d'un thème en particulier
    public Questions getQuestionsTheme(Theme theme) {
        Questions questionsTheme = new Questions();
        for(Question q : questions) {
            if(q.theme.equals(theme))
                questionsTheme.add(q);
        }

        return questionsTheme;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    //Méthode permettant de faire une boucle directement sur la classe Questions au lieu de passer par un compromis hideux
    @Override
    public Iterator<Question> iterator() {
        return questions.iterator();
    }
}

