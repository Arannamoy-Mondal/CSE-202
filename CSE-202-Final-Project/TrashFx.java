// cursor
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




// claude 
package event.app;

import event.lib.EventPlanner;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class EventPlannerApp extends Application {
    private EventPlanner eventPlanner;
    private Stage primaryStage;
    private Scene mainScene, employeeScene, customerScene;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        eventPlanner = new EventPlanner("Event Management System");
        
        // Main Login Scene
        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(20));
        
        Label titleLabel = new Label("Event Planner System");
        Button employeeLoginBtn = new Button("Employee Login");
        Button customerLoginBtn = new Button("Customer Login");
        Button exitBtn = new Button("Exit");
        
        employeeLoginBtn.setOnAction(e -> showEmployeeMenu());
        customerLoginBtn.setOnAction(e -> showCustomerMenu());
        exitBtn.setOnAction(e -> primaryStage.close());
        
        mainLayout.getChildren().addAll(titleLabel, employeeLoginBtn, customerLoginBtn, exitBtn);
        
        mainScene = new Scene(mainLayout, 300, 250);
        primaryStage.setTitle("Event Planner");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
    
    private void showEmployeeMenu() {
        VBox employeeLayout = new VBox(10);
        employeeLayout.setPadding(new Insets(20));
        
        Label menuLabel = new Label("Employee Menu");
        
        Button offerTourPackageBtn = new Button("Offer Tour Package");
        offerTourPackageBtn.setOnAction(e -> offerTourPackage());
        
        Button viewAcceptedEventsBtn = new Button("View Accepted Events");
        viewAcceptedEventsBtn.setOnAction(e -> viewAcceptedEvents());
        
        Button acceptEventBtn = new Button("Accept Event");
        acceptEventBtn.setOnAction(e -> acceptEvent());
        
        Button assignManagerBtn = new Button("Assign Event Manager");
        assignManagerBtn.setOnAction(e -> assignEventManager());
        
        Button backBtn = new Button("Logout");
        backBtn.setOnAction(e -> primaryStage.setScene(mainScene));
        
        employeeLayout.getChildren().addAll(
            menuLabel, offerTourPackageBtn, viewAcceptedEventsBtn, 
            acceptEventBtn, assignManagerBtn, backBtn
        );
        
        employeeScene = new Scene(employeeLayout, 300, 350);
        primaryStage.setScene(employeeScene);
    }
    
    private void showCustomerMenu() {
        VBox customerLayout = new VBox(10);
        customerLayout.setPadding(new Insets(20));
        
        Label menuLabel = new Label("Customer Menu");
        
        Button requestEventBtn = new Button("Request Corporate Event");
        requestEventBtn.setOnAction(e -> requestCorporateEvent());
        
        Button searchToursBtn = new Button("Search Tour Packages");
        searchToursBtn.setOnAction(e -> searchTourPackages());
        
        Button registerTourBtn = new Button("Register for Tour");
        registerTourBtn.setOnAction(e -> registerForTour());
        
        Button viewEventDetailsBtn = new Button("View Event Details");
        viewEventDetailsBtn.setOnAction(e -> viewEventDetails());
        
        Button payBillBtn = new Button("Pay Bill");
        payBillBtn.setOnAction(e -> payBill());
        
        Button backBtn = new Button("Logout");
        backBtn.setOnAction(e -> primaryStage.setScene(mainScene));
        
        customerLayout.getChildren().addAll(
            menuLabel, requestEventBtn, searchToursBtn, 
            registerTourBtn, viewEventDetailsBtn, payBillBtn, backBtn
        );
        
        customerScene = new Scene(customerLayout, 300, 350);
        primaryStage.setScene(customerScene);
    }
    
    // Implement individual method stubs for each button action
    private void offerTourPackage() {
        // Create dialog to input tour package details
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Offer Tour Package");
        
        // Add input fields for tour package details
        VBox content = new VBox(10);
        TextField titleField = new TextField();
        titleField.setPromptText("Event Title");
        
        DatePicker datePicker = new DatePicker();
        datePicker.setPromptText("Event Date");
        
        TextField durationField = new TextField();
        durationField.setPromptText("Duration (Days)");
        
        TextField participantsField = new TextField();
        participantsField.setPromptText("Number of Participants");
        
        TextField priceField = new TextField();
        priceField.setPromptText("Price per Person");
        
        content.getChildren().addAll(
            new Label("Title:"), titleField,
            new Label("Date:"), datePicker,
            new Label("Duration:"), durationField,
            new Label("Participants:"), participantsField,
            new Label("Price:"), priceField
        );
        
        dialog.getDialogPane().setContent(content);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        
        dialog.setResultConverter(buttonType -> {
            if (buttonType == ButtonType.OK) {
                try {
                    String title = titleField.getText();
                    LocalDate date = datePicker.getValue();
                    int duration = Integer.parseInt(durationField.getText());
                    int participants = Integer.parseInt(participantsField.getText());
                    int price = Integer.parseInt(priceField.getText());
                    
                    String eventId = eventPlanner.offerTourPackage(
                        title, date, duration, participants, price
                    );
                    
                    showAlert("Tour Package Created", "Event ID: " + eventId);
                } catch (Exception e) {
                    showAlert("Error", "Invalid input: " + e.getMessage());
                }
            }
            return null;
        });
        
        dialog.showAndWait();
    }
    
    // Implement similar methods for other actions
    
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        // Continuing the EventPlannerApp class
private void requestCorporateEvent() {
    Dialog<ButtonType> dialog = new Dialog<>();
    dialog.setTitle("Request Corporate Event");
    
    VBox content = new VBox(10);
    TextField titleField = new TextField();
    titleField.setPromptText("Event Title");
    
    TextField contactField = new TextField();
    contactField.setPromptText("Customer Contact");
    
    DatePicker datePicker = new DatePicker();
    datePicker.setPromptText("Event Date");
    
    TextField durationField = new TextField();
    durationField.setPromptText("Duration (Days)");
    
    TextField participantsField = new TextField();
    participantsField.setPromptText("Number of Participants");
    
    content.getChildren().addAll(
        new Label("Title:"), titleField,
        new Label("Contact:"), contactField,
        new Label("Date:"), datePicker,
        new Label("Duration:"), durationField,
        new Label("Participants:"), participantsField
    );
    
    dialog.getDialogPane().setContent(content);
    dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
    
    dialog.setResultConverter(buttonType -> {
        if (buttonType == ButtonType.OK) {
            try {
                String title = titleField.getText();
                String contact = contactField.getText();
                LocalDate date = datePicker.getValue();
                int duration = Integer.parseInt(durationField.getText());
                int participants = Integer.parseInt(participantsField.getText());
                
                String eventId = eventPlanner.requestEvent(
                    title, contact, date, duration, participants
                );
                
                showAlert("Event Requested", "Event ID: " + eventId);
            } catch (Exception e) {
                showAlert("Error", "Invalid input: " + e.getMessage());
            }
        }
        return null;
    });
    
    dialog.showAndWait();
}

