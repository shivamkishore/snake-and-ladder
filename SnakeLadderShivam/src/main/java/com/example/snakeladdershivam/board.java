package com.example.snakeladdershivam;

import javafx.util.Pair;

import java.util.ArrayList;

public class board {

    ArrayList<Pair<Integer,Integer>> positioncoordinates;

    ArrayList<Integer> snakeladderposition;

    public board(){
        positioncoordinates=new ArrayList<>();
        populatesnakeladder();
        populatepositioncoordinates();
    }

    private void populatepositioncoordinates(){
        positioncoordinates.add(new Pair<>(0,0));//dummy values
        for (int i = 0; i < snakeladder.height; i++) {
            for (int j = 0; j < snakeladder.width; j++) {
                //x coordinates
                int xcord=0;
                if(i%2==0){
                    xcord=j*snakeladder.tilesize+snakeladder.tilesize/2;
                }else{
                    xcord=snakeladder.tilesize*snakeladder.height - j*snakeladder.tilesize - snakeladder.tilesize/2;
                }

                int ycord=snakeladder.tilesize*snakeladder.height - (i*snakeladder.tilesize)-snakeladder.tilesize/2;
                positioncoordinates.add(new Pair<>(xcord,ycord));
            }

        }
    }

    private void populatesnakeladder(){
        snakeladderposition = new ArrayList<>();
        for(int i=0;i<101;i++){
            snakeladderposition.add(i);
        }
        snakeladderposition.set(4,25);
        snakeladderposition.set(13,46);
        snakeladderposition.set(27,5);
        snakeladderposition.set(33,49);
        snakeladderposition.set(40,3);
        snakeladderposition.set(42,63);
        snakeladderposition.set(43,18);
        snakeladderposition.set(50,69);
        snakeladderposition.set(54,31);
        snakeladderposition.set(62,81);
        snakeladderposition.set(66,45);
        snakeladderposition.set(76,58);
        snakeladderposition.set(74,92);
        snakeladderposition.set(89,53);
        snakeladderposition.set(99,41);
    }

    public int getnewposition(int currentposition){
        if(currentposition>0 && currentposition<=100){
            return snakeladderposition.get(currentposition);
        }
        return -1;
    }
    int getxcoordinate(int position){
        if(position>=1 && position<=100){
            return positioncoordinates.get(position).getKey();
        }
        return -1;
    }

    int getycoordinate(int position){
        if(position>=1 && position<=100){
            return positioncoordinates.get(position).getValue();
        }
        return -1;
    }

    public static void main(String[] args) {
        board board=new board();
        for (int i = 0; i < board.positioncoordinates.size(); i++) {
            System.out.println( i + "x" + board.positioncoordinates.get(i).getKey()
                    +"y"+board.positioncoordinates.get(i).getValue()
            );
        }
    }
}
