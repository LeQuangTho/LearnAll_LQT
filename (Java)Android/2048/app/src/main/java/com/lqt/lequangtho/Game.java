package com.lqt.lequangtho;

import java.util.ArrayList;

public class Game {
    private static Game game;
    private ArrayList<Integer> arrSo = new ArrayList<>();
    private int[][] mangXuLy = new int[3][3];
    static {
        game = new Game();
    }

    public static Game getGame() {
        return game;
    }

    public void init(){
        for (int i = 1; i<4;i++)
            for (int j = 1; j<4; j++){
                mangXuLy[i][j] = 0;
                arrSo.add(0);
            }
    }

    public ArrayList<Integer> getArrSo() {
        return arrSo;
    }
}
