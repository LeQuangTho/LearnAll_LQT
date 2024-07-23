package com.lqt.dodgame.model;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;

public class Node {

    private ArrayList<Node> nextNodes;
    private int mapPoint[];
    private int depth;
    private boolean turnWhite;

    /*
     * Hàm constructor sẽ tự tạo ra các con cho đến độ sâu yêu cầu
     */
    public Node(int[] mapPoint, int depth, boolean turnWhite) {
        super();
        this.mapPoint = mapPoint;
        this.depth = depth;
        this.turnWhite = turnWhite;
        this.nextNodes = new ArrayList<>();
        if (depth <= IMiniMax.DEPTH && !this.isNodeEnd2()) {
            for (int i = 0; i < 9; i++) {
                if (this.mapPoint[i] == 0) continue; // Nếu là ô trống thì bỏ qua.
                if (this.turnWhite) {
                    if (this.mapPoint[i] == 1) { // Quân Trắng
                        for (int direction : IMiniMax.CELL_WHITE_CAN_RUN) {
                            if (this.canMove(direction, i)) {  // Kiểm tra nước có thể di chuyển
                                int[] mapPointClone = this.mapPoint.clone();
                                if (i + direction >= 0) { // Quân trắng không ở hàng trên cùng và đi lên
                                    mapPointClone[i + direction] = mapPointClone[i];
                                }
                                mapPointClone[i] = 0;
                                this.nextNodes.add(new Node(mapPointClone, this.depth + 1, !this.turnWhite));
                            }
                        }
                    }
                } else {
                    if (this.mapPoint[i] == -1) { // Quân Đen
                        for (int direction : IMiniMax.CELL_BLACK_CAN_RUN) {
                            if (this.canMove(direction, i)) {  // Kiểm tra nước có thể di chuyển
                                int[] mapPointClone = this.mapPoint.clone();
                                if (!(i % 3 == 2 && direction == 1)) { // Quân Đen không ở hàng ngoài cùng bên Phải và đi sang Phải
                                    mapPointClone[i + direction] = mapPointClone[i];
                                }
                                mapPointClone[i] = 0;
                                this.nextNodes.add(new Node(mapPointClone, this.depth + 1, !this.turnWhite));
                            }
                        }
                    }
                }
            }
        }
    }

    public ArrayList<Node> getNextNodes() {
        return nextNodes;
    }

    public int[] getMapPoint() {
        return mapPoint;
    }

    @NonNull
    @Override
    public String toString() {
        return "Node [nextNodes=" + nextNodes + ", mapPoint=" + Arrays.toString(mapPoint) + ", hight=" + depth
                + ", turn=" + turnWhite + ", getSumPoint()=" + getSumPoint() + "]";
    }

    /*
     * tính điểm của node đối chiếu với bảng tra trong IMinimax cộng thêm 40 điểm
     * nếu như quân trắng chặn trực tiếp đen và 30 nếu là gián tiếp ngược lại là -40
     * và -30
     */
    public int getSumPoint() {
        int sum = 0;
        int numberBlack = 2;
        int numberWhite = 2;
        for (int i = 0; i < 9; i++) {
            if (this.mapPoint[i] == -1) {  // Quân Đen
                numberBlack--;
                sum += IMiniMax.POINTS_OF_BLACK[i];
                if (i < 6) {
                    if (this.mapPoint[i + 3] == 1) {
                        sum -= 40;
                    }
                    if (i < 3 && this.mapPoint[i + 6] == 1) {
                        sum -= 30;
                    }
                }
            } else {
                if (this.mapPoint[i] == 1) {  // Quân Trắng
                    numberWhite--;
                    sum += IMiniMax.POINTS_OF_WHITE[i];
                    if (i % 3 != 0) {
                        if (this.mapPoint[i - 1] == -1) {
                            sum += 40;
                        }
                        if (i % 3 == 2 && this.mapPoint[i - 2] == -1) {
                            sum += 30;
                        }
                    }
                }
            }
        }
        sum += (numberWhite - numberBlack) * 85;
        if (this.isNodeEnd() && !isNodeEnd2()) {
            if (this.turnWhite) {
                sum -= 100;
            } else {
                sum += 100;
            }
        }
        return sum;
    }

    /*
     * Nếu trên bàn cờ chỉ có 1 loại quân thì là end
     *
     * TODO tới lượt nhưng không đi được
     */
    public boolean isNodeEnd() {
        return this.nextNodes.size() == 0;
    }

    public boolean isNodeEnd2() {
        boolean blackEmpty = true;
        boolean whiteEmpty = true;
        for (int i : this.mapPoint) {
            if (i == -1) {
                blackEmpty = false;
            } else if (i == 1) {
                whiteEmpty = false;
            }
        }
        return blackEmpty || whiteEmpty;
    }

    private boolean canMove(int direction, int position) {
        if (position % 3 == 0 && direction == -1) {
            return false;
        }
        if (position % 3 == 2 && direction == 1) {
            return mapPoint[position] == -1;
        }
        if (position < 3 && direction == -3) {
            return mapPoint[position] == 1;
        }
        if (position > 5 && direction == 3) {
            return false;
        }
        return mapPoint[position + direction] == 0;
    }
}
