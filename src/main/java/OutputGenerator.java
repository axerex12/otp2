import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class OutputGenerator {
    public void generateOutput(String languageCode) {
        Scanner sc = new Scanner(System.in);
        Locale locale = new Locale(languageCode);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.MessagesBundle", locale);
        System.out.println(resourceBundle.getString("apples"));
        int apples = sc.nextInt();
        System.out.println(resourceBundle.getString("apples2"));
        double applesPrice = sc.nextDouble();
        System.out.println(resourceBundle.getString("oranges"));
        int oranges = sc.nextInt();
        System.out.println(resourceBundle.getString("oranges2"));
        double orangesPrice = sc.nextDouble();
        System.out.println(resourceBundle.getString("tomatoes"));
        int tomatoes = sc.nextInt();
        System.out.println(resourceBundle.getString("tomatoes2"));
        double tomatoesPrice = sc.nextDouble();

        double total = (apples * applesPrice) + (oranges * orangesPrice) + (tomatoes * tomatoesPrice);
        System.out.println(total);
    }
}