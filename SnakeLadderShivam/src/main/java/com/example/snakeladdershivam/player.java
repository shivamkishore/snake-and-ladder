package com.example.snakeladdershivam;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class player {
    private Circle coin;
    private int currentposition;
    private String name;
    private static board gameboard = new board();

    public player(int tilesize, Color coincolor, String playername){
        coin = new Circle(tilesize/2);
        coin.setFill(coincolor);
        currentposition=0;
        moveplayer(1);
        name=playername;
    }

    public void moveplayer(int dicevalue){
        if(currentposition+dicevalue<=100){
            currentposition+=dicevalue;

            TranslateTransition secondmove=null,firstmove=translateanimation(dicevalue);

            int newposition=gameboard.getnewposition(currentposition);
            if(newposition!=currentposition && newposition!=-1){
                currentposition=newposition;
                secondmove =translateanimation(6);
            }
            if(secondmove==null){
                firstmove.play();
            }else{
                SequentialTransition sequentialtranslation = new SequentialTransition(firstmove,
                        new PauseTransition(Duration.millis(1000)),secondmove);
                sequentialtranslation.play();
            }
        }
//        int x=gameboard.getxcoordinate(currentposition);
//        int y= gameboard.getycoordinate(currentposition);
//
//        coin.setTranslateX(x);
//        coin.setTranslateY(y);

     //   translateanimation();
    }

    private TranslateTransition translateanimation(int dicevalue){
        TranslateTransition animate=new TranslateTransition(Duration.millis(200*dicevalue),coin);
        animate.setToX(gameboard.getxcoordinate(currentposition));
        animate.setToY(gameboard.getycoordinate(currentposition));
        animate.setAutoReverse(false);
        animate.play();
        return animate;
    }

    public void startingposition(){
        currentposition=0;
        moveplayer(1);
    }

    boolean iswinner(){
        if(currentposition==100) return true;

        return false;
    }

    public Circle getCoin() {
        return coin;
    }

    public int getCurrentposition() {
        return currentposition;
    }

    public String getName() {
        return name;
    }
}
