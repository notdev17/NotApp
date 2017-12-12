package controller;

import appliance.AirConditioner;
import appliance.Refrigerator;
import appliance.WashingMachine;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;


public class SearchApplianceController
{
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
    private void initialize()
    {
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

        System.out.println("Price Min:" + myPriceMinimum.getCharacters());
        System.out.println("Price Max:" + myPriceMaximum.getCharacters());
        System.out.println("Energy Min:" + myEnergyMinimum.getCharacters());
        System.out.println("Energy Max:" + myEnergyMaximum.getCharacters());
    }


}