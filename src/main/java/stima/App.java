package stima;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/main.fxml"));
            Scene scene = new Scene(root,Color.DIMGRAY);

            stage.setTitle("queens game solver");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public static void main(String[] args) throws Exception{
        launch(args);
    }
    
}