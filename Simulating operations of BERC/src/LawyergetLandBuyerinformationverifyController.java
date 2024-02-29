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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import modelclass.Landbuyerinformation;

/**
 * FXML Controller class
 *
 * @author sajid
 */
public class LawyergetLandBuyerinformationverifyController implements Initializable {

    @FXML
    private TextArea LandBuyerInformationArea;
    @FXML
    private ComboBox<String> employeeidcombobox2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       File g = null;
        FileInputStream fi = null;      
        ObjectInputStream oi = null;
        
        
        
        try {
            g = new File("Landbuyerinfo.bin");
            fi = new FileInputStream(g);
            oi = new ObjectInputStream(fi);
            Landbuyerinformation land;
            try{
                LandBuyerInformationArea.setText("");
                
                while(true){
                    land = (Landbuyerinformation)oi.readObject();
                    employeeidcombobox2.getItems().add(land.getNid());
                }
                

            }//end of nested try
            catch(Exception e){
                //
            }//nested catch     
                   
        } catch (IOException ex) { } 
        finally {
            try {
                if(oi != null) oi.close();
            } catch (IOException ex) { }
        }
    }    

    @FXML
    private void backbtn(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("LawyerHomeScene.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }

    @FXML
    private void loadbuyerdatabtn(ActionEvent event) {
        LandBuyerInformationArea.setText("");
                File f = null;
                FileInputStream fis = null;      
                ObjectInputStream ois = null;

                try {
                    f = new File("Landbuyerinfo.bin");
                    fis = new FileInputStream(f);
                    ois = new ObjectInputStream(fis);
                    Landbuyerinformation buyer;
                    try{
                        LandBuyerInformationArea.setText("");
                        while(true){
                            buyer = (Landbuyerinformation)ois.readObject();
                            if(employeeidcombobox2.getValue().equals(buyer.getNid())){

                            LandBuyerInformationArea.appendText("Land Buyer:"+buyer.getName());
                            LandBuyerInformationArea.appendText(",Gender: "+buyer.getGender()+",Age: "+buyer.getAge()+",Nid: "+buyer.getNid()+",Phone:"+buyer.getPhone()+",Address: "+buyer.getAddress()+" \n");
                            }


                        }
                    }//end of nested try
                    catch(Exception e){
                        //
                    }//nested catch     
                    LandBuyerInformationArea.appendText("All objects are loaded successfully...\n");            
                } catch (IOException ex) { } 
                finally {
                    try {
                        if(ois != null) ois.close();
                    } catch (IOException ex) { }
                } 
        
    }
    
}