private void searchTourPackages() {
    TextInputDialog dialog = new TextInputDialog();
    dialog.setTitle("Search Tour Packages");
    dialog.setHeaderText("Enter search keyword");
    dialog.setContentText("Keyword:");
    
    dialog.showAndWait().ifPresent(keyword -> {
        ArrayList<TourPackage> packages = eventPlanner.searchForTourPackages(keyword);
        
        if (packages.isEmpty()) {
            showAlert("Search Results", "No tour packages found.");
        } else {
            StringBuilder results = new StringBuilder();
            for (TourPackage pkg : packages) {
                results.append(pkg.toString()).append("\n");
            }
            
            showAlert("Search Results", results.toString());
        }
    });
}

private void registerForTour() {
    Dialog<ButtonType> dialog = new Dialog<>();
    dialog.setTitle("Register for Tour");
    
    VBox content = new VBox(10);
    TextField tourIdField = new TextField();
    tourIdField.setPromptText("Tour Package ID");
    
    TextField participantsField = new TextField();
    participantsField.setPromptText("Number of Participants");
    
    TextField contactField = new TextField();
    contactField.setPromptText("Contact Number");
    
    content.getChildren().addAll(
        new Label("Tour ID:"), tourIdField,
        new Label("Participants:"), participantsField,
        new Label("Contact:"), contactField
    );
    
    dialog.getDialogPane().setContent(content);
    dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
    
    dialog.setResultConverter(buttonType -> {
        if (buttonType == ButtonType.OK) {
            try {
                String tourId = tourIdField.getText();
                int participants = Integer.parseInt(participantsField.getText());
                String contact = contactField.getText();
                
                eventPlanner.registerForTour(tourId, participants, contact);
                showAlert("Registration", "Successfully registered for the tour.");
            } catch (Exception e) {
                showAlert("Error", "Registration failed: " + e.getMessage());
            }
        }
        return null;
    });
    
    dialog.showAndWait();
}

