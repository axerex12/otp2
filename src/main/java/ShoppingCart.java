import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShoppingCart extends Application {

        Label item1 = new Label("Item 1:");
        TextField item1Field = new TextField();
        Label item2 = new Label("Item 2:");
        TextField item2Field = new TextField();
        Label item1cost = new Label("Cost 1:");
        TextField item1costField = new TextField();
        Label item2cost = new Label("Cost 2:");
        TextField item2costField = new TextField();
        Button calculateButton = new Button("Calculate Total");
        ComboBox<String> languageSelector = new ComboBox<>();
        Label totalLabel = new Label("Total Cost: ");

    @Override
    public void start(Stage primaryStage) {
        languageSelector.getItems().addAll("English", "Finnish", "Swedish", "Japanese");
        primaryStage.setTitle("Shopping Cart");
        languageSelector.setOnAction(e -> {
            String selected = languageSelector.getValue();
            Locale locale;
            switch (selected) {
                case "Finnish":
                    locale = new Locale("fi", "FI");
                    break;
                case "Swedish":
                    locale = new Locale("sv", "SE");
                    break;
                case "Japanese":
                    locale = new Locale("ja", "JP");
                    break;
                default:
                    locale = new Locale("en", "US");
                    break;
            }
            changeLanguage(locale);
        });
        calculateButton.setOnAction(e -> calculateItemCost());

        VBox root = new VBox();
        Scene scene = new Scene(root, 400, 300);

        root.getChildren().addAll(languageSelector, item1, item1Field, item1cost, item1costField, item2, item2Field, item2cost, item2costField, calculateButton, totalLabel);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void changeLanguage(Locale locale) {
        ResourceBundle messages = ResourceBundle.getBundle("messages", locale);
        item1.setText(messages.getString("item.1"));
        item2.setText(messages.getString("item.2"));
        item1cost.setText(messages.getString("cost.1"));
        item2cost.setText(messages.getString("cost.2"));
        calculateButton.setText(messages.getString("calculate.total"));
        totalLabel.setText(messages.getString("total.cost") + ": ");
    }

    public void calculateItemCost() {
        double price1 = Double.parseDouble(item1costField.getText());
        int quantity1 = Integer.parseInt(item1Field.getText());
        double price2 = Double.parseDouble(item2costField.getText());
        int quantity2 = Integer.parseInt(item2Field.getText());

        double totalCost = calculateItemCost(price1, quantity1) + calculateItemCost(price2, quantity2);
        totalLabel.setText(String.valueOf(totalCost));


    }

    public static void main(String[] args) {
        launch(args);
    }

    public static double calculateItemCost(double price, int quantity) {
        return price * quantity;
    }

}
