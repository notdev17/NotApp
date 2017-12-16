package controller;

import appliance.*;
import driver.H2Database;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;


public class SearchApplianceController {
    private String currentApplianceType;

    private MasterController masterController;

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
    private TableColumn<Appliance, String> typeColumn;

    @FXML
    private ChoiceBox<String> myApplianceBox;

    @FXML
    private TextField myEnergyMinimum;

    @FXML
    private TextField myEnergyMaximum;

    @FXML
    private TextField mySearchBar;

    /**
     * By Daylen
     * called every time the user types in the search bar
     * The elements that do not contain the characters typed will be removed
     */
    @FXML
    public void searchBarFilter() {
        //apply the filters first
        updateButtonClicked();

        //get the observable list
        ObservableList<Appliance> currentList = myTableView.getItems();
        //create a copy as an array so we can go through it
        Object[] toSearch = currentList.toArray();
        //traverse the list, if the model of the appliance does not contain the characters typed, remove it
        for (Object a : toSearch) {
            if (!((Appliance) a).getModel().contains(mySearchBar.getCharacters()))
                currentList.remove(a);
        }

        //update the table view
        myTableView.setItems(currentList);
    }

    @FXML
    private void initialize() {
        //set up the columns in the table
        typeColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("applianceType"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("brand"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("model"));
        energyColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("energy"));
        //set the items in the table to the items returned by the getApplianceType() method
        //resultTableView.setItems(getAppliances());
        myApplianceBox.getItems().add(new AirCleaner().getApplianceType());
        myApplianceBox.getItems().add(new AirConditioner().getApplianceType());
        myApplianceBox.getItems().add(new Dishwasher().getApplianceType());
        myApplianceBox.getItems().add(new Dryer().getApplianceType());
        myApplianceBox.getItems().add(new WashingMachine().getApplianceType());
        myApplianceBox.getItems().add(new Refrigerator().getApplianceType());
        myApplianceBox.getItems().add(new Freezer().getApplianceType());


        myApplianceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                //System.out.println("The Appliance you selected was: " + myApplianceBox.getItems().get(newValue.intValue()));
                /*DEVON
                  When a user clicks an appliance type in the drop down menu, it will be re-populated with the proper
                  appliances (using getAppliances).
                 */
                myTableView.setItems(getAppliances(myApplianceBox.getItems().get(newValue.intValue())));
            }
        });

        populateListOnLoad();
    }

    /**
     * By: Daylen
     * When the user clicks the update button, the list of items is
     * updated to correlate with any filters the user may have input
     *
     * @throws IOException
     */
    @FXML
    public void updateButtonClicked() {
        //if the user has selected an appliance from the drop down
        if (!currentApplianceType.isEmpty()) {
            ObservableList<Appliance> updateList = getAppliances(currentApplianceType);
            int myEnergyMinInt;
            int myEnergyMaxInt;

            //convert the strings to ints if the fields are not empty
            if (!myEnergyMinimum.getCharacters().toString().isEmpty()) {
                myEnergyMinInt = Integer.parseInt(myEnergyMinimum.getCharacters().toString());
            } else {
                myEnergyMinInt = 0; //if empty
            }
            if (!myEnergyMaximum.getCharacters().toString().isEmpty()) {
                myEnergyMaxInt = Integer.parseInt(myEnergyMaximum.getCharacters().toString());
            } else {
                myEnergyMaxInt = 9999; //if empty
            }

            //convert the observable list to an array
            Object[] w = updateList.toArray();

            //iterate over that array and remove any appliances that are not contained in the filter
            for (Object a : w) {
                //cast the objects as appliances
                if (((Appliance) a).getEnergy() != 0) {
                    if (((Appliance) a).getEnergy() < myEnergyMinInt)
                        updateList.remove(a);
                    else if (((Appliance) a).getEnergy() > myEnergyMaxInt)
                        updateList.remove(a);
                }
            }

            //update the table view
            myTableView.setItems(updateList);
        }
    }

    /**
     * returns back to the compare appliances page
     * by daylen
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void backButtonClicked(ActionEvent event) throws IOException {
        masterController.getComparePage();
    }

    @FXML
    public void selectButtonClicked(ActionEvent event) throws IOException {
        if (!myTableView.getSelectionModel().getSelectedItems().isEmpty())
        {
            masterController.getSelectedAppliances().add(myTableView.getSelectionModel().getSelectedItem());
            masterController.getComparePage();
        }
    }

    /**
     * by Daylen
     *
     * @return returns the list of appliances (test atm)
     */
    public ObservableList<Appliance> getAppliances(String applianceType) {

        //create an applianceList to populate
        ObservableList<Appliance> applianceList = FXCollections.observableArrayList();

        H2Database h2db = new H2Database();


        /*DEVON
          Added this switch statement to facilitate applianceList population and search filtering.
          Can likely be refactored to reduce the mostly identical case bodies.
         */
        switch (applianceType) {
            //IMPORTANT the energy value for air cleaners is Watts. Not kWHrs per Year.
            case "Air Cleaner":
                h2db.selectTable("aircleaner");
                for (Appliance a : h2db.getAppliances()) {
                    applianceList.add(new AirCleaner(a.getModel(), a.getBrand(), a.getEnergy()));
                    //System.out.println(a);
                }
                break;
            //IMPORTANT the energy value for conditioners is in energy efficiency ratio. Not kWHrs/Yr.
            case "Air Conditioner":
                h2db.selectTable("airconditioner");
                for (Appliance a : h2db.getAppliances()) {
                    applianceList.add(new AirConditioner(a.getModel(), a.getBrand(), a.getEnergy()));
                    //System.out.println(a);
                }
                break;

            case "Dishwasher":
                h2db.selectTable("dishwasher");
                for (Appliance a : h2db.getAppliances()) {
                    applianceList.add(new Dishwasher(a.getModel(), a.getBrand(), a.getEnergy()));
                    //System.out.println(a);
                }
                break;

            case "Dryer":
                h2db.selectTable("dryer");
                for (Appliance a : h2db.getAppliances()) {
                    applianceList.add(new Dryer(a.getModel(), a.getBrand(), a.getEnergy()));
                    //System.out.println(a);
                }
                break;

            case "Freezer":
                h2db.selectTable("freezer");
                for (Appliance a : h2db.getAppliances()) {
                    applianceList.add(new Freezer(a.getModel(), a.getBrand(), a.getEnergy()));
                    //System.out.println(a);
                }
                break;

            case "Refrigerator":
                h2db.selectTable("refrigerator");
                for (Appliance a : h2db.getAppliances()) {
                    applianceList.add(new Refrigerator(a.getModel(), a.getBrand(), a.getEnergy()));
                    //System.out.println(a);
                }
                break;

            case "Washer":
                h2db.selectTable("washingmachine");
                for (Appliance a : h2db.getAppliances()) {
                    applianceList.add(new WashingMachine(a.getModel(), a.getBrand(), a.getEnergy()));
                    //System.out.println(a);
                }
                break;

        }
        h2db.closeConnection();
        return applianceList;
    }

    public void setMasterController(MasterController mc) {
        masterController = mc;
    }

    /**
     * Populate the appliance list with first item on list onload
     *
     * @author Tim
     */
    private void populateListOnLoad() {
        myApplianceBox.getSelectionModel().selectFirst();
        //System.out.println(myApplianceBox.getValue());
        currentApplianceType = myApplianceBox.getValue();
        myTableView.setItems(getAppliances(myApplianceBox.getItems().get(0)));
    }

}