package controller;

import appliance.Appliance;
import driver.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Tim on 12/13/2017.
 * Used to easily share/transfer relevant data and objects between different scenes.
 */
public class MasterController {
    //Holds appliances to be listed in the compare appliances page
    private ArrayList<Appliance> myApplianceList;

    //Holds User's favorited appliances.
    private ArrayList<Appliance> myFavoriteList;

    private FXMLLoader myLoader;

    private Stage myStage;

    private Parent myParent;

    /** Constructor containing  */
    public MasterController(Stage stage) {

        // creates lists to be populated with appliances
        myFavoriteList = new ArrayList<>();
        myApplianceList = new ArrayList<>();
        myLoader = new FXMLLoader();
        myStage = stage;
        try {
            getFirstPage();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**
     * changes scene to FirstPage
     */
    void getFirstPage() throws IOException {
        myParent = myLoader.load(getClass().getResource("../fxml/FirstPage.fxml").openStream());
        ((FirstPageController) myLoader.getController()).setMasterController(this);
        Scene scene = new Scene(myParent);
        myStage.setScene(scene);
        myStage.show();
        myLoader = new FXMLLoader();
    }

    /**
     * changes scene to CompareAppliances page
     */
    void getComparePage() throws IOException {
        myParent = myLoader.load(getClass().getResource("../fxml/CompareAppliances.fxml").openStream());
        ((CompareAppliancesController) myLoader.getController()).setMasterController(this);
        Scene scene = new Scene(myParent);
        scene.getStylesheets().add(Main.class.getResource("../style/bootstrap3.css").toExternalForm());
        myStage.setScene(scene);
        myStage.show();
        myLoader = new FXMLLoader();
    }

    /**
     * changes scene to SearchAppliance page.
     */
    void getSearchPage() throws IOException {
        myParent = myLoader.load(getClass().getResource("../fxml/SearchAppliance.fxml").openStream());
        ((SearchApplianceController) myLoader.getController()).setMasterController(this);
        Scene scene = new Scene(myParent);
        scene.getStylesheets().add(Main.class.getResource("../style/bootstrap3.css").toExternalForm());
        myStage.setScene(scene);
        myStage.show();
        myLoader = new FXMLLoader();
    }

    /**
     * changes scene to CalculateSavings page
     */
    void getCalculationsPage() throws IOException {
        myParent = myLoader.load(getClass().getResource("../fxml/CalculateSavings.fxml").openStream());
        ((CalculateSavingsController) myLoader.getController()).setMasterController(this);
        Scene scene = new Scene(myParent);
        scene.getStylesheets().add(Main.class.getResource("../style/bootstrap3.css").toExternalForm());
        myStage.setScene(scene);
        myStage.show();
        myLoader = new FXMLLoader();
    }

    /**
     * changes scene to User page
     */
    void getUserPage() throws IOException {
        myParent = myLoader.load(getClass().getResource("../fxml/User.fxml").openStream());
        ((UserController) myLoader.getController()).setMasterController(this);
        Scene scene = new Scene(myParent);
        scene.getStylesheets().add(Main.class.getResource("../style/bootstrap3.css").toExternalForm());
        myStage.setScene(scene);
        myStage.show();
        myLoader = new FXMLLoader();
    }

    /**
     * returns myApplianceList
     */
    public ArrayList<Appliance> getSelectedAppliances() {
        return myApplianceList;
    }

    /**
     * returns myFavoriteList
     */
    public ArrayList<Appliance> getFavoriteAppliances() {
        return myFavoriteList;
    }

    /**
     * sets myFavoriteList according to 'list' input
     */
    public void setMyFavoriteList(ArrayList<Appliance> list) {
        myFavoriteList = list;
    }
}
