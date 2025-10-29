import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class OutputGenerator {
    public void generateOutput(String languageCode) {
        Scanner sc = new Scanner(System.in);
        // Build a Locale from codes like "en", "sv", "en_US" or "fi_FI"
        String lang = "";
        String country = "";
        if (languageCode != null && !languageCode.isEmpty()) {
            String normalized = languageCode.replace('-', '_');
            String[] parts = normalized.split("_");
            if (parts.length >= 1) lang = parts[0];
            if (parts.length >= 2) country = parts[1];
        }
        lang = (lang == null) ? "" : lang.toLowerCase();
        country = (country == null) ? "" : country.toUpperCase();

        Locale locale = country.isEmpty() ? new Locale(lang) : new Locale(lang, country);

        ResourceBundle resourceBundle;
        try {
            resourceBundle = ResourceBundle.getBundle("resources.MessagesBundle", locale);
        } catch (java.util.MissingResourceException e) {
            // Try falling back to language-only locale (e.g. "en")
            try {
                resourceBundle = ResourceBundle.getBundle("resources.MessagesBundle", new Locale(lang));
            } catch (java.util.MissingResourceException e2) {
                // Final fallback to default (English)
                resourceBundle = ResourceBundle.getBundle("resources.MessagesBundle", Locale.ENGLISH);
                System.out.println("Warning: specific resource bundle not found; falling back to English.");
            }
        }
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