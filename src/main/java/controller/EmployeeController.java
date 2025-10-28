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
import model.dto.Employee;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeController implements Initializable {

    ObservableList<Employee> employees = FXCollections.observableArrayList(

            new Employee("E001", "Nimal Perera", "199012345678", "1990-03-15", "Manager", 150000.00, "077-4567890", "12 Flower Road, Colombo", "2015-06-01", "Active"),
            new Employee("E002", "Kasun Fernando", "199233456789", "1992-08-21", "Cashier", 85000.00, "071-2345678", "33 Hill Street, Kandy", "2018-02-15", "Active"),
            new Employee("E003", "Priya Jayasuriya", "198876543210", "1988-11-30", "Sales Executive", 95000.00, "075-9876543", "89 Galle Road, Galle", "2017-04-20", "Active"),
            new Employee("E004", "Lahiru Bandara", "199545612345", "1995-07-10", "Store Keeper", 70000.00, "072-4455667", "25 Temple Street, Matara", "2020-01-10", "Active"),
            new Employee("E005", "Anusha Rathnayake", "199333345678", "1993-09-25", "HR Assistant", 90000.00, "078-2233445", "44 Lake View, Kurunegala", "2019-09-05", "Active"),
            new Employee("E006", "Ruwan Dissanayake", "198755543210", "1987-01-05", "Technician", 80000.00, "076-6677889", "9 Beach Road, Negombo", "2016-12-12", "Active"),
            new Employee("E007", "Thilina Madushan", "199477889900", "1994-05-22", "Supervisor", 98000.00, "070-8899776", "56 Old Road, Anuradhapura", "2019-03-03", "Active"),
            new Employee("E008", "Ishara Ranasinghe", "199812345678", "1998-02-28", "Receptionist", 60000.00, "074-2233110", "8 New Market Street, Colombo", "2021-07-01", "Active"),
            new Employee("E009", "Chamara Wijesinghe", "199022334455", "1990-12-18", "Delivery Officer", 55000.00, "071-8899776", "76 Temple Street, Kandy", "2022-02-12", "Active"),
            new Employee("E010", "Dinithi Silva", "199911122233", "1999-04-09", "Accountant", 120000.00, "075-4455668", "32 Union Place, Colombo", "2023-05-01", "Active")
    );

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colContactNumber;

    @FXML
    private TableColumn<?, ?> colDOB;

    @FXML
    private TableColumn<?, ?> colJoinedDate;

    @FXML
    private TableColumn<?, ?> colNIC;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPosition;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableColumn<?, ?> colSupID;

    @FXML
    private TableView<Employee> tblEmployee;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtDOB;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtJoined;

    @FXML
    private TextField txtNIC;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPosition;

    @FXML
    private TextField txtSalary;

    @FXML
    private TextField txtStatus;

    void clearTextField(){
        txtID.clear();
        txtName.clear();
        txtNIC.clear();
        txtAddress.clear();
        txtDOB.clear();
        txtPosition.clear();
        txtContact.clear();
        txtSalary.clear();
        txtJoined.clear();
        txtStatus.clear();
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {

        employees.add(new Employee(txtID.getText(), txtName.getText(), txtNIC.getText(), txtDOB.getText(), txtPosition.getText(), Double.parseDouble(txtSalary.getText()), txtContact.getText(), txtAddress.getText(), txtJoined.getText(), txtStatus.getText()));
        tblEmployee.refresh();

        clearTextField();

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

        Employee selectedEmployee = tblEmployee.getSelectionModel().getSelectedItem();
        employees.remove(selectedEmployee);

        tblEmployee.refresh();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

        Employee selectedEmployee = tblEmployee.getSelectionModel().getSelectedItem();

        selectedEmployee.setEmployeeID(txtID.getText());
        selectedEmployee.setName(txtName.getText());
        selectedEmployee.setNic(txtNIC.getText());
        selectedEmployee.setDob(txtDOB.getText());
        selectedEmployee.setAddress(txtAddress.getText());
        selectedEmployee.setContactNumber(txtContact.getText());
        selectedEmployee.setPosition(txtPosition.getText());
        selectedEmployee.setSalary(Double.parseDouble(txtSalary.getText()));
        selectedEmployee.setJoinedDate(txtJoined.getText());
        selectedEmployee.setStatus(txtStatus.getText());

        tblEmployee.refresh();

        clearTextField();
    }

    @FXML
    void btnViewOnAction(ActionEvent event) {

        boolean isEmployee = false;

        for(Employee emp : employees){
            if(txtID.getText().equals(emp.getEmployeeID())){
                txtID.setText(emp.getEmployeeID());
                txtName.setText(emp.getName());
                txtNIC.setText(emp.getNic());
                txtDOB.setText(emp.getDob());
                txtPosition.setText(emp.getPosition());
                txtSalary.setText(String.valueOf(emp.getSalary()));
                txtAddress.setText(emp.getAddress());
                txtContact.setText(emp.getContactNumber());
                txtJoined.setText(emp.getJoinedDate());
                txtStatus.setText(emp.getStatus());

            }
        }

        if (!isEmployee){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Employee");
            alert.setContentText("Please enter a Employee ID");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colSupID.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colContactNumber.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colJoinedDate.setCellValueFactory(new PropertyValueFactory<>("joinedDate"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        tblEmployee.setItems(employees);

        tblEmployee.getSelectionModel().selectedItemProperty().addListener((observableValue, employee, emp) -> {
            if(emp != null){
                txtID.setText(emp.getEmployeeID());
                txtName.setText(emp.getName());
                txtNIC.setText(emp.getNic());
                txtDOB.setText(emp.getDob());
                txtPosition.setText(emp.getPosition());
                txtSalary.setText(String.valueOf(emp.getSalary()));
                txtContact.setText(emp.getContactNumber());
                txtAddress.setText(emp.getAddress());
                txtJoined.setText(emp.getJoinedDate());
                txtStatus.setText(emp.getStatus());
            }
        });

    }

    public void customerOnAction(ActionEvent actionEvent) {
    }

    public void itemOnAction(ActionEvent actionEvent) {
    }

    public void supplierOnAction(ActionEvent actionEvent) {
    }

    public void employeeOnAction(ActionEvent actionEvent) {
    }
}
