package com.lqt.dodgame.model;

public interface IMiniMax {
    int[] CELL_BLACK_CAN_RUN = {-3, 1, 3};
    int[] CELL_WHITE_CAN_RUN = {-1, -3, 1};
    //    int[] CELL_BLACK_CAN_RUN = {1,3,-3};
//    int[] CELL_WHITE_CAN_RUN = {-3, -1, 1};
    int DEPTH = 5;
    int MAP_ROOT[] = {-1, 0, 0, -1, 0, 0, 0, 1, 1};
    int POINTS_OF_WHITE[] = {30, 35, 40, 15, 20, 25, 0, 5, 10};
    int POINTS_OF_BLACK[] = {-10, -25, -40, -5, -20, -35, -0, -15, -30};
}