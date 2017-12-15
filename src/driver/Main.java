package driver;

import controller.FirstPageController;
import controller.MasterController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private MasterController mc;


    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setTitle("Not App: Compare Appliances!");
        stage.setResizable(false);
        mc = new MasterController(stage);
    }


    public static void main(String[] args)
    {

        launch(args);
    }
}
