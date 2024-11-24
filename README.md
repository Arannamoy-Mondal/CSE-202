# Set up javafx For Eclipse
# Help -> Eclipse User Storage -> Eclipse Market Place -> Search -> e(fx)clipse install 
# Set up JavaFx for IntelliJ student pack account without maven:
``
Step 1: File -> New -> Project -> Java -> "Select JDK" -> 
``

``
Step 2: File -> File Structure -> Libraries -> + "Add All JavaFx JDK Files" ->
``

``
Step 3: Current File -> Edit Configurations -> Edit COnfiguration Templates -> Application -> Modify Options -> Add VM Options -> "1st dropdown box select Oracle JDK " -> Add VM Arguments
``
# Add VM Arguments:
```txt
--module-path "path\openjfx-23.0.1_windows-x64_bin-sdk\javafx-sdk-23.0.1\lib" --add-modules javafx.controls,javafx.fxml
```

# If FXML file not create, then " Install new software " and add software. Links ( N.B. Please check the link is it vulnerable or not? You can simply chcek it by virus total. Do it at own risk. ):
```txt
https://download.eclipse.org/justj/?file=efxclipse/updates-nightly/site
```
```txt
https://download.eclipse.org/efxclipse/updates-nightly/site/
```


# File structure of IntelliJ vs Eclipse:

```
┌─────────┬─────────────────┬──────────────────┐
│ (index) │ Eclipse         │ IntelliJ_IDEA    │
├─────────┼─────────────────┼──────────────────┤
│ 0       │ 'Workspace'     │ 'Project'        │
│ 1       │ 'Project'       │ 'Module'         │
│ 2       │ 'Facet'         │ 'Facet'          │
│ 3       │ 'Library'       │ 'Library'        │
│ 4       │ 'JRE'           │ 'SDK'            │
│ 5       │ 'Path-Variable' │ 'Class-Variable' │
└─────────┴─────────────────┴──────────────────┘
```


<!--start topics-->
<div id="topic">
    <h1>Topic:</h1>
    <li><a href="#sceneController">Scene Controller</a></li>
    <li><a href="#communicationBetweenController">Communication Between Controller</a></li>
    <li><a href="#logoutandexit">Log Out And Alert Box</a></li>
</div>

<div id="sceneController">
    <a href="#topic">Topic</a>
`Main Class:`
```java
    
    package application;
    import javafx.application.Application;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Scene;
    import javafx.scene.layout.Pane;
    import javafx.stage.Stage;
    
    public class Main extends Application {
        @Override
        public void start(Stage stage) throws Exception {
            try{
                Pane root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        public static void main(String[] args) {
            launch(args);
        }
    
    }
    
```
`SceneController Class:`
```java
    import javafx.event.ActionEvent;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Node;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.scene.layout.Pane;
    import javafx.stage.Stage;
    
    import java.io.IOException;
    
    public class SceneController {
        private Stage stage;
        private Scene scene;
        private Pane root;
        public void switchScene1(ActionEvent e) throws Exception {
            root = FXMLLoader.load(getClass().getResource("/Application/Scene1.fxml"));
            stage =(Stage) ((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
        }
        public void switchScene2(ActionEvent e) throws Exception {
            root = FXMLLoader.load(getClass().getResource("/Application/Scene2.fxml"));
            stage =(Stage) ((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
        }
    }
    
```
    
    
</div>

<div id="communicationBetweenController">
    <a href="#topic">Topic</a>

`SceneBuilder1 :`

```java
package Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController1 {
    private Stage stage;
    private Scene scene;
    private Pane root;
    @FXML
    TextField name;
    public void login(ActionEvent event) throws IOException {
        String userName=name.getText();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
        root=loader.load();
        SceneController2 controller2=loader.getController();
        controller2.displayName(userName);
        stage =(Stage)((Node)event.getSource()).getScene().getWindow(); // for switch window
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Home");
        stage.show();
    }
}

```

`SceneController2 :`

```java
package Application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class SceneController2 {
    @FXML
    private Label nameLabel;

    public void displayName(String userName) {
        nameLabel.setText("Hello, " + userName);
    }
}

```
</div>


<div id="logoutandexit">
    <a href="#topic">Topic</a>

`Main`
```java
package Application;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        try{
            Pane root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(event->{
                event.consume();
                logOut(stage);
            });
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void logOut(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Log Out");
        alert.setContentText("Are you sure you want to log out?");
        if(alert.showAndWait().get() == ButtonType.OK) {
//            stage=(Stage)scene_pane.getScene().getWindow();
            System.out.println("LogOut");
            stage.close();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }

}
```

`logOut :`
```java
package Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private Button logOut;
    @FXML
    private AnchorPane scene_pane;
    Stage stage;
    public void logOut(ActionEvent event) {
        stage=(Stage)scene_pane.getScene().getWindow();
        System.out.println("LogOut");
        stage.close();
    }
}

```

</div>
File -> Project Structure -> Modules -> " Add Module by + sign " -> Import Module -> Choose One ( Prefer Create module from existing source ) -> "Overwritten/ Reuse: Choose Reuse " -> 
`

``File -> Project Structure -> Modules -> Dependencies " From Source Path Dependecies " -> + -> Module Dependency -> Select Module ->``

