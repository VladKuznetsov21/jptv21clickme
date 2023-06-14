/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptv21clickme;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 *
 * @author pupil
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button button;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        button.getScene().getRoot().setDisable(!button.getScene().getRoot().isDisable());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}