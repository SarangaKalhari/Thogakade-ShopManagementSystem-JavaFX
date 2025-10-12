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
    private TextField txtCity;

    @FXML
    private TextField txtCompanyName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtEmail1;

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

    }
}
