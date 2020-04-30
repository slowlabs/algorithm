package com.man1s.algorithm.algorithm.backtrack;


@SuppressWarnings(value = "all")
public class Queen {



    public static void main(String[] args) {
        new Queen().cal(0);
    }

    private int [] result = new int[8];

    private void cal(int row){
        if(row==8){
            print();
            return;
        }
        for (int col = 0; col <8 ; col++) {
            if(onlyQueue(row,col)){
                result[row] = col;
                cal(row+1);
            }
        }



    }

    private void print(){
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < 8 ; j++) {
                if(result[i] == j){
                    System.out.print("#");
                }else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        System.out.println();
    }


    private boolean isOk(int row, int column) {
        int leftup = column - 1, rightup = column + 1;
        // 逐行往上考察每一行
        for (int i = row-1; i >= 0; --i) {
            // 第i行的column列有棋子吗？
            if (result[i] == column) return false;
            // 考察左上对角线：第i行leftup列有棋子吗？
            if (leftup >= 0) {
                if (result[i] == leftup) return false;
            }
            // 考察右上对角线：第i行rightup列有棋子吗？
            if (rightup < 8) {
                if (result[i] == rightup) return false;
            }
            --leftup; ++rightup;
        }
        return true;
    }



    private boolean onlyQueue(int row ,int col){
        int leftTop = col - 1;
        int rightTop = col + 1;
        for (int i = row-1; i >= 0; --i) {
            if(result[i] == col){
                return false;
            }
            if(rightTop < 8&&result[i] == rightTop ){
                return false;
            }

            if(leftTop>-1&&result[i] == leftTop){
                return false;
            }

            ++rightTop;
            --leftTop;
        }
        return true;


    }





}


class StandardQueue{

    //全局或成员变量,下标表示行,值表示queen存储在哪一列
    int[] result = new int[8];
    // 调用方式：cal8queens(0);
    public void cal8queens(int row) {
        // 8个棋子都放置好了，打印结果
        if (row == 8) {
            printQueens(result);
            // 8行棋子都放好了，已经没法再往下递归了，所以就return
            return;
        }
        // 每一行都有8中放法
        for (int column = 0; column < 8; ++column) {
            // 有些放法不满足要求
            if (isOk(row, column)) {
                // 第row行的棋子放到了column列
                result[row] = column;
                // 考察下一行
                cal8queens(row+1);
            }
        }
    }

    //判断row行column列放置是否合适
    private boolean isOk(int row, int column) {
        int leftup = column - 1, rightup = column + 1;
        // 逐行往上考察每一行
        for (int i = row-1; i >= 0; --i) {
            // 第i行的column列有棋子吗？
            if (result[i] == column) return false;
            // 考察左上对角线：第i行leftup列有棋子吗？
            if (leftup >= 0) {
                if (result[i] == leftup) return false;
            }
            // 考察右上对角线：第i行rightup列有棋子吗？
            if (rightup < 8) {
                if (result[i] == rightup) return false;
            }
            --leftup; ++rightup;
        }
        return true;
    }


    // 打印出一个二维矩阵
    private void printQueens(int[] result) {
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; ++column) {
                if (result[row] == column) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
