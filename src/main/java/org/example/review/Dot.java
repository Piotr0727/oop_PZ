package org.example.review;

import javafx.scene.paint.Color;
import org.jetbrains.annotations.NotNull;

public record Dot(double x, double y, Color color, double radius) { // Rekordy nie potrzebuja getterow ani konstruktorow sa one tworzone automatycznie przez taki rekord
    public static String toMessage(double x, double y, Color color, double radius) {
        return x + "," + y + "," + color.toString().substring(2, 8).toUpperCase() + "," + radius;
    }
    public static Dot fromMessage(String msg){
        String[] parts = msg.split(",");
        double x = Double.parseDouble(parts[0]);
        double y = Double.parseDouble(parts[1]);
        Color color = Color.web(parts[2]);
        double radius = Double.parseDouble(parts[3]);
        return new Dot(x,y,color,radius);
    }
}
