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
    public void start(Stage primaryStage) throws Exception
    {
        mc = new MasterController();
    }


    public static void main(String[] args) {




        launch(args);
    }

    /**
     * initialize database
     */
//    public void initializeDatabase() {
//        h2db = new H2Database();
//
//        h2db.selectTable("refrigerator");
//
//        for (Appliance a : h2db.getAppliances()) {
//            System.out.println(a);
//        }
//    }
}
