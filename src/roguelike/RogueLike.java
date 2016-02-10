package roguelike;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RogueLike extends Application {
    
    static Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) {      
        MainMenu mainMenu = new MainMenu();
        Scene scene = new Scene(mainMenu, MainMenu.WIDTH, MainMenu.HEIGHT);
        
        this.primaryStage = primaryStage;
        primaryStage.setTitle("This is RogueLike!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
