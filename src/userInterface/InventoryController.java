package userInterface;

import dataStructures.*;
import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Block;
import model.Inventory;
import model.Slot;

public class InventoryController {

	private Stage stage;
	
	private QueueInterface<GridPane> quickAccessBars;
	
	private QueueInterface<StackInterface<VBox>> quickAccessBarsMirror;
	
	private int nextEmptyQuickAccessBar;
	
	private int currentQuickAccessBar;
	
	private Inventory minecraftInventory;
	
	private VBox[][] inventoryMirror;
	
    @FXML
    private BorderPane parent;
	
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
    private HBox quickAccessBarDisplay;
    
    @FXML
    public void initialize() {
    	quickAccessBars = new QueueClass<>();
    	quickAccessBarsMirror = new QueueClass<>();
    	quickAccessBarsMirror.enqueue(new StackClass<>());
    	nextEmptyQuickAccessBar = 1;
    	currentQuickAccessBar = 1;
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
    								img.setImage(new Image(current.getBlock().getImage()));
    							}
    						}
    					}

    				}
    				
    				else {
    					int p = minecraftInventory.getNextEmptySlotRow();
    					int q = minecraftInventory.getNextEmptySlotColumn();
    					while((p < Inventory.ROWS-1 && q < Inventory.COLUMNS) && minecraftInventory.getMatrix()[p][q] != null) {
    						q++;
    						if(q == Inventory.COLUMNS) {
    							q = 0;
    							p++;
    						}
    					}
    					if(!(p == Inventory.ROWS-1 && q == Inventory.COLUMNS)) {
    						minecraftInventory.setNextEmptySlotRow(p);
    						minecraftInventory.setNextEmptySlotColumn(q);
    						if(minecraftInventory.addBlock(itemSelector.getValue(), a)) {
    	    					for (int i = 0; i < 3; i++) {
    	    						for (int j = 0; j < 9; j++) {
    	    							Slot current = minecraftInventory.getMatrix()[i][j];
    	    							if(current!=null) {
    	    								VBox v = inventoryMirror[i][j];
    	    								ImageView img = (ImageView) v.getChildren().get(0);
    	    								Label l = (Label) v.getChildren().get(1);
    	    								l.setText("" + current.getQuantity());
    	    								img.setImage(new Image(current.getBlock().getImage()));
    	    							}
    	    						}
    	    					}
    						}
    					}

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
			quickAccessBars.enqueue(quickAccessBars.dequeue());
			quickAccessBarDisplay.getChildren().set(1, quickAccessBars.front());
			if(currentQuickAccessBar == nextEmptyQuickAccessBar-1)
				currentQuickAccessBar = 1;
			else
				currentQuickAccessBar++;
			quickAccessNumber.setText(currentQuickAccessBar + "");
		
    }

    @FXML
    void clearInventoryButton(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("inventoryGUI.fxml"));
    	Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		InventoryController iv = loader.getController();
		iv.setStage(this.stage);
		stage.setTitle("Minecraft inventory");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
    }
    
    @FXML
    void newQuickAccessBar(ActionEvent event) {
    	for (int i = 0; i < inventoryMirror.length; i++) {
			for (int j = 0; j < inventoryMirror[i].length; j++) {
				VBox v = inventoryMirror[i][j];
				int p = i;
				int q = j;
				v.setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent arg0) {
						String type = minecraftInventory.getMatrix()[p][q].getBlock().getType();
						List<Slot> slots = minecraftInventory.getInventoryTable().get(type);
						GridPane quick = new GridPane();
						quick.setGridLinesVisible(true);
						quick.setStyle("-fx-background-color:#8b8b8b; -fx-border-color: black;");
						quick.setPrefSize(840, 69);
						int minRow = 5;
						int minCol = 10;
						int count = 0;
						for (int i = 0; i < slots.size() && i < 9; i++) {
							count++;
							int j = slots.get(i).getPosRow();
							int k = slots.get(i).getPosColumn();
							minRow = Math.min(minRow, j);
							minCol = Math.min(minCol, k);
							VBox vBox = inventoryMirror[j][k];
							ImageView img = new ImageView();
							img.setFitWidth(91);
							img.setFitHeight(48);
							Label l = new Label();
							l.setAlignment(Pos.CENTER_RIGHT);
							l.setPrefWidth(90);
							l.setPrefHeight(21);
							VBox vv = new VBox();
							vv.setPrefWidth(100);
							vv.setPrefHeight(200);
							vv.getChildren().add(img);
							vv.getChildren().add(l);
							inventory.getChildren().remove(vBox);
							inventoryMirror[j][k] = vv;
							inventory.add(vv, k, j);
							minecraftInventory.getMatrix()[j][k] = null;
							if(nextEmptyQuickAccessBar == 1) {
								quick.add(vBox, i, 0);
								quickAccessBarsMirror.front().push(vBox);
							}else {
								currentQuickAccessBar = nextEmptyQuickAccessBar;
								quickAccessNumber.setText(currentQuickAccessBar + "");
								quick.add(vBox, i, 0);
								quickAccessBarsMirror.front().push(vBox);
							}
							
						}
						
						quickAccessBars.enqueue(quick);
						while(!quickAccessBars.front().equals(quick))
							quickAccessBars.enqueue(quickAccessBars.dequeue());
						quickAccessBarDisplay.getChildren().set(1, quick);
						minecraftInventory.setNextEmptySlotRow(minRow);
						minecraftInventory.setNextEmptySlotColumn(minCol);
						while(count > 0) {
							slots.remove(0);
							count--;
						}
						nextEmptyQuickAccessBar++;
						for (int i = 0; i < inventoryMirror.length; i++) {
							for (int j = 0; j < inventoryMirror[i].length; j++) {
								VBox box = inventoryMirror[i][j];
								box.setOnMouseClicked(null);
							}
						}
					}
				});
			}
		}
    }

    public void setStage(Stage stage) {
    	this.stage = stage;
    }
    
}
