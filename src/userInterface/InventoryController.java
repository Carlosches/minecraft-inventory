package userInterface;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.Block;
import model.Inventory;

public class InventoryController {

	private Inventory minecraftInventory;
	
    @FXML
    private GridPane inventory;

    @FXML
    private ComboBox<String> itemSelector;

    @FXML
    private TextField quantitySelector;

    @FXML
    private Label quickAccessNumber;

    @FXML
    private GridPane quickAccessBar;

    @FXML
    public void initialize() {
    	ObservableList<String> o = FXCollections.observableArrayList(Block.WOOD, Block.COBBLESTONE, Block.STONE
    			, Block.GRAVEL, Block.ANDESITE, Block.DIRT, Block.SAND, Block.WOODPLANKS, Block.OBSIDIAN
    			, Block.BRICK, Block.GRANITE, Block.DIORITE, Block.TNT, Block.IRON_ORE, Block.GOLD_ORE);
    	itemSelector.setItems(o);
    	for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				ImageView img = new ImageView();
				img.setImage(new Image(Block.DIRTI));
				img.setFitWidth(91);
				img.setFitHeight(48);
				Label l = new Label("64");
				l.setAlignment(Pos.CENTER_RIGHT);
				l.setPrefWidth(90);
				l.setPrefHeight(21);
				VBox v = new VBox();
				v.setOnDragDetected(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent m) {
						
					}
					
				});
				v.setPrefWidth(100);
				v.setPrefHeight(200);
				v.getChildren().add(img);
				v.getChildren().add(l);
				inventory.add(v, j, i);
				
			}
		}
    	minecraftInventory = new Inventory();
    }
    
    @FXML
    void addItemButton(ActionEvent event) {
    	if(!itemSelector.getValue().isEmpty()) {
    		if(!quantitySelector.getText().isEmpty()) {
    			int a = -1;
    			try {
    				a = Integer.parseInt(quantitySelector.getText());
    			}catch(NumberFormatException e) {
    			}
    			if(a >= 0 && a <= 64) {
    				if(minecraftInventory.addBlock(itemSelector.getValue(), a)) {
    					
    				}else {
    					
    				}
    			}else {
    				quantitySelector.clear();
    				quantitySelector.setPromptText("Please specify a number less than or equal to 64");
    			}
    		}else
    			quantitySelector.setPromptText("Please specify a quantity to be added");
    	}else
    		itemSelector.setPromptText("Please select a block to be added");
    }
    
    @FXML
    void changeBarButton(ActionEvent event) {

    }

    @FXML
    void clearInventoryButton(ActionEvent event) {

    }

}
