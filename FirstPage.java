package application;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//23MCA1037 - Krishna Chandel

public class FirstPage extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login Screen");

        // labels
        Label usernameLabel = new Label("Username:");
        Label passwordLabel = new Label("Password:");

        // text fields
        TextField username = new TextField();
        PasswordField password = new PasswordField();

        Button loginButton = new Button("Login");
        Label messageLabel = new Label();
        
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        gridPane.add(usernameLabel, 0, 0);
        gridPane.add(username, 1, 0);
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(password, 1, 1);
        gridPane.add(loginButton, 1, 2);
        gridPane.add(messageLabel, 1, 3);

        loginButton.setOnAction(e -> {
            String usernameInput = username.getText();
            String passwordInput = password.getText();
            if (usernameInput.equals("krishna") && passwordInput.equals("12345")) {
                messageLabel.setText("Login successful");
            } else {
                messageLabel.setText("Login failed. Please try again.");
            }
        });
        
        Scene scene = new Scene(gridPane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
