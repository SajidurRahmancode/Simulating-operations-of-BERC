/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelclass.EmployeeSalary;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FinanceOfficerSalaryInfoController implements Initializable {

    @FXML
    private TableView<EmployeeSalary> tableview;
    @FXML
    private TableColumn<EmployeeSalary, String> IDcol;
    @FXML
    private TableColumn<EmployeeSalary, String> salarycol;
    @FXML
    private TableColumn<EmployeeSalary, String> bonuscol;
    @FXML
    private TableColumn<EmployeeSalary, String> datecol;
    
    private ObservableList<EmployeeSalary> salaryList;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        IDcol.setCellValueFactory(new PropertyValueFactory <EmployeeSalary, String>("employeeid"));
        salarycol.setCellValueFactory(new PropertyValueFactory <EmployeeSalary, String>("salary"));
        bonuscol.setCellValueFactory(new PropertyValueFactory <EmployeeSalary, String>("bonusAmount"));
        datecol.setCellValueFactory(new PropertyValueFactory <EmployeeSalary, String>("sd"));
       
        
       salaryList = FinanceOfficer.Salaryinfo();
        
        for (EmployeeSalary s: salaryList){
            
            tableview.getItems().add(s);
                        
            
        }
    }
        
        // TODO

    @FXML
    private void backBTN(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("FinanceOfficerHomeScene.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene2);
        window.show();
    }
    
}
