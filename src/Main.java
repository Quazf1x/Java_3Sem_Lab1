import java.util.InputMismatchException;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        String text;
        char sym;
        int k;
        while(true) {
            Scanner sc = new Scanner(System.in);
            try {
                System.out.println("Введите текст.");
                text = sc.nextLine();
                System.out.println("Каким символом будут заменяться буквы?");
                sym = sc.next().charAt(0);
                System.out.println("Замена будет происходить на k букве, где k = ");
                k = sc.nextInt();
                break;
            } catch(InputMismatchException fg) {
                System.out.println("Неправильный тип данных." );
            }

        }

        String newWords = replaceSymbol(text, sym, k);
        System.out.println("Новый текст:");
        System.out.println(newWords);
    }

    public static String replaceSymbol(String text,char symbol,int k) {
        String[] words = text.split("\\s+");
        String[] newWords = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() >= k) {
                newWords[i] = word.substring(0, k - 1) + symbol + word.substring(k);
            } else {
                newWords[i] = word;
            }
        }
        return  String.join(" ", newWords);
    }
}