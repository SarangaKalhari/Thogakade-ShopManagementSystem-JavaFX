package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.dto.Customer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {

    Stage stage = new Stage();

    ObservableList<Customer> customers = FXCollections.observableArrayList(
            new Customer("C001", "Mr.", "John Perera", "1992-05-14", 55000.00, "23 Temple Road", "Colombo", "Western", "10100"),
            new Customer("C002", "Mrs.", "Nadeesha Silva", "1988-11-02", 62000.00, "12 Rose Avenue", "Kandy", "Central", "20000"),
            new Customer("C003", "Ms.", "Tharushi Fernando", "1996-03-19", 48000.00, "78 Lake View", "Galle", "Southern", "80000"),
            new Customer("C004", "Mr.", "Kasun Jayasuriya", "1990-07-25", 75000.00, "45 Green Park", "Kurunegala", "North Western", "60000"),
            new Customer("C005", "Ms.", "Iresha Senanayake", "1998-09-10", 51000.00, "89 Palm Grove", "Matara", "Southern", "81000"),
            new Customer("C006", "Dr.", "Amal Wijesinghe", "1983-01-06", 120000.00, "15 Lotus Lane", "Nugegoda", "Western", "10250"),
            new Customer("C007", "Mr.", "Lahiru Abeysekara", "1994-10-22", 68000.00, "56 College Street", "Jaffna", "Northern", "40000"),
            new Customer("C008", "Mrs.", "Dilhani Gunasekara", "1989-12-05", 58000.00, "34 Beach Road", "Negombo", "Western", "11500")
    );

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colCustId;

    @FXML
    private TableColumn<?, ?> colDOB;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPostalcode;

    @FXML
    private TableColumn<?, ?> colProvince;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private TableView<Customer> tblCustomer;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtDOB;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPostalCode;

    @FXML
    private TextField txtProvience;

    @FXML
    private TextField txtSalary;

    @FXML
    private TextField txtTitle;

    void clearTextField(){
        txtID.clear();
        txtTitle.clear();
        txtName.clear();
        txtDOB.clear();
        txtSalary.clear();
        txtAddress.clear();
        txtCity.clear();
        txtProvience.clear();
        txtPostalCode.clear();
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        customers.add(new Customer(txtID.getText(), txtTitle.getText(), txtName.getText(), txtDOB.getText(), Double.parseDouble(txtSalary.getText()), txtAddress.getText(), txtCity.getText(), txtProvience.getText(), txtPostalCode.getText()));
        tblCustomer.refresh();

        clearTextField();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        Customer selectedItem = tblCustomer.getSelectionModel().getSelectedItem();
        customers.remove(selectedItem);

        tblCustomer.refresh();
    }

    @FXML
    void btnViewOnAction(ActionEvent event) {

        boolean isCustomer = false;

        for(Customer c1 : customers){
            if(txtID.getText().equals(c1.getCustID())){
                txtTitle.setText(c1.getTitle());
                txtName.setText(c1.getName());
                txtDOB.setText(c1.getDob());
                txtSalary.setText(String.valueOf(c1.getSalary()));
                txtAddress.setText(c1.getAddress());
                txtCity.setText(c1.getCity());
                txtProvience.setText(c1.getProvince()); // make sure getter name matches
                txtPostalCode.setText(c1.getPostalCode());

                isCustomer = true;
                break;
            }
        }

        if (!isCustomer) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid User");
            alert.setContentText("Please enter a valid Customer ID");
            alert.showAndWait();
        }

    }



    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        Customer selectedItem = tblCustomer.getSelectionModel().getSelectedItem();

        selectedItem.setCustID(txtID.getText());
        selectedItem.setTitle(txtTitle.getText());
        selectedItem.setName(txtName.getText());
        selectedItem.setDob(txtDOB.getText());
        selectedItem.setSalary(Double.parseDouble(txtSalary.getText()));
        selectedItem.setAddress(txtAddress.getText());
        selectedItem.setCity(txtCity.getText());
        selectedItem.setProvince(txtProvience.getText());
        selectedItem.setPostalCode(txtPostalCode.getText());

        tblCustomer.refresh();

        clearTextField();

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCustId.setCellValueFactory(new PropertyValueFactory<>("custID"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colPostalcode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

        tblCustomer.setItems(customers);

        tblCustomer.getSelectionModel().selectedItemProperty().addListener((observableValue, customer, aCustomer) -> {
            if(aCustomer != null){
                txtID.setText(aCustomer.getCustID());
                txtTitle.setText(aCustomer.getTitle());
                txtName.setText(aCustomer.getName());
                txtDOB.setText(aCustomer.getDob());
                txtSalary.setText(String.valueOf(aCustomer.getSalary()));
                txtAddress.setText(aCustomer.getAddress());
                txtCity.setText(aCustomer.getCity());
                txtProvience.setText(aCustomer.getProvince());
                txtPostalCode.setText(aCustomer.getPostalCode());
            }
        });

    }

    public void customerOnAction(ActionEvent actionEvent) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/customer_management.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void itemOnAction(ActionEvent actionEvent) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/item_management.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Thogakade Item Management System");
        stage.show();

        Stage currentStage = (Stage) ( (Node)actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
    }

    public void supplierOnAction(ActionEvent actionEvent) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/supplier_management.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Thogakade Supplier Management");
        stage.show();

        Stage currentStage = (Stage) ( (Node)actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
    }

    public void employeeOnAction(ActionEvent actionEvent) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/employee_management.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Thogakade Employee Management");
        stage.show();

        Stage currentStage = (Stage) ( (Node)actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
    }
}
