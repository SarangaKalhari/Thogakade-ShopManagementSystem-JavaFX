package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.Item;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemController implements Initializable {

    ObservableList <Item> items = FXCollections.observableArrayList(
        new Item("I001", "Apple iPhone 15", "Electronics", 25, 1450.00),
        new Item("I002", "Samsung Galaxy S24", "Electronics", 18, 1320.50),
        new Item("I003", "Dell XPS 13 Laptop", "Computers", 12, 2450.00),
        new Item("I004", "Nike Air Max 270", "Footwear", 30, 225.99),
        new Item("I005", "Levi’s Jeans 501", "Clothing", 45, 89.90),
        new Item("I006", "HP DeskJet Printer", "Electronics", 20, 155.75),
        new Item("I007", "Wooden Chair", "Furniture", 40, 75.00),
        new Item("I008", "Office Desk Large", "Furniture", 15, 199.99),
        new Item("I009", "Blender Pro 500W", "Home Appliance", 25, 59.50),
        new Item("I010", "Wrist Watch Casio", "Accessories", 35, 120.00)

    );

    @FXML
    private TableColumn<?, ?> colCategory;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private TableView<Item> tblItem;

    @FXML
    private TextField txtCategory;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtQtyOnHand;

    @FXML
    private TextField txtUnitPrice;

    void clearTextField(){
        txtItemCode.clear();
        txtDescription.clear();
        txtCategory.clear();
        txtQtyOnHand.clear();
        txtUnitPrice.clear();
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        items.add(new Item(txtItemCode.getText(), txtDescription.getText(), txtCategory.getText(), Integer.parseInt(txtQtyOnHand.getText()), Double.parseDouble(txtUnitPrice.getText())));
        tblItem.refresh();

        clearTextField();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        Item isSelected = tblItem.getSelectionModel().getSelectedItem();
        items.remove(isSelected);
        tblItem.refresh();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        Item isSelected = tblItem.getSelectionModel().getSelectedItem();

        isSelected.setItemCode(txtItemCode.getText());
        isSelected.setDescription(txtDescription.getText());
        isSelected.setCategory(txtCategory.getText());
        isSelected.setQtyOnHand(Integer.parseInt(txtQtyOnHand.getText()));
        isSelected.setUnitPrice(Double.parseDouble(txtUnitPrice.getText()));

        tblItem.refresh();

        clearTextField();
    }

    @FXML
    void btnViewOnAction(ActionEvent event) {
        boolean isItem = false;

        for(Item itm : items){
            if(txtItemCode.getText().equals(itm.getItemCode())){
                txtDescription.setText(itm.getDescription());
                txtCategory.setText(itm.getCategory());
                txtQtyOnHand.setText(String.valueOf(itm.getQtyOnHand()));
                txtUnitPrice.setText(String.valueOf(itm.getUnitPrice()));

                isItem = true;
                break;
            }
        }

        if (!isItem) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Item");
            alert.setContentText("Please enter a item code");
            alert.showAndWait();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        tblItem.setItems(items);

        tblItem.getSelectionModel().selectedItemProperty().addListener((observableValue, item, t1) -> {
            if (t1 != null){
                txtItemCode.setText(t1.getItemCode());
                txtDescription.setText(t1.getDescription());
                txtCategory.setText(t1.getCategory());
                txtQtyOnHand.setText(String.valueOf(t1.getQtyOnHand()));
                txtUnitPrice.setText(String.valueOf(t1.getUnitPrice()));
            }
        });
    }
}
