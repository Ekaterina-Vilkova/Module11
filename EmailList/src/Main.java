import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmailList emailList = new EmailList();
        System.out.println("Введите команду:");
        while (true) {
            String text = new Scanner(System.in).nextLine();

            String[] word = text.split("\s");
            if (word[0].equals("ADD")) {
                String[] withoutFirstWord = Arrays.copyOfRange(word, 1, word.length);
                String textWithoutFirstWord = Arrays.toString(withoutFirstWord).replaceAll("\\[|\\]|,", "");

                String regex = "([A-Za-z0-9]{1,}[\\-]{0,1}[A-Za-z0-9]{1,}[\\.]{0,1}[A-Za-z0-9]{1,})+@[A-Za-z]{4,}[\\.]{1}[A-Za-z]{2,4}";
                boolean formatText = textWithoutFirstWord.matches(regex);
                if (formatText == true) {
                    emailList.addNewEmail(textWithoutFirstWord);
                }
            }
            if (word.length == 1 && word[0].equals("LIST")) {
                emailList.listAllEmail();
            }
        }
    }
}