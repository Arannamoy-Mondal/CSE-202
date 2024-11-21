package event.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import event.lib.EventPlanner;

public class EventPlannerApp extends Application {
    private EventPlanner eventPlanner;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        eventPlanner = new EventPlanner("Nationwide Event Planner");

        // UI Components
        VBox root = new VBox();
        Scene scene = new Scene(root, 300, 200);

        Button employeeButton = new Button("Login as Employee");
        Button customerButton = new Button("Login as Customer");
        Button exitButton = new Button("Exit");

        root.getChildren().addAll(employeeButton, customerButton, exitButton);

        // Button Actions
        employeeButton.setOnAction(e -> showEmployeeMenu());
        customerButton.setOnAction(e -> showCustomerMenu());
        exitButton.setOnAction(e -> System.exit(0));

        primaryStage.setTitle("Event Planner");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showEmployeeMenu() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Employee Menu");
        alert.setHeaderText(null);
        alert.setContentText("Employee can perform tasks like offering packages, accepting events, etc.");
        alert.showAndWait();
    }

    private void showCustomerMenu() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Customer Menu");
        alert.setHeaderText(null);
        alert.setContentText("Customer can request events, register for tours, etc.");
        alert.showAndWait();
    }
}
