package com.example.snakeladdershivam;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class snakeladder extends Application {

    public static final int tilesize=40, width=10,height=10;
    public static final int buttonline=height*tilesize+50,infoline=buttonline-30;

    private  static dice dice=new dice();
    private player playerone,playertwo;

    private boolean gamestarted=false, playeroneturn=false,playertwoturn=false;


    private Pane createcontent(){
        Pane root= new Pane();
        root.setPrefSize(width*tilesize,height*tilesize+100);

        //creating tiles using one singular tile
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                tile tile=new tile(tilesize);
                tile.setTranslateX((j*tilesize));
                tile.setTranslateY((i*tilesize));
                root.getChildren().add(tile);
            }
        }

        //backgroundimage
        Image img=new Image("C:\\Users\\Shivam Kishore\\IdeaProjects\\SnakeLadderShivam\\src\\main\\img.png");
        ImageView board = new ImageView();
        board.setImage(img);
        board.setFitHeight(height*tilesize);
        board.setFitWidth(height*tilesize);

        //buttons
        Button playeronebutton=new Button("player 1");
        Button playertwobutton=new Button("player 2");
        Button startbutton=new Button("start");

        playeronebutton.setTranslateY(buttonline);
        playeronebutton.setTranslateX(20);
        playeronebutton.setDisable(true);
        playertwobutton.setTranslateY(buttonline);
        playertwobutton.setTranslateX(300);
        playertwobutton.setDisable(true);
        startbutton.setTranslateY(buttonline);
        startbutton.setTranslateX(160);


        //info display
        Label playeronelabel=new Label(" ");
        Label playertwolabel=new Label(" ");
        Label dicelabel=new Label("start the game");

        playeronelabel.setTranslateY(infoline);
        playeronelabel.setTranslateX(20);
        playertwolabel.setTranslateY(infoline);
        playertwolabel.setTranslateX(300);
        dicelabel.setTranslateY(infoline);
        dicelabel.setTranslateX(160);

        playerone=new player(tilesize, Color.BLACK,"s1");
        playertwo=new player(tilesize-10,Color.GREEN,"s2");

        playeronebutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gamestarted){
                    if(playeroneturn){
                      int dicevalue=dice.getrolleddicevalue();
                      dicelabel.setText("dice value" + dicevalue);
                      playerone.moveplayer(dicevalue);

                        if(playerone.iswinner()){
                            dicelabel.setText("winner is" + playerone.getName());
                            playeroneturn=false;
                            playeronebutton.setDisable(true);
                            playeronelabel.setText("");

                            playertwoturn=true;
                            playertwobutton.setDisable(true);
                            playertwolabel.setText("");

                            startbutton.setDisable(false);
                            startbutton.setText("restart");
                        }else {

                            playeroneturn = false;
                            playeronebutton.setDisable(true);
                            playeronelabel.setText("");

                            playertwoturn = true;
                            playertwobutton.setDisable(false);
                            playertwolabel.setText("your turn" + playertwo.getName());
                        }
            }}}
        });

        playertwobutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gamestarted){
                    if(playertwoturn){
                        int dicevalue=dice.getrolleddicevalue();
                        dicelabel.setText("dice value" + dicevalue);
                        playertwo.moveplayer(dicevalue);

                        if(playertwo.iswinner()){
                            dicelabel.setText("winner is" + playertwo.getName());
                            playeroneturn=false;
                            playeronebutton.setDisable(true);
                            playeronelabel.setText("");

                            playertwoturn=true;
                            playertwobutton.setDisable(false);
                            playertwolabel.setText("");
                        }else {
                            playeroneturn = true;
                            playeronebutton.setDisable(false);
                            playeronelabel.setText("your turn" + playerone.getName());

                            playertwoturn = false;
                            playertwobutton.setDisable(true);
                            playertwolabel.setText("");
                        }

                    }}
            }
        });

        startbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gamestarted=true;
                dicelabel.setText("game started");
                startbutton.setDisable(true);
                playeroneturn=true;
                playeronelabel.setText("your turn"+ playerone.getName());
                playeronebutton.setDisable(false);
                playerone.startingposition();

                playertwoturn=false;
                playertwolabel.setText("");
                playertwobutton.setDisable(true);
                playertwo.startingposition();
            }
        });

        root.getChildren().addAll(
                board,playeronebutton,playertwobutton,startbutton,
                playeronelabel,playertwolabel,dicelabel,
                playerone.getCoin(),playertwo.getCoin()

        );








        return root;
    }
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(createcontent());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}