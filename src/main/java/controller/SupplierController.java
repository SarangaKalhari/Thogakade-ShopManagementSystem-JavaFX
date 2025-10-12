package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.Supplier;

import java.net.URL;
import java.util.ResourceBundle;

public class SupplierController implements Initializable {

    ObservableList <Supplier> suppliers = FXCollections.observableArrayList(

            new Supplier("S001", "John Perera", "Perera Electronics", "12 Main Street", "Colombo", "Western", "10000", "077-4567890", "john@pereraelec.lk"),
            new Supplier("S002", "Nimal Silva", "Silva Textiles", "45 Lake Road", "Kandy", "Central", "20000", "071-2345678", "nimal@silvatextiles.lk"),
            new Supplier("S003", "Kasun Fernando", "GreenGrow Agro Ltd", "88 Market Lane", "Kurunegala", "North Western", "60000", "075-7891234", "kasun@greengrow.lk"),
            new Supplier("S004", "Amal Wijesinghe", "TechZone Pvt Ltd", "23 Liberty Plaza", "Colombo", "Western", "10100", "078-1234567", "amal@techzone.lk"),
            new Supplier("S005", "Ruwan Dissanayake", "Dissanayake Furniture", "105 Galle Road", "Galle", "Southern", "80000", "070-9988776", "ruwan@dissafurn.lk"),
            new Supplier("S006", "Priya Jayasuriya", "Jayasuriya Distributors", "16 Temple Road", "Matara", "Southern", "81000", "076-6677889", "priya@jayadis.lk"),
            new Supplier("S007", "Lahiru Bandara", "FreshFoods Suppliers", "9 New Market Street", "Negombo", "Western", "11500", "072-5544332", "lahiru@freshfoods.lk"),
            new Supplier("S008", "Ishara Ranasinghe", "PrintMaster Solutions", "33 Union Place", "Colombo", "Western", "10020", "074-3322110", "ishara@printmaster.lk"),
            new Supplier("S009", "Anusha Rathnayake", "Rathna Cosmetics", "78 Temple Street", "Kandy", "Central", "20050", "071-8899776", "anusha@rathnacos.lk"),
            new Supplier("S010", "Thilina Madushan", "Madushan Hardware", "5 Old Road", "Anuradhapura", "North Central", "50000", "075-6655443", "thilina@maduhard.lk")
    );

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colCompanyName;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPhone;

    @FXML
    private TableColumn<?, ?> colPostalCode;

    @FXML
    private TableColumn<?, ?> colProvince;

    @FXML
    private TableColumn<?, ?> colSupID;

    @FXML
    private TableView<Supplier> tblSupplier;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCompanyName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtPostalCode;

    @FXML
    private TextField txtProvince;

    @FXML
    void btnAddOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void btnViewOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colSupID.setCellValueFactory(new PropertyValueFactory<>("supplierID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCompanyName.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        tblSupplier.setItems(suppliers);

        tblSupplier.getSelectionModel().selectedItemProperty().addListener((observableValue, supplier, sup) -> {
            if (sup != null){
                txtID.setText(sup.getSupplierID());
                txtName.setText(sup.getName());
                txtCompanyName.setText(sup.getCompanyName());
                txtAddress.setText(sup.getAddress());
                txtCity.setText(sup.getCity());
                txtProvince.setText(sup.getProvince());
                txtPostalCode.setText(sup.getPostalCode());
                txtPhone.setText(sup.getPhone());
                txtEmail.setText(sup.getEmail());
            }
        });

    }
}
