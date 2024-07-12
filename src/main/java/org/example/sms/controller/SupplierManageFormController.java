package org.example.sms.controller;

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
import org.example.sms.bo.custom.SupplierBO;
import org.example.sms.db.DbConnection;
import org.example.sms.dto.SupplierDTO;
import org.example.sms.factory.BOFactory;
import org.example.sms.regex.Regex;
import org.example.sms.tm.SupplierTM;
import org.example.sms.types.BOTypes;
import org.example.sms.types.RegexTypes;

import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class SupplierManageFormController implements Initializable {
    @FXML
    public JFXTextField txtId;
    @FXML
    public JFXTextField txtName;
    @FXML
    public JFXTextField txtCompany;
    @FXML
    public JFXTextField txtContact;
    @FXML
    public TableView tblSupplier;
    @FXML
    public TableColumn colId;
    @FXML
    public TableColumn colName;
    @FXML
    public TableColumn colCompanyName;
    @FXML
    public TableColumn colContact;

    SupplierBO supplierBO = (SupplierBO) BOFactory.getBoFactory().getBO(BOTypes.SUPPLIER);

    @FXML
    public void saveBtnOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();
        String name = txtName.getText();
        String company = txtCompany.getText();
        String contact = txtContact.getText();

        try {
            boolean isSaved = supplierBO.saveSupplier(new SupplierDTO(id,name,company,contact));
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION,"Supplier saved").show();
                getAll();
            }else {
                new Alert(Alert.AlertType.ERROR, "Supplier not saved").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQLException").show();
        }
    }
    @FXML
    public void updateBtnOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();
        String name = txtName.getText();
        String company = txtCompany.getText();
        String contact = txtContact.getText();


        try {
            boolean isUpdated = supplierBO.updateSupplier(new SupplierDTO(id,name,company,contact));
            if (isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION, "Supplier updated").show();
                getAll();
            }else {
                new Alert(Alert.AlertType.ERROR, "Supplier not updated").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQLException").show();
        }
    }

    @FXML
    public void deleteBtnOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();

        try {
            boolean isDeleted = supplierBO.deleteSupplier(id);
            if (isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION, "supplier deleted").show();
                getAll();
            }else{
                new Alert(Alert.AlertType.ERROR, "supplier not deleted").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.WARNING, "SQLException").show();
        }
    }
    @FXML
    public void clearBtnOnAction(ActionEvent actionEvent) {
        txtId.clear();
        txtName.clear();
        txtCompany.clear();
        txtContact.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        getAll();
    }

    void getAll() {
        ObservableList<SupplierTM> oblist = FXCollections.observableArrayList();
        try {
            List<SupplierDTO> supplierList = supplierBO.getAllSupplier();
            for (SupplierDTO supplier:supplierList) {
                oblist.add(new SupplierTM(
                        supplier.getId(),
                        supplier.getSupplierName(),
                        supplier.getSupplierCompany(),
                        supplier.getContact()

                ));
            }
            tblSupplier.setItems(oblist);

        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Query error");
        }
    }

    void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("supplierName"));
        colCompanyName.setCellValueFactory(new PropertyValueFactory<>("supplierCompany"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("Contact"));
    }

    public void searchOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();

        try {
             SupplierDTO supplier = supplierBO.searchSupplier(id);
             if (supplier != null){
                 txtId.setText(supplier.getId());
                 txtName.setText(supplier.getSupplierName());
                 txtCompany.setText(supplier.getSupplierCompany());
                 txtContact.setText(String.valueOf(supplier.getContact()));
             }else {
                 new Alert(Alert.AlertType.ERROR, "supplier not found");
             }

        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.WARNING, "SQLException");
        }
    }

    public void supplierTblOnMouseClicked(MouseEvent mouseEvent) {
        SupplierTM selectedSupplier = (SupplierTM) tblSupplier.getSelectionModel().getSelectedItem();
        try {
            SupplierDTO supplier = supplierBO.searchSupplier(selectedSupplier.getId());
            txtId.setText(supplier.getId());
            txtName.setText(supplier.getSupplierName());
            txtCompany.setText(supplier.getSupplierCompany());
            txtContact.setText(String.valueOf(supplier.getContact()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void reportBtnOnAction(ActionEvent actionEvent) throws JRException, SQLException {
<<<<<<< HEAD
        JasperDesign load = JRXmlLoader.load(new File("F:\\IJSE - Second Semester\\Architectural Design Patterns - I\\Stock-Management-System\\src\\main\\resources\\org\\example\\sms\\report\\Supplier.jrxml"));
=======
        JasperDesign load = JRXmlLoader.load(new File("E:\\Final_Project_65\\src\\main\\resources\\report\\Supplier.jrxml"));
>>>>>>> 76e59a66fbd2aad1e7a7519dda9613cda3650dfd
        JRDesignQuery newQuery = new JRDesignQuery();
        String sql = "SELECT * FROM supplier";
        newQuery.setText(sql);
        load.setQuery(newQuery);
        JasperReport js = JasperCompileManager.compileReport(load);
        HashMap<String, Object> hm = new HashMap<>();
        JasperPrint jp = JasperFillManager.fillReport(js, hm, DbConnection.getInstance().getConnection());
        JasperViewer viewer = new JasperViewer(jp, false);
        viewer.show();
    }

    public void txtIdOnKeyReleased(KeyEvent keyEvent) {
        if (Regex.getInstance().getPattern(RegexTypes.SUPPLIER_ID_PATTERN).matcher(txtId.getText()).matches()){
            txtId.setFocusColor(Color.WHITE);
        }else {
            txtId.setFocusColor(Color.RED);
        }
    }

    public void txtNameOnKeyReleased(KeyEvent keyEvent) {
        if (Regex.getInstance().getPattern(RegexTypes.NAME_PATTERN).matcher(txtName.getText()).matches()){
            txtName.setFocusColor(Color.WHITE);
        }else {
            txtName.setFocusColor(Color.RED);
        }
    }

    public void txtCompanyOnKeyReleased(KeyEvent keyEvent) {
        if (Regex.getInstance().getPattern(RegexTypes.ADDRESS_PATTERN).matcher(txtCompany.getText()).matches()){
            txtCompany.setFocusColor(Color.WHITE);
        }else {
            txtCompany.setFocusColor(Color.RED);
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
            String nextId = supplierBO.generateNextSupplierId();
            txtId.setText(nextId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
