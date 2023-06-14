/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptv21clickme;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author pupil
 */
public class JPTV21ClickMe extends Application {
    private boolean isMoving = true;
    private int delay = 100;
    private Integer level = 1;
    private final double sceneWidth = 500;
    private final double sceneHeight = 500;
    private Button btnClickMe;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        Label lblLevel = (Label) scene.lookup("#lblLevel");
        btnClickMe = (Button) scene.lookup("#btnClickMe");
        btnClickMe.setOnAction(event -> {
            isMoving =! isMoving;
            if(btnClickMe.getText().equals("Нажми")){
                btnClickMe.setText("Продолжить");
            }else{
                btnClickMe.setText("Нажми");
                delay -= 100;
                level++;
                lblLevel.setText("Level "+level.toString());
                
            }
        });
        
        
        
        stage.setScene(scene);
        stage.show();
        
        moveButtonRandomly ();
    }
    private void moveButtonRandomly() {
        Thread thread = new Thread(() -> {
            while (true) {                
                
                    if(isMoving) {
                        double x = Math.random()*(sceneWidth - btnClickMe.getWidth());
                        double y = Math.random()*(sceneHeight - btnClickMe.getHeight());
                        btnClickMe.relocate(x, y);
                    }
                    try {
                    Thread.sleep(delay);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    
    
}

