package userInterface;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.Block;
import model.Inventory;
import model.Slot;

public class InventoryController {

	private Inventory minecraftInventory;
	
	private VBox[][] inventoryMirror;
	
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
    	inventoryMirror = new VBox[3][9];
    	for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				ImageView img = new ImageView();
				img.setFitWidth(91);
				img.setFitHeight(48);
				Label l = new Label();
				l.setAlignment(Pos.CENTER_RIGHT);
				l.setPrefWidth(90);
				l.setPrefHeight(21);
				VBox v = new VBox();
				v.setPrefWidth(100);
				v.setPrefHeight(200);
				v.getChildren().add(img);
				v.getChildren().add(l);
				inventory.add(v, j, i);
				inventoryMirror[i][j] = v;
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
    					for (int i = 0; i < 3; i++) {
    						for (int j = 0; j < 9; j++) {
    							Slot current = minecraftInventory.getMatrix()[i][j];
    							if(current!=null) {
    								VBox v = inventoryMirror[i][j];
    								ImageView img = (ImageView) v.getChildren().get(0);
    								Label l = (Label) v.getChildren().get(1);
    								l.setText("" + current.getQuantity());
    								//img.setImage(new Image(current.getBlock().getImage()));
    							}
    						}
    					}
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
