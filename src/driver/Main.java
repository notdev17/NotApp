package driver;

import appliance.Appliance;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public ObservableList<Appliance> UserApplianceList;
    public ObservableList<Appliance> UserFavList;
    @Override
    public void start(Stage primaryStage) throws Exception {

        //initial appliance list is empty when the program starts
        UserApplianceList = FXCollections.observableArrayList();
        UserFavList = FXCollections.observableArrayList();

        //load the fxml file for the first page
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/FirstPage.fxml"));
        //set the title of the window
        primaryStage.setTitle("Not App: Compare Appliances!");
        //set the scene as the fxml file
        primaryStage.setScene(new Scene(root));
        //the window is not resizable
        primaryStage.setResizable(false);
        //show the stage
        primaryStage.show();
    }


    public static void main(String[] args) {
        //launch the application
        launch(args);
    }
}
