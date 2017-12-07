package driver;

import appliance.Appliance;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/FirstPage.fxml"));
        primaryStage.setTitle("Not App: Compare Appliances!");
        primaryStage.setScene(new Scene(root));

        primaryStage.show();
    }


    public static void main(String[] args) {

        H2Database h2db = new H2Database();

        h2db.selectTable("airconditioner");

        for (Appliance a : h2db.getAppliances()) {
            System.out.println(a);
        }


        launch(args);
    }
}
