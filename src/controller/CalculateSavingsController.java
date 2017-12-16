package controller;

import appliance.Appliance;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculateSavingsController {

    @FXML
    private TableView<Appliance> calculationsTableView;
//    @FXML
//    private TableView<Appliance> calculationsTableView;

    //columns in the table view
    @FXML
    private TableColumn<Appliance, String> calcModelCol;
    @FXML
    private TableColumn<Appliance, String> calcBrandCol;
    @FXML
    private TableColumn<Appliance, String> calcPriceCol;
    @FXML
    private TableColumn<Appliance, String> calcEnergyCol;
    @FXML
    private TableColumn<Appliance, String> calc1Col;
    @FXML
    private TableColumn<Appliance, String> calc2Col;

    private MasterController masterController;

    @FXML
    private void initialize() {
        //set up the columns in the table
        //priceColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("price"));
        calcModelCol.setCellValueFactory(new PropertyValueFactory<Appliance, String>("model"));
        calcBrandCol.setCellValueFactory(new PropertyValueFactory<Appliance, String>("brand"));
        calcPriceCol.setCellValueFactory(new PropertyValueFactory<Appliance, String>("price"));
        calcEnergyCol.setCellValueFactory(new PropertyValueFactory<Appliance, String>("energy"));
//        calc1Col.setCellValueFactory(new PropertyValueFactory<Appliance, String>("calculation1"));
//        calc2Col.setCellValueFactory(new PropertyValueFactory<Appliance, String>("calculation2"));
    }
    @FXML
    public void backButtonClicked(ActionEvent event) throws IOException {
        masterController.getComparePage();
    }

    /**
     * closes the window when the done button that is clicked
     * By: Daylen
     *
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
    public void userProfileButtonClicked() throws IOException{
        masterController.getUserPage();
    }

    void setMasterController(MasterController mc) {
        masterController = mc;
        if (masterController.getSelectedAppliances().size() > 0) {
            calculationsTableView.getItems().addAll(masterController.getSelectedAppliances());
        }
    }
}
