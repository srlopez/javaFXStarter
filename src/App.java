import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.Controller;
 
public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    // @Override
    // public void start(Stage primaryStage) {
    //     primaryStage.setTitle("Hello World!");
    //     Button btn = new Button();
    //     btn.setText("Say 'Hello World'");
    //     btn.setOnAction(new EventHandler<ActionEvent>() {
 
    //         @Override
    //         public void handle(ActionEvent event) {
    //             System.out.println("Hello World!");
    //         }
    //     });
        
    //     StackPane root = new StackPane();
    //     root.getChildren().add(btn);
    //     primaryStage.setScene(new Scene(root, 300, 250));
    //     primaryStage.show();
    // }

    @Override
    public void start(Stage primaryStage) {
        try {
            // Controller
            Controller controller = new Controller();
            // Vista
            URL location = getClass().getResource("ui/View.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(location);
            fxmlLoader.setController(controller);

            // RUN
            Parent root = (Parent) fxmlLoader.load();
            Scene scene = new Scene(root);
            primaryStage.setTitle("Hello from JavaFX");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}