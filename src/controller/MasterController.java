package controller;

import appliance.*;
import driver.H2Database;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MasterController {

    private FXMLLoader fxmlLoader;
    //FXML COMPONENTS
    //table view from the fxml file
    @FXML
    private TableView<Appliance> myTableView;

    //columns in the table view
    @FXML
    private TableColumn<Appliance, String> brandColumn;

    @FXML
    private TableColumn<Appliance, String> modelColumn;

    @FXML
    private TableColumn<Appliance, String> energyColumn;

    @FXML
    public ChoiceBox myApplianceBox;

    @FXML
    private TextField myPriceMinimum;

    @FXML
    private TextField myPriceMaximum;

    @FXML
    private TextField myEnergyMinimum;

    @FXML
    private TextField myEnergyMaximum;
    //

    public ObservableList<Appliance> currentUserApplianceList;
    public ObservableList<Appliance> userFavoriteList;

//    MasterController() {
//        super();
//    }

    /**
     * By: Daylen
     * displays the Search Appliance Screen
     * @param event
     * @throws IOException
     */
    public void getSearchApplianceScreen(ActionEvent event) throws IOException {
        loadFXML(event, "../fxml/SearchAppliance.fxml");
        brandColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("brand"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("model"));
        energyColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("energy"));
        System.out.println(energyColumn);
//        //set the items in the table to the items returned by the getApplianceType() method
//        //myTableView.setItems(getAppliances())
        System.out.println(myApplianceBox);

    }

    /**
     * By: Daylen
     * displays the User screen
     * @param event
     * @throws IOException
     */
    public void getUserScreen(ActionEvent event) throws IOException {
        loadFXML(event, "../fxml/User.fxml");
    }

    /**
     * By: Daylen
     * displays the Calculate Savings screen
     * @param event
     * @throws IOException
     */
    public void getCalculateSavingsScreen(ActionEvent event) throws IOException {
        loadFXML(event, "../fxml/CalculateSavings.fxml");
    }

    /**
     * By: Daylen
     * displays the first page screen
     * @param event
     * @throws IOException
     */
    public void getFirstPageScreen(ActionEvent event) throws IOException {
        loadFXML(event, "../fxml/FirstPage.fxml");
    }

    /**
     * By: Daylen
     * displays the CompareApplianceScreen
     * @param event
     * @throws IOException
     */
    public void getCompareApplianceScreen(ActionEvent event) throws IOException {
        loadFXML(event, "../fxml/CompareAppliances.fxml");
    }

    /**
     * By: Daylen
     * Loads the fxml file when the action event is sent
     * @param event
     * @param fxmlLocation
     * @throws IOException
     */
    @FXML
    public void loadFXML(ActionEvent event, String fxmlLocation) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(fxmlLocation));
        Scene scene = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    /**
     * closes the window when the done button that is clicked
     * By: Daylen
     * @param event
     * @throws IOException
     */
    @FXML
    public void doneButtonClicked(ActionEvent event) throws IOException {
        //get the window from the action event
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        //close the window
        window.close();
    }

    @FXML
    public void updateButtonClicked(ActionEvent event) throws IOException
    {
        System.out.println("Price Min: " + myPriceMinimum.getCharacters());
        System.out.println("Price Max: " + myPriceMaximum.getCharacters());
        System.out.println("Energy Min: " + myEnergyMinimum.getCharacters());
        System.out.println("Energy Max: " + myEnergyMaximum.getCharacters());
    }
    /**
     * Takes the currently selected appliance and gives it to the
     * CompareApplianceController, then shows the CompareAppliance stage.
     * by Brandon
     */
    @FXML
    public void selectButtonClicked(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/CompareAppliances.fxml"));
        Pane p = fxmlLoader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(p));
        CompareAppliancesController cmpController = fxmlLoader.getController();
        cmpController.setTableView(myTableView.getSelectionModel().getTableView());
        System.err.println(myTableView.getSelectionModel().getSelectedItem());
        stage.show();
    }

    /**
     * by Daylen
     * @return returns the list of appliances (test atm)
     */
    public ObservableList<Appliance> getAppliances(String applianceType){

        //create an applianceList to populate
        ObservableList<Appliance> applianceList = FXCollections.observableArrayList();
        H2Database h2db = new H2Database();


        /*DEVON
          Added this switch statement to facilitate applianceList population and search filtering.
          Can likely be refactored to reduce the mostly identical case bodies.
         */
        switch(applianceType) {
            //IMPORTANT the energy value for air cleaners is Watts. Not kWHrs per Year.
            case "Air Cleaner":
                h2db.selectTable("aircleaner");
                for (Appliance a : h2db.getAppliances()) {
                    applianceList.add(new AirCleaner( a.getModel(), a.getBrand(), a.getEnergy()));
                    System.out.println(a);
                }
                break;
            //IMPORTANT the energy value for conditioners is in energy efficiency ratio. Not kWHrs/Yr.
            case "Air Conditioner":
                h2db.selectTable("airconditioner");
                for (Appliance a : h2db.getAppliances()) {
                    applianceList.add(new AirConditioner( a.getModel(), a.getBrand(), a.getEnergy()));
                    System.out.println(a);
                }
                break;

            case "Dishwasher":
                h2db.selectTable("dishwasher");
                for (Appliance a : h2db.getAppliances()) {
                    applianceList.add(new Dishwasher( a.getModel(), a.getBrand(), a.getEnergy()));
                    System.out.println(a);
                }
                break;

            case "Dryer":
                h2db.selectTable("dryer");
                for (Appliance a : h2db.getAppliances()) {
                    applianceList.add(new Dryer( a.getModel(), a.getBrand(), a.getEnergy()));
                    System.out.println(a);
                }
                break;

            case "Freezer":
                h2db.selectTable("freezer");
                for (Appliance a : h2db.getAppliances()) {
                    applianceList.add(new Freezer( a.getModel(), a.getBrand(), a.getEnergy()));
                    System.out.println(a);
                }
                break;

            case "Refrigerator":
                h2db.selectTable("refrigerator");
                for (Appliance a : h2db.getAppliances()) {
                    applianceList.add(new Refrigerator( a.getModel(), a.getBrand(), a.getEnergy()));
                    System.out.println(a);
                }
                break;

            case "Washer":
                h2db.selectTable("washingmachine");
                for (Appliance a : h2db.getAppliances()) {
                    applianceList.add(new WashingMachine( a.getModel(), a.getBrand(), a.getEnergy()));
                    System.out.println(a);
                }
                break;

        }


        return applianceList;
    }
}