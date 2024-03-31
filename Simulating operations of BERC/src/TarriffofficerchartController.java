/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Reaper
 */
public class TarriffofficerchartController implements Initializable {

    @FXML
    private PieChart tarriffpiechart;
    private final String tariffDataFile = "tarriff.txt"; 

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    try {
            Map<String, Double> departmentTariffMap = readTariffData();

            PieChart.Data[] pieChartData = new PieChart.Data[departmentTariffMap.size()];
            int i = 0;
            for (Map.Entry<String, Double> entry : departmentTariffMap.entrySet()) {
                pieChartData[i] = new PieChart.Data(entry.getKey(), entry.getValue());
                i++;
            }

            tarriffpiechart.getData().addAll(pieChartData);
        } catch (IOException e) {
            System.err.println("Error reading tariff data: " + e.getMessage());
        }
    }

    private Map<String, Double> readTariffData() throws IOException {
        Map<String, Double> departmentTariffMap = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(tariffDataFile));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length >= 7) {
                String department = data[0];
                double tariffAmount = Double.parseDouble(data[data.length - 1]);
                departmentTariffMap.put(department, tariffAmount);
            } else {
                System.err.println("Warning: Invalid data format in tariff.txt (line: " + line + ")");
            }
        }

        reader.close();
        return departmentTariffMap;
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
