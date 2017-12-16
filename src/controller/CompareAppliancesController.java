package controller;

import appliance.Appliance;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class CompareAppliancesController {

<<<<<<< HEAD
=======
    @FXML
    ButtonBar myCalculateBox;
    private MasterController masterController;
    @FXML
    private TableView<Appliance> myTableView;
    //columns in the table view
    @FXML
    private TableColumn<Appliance, String> brandColumn;
    @FXML
    private TableColumn<Appliance, String> modelColumn;
    @FXML
    private TableColumn<Appliance, String> energyColumn;

>>>>>>> master
    @FXML
    private void initialize() {
        //set up the columns in the table
        //priceColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("price"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("brand"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("model"));
        energyColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("energy"));

        if (masterController == null) {
            myCalculateBox.setDisable(true);
        }
    }

<<<<<<< HEAD
        window.show();
=======
    @FXML
    public void backButtonClicked(ActionEvent event) throws IOException {
        masterController.getFirstPage();
>>>>>>> master
    }

    /**
     * @author Michelle
     * For getting back to calculations result page.. NEEDS TO LOAD SAVINGS PAGE ACCORDINGLY
     */
    @FXML
<<<<<<< HEAD
    public void calculateSavingsButtonClicked(ActionEvent event) throws IOException {
        Parent calcSumParent = FXMLLoader.load(getClass().getResource("../fxml/CalculationsSummary.fxml"));
        Scene calcSumScene = new Scene(calcSumParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(calcSumScene);
=======
    public void createApplianceButtonClicked(ActionEvent event) throws IOException {
        masterController.getSearchPage();
    }

    void setMasterController(MasterController mc) {
        masterController = mc;
        if (masterController.getSelectedAppliances().size() > 0) {
            myTableView.getItems().addAll(masterController.getSelectedAppliances());
            myCalculateBox.setDisable(false);
        }
    }
>>>>>>> master

    /**
     * By Daylen
     * Displays the calculate savings page from the fxml file
     *
     * @param event, sent when the button is clicked
     * @throws IOException
     */
    @FXML
    public void calcSavingsButtonClicked(ActionEvent event) throws IOException {
        masterController.getCalculationsPage();
    }

}
