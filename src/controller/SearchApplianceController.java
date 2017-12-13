package controller;

import appliance.AirConditioner;
import appliance.Appliance;
import appliance.Refrigerator;
import appliance.WashingMachine;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.io.IOException;


public class SearchApplianceController
{
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
    private ChoiceBox<String> myApplianceBox;

    @FXML
    private TextField myPriceMinimum;

    @FXML
    private TextField myPriceMaximum;

    @FXML
    private TextField myEnergyMinimum;

    @FXML
    private TextField myEnergyMaximum;

    @FXML
    private void initialize() throws IOException
    {
        //set up the columns in the table
        //priceColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("price"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("brand"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("model"));
        energyColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("energy"));

        //set the items in the table to the items returned by the getAppliance() method
        myTableView.setItems(getAppliances());



        myApplianceBox.getItems().add(new AirConditioner().getApplianceType());
        myApplianceBox.getItems().add(new Refrigerator().getApplianceType());
        myApplianceBox.getItems().add(new WashingMachine().getApplianceType());

        myApplianceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
            {
                System.out.println("The Appliance you selected was: " + myApplianceBox.getItems().get(newValue.intValue()));
            }
        });
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
     * by Daylen
     * @return returns the list of appliances (test atm)
     */
    public ObservableList<Appliance> getAppliances(){
        //create an applianceList to populate
        ObservableList<Appliance> applianceList = FXCollections.observableArrayList();
        //add a test appliance
        applianceList.add(new Refrigerator("test model","test brand",0));

        //return the populated list
        return applianceList;
    }


}