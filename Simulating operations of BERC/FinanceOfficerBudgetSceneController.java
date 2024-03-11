/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FinanceOfficerBudgetSceneController implements Initializable {

    @FXML
    private ComboBox<?> combobox;
    @FXML
    private DatePicker datepicker;
    @FXML
    private TextField budgetTF;
    @FXML
    private TextField IncomeTF;
    @FXML
    private TextField ExpenseTF;
    @FXML
    private Button backBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
