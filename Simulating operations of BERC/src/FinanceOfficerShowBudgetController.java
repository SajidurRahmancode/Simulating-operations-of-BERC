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
import modelclass.Budget;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FinanceOfficerShowBudgetController implements Initializable {

    @FXML
    private TableView<Budget> tableview;
    @FXML
    private TableColumn<Budget, String> departmentcol;
    @FXML
    private TableColumn<Budget, String> datecol;
    @FXML
    private TableColumn<Budget, String> budgetcol;
    @FXML
    private TableColumn<Budget, String> incomecol;
    @FXML
    private TableColumn<Budget,String> expensecol;
    private ObservableList<Budget> budgetList;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        departmentcol.setCellValueFactory(new PropertyValueFactory <Budget, String>("department"));
        datecol.setCellValueFactory(new PropertyValueFactory <Budget, String>("sd"));
        budgetcol.setCellValueFactory(new PropertyValueFactory <Budget, String>("budget"));
        incomecol.setCellValueFactory(new PropertyValueFactory <Budget, String>("income"));
        expensecol.setCellValueFactory(new PropertyValueFactory <Budget, String>("expense"));
      
       budgetList = FinanceOfficer.ShowBudget();
        
        for (Budget b: budgetList){
            
            tableview.getItems().add(b);
                        
            
        }
    }
        // TODO
       

    @FXML
    private void backbutton(ActionEvent event) throws IOException {
         Parent scene2Parent = FXMLLoader.load(getClass().getResource("FinanceOfficerHomeScene.fxml"));
         Scene scene2 = new Scene(scene2Parent);
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
         window.setScene(scene2);
         window.show();
    }
    
    
}
