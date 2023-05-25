package com.example.snakeladdershivam;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class tile extends Rectangle {
    public tile(int titlesize){
        setWidth(titlesize);
        setHeight(titlesize);
        setFill(Color.AZURE);
        setStroke(Color.BLACK);
    }
}
