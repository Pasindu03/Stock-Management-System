package org.example.sms.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.example.sms.bo.custom.EmployeeBO;
import org.example.sms.db.DbConnection;
import org.example.sms.dto.EmployeeDTO;
import org.example.sms.factory.BOFactory;
import org.example.sms.regex.Regex;
import org.example.sms.tm.EmployeeTM;
import org.example.sms.types.BOTypes;
import org.example.sms.types.RegexTypes;

import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class EmployeeManageFormController implements Initializable {
    @FXML
    public JFXComboBox<String> comboBoxJobRoll;
    @FXML
    public JFXTextField txtID;
    @FXML
    public JFXTextField txtName;
    @FXML
    public JFXTextField txtAddress;
    @FXML
    public JFXTextField txtSalary;
    @FXML
    public JFXTextField txtContact;
    @FXML
    public TableView tblEmployee;
    @FXML
    public TableColumn colId;
    @FXML
    public TableColumn colName;
    @FXML
    public TableColumn colAddress;
    @FXML
    public TableColumn colSalary;
    @FXML
    public TableColumn colJobRoll;
    @FXML
    public TableColumn colContactNo;
    EmployeeBO employeeBO = (EmployeeBO) BOFactory.getBoFactory().getBO(BOTypes.EMPLOYEE);
    @FXML
    public void saveBtnOnAction(ActionEvent actionEvent) {
        String id = txtID.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        double salary = Double.parseDouble(txtSalary.getText());
        String jobRoll = comboBoxJobRoll.getValue();
        String contact = txtContact.getText();

        try {
                boolean isSaved = employeeBO.saveEmployee(new EmployeeDTO(id, name, address, jobRoll, contact, salary));
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Employee saved").show();
                    getAll();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Employee not saved").show();
                }

            } catch(SQLException e){
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, "SQLException").show();
            }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadEmployeeJobRoll();
        setCellValueFactory();
        getAll();
    }

    void getAll() {
        ObservableList<EmployeeTM> oblist = FXCollections.observableArrayList();
        try {
            List<EmployeeDTO> employeeList = employeeBO.getAllEployee();
            for (EmployeeDTO employee:employeeList) {
                oblist.add(new EmployeeTM(
                        employee.getId(),
                        employee.getName(),
                        employee.getAddress(),
                        employee.getContact(),
                        employee.getJobRoll(),
                        employee.getSalary()
                ));
            }
            tblEmployee.setItems(oblist);

        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Query error");
        }
    }

    void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContactNo.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colJobRoll.setCellValueFactory(new PropertyValueFactory<>("jobRoll"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
    }

    private void loadEmployeeJobRoll() {
        ObservableList<String> options = FXCollections.observableArrayList(
                "Admin",
                "Cashier",
                "Shop keeper",
                "Driver",
                "Owner"
        );
        comboBoxJobRoll.setItems(options);

    }
    @FXML
    public void comboBoxJobRollOnAction(ActionEvent actionEvent) {
        String selectedOption = comboBoxJobRoll.getValue();
    }
    @FXML
    public void updateBtnOnAction(ActionEvent actionEvent) {
        String id = txtID.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        String jobRoll = comboBoxJobRoll.getValue();
        double salary = Double.parseDouble(txtSalary.getText());

        try {
            boolean isUpdated = employeeBO.updateEmployee(new EmployeeDTO(id,name,address,contact,jobRoll,salary));
            if (isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION, "Customer updated").show();
                getAll();
            }else {
                new Alert(Alert.AlertType.ERROR, "Customer not updated").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQLException");
        }
    }
    @FXML
    public void clearBtnOnAction(ActionEvent actionEvent) {
        txtID.clear();
        txtName.clear();
        txtAddress.clear();
        txtContact.clear();
        txtSalary.clear();
    }
    @FXML
    public void deleteBtnOnAction(ActionEvent actionEvent) {
        String id = txtID.getText();

        try {
            boolean isDeleted = employeeBO.deleteEmployee(id);
            if(isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer deleted !").show();
                getAll();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "something happened !").show();
        }
    }

    public void tblEmployeeOnMouseClick(MouseEvent mouseEvent) {
        EmployeeTM selectedEmployee = (EmployeeTM) tblEmployee.getSelectionModel().getSelectedItem();
        try {
            EmployeeDTO employee = employeeBO.searchEmployee(selectedEmployee.getId());
            txtID.setText(employee.getId());
            txtName.setText(employee.getName());
            txtAddress.setText(employee.getAddress());
            txtContact.setText(employee.getContact());
            comboBoxJobRoll.setValue(employee.getJobRoll());
            txtSalary.setText(String.valueOf(employee.getSalary()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void txtIDOnAction(ActionEvent actionEvent) {
        String id = txtID.getText();
        try {
            EmployeeDTO employee = employeeBO.searchEmployee(id);
            txtID.setText(employee.getId());
            txtName.setText(employee.getName());
            txtAddress.setText(employee.getAddress());
            txtContact.setText(employee.getContact());
            comboBoxJobRoll.setValue(employee.getJobRoll());
            txtSalary.setText(String.valueOf(employee.getSalary()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void reportBtnOnAction(ActionEvent actionEvent) throws JRException, SQLException {
        JasperDesign load = JRXmlLoader.load(new File("E:\\Final_Project_65\\src\\main\\resources\\report\\EmployeeManage.jrxml"));
        JRDesignQuery newQuery = new JRDesignQuery();
        String sql = "SELECT * FROM employee";
        newQuery.setText(sql);
        load.setQuery(newQuery);
        JasperReport js = JasperCompileManager.compileReport(load);
        HashMap<String, Object> hm = new HashMap<>();
        JasperPrint jp = JasperFillManager.fillReport(js, hm, DbConnection.getInstance().getConnection());
        JasperViewer viewer = new JasperViewer(jp, false);
        viewer.show();
    }

    public void employeeIdOnKeyReleased(KeyEvent keyEvent) {
        if (Regex.getInstance().getPattern(RegexTypes.EMPLOYEE_ID_PATTERN).matcher((txtID.getText())).matches()) {
            txtID.setFocusColor(Color.WHITE);
        } else {

            txtID.setFocusColor(Color.RED);
        }
    }


    public void txtNameOnKeyReleased(KeyEvent keyEvent) {
        if (Regex.getInstance().getPattern(RegexTypes.NAME_PATTERN).matcher(txtName.getText()).matches()){
            txtName.setFocusColor(Color.WHITE);
        }else {
            txtName.setFocusColor(Color.RED);
        }
    }

    public void txtAddressOnKeyReleased(KeyEvent keyEvent) {
        if (Regex.getInstance().getPattern(RegexTypes.ADDRESS_PATTERN).matcher(txtAddress.getText()).matches()){
            txtAddress.setFocusColor(Color.WHITE);
        }else {
            txtAddress.setFocusColor(Color.RED);
        }
    }

    public void txtSalaryOnKeyReleased(KeyEvent keyEvent) {
        if (Regex.getInstance().getPattern(RegexTypes.DOUBLE_PATTERN).matcher(txtSalary.getText()).matches()){
            txtSalary.setFocusColor(Color.WHITE);
        }else {
            txtSalary.setFocusColor(Color.RED);
        }
    }

    public void txtContactOnKeyReleased(KeyEvent keyEvent) {
        if (Regex.getInstance().getPattern(RegexTypes.CONTACT_PATTERN).matcher(txtContact.getText()).matches()){
            txtContact.setFocusColor(Color.WHITE);
        }else {
            txtContact.setFocusColor(Color.RED);
        }
    }

    public void newBtnOnAction(ActionEvent actionEvent) {
        try {
            String nextId = employeeBO.generateNextEmployeeId();
            txtID.setText(nextId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
