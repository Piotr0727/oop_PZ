package org.example.review;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import server.Server;

public class HelloController {
    public Canvas canvas;
    public TextField addressField;
    public TextField portField;
    private Server server = new Server(); // Server nie moze byc nullem gdy sie laczy wiec trzeba tu napisac new Server();
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private Slider radiusSlider;

    @FXML
    public void onStartServerClicked(ActionEvent actionEvent) {
        int port = Integer.parseInt(portField.getText()); // Do TextFieldow GETTEXT
        System.out.println(port);
        server.start(port);
    }
    public void onConnectClicked(ActionEvent actionEvent) {

    }
    public void onMouseClicked(MouseEvent mouseEvent) {
        Color colorValue = colorPicker.getValue();
        double radius = radiusSlider.getValue();
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        System.out.println(colorValue.toString());
        GraphicsContext gc = canvas.getGraphicsContext2D(); // To jest wazne do pobrania jesli chcemy rysowac cokolwiek na obiekcie typu canvas
        gc.setFill(colorValue);
        gc.fillOval(x - radius,y - radius, radius*2,radius*2);
    }
}