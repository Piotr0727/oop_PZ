package org.example.review;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DotTest {

    @Test
    void fromMessageTest() {
        String testString = "120.0,120.0,#FFFFFF,2";
        Dot testDot = Dot.fromMessage(testString);
        String[] parts = testString.split(",");
        double x = Double.parseDouble(parts[0]);
        assertEquals(x,testDot.x());
        double y = Double.parseDouble(parts[1]);
        assertEquals(y,testDot.y());
        Color color = Color.web(parts[2]);
        assertEquals(color,testDot.color());
        double radius = Double.parseDouble(parts[3]);
        assertEquals(radius,testDot.radius());
    }
}