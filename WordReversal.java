import java.util.Scanner;
import javax.swing.JOptionPane;

public class WordReversal {

    public static String getPhrase(Scanner k) {
        System.out.print("May I please have the phrase you would like backwards: ");
        return k.nextLine();
    }

    public static String reversePhrase(String userPhrase) {
        String userPhraseBackwards = "", punctuation = "";
        String[] brokenUpPhrase = userPhrase.split(" ");

        punctuation = userPhrase.substring(userPhrase.length() - 1, userPhrase.length());

        for (int i = brokenUpPhrase.length - 1; i > -1; i--) {

            // Uppercase the last word
            if (i == brokenUpPhrase.length - 1) {
                brokenUpPhrase[i] = brokenUpPhrase[i].substring(0, 1).toUpperCase()
                        + brokenUpPhrase[i].substring(1, brokenUpPhrase[i].length() - 1);

                if (!(punctuation.equals("!") || punctuation.equals("?") || punctuation.equals(".")))
                    brokenUpPhrase[i] += punctuation;

                // Lowercase the last word
            } else if (i == 0) {
                brokenUpPhrase[i] = brokenUpPhrase[i].toLowerCase();

                if (punctuation.equals("!") || punctuation.equals("?") || punctuation.equals("."))
                    brokenUpPhrase[i] += punctuation;
            }

            userPhraseBackwards += brokenUpPhrase[i] + " ";
        }

        return userPhraseBackwards;
    }

    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        String userPhrase;

        userPhrase = getPhrase(k);

        System.out.println(reversePhrase(userPhrase));
        k.close();
    }
}