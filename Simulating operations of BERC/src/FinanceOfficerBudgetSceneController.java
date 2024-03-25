/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelclass.Budget;
import modelclass.Member;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FinanceOfficerBudgetSceneController implements Initializable {

    @FXML
    private ComboBox<String> combobox;
    @FXML
    private DatePicker datepicker;
    @FXML
    private TextField budgetTF;
    @FXML
    private TextField IncomeTF;
    @FXML
    private TextField ExpenseTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         combobox.getItems().addAll("chairman", "Employee", "Lawyer", "Tariff officer", "Consumer","Finance officer","District Manager","Government Authorities");
        
        
        // TODO
    }    

    @FXML
    private void backbutton(ActionEvent event) throws IOException {
         Parent scene2Parent = FXMLLoader.load(getClass().getResource("FinanceOfficerHomeScene.fxml"));
         Scene scene2 = new Scene(scene2Parent);
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
         window.setScene(scene2);
         window.show();
    }

    @FXML
    private void savebutton(ActionEvent event) throws IOException {
        
                          Boolean addstatus= 
                            FinanceOfficer.givebudget(

                                    combobox.getValue(),
                                    budgetTF.getText(),
                                    IncomeTF.getText(),
                                    ExpenseTF.getText(),
                                    datepicker.getValue()
   
                            );


                    if(addstatus){

                        Alert a=new Alert(Alert.AlertType.INFORMATION);
                        a.setContentText("Budget are Added Sucussfully");
                        a.showAndWait();
                    }
                    else{

                        Alert a =new Alert(Alert.AlertType.ERROR);
                        a.setContentText("Error");
                        a.showAndWait();

                }
   
    }
        
        
        
        
        
        }
        
    
     

