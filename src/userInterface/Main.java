package userInterface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	/**
	* The main function responsible of initiating the program.
	* @param args Used to launch the program.
	*/
	public static void main(String[] args) {
		launch(args);
	}

	/**
	* The start function which initializes the stage and displays it.
	* @param stage The main stage of the graphical interface.
	*/
	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("inventoryGUI.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		InventoryController iv = loader.getController();
		iv.setStage(stage);
		stage.setTitle("Minecraft inventory");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		
	}
	
	
}
