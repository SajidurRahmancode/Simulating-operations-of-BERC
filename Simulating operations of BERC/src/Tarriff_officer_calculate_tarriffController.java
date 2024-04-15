/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelclass.Tarriff;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Reaper
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */


/**
 * FXML Controller class
 *
 * @author Reaper
 */
public class Tarriff_officer_calculate_tarriffController implements Initializable{

    @FXML
    private TextField amountinvested;
    @FXML
    private TextField profit;
    @FXML
    private TextField tarriff_percentage;
    @FXML
    private DatePicker endpicker;
    @FXML
    private ComboBox<String> deptcombo;
    @FXML
    private DatePicker startpicker;
    @FXML
    private TableView<Tarriff> Tableview;
    @FXML
    private TableColumn<Tarriff, String> deptc;
    @FXML
    private TableColumn<Tarriff, String> investedc;
    @FXML
    private TableColumn<Tarriff, String> profitc;
    @FXML
    private TableColumn<Tarriff, String> percentagec;
    @FXML
    private TableColumn<Tarriff, String> startc;
    @FXML
    private TableColumn<Tarriff, String> endc;
    @FXML
    private TableColumn<Tarriff, String> tarriffc;
    //private ObservableList<Tarriff> caseList;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    deptcombo.getItems().addAll("Electrical","Water","Gas");
    
    
    deptc.setCellValueFactory(new PropertyValueFactory<Tarriff, String>("deptcombo"));
    investedc.setCellValueFactory(new PropertyValueFactory<Tarriff, String>("amountinvested"));
    profitc.setCellValueFactory(new PropertyValueFactory<Tarriff, String>("profit"));
    percentagec.setCellValueFactory(new PropertyValueFactory<Tarriff, String>("tarriff_percentage"));
    startc.setCellValueFactory(new PropertyValueFactory<Tarriff, String>("startpicker"));
    endc.setCellValueFactory(new PropertyValueFactory<Tarriff, String>("endpicker"));
    tarriffc.setCellValueFactory(new PropertyValueFactory<Tarriff, String>("tarriff"));



    
    
    }

    @FXML
    private void savebtn(ActionEvent event) throws IOException {
        File file = new File("tarriff.txt");
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(file, true); // Append to existing file
            bw = new BufferedWriter(fw);

            String data = String.format("%s,%d,%d,%.2f,%s,%s,%.2f,\n",
                    deptcombo.getValue(),
                    Integer.parseInt(amountinvested.getText()),
                    Integer.parseInt(profit.getText()),
                    Float.parseFloat(tarriff_percentage.getText()),
                    startpicker.getValue().toString(),
                    endpicker.getValue().toString(),                    
                    calctarriff(Float.parseFloat(tarriff_percentage.getText()), Integer.parseInt(amountinvested.getText()), Integer.parseInt(profit.getText())));

            bw.write(data);

        } catch (IOException ex) {
            Logger.getLogger(Tarriff_officer_calculate_tarriffController.class.getName()).log(Level.SEVERE, null, ex);
            showErrorAlert("Error Saving Data", "Failed to save data to tarriff.txt.");
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Tarriff_officer_calculate_tarriffController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }

    @FXML
    private void loader(ActionEvent event) {
        List<Tarriff> caseList = new ArrayList<>();
        //caseList.clear();
        File file = new File("tarriff.txt");

        if (!file.exists()) {
            return; // No file to load
        }

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Tarriff tariff = new Tarriff(
                        data[0],
                        Float.parseFloat(data[1]),
                        Float.parseFloat(data[2]),
                        Float.parseFloat(data[3]),
                        LocalDate.parse(data[4]),
                        LocalDate.parse(data[5]),
                         Float.parseFloat(data[6])

                        
                );
                caseList.add(tariff);
            }

            Tableview.setItems(FXCollections.observableArrayList(caseList));

        } catch (IOException ex) {
            Logger.getLogger(Tarriff_officer_calculate_tarriffController.class.getName()).log(Level.SEVERE, null, ex);
            showErrorAlert("Error Loading Data", "Failed to load data from tarriff.txt.");
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Tarriff_officer_calculate_tarriffController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
        
        
        
        
    
}
    private void showErrorAlert(String title, String message) {
       Alert alert = new Alert(Alert.AlertType.ERROR);
       alert.setTitle(title);
       alert.setContentText(message);
       alert.showAndWait();
    }    

    public static float calctarriff(float tarriff_percentage, int amountinvested, int profit) {
                    float tariffAmount = (tarriff_percentage / 100) * profit;
                    return tariffAmount;


     }

    @FXML
    private void backbtn(ActionEvent event) throws IOException {
        
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("tarriffofficerhomescene.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene2);
        window.show();
    }
}

    
        
    



  
    