private void viewEventDetails() {
    TextInputDialog dialog = new TextInputDialog();
    dialog.setTitle("View Event Details");
    dialog.setHeaderText("Enter Event ID");
    dialog.setContentText("Event ID:");
    
    dialog.showAndWait().ifPresent(eventId -> {
        Event event = eventPlanner.findEvent(eventId);
        
        if (event != null) {
            showAlert("Event Details", event.toString());
        } else {
            showAlert("Error", "Event not found.");
        }
    });
}

private void payBill() {
    TextInputDialog dialog = new TextInputDialog();
    dialog.setTitle("Pay Bill");
    dialog.setHeaderText("Enter Event ID");
    dialog.setContentText("Event ID:");
    
    dialog.showAndWait().ifPresent(eventId -> {
        double bill = eventPlanner.payBill(eventId);
        
        if (bill > 0) {
            Alert confirmDialog = new Alert(Alert.AlertType.CONFIRMATION);
            confirmDialog.setTitle("Bill Payment");
            confirmDialog.setHeaderText("Total Bill: $" + bill);
            confirmDialog.setContentText("Do you want to proceed with payment?");
            
            confirmDialog.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    showAlert("Payment Successful", "Bill of $" + bill + " has been paid.");
                }
            });
        } else {
            showAlert("Error", "Event not found or invalid bill.");
        }
    });
}

private void acceptEvent() {
    TextInputDialog dialog = new TextInputDialog();
    dialog.setTitle("Accept Event");
    dialog.setHeaderText("Enter Event ID to Accept");
    dialog.setContentText("Event ID:");
    
    dialog.showAndWait().ifPresent(eventId -> {
        try {
            eventPlanner.acceptEvent(eventId);
            showAlert("Event Accepted", "Event with ID " + eventId + " has been accepted.");
        } catch (Exception e) {
            showAlert("Error", "Failed to accept event: " + e.getMessage());
        }
    });
}

private void assignEventManager() {
    Dialog<ButtonType> dialog = new Dialog<>();
    dialog.setTitle("Assign Event Manager");
    
    VBox content = new VBox(10);
    TextField eventIdField = new TextField();
    eventIdField.setPromptText("Event ID");
    
    TextField managerNameField = new TextField();
    managerNameField.setPromptText("Manager Name");
    
    content.getChildren().addAll(
        new Label("Event ID:"), eventIdField,
        new Label("Manager Name:"), managerNameField
    );
    
    dialog.getDialogPane().setContent(content);
    dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
    
    dialog.setResultConverter(buttonType -> {
        if (buttonType == ButtonType.OK) {
            try {
                String eventId = eventIdField.getText();
                String managerName = managerNameField.getText();
                
                eventPlanner.assignEventManager(eventId, managerName);
                showAlert("Manager Assigned", "Manager " + managerName + " assigned to event " + eventId);
            } catch (Exception e) {
                showAlert("Error", "Failed to assign manager: " + e.getMessage());
            }
        }
        return null;
    });
    
    dialog.showAndWait();
}

