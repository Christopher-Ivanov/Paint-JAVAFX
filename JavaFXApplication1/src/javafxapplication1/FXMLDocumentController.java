/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;

/**
 *
 * @author Chris'
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private Canvas canvas;
    @FXML
    private ColorPicker cp;
    @FXML
    private Slider slider;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void paint(MouseEvent event) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        if (event.getButton()==MouseButton.PRIMARY) {
        gc.setLineWidth(slider.getValue());
        gc.setLineCap(StrokeLineCap.ROUND);
        gc.setStroke(cp.getValue());
        gc.strokeLine(x, y, event.getX(), event.getY());
        } else {
                
        gc.setLineWidth(30);
        gc.setLineCap(StrokeLineCap.ROUND);
        gc.setStroke(Color.WHITESMOKE);
        gc.strokeLine(x, y, event.getX(), event.getY());
                }
        move(event);
    }

    @FXML
    private void move(MouseEvent event) {
        x = event.getX();
        y = event.getY();
           
    }
    
    double x, y ;
}
