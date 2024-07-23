package com.lqt.dodgame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.lqt.dodgame.model.IMiniMax;
import com.lqt.dodgame.model.Minimax;
import com.lqt.dodgame.model.Node;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    static final String TAG = MainActivity.class.toString();
    static boolean selectedChessmanMove = false;
    static int selectedFrom = 0;
    static int selectedTo = 0;
    static Minimax minimax = new Minimax();
    static int[] mapPresent = IMiniMax.MAP_ROOT;
    static int idImageViewCell[] = {
            R.id.Image_Cell_0, R.id.Image_Cell_1, R.id.Image_Cell_2,
            R.id.Image_Cell_3, R.id.Image_Cell_4, R.id.Image_Cell_5,
            R.id.Image_Cell_6, R.id.Image_Cell_7, R.id.Image_Cell_8
    };

    static ImageView imageViewCell[] = new ImageView[9];
    static int imageChessman[] = {R.drawable.cell_black_inactive, R.drawable.cell_none, R.drawable.cell_white_inactive};
    ImageButton imageButtonRestart;
    Button buttonFinalBlack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitView();

        SetListenUI();

        BOTMove();

        LoadMap();
    }

    //check can move
    private boolean canMove(int from, int to, int mapP[]) {
        if (from >= 9 || to < 0 || to >= 9 || from < 0) return false;
        if (mapP[to] == 0) {
            if (to - from == 1 || to - from == 3 || from - to == 3) {
                return true;
            }
        }
        Log.e(TAG, "canMove: ");
        return false;
//
//        if (from % 3 == 0 && to == -1) {
//            return false;
//        }
//        if (from % 3 == 2 && to == 1) {
//            if (mapP[from] == -1) {
//                buttonFinalBlack.setVisibility(View.VISIBLE);
//            }
//            return false;
//        }
//        if (from < 3 && to == -3) {
//            if (mapP[from] == 1) {
//                buttonFinalBlack.setVisibility(View.VISIBLE);
//            }
//            return false;
//        }
//        if(from > 5 && to == 3) {
//            return false;
//        }
//        return true;
    }

    //on click for image
    public void clickImageCell(View view) {
        int mapPoint[] = mapPresent.clone();

        //if not end game
        if (!isEndGame()) {
            //if not selected yet
            if (!selectedChessmanMove) {
                selectedFrom = Integer.parseInt(view.getTag().toString());
                if (mapPoint[selectedFrom] == -1) {
                    //if final
                    if (selectedFrom == 2 || selectedFrom == 5 || selectedFrom == 8) {
                        buttonFinalBlack.setVisibility(View.VISIBLE);
                    } else {
                        buttonFinalBlack.setVisibility(View.INVISIBLE);
                    }
                    imageViewCell[selectedFrom].setImageResource(R.drawable.cell_black_active);
                    selectedChessmanMove = true;
                    return;
                } else {
                    //reset selectedFrom
                    selectedFrom = -1;
                    Toast.makeText(MainActivity.this, "You can't select cell here! Try again please.", Toast.LENGTH_SHORT).show();
                }
                return;
            } else { //if selected
                selectedTo = Integer.parseInt(view.getTag().toString());
                //if from = to
                if (selectedFrom == selectedTo) {
                    PlayerMove();
                    return;
                } else if (selectedTo == selectedFrom + 1 || selectedTo == selectedFrom + 3 || selectedTo == selectedFrom - 3) {
                    //if selected cell zero
                    if (mapPoint[selectedTo] == 0) {
                        PlayerMove();
                        if (isEndGame()) {
                            showDialogEndGame();
                        } else {
                            BOTMove();
                        }
                    }
                    return;
                }
                Toast.makeText(MainActivity.this, "You can't select cell here! Try again please.", Toast.LENGTH_SHORT).show();
                return;
            }
        }
    }

    private void BOTMove() {
        Node nodePresent = new Node(mapPresent.clone(), 0, true);
        nodePresent = minimax.MiniMaxVal(nodePresent, IMiniMax.DEPTH);
        mapPresent = nodePresent.getMapPoint();
        LoadMap();
    }

    private void PlayerMove() {
        if (selectedFrom != selectedTo) {
            int mapPoint[] = mapPresent.clone();
            int t = mapPoint[selectedFrom];
            mapPoint[selectedFrom] = mapPoint[selectedTo];
            mapPoint[selectedTo] = t;

            mapPresent = mapPoint.clone();
        }

        Toast.makeText(MainActivity.this, "Move from " + selectedFrom + " to " + selectedTo, Toast.LENGTH_SHORT).show();
        //reset
        selectedFrom = -1;
        selectedTo = -1;
        selectedChessmanMove = false;
        LoadMap();
    }

    private void showDialogEndGame() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("Would you like replay?");
        dialog.setCancelable(false);
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ResetGame();
            }
        });
        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        dialog.show();
    }

    private void ResetGame() {
        selectedFrom = -1;
        selectedTo = -1;
        selectedChessmanMove = false;
        mapPresent = IMiniMax.MAP_ROOT;
        BOTMove();
        LoadMap();
    }

    private boolean isEndGame() {
        // if count chessman black or chessman white == 0 then end game
        int mapPoint[] = mapPresent.clone();
        int checkWhite = 0;
        int checkBlack = 0;
        int blackStranded = 2;
        int whiteStranded = 2;
        for (int i = 0; i < 9; i++) {
            if (mapPoint[i] == 0) continue;
            if (mapPoint[i] == -1) {
                checkBlack++;
                // xet xem 1 trong 2 con có bị kẹt hay không
                if (!canMove(i, i + 1, mapPoint) && !canMove(i, i + 3, mapPoint) && !canMove(i, i - 3, mapPoint)) {
                    blackStranded--;
                }
            } else if (mapPoint[i] == 1) {
                if (!canMove(i, i + 1, mapPoint) && !canMove(i, i - 3, mapPoint) && !canMove(i, i - 1, mapPoint)) {
                    whiteStranded--;
                }
                checkWhite++;
            }
        }
        if (checkBlack == 0 || checkWhite == 0 || blackStranded == 0 || whiteStranded == 0) {
            return true;
        }
        return false;
    }

    private void LoadMap() {
        //if cell = -1 then imagechess[0] (black color) same 0 and -1
        int mapPoint[] = mapPresent.clone();
        for (int i = 0; i < 9; i++) {
            if (mapPoint[i] == -1) {
                imageViewCell[i].setImageResource(imageChessman[0]);
            } else if (mapPoint[i] == 0) {
                imageViewCell[i].setImageResource(imageChessman[1]);
            } else if (mapPoint[i] == 1) {
                imageViewCell[i].setImageResource(imageChessman[2]);
            }
        }

        //invisible button out
        buttonFinalBlack.setVisibility(View.INVISIBLE);
        Log.e(TAG, ", mapPoint=" + Arrays.toString(mapPoint));

        if (isEndGame()) {
            showDialogEndGame();
        }
    }

    private void SetListenUI() {
        imageButtonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResetGame();
            }
        });

        buttonFinalBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedFrom != -1) {
                    int mapPoint[] = mapPresent.clone();
                    mapPoint[selectedFrom] = 0;
                    mapPresent = mapPoint.clone();
                    BOTMove();
                    LoadMap();
                    selectedFrom = -1;
                    selectedTo = -1;
                    selectedChessmanMove = false;
                }
            }
        });
    }

    private void InitView() {
        for (int i = 0; i < 9; i++) {
            imageViewCell[i] = findViewById(idImageViewCell[i]);
        }
        imageButtonRestart = findViewById(R.id.Button_Restart);
        buttonFinalBlack = findViewById(R.id.Button_FinalBlack);
    }
}