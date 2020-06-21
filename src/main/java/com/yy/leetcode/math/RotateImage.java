package com.yy.leetcode.math;
/**
 * @author youyouhuang
 * @create 2020-06-14
 **/

/**
 * <p>
 *
 * </p>
 **/
public class RotateImage {

    //一圈一圈的处理
    public void rotate(int[][] matrix) {
        if(matrix == null){
            return;
        }
        //y0 = length - x;
        //x0 = y;
        int length = matrix.length;

        int rawMax = 0;
        if(length%2 == 0){
            rawMax = length/2;
        }else{
            rawMax = length/2+1;
        }

        for (int i = 0; i < rawMax; i++) {
            for (int j = i; j < (length-2*i)+i-1; j++) {
                swap(matrix, length, i, j,matrix[i][j],0);
            }
        }
    }

    private void swap(int[][] matrix, int length, int i, int j, int prev, int count) {
        if(count == 4){
            return;
        }
        int x1 = j;
        int y1 = length - i-1;
        int temp = matrix[x1][y1];
        matrix[x1][y1] =prev;
        swap(matrix,length,x1,y1, temp, ++count);
    }
}
