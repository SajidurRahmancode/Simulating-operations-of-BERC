/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FinanceOfficerShowSalarySceneController implements Initializable {

    @FXML
    private TableView<?> tableview;
    @FXML
    private TableColumn<?, ?> empidcol;
    @FXML
    private TableColumn<?, ?> salarycol;
    @FXML
    private TableColumn<?, ?> bonuscol;
    @FXML
    private TableColumn<?, ?> datecol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backButtonOnAction(ActionEvent event) {
    }
    
}
