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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelclass.EmployeeSalary;
import modelclass.Member;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FinanceOfficerGivenSalaryController implements Initializable {

    @FXML
    private TextField salaryTF;
    @FXML
    private TextField bonusTF;
    @FXML
    private ComboBox<String> idcombox;
    @FXML
    private DatePicker datepicker;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          idcombox.getItems().addAll("2131001", "2221001", "2141565", "2459788", "4131221","9561001","3361999","1785779","1866000","2061099","3335009","1991034");
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
    private void givesalarybutton(ActionEvent event) throws IOException {
           

                          Boolean addstatus= 
                            FinanceOfficer.givenSalary(

                                    salaryTF.getText(),
                                    bonusTF.getText(),
                                    idcombox.getValue(),                                  
                                    datepicker.getValue()
                            );

                    if(addstatus){

                        Alert a=new Alert(Alert.AlertType.INFORMATION);
                        a.setContentText("Salary has given Sucussfully");
                        a.showAndWait();
                    }
                    else{

                        Alert a =new Alert(Alert.AlertType.ERROR);
                        a.setContentText("Error");
                        a.showAndWait();

                }
   
    }
        
        
        
        
        
        }
        
    
   



    
    

