package controller;

import appliance.Appliance;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

public class CompareAppliancesController {

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

    /**
     * By Daylen
     * Displays the first page from the fxml file
     * @param event, sent when the button is clicked
     * @throws IOException
     */
    @FXML
    public void backButtonClicked(ActionEvent event) throws IOException {
        Parent compareAppParent = FXMLLoader.load(getClass().getResource("../fxml/FirstPage.fxml"));
        Scene compareAppScene = new Scene(compareAppParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(compareAppScene);

        window.show();
    }
    /**
     * By Daylen
     * Displays the search appliance page from the fxml file
     * @param event, sent when the button is clicked
     * @throws IOException
     */
    @FXML
    public void createApplianceButtonClicked(ActionEvent event) throws IOException {
        Parent compareAppParent = FXMLLoader.load(getClass().getResource("../fxml/SearchAppliance.fxml"));
        Scene compareAppScene = new Scene(compareAppParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(compareAppScene);

        window.show();
    }

    /**
     * By Daylen
     * Displays the calculate savings page from the fxml file
     * @param event, sent when the button is clicked
     * @throws IOException
     */
    @FXML
    public void calcSavingsButtonClicked(ActionEvent event) throws IOException {
        Parent compareAppParent = FXMLLoader.load(getClass().getResource("../fxml/CalculateSavings.fxml"));
        Scene compareAppScene = new Scene(compareAppParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(compareAppScene);
        window.show();
    }

    /**
     * By Brandon
     * Sets the TableView of this class equal to the the appliance the user
     * selected when the select button was clicked.
     * @param theTable is the SearchApplianceController's TableView.
     *
     */
    @FXML
    void setTableView(TableView<Appliance> theTable)
    {
        brandColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("brand"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("model"));
        energyColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("energy"));
        myTableView.getItems().add(theTable.getSelectionModel().getSelectedItem());
    }
}
