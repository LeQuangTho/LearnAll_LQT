package com.lqt.lequangtho;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class OptionActivity extends AppCompatActivity {
    int KHOANG_CACH_VUOT = 100;
    int  TOC_DO_VUOT = 100;
    ArrayList<Node> nodeArrayList;
    Node[] test = new Node[8];
    nodeAdapter nAdapter;
    OsoAdapter adapter;

    LinearLayout linearLayout;
    GestureDetector gestureDetector;
    ImageButton home;
    GridView game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        game = (GridView) findViewById(R.id.game);
//        khoitao();
//        setData();
        gestureDetector = new GestureDetector(OptionActivity.this, new Vuot());
        game.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return true;
            }
        });

        AnhXa();
        nAdapter = new nodeAdapter(OptionActivity.this, R.layout.dong_node, nodeArrayList);
        game.setAdapter(nAdapter);



    }

    private void khoitao(){
        Game.getGame().init();
        adapter = new OsoAdapter(OptionActivity.this,0,Game.getGame().getArrSo());
    }

    private void setData(){
        game.setAdapter(adapter);
    }


    void AnhXa(){
        game = (GridView) findViewById(R.id.game);
        nodeArrayList = new ArrayList<>();
        nodeArrayList.add(new Node(2,R.drawable.so2));
        nodeArrayList.add(new Node(2,R.drawable.so2));
        for(int i = 2; i <= 8; i++)
            nodeArrayList.add(new Node(0,R.drawable.so0));
    }

    void taoSoNgauNhien(){
        ArrayList<Integer> a = new ArrayList<>();
        for(int i = 0; i<= 8 ;i++){
            if(nodeArrayList.get(i).getSo() == 0){
                a.add(i);
            }
        }
        if (a.isEmpty() == false){
        Random rd = new Random();
        int ngaunhien = rd.nextInt(a.size());
        nodeArrayList.get(a.get(ngaunhien)).setSo(2);
        nodeArrayList.get(a.get(ngaunhien)).setHinh(R.drawable.so2);
        }
    }

    void loadGame(){
        taoSoNgauNhien();
        nAdapter.setNodeList(nodeArrayList);
        game.setAdapter(nAdapter);
    }

    void donTrai(){
        int[][] tam = new int[3][3];
        int k=0;
        for (int i = 0; i<=2; i++){
            for (int j = 0; j<=2; j++){
                tam[i][j] = nodeArrayList.get(k++).getSo();
            }
        }
        for (int i = 0; i<=2; i++){
            for (int j = 0; j<2; j++){
                if (tam[i][j] == 0)
                if(tam[i][j] == tam[i][j+1]) {
                    tam[i][j] += tam[i][j+1];
                }
            }
        }
    }
    class Vuot extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if(e2.getX() - e1.getX() > KHOANG_CACH_VUOT && Math.abs(velocityX) > TOC_DO_VUOT)
            {
                Toast.makeText(OptionActivity.this, "Từ trái qua phải", Toast.LENGTH_SHORT).show();
                loadGame();
            }
            else if (e1.getX() - e2.getX() > KHOANG_CACH_VUOT && Math.abs(velocityX) > TOC_DO_VUOT)
            {
                Toast.makeText(OptionActivity.this, "Phải Sang Trái", Toast.LENGTH_SHORT).show();
                donTrai();
                loadGame();
            }
            else if (e2.getY() - e1.getY() > KHOANG_CACH_VUOT && Math.abs(velocityY) > TOC_DO_VUOT)
            {
                Toast.makeText(OptionActivity.this, "Trên Xuống", Toast.LENGTH_SHORT).show();
                loadGame();
            }

            else if (e1.getY() - e2.getY() > KHOANG_CACH_VUOT && Math.abs(velocityY) > TOC_DO_VUOT)
            {
                Toast.makeText(OptionActivity.this, "Dưới Lên" , Toast.LENGTH_SHORT).show();
                loadGame();
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
}