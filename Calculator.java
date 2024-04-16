package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
//23MCA1037 - Krishna Chandel
public class Calculator extends Application {

    private TextField numField1;
    private TextField numField2;
    private TextField resultField;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Basic Calculator");

        // labels
        Label numLabel1 = new Label("Number 1:");
        Label numLabel2 = new Label("Number 2:");
        Label resultLabel = new Label("Result:");

        // text fields
        numField1 = new TextField();
        numField2 = new TextField();
        resultField = new TextField();
        resultField.setEditable(false);

        // buttons
        Button addButton = new Button("+");
        Button subButton = new Button("-");
        Button mulButton = new Button("*");
        Button divButton = new Button("/");

        //  button actions
        addButton.setOnAction(e -> calculate('+'));
        subButton.setOnAction(e -> calculate('-'));
        mulButton.setOnAction(e -> calculate('*'));
        divButton.setOnAction(e -> calculate('/'));

  
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

  
        grid.add(numLabel1, 0, 0);
        grid.add(numField1, 1, 0);
        grid.add(numLabel2, 0, 1);
        grid.add(numField2, 1, 1);
        grid.add(resultLabel, 0, 2);
        grid.add(resultField, 1, 2);
        grid.add(addButton, 0, 3);
        grid.add(subButton, 1, 3);
        grid.add(mulButton, 2, 3);
        grid.add(divButton, 3, 3);

  
        Scene scene = new Scene(grid, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculate(char operator) {
        try {
            double num1 = Double.parseDouble(numField1.getText());
            double num2 = Double.parseDouble(numField2.getText());
            double result = 0;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                    	resultField.setText("Cannot divide by 0");
                        return;
                    }
                    result = num1 / num2;
                    break;
            }

            resultField.setText(Double.toString(result));
        } catch (NumberFormatException ex) {
        	resultField.setText("Invalid input!");
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
