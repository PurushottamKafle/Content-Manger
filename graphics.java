package pksoftFX;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class graphics extends Application{
//  first of all we need to declare the table view
	TableView<Product> table;
	Stage window;
	TextField nameInput, priceInput, quantityInput;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Contents Manager");
 // making colums
        // name
        TableColumn<Product, String> Columname = new TableColumn<>("Name");
        Columname.setCellValueFactory(new PropertyValueFactory("name"));
        Columname.setMinWidth(200);
        
        // price
        TableColumn<Product, Double> Columnprice = new TableColumn<>("Price");
        Columnprice.setCellValueFactory(new PropertyValueFactory("price"));
        Columnprice.setMinWidth(100);
        // quantity
        TableColumn<Product, Integer> Columnquantity = new TableColumn<>("Quantity");
        Columnquantity.setCellValueFactory(new PropertyValueFactory("quantity"));
        Columnquantity.setMinWidth(100);
        // making input and its layout
        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);
        // for price Input
        priceInput = new TextField();
        priceInput.setPromptText("Price");
        // quantityInput
        quantityInput =new TextField();
        quantityInput.setPromptText("Quantity");
        // making two add and delete buttons
        Button addButton = new  Button("Add");
        addButton.setOnAction(e-> addButtonClicked());// listener event
        Button deleButton = new Button("Delete");
        deleButton.setOnAction(e-> deleButtonClicked());
        // making Horizental box as a primaryLayout
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10,10,10,10));
        hbox.setSpacing(10);
        hbox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, deleButton);
        // making table view
        table = new TableView<>();
        table.getColumns().addAll(Columname, Columnprice, Columnquantity);
        
        table.getItems().addAll(getProduct());
       
        VBox vBox = new VBox(table, hbox); // table is inside the Verticle BOX
        vBox.getChildren().addAll();

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }
    // making event handler method
    public void addButtonClicked() {
    	// make object of class
    	Product product = new Product();
    	product.setName(nameInput.getText());
    	product.setPrice(Double.parseDouble(priceInput.getText()));
    	product.setQuantity(Integer.parseInt(quantityInput.getText()));
    	// vayo
    	table.getItems().add(product);
    	nameInput.clear();
    	priceInput.clear();
    	quantityInput.clear();
    }
    // delete button clicked
    public void deleButtonClicked() {
    	ObservableList<Product> allProducts, selectedProducts;
    	allProducts = table.getItems();
    	selectedProducts = table.getSelectionModel().getSelectedItems();
    	selectedProducts.forEach(allProducts::remove);
    }
    public ObservableList<Product> getProduct(){
	ObservableList<Product> products = FXCollections.observableArrayList();
	products.add(new Product("Dell Vostro 3458", 450.9, 1));
	products.add(new Product("Karbonn K9", 90.9, 30));
	products.add(new Product("Colors k2o", 40.9, 200));
	return products;
}
   
}
