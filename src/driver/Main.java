package driver;

import controller.MasterController;
import javafx.application.Application;
import javafx.stage.Stage;


/**
 * Main program driver
 */
public class Main extends Application {

    @SuppressWarnings("unused")
	private MasterController mc;

    public static void main(String[] args) {
        launch(args);
    }

    // Creates the panel and master controller. JavaFX uses this method when starting the program.
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Not App: Compare Appliances!");
        stage.setResizable(false);
        mc = new MasterController(stage);
    }
}
