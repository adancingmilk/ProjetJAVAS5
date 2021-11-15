import java.util.InputMismatchException;
import java.util.Scanner;

public class Question_RC extends Question {
    private String reponse;

    public Question_RC(int d, String description, String type, int num, String rep) {
        super(d, description, type, num);
        this.reponse = rep;
    }
    public void saisir() {
        boolean valid = false;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Veuillez saisir la description de la question");
            String desc = sc.nextLine();
            if(desc != "") {
                this.setDescription(desc);
                while(!valid) {
                    Scanner rep = new Scanner(System.in);
                    System.out.println("Saisir la bonne réponse à la question");
                    String response = rep.nextLine();
                    if (response != ""){
                        valid = true;
                        this.reponse = response;
                    }
                }
            }
        }
        catch (InputMismatchException e){
            System.out.println("La réponse n'est pas valide");
            this.supprDescription();
        }

    }

    public void setReponse(String rep){
        this.reponse = rep;
    }
    public String getReponse(){
        return this.reponse;
    }
    @Override
    public String toString(){
        return super.toString() + "\n La bonne réponse de la question : " + this.reponse;
    }
}
