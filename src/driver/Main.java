package driver;

import appliance.Appliance;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Tim on 12/7/2017.
 */
public class Main extends Application {

//    public H2Database h2db;

    @Override
    public void start(Stage primaryStage) throws Exception {

//        initializeDatabase();

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/FirstPage.fxml"));
        primaryStage.setTitle("Not App: Compare Appliances!");
        primaryStage.setScene(new Scene(root));

        primaryStage.show();
    }


    public static void main(String[] args) {


<<<<<<< HEAD
        h2db.selectTable("washingmachine");

        for (Appliance a : h2db.getAppliances()) {
            System.out.println(a);
        }
=======
>>>>>>> origin/dayday


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