private void viewAcceptedEvents() {
    // This method would display a list of accepted events
    // You might want to implement this with a ListView or TableView
    StringBuilder eventsList = new StringBuilder();
    
    // In a real implementation, you'd fetch events from eventPlanner
    eventsList.append("Accepted Events:\n");
    private void viewAcceptedEvents() {
    // Create a dialog to show accepted events
    Dialog<ButtonType> dialog = new Dialog<>();
    dialog.setTitle("Accepted Events");
    dialog.setHeaderText("List of Accepted Events");

    TextArea eventsTextArea = new TextArea();
    eventsTextArea.setEditable(false);
    eventsTextArea.setWrapText(true);

    // In a real implementation, you'd fetch events from eventPlanner
    StringBuilder eventsList = new StringBuilder();
    eventsList.append("Accepted Events:\n");
    
    // Placeholder for fetching events (you'd replace this with actual event retrieval)
    eventsList.append("1. Corporate Event: Tech Conference\n");
    eventsList.append("2. Tour Package: Summer Vacation\n");
    eventsList.append("3. Corporate Event: Annual Meeting\n");

    eventsTextArea.setText(eventsList.toString());

    VBox content = new VBox(10);
    content.getChildren().add(eventsTextArea);

    dialog.getDialogPane().setContent(content);
    dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

    dialog.showAndWait();
}

// Utility method for showing alerts
private void showAlert(String title, String content) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(content);
    alert.showAndWait();
}

// Additional utility methods
private void showErrorAlert(String title, String content) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(content);
    alert.showAndWait();
}

// Validation methods
private boolean validateInput(String... inputs) {
    for (String input : inputs) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
    }
    return true;
}

// Logging method (could be expanded to write to a file)
private void logEvent(String eventType, String details) {
    System.out.println(LocalDateTime.now() + " - " + eventType + ": " + details);
}

// Main method with additional configuration
public static void main(String[] args) {
    // Set default uncaught exception handler
    Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Unexpected Error");
            alert.setHeaderText("An unexpected error occurred");
            alert.setContentText(throwable.getMessage());
            
            // Optional: Print stack trace
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            throwable.printStackTrace(pw);
            TextArea textArea = new TextArea(sw.toString());
            textArea.setEditable(false);
            
            alert.getDialogPane().setExpandableContent(textArea);
            alert.showAndWait();
        });
    });

    // Launch the application
    launch(args);
}

// Additional helper method for data persistence (placeholder)
private void saveApplicationState() {
    try {
        // Implement serialization or database storage
        System.out.println("Saving application state...");
        // Serialize events, tour packages, etc.
    } catch (Exception e) {
        showErrorAlert("Save Error", "Could not save application state");
    }
}

// Load application state on startup
private void loadApplicationState() {
    try {
        // Implement deserialization or database loading
        System.out.println("Loading application state...");
        // Deserialize events, tour packages, etc.
    } catch (Exception e) {
        showErrorAlert("Load Error", "Could not load previous application state");
    }
}

// Override start method to include state loading
@Override
public void start(Stage primaryStage) {
    // Load previous application state
    loadApplicationState();

    // Existing start method implementation...
    this.primaryStage = primaryStage;
    eventPlanner = new EventPlanner("Event Management System");
    
    // Rest of the existing start method...

    // Add shutdown hook to save state
    primaryStage.setOnCloseRequest(event -> {
        saveApplicationState();
    });
}


import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.StringWriter;
import java.io.PrintWriter;
import event.lib.*;
