package com.cxx.data.structure;

/**
 * 二维数组 -> 稀疏数字
 * 稀疏数组 -> 二维数组
 * <p>
 * 稀疏数组：
 * 第一行存原数组的：行 列 有效数值个数
 * 第二行-n：没个有效元素在原数组的位置
 *
 * @author chu_xiangxing
 * @date 2019/12/14
 * @description:
 */
public class SparseArray {
    //数组中存在大量没有意义的数据，可以将原始数组转稀疏数组
    public static void main(String[] args) {
        int[][] array = new int[11][11];
        array[3][6] = 5;
        array[7][3] = 9;
        //二维数组有效数值个数
        int vaild = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (0 != array[i][j]) {
                    vaild++;
                }
            }
        }
        int[][] sparseArray = new int[vaild + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = vaild;

        int index = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (0 != array[i][j]) {
                    index++;
                    sparseArray[index][0] = i;
                    sparseArray[index][1] = j;
                    sparseArray[index][2] = array[i][j];
                }
            }
        }
        arrayPrint(sparseArray);

        int[][] restoreArray =new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i=1;i<sparseArray.length;i++){
            restoreArray[sparseArray[i][0]][sparseArray[i][1]]=sparseArray[i][2];
        }

        arrayPrint(restoreArray);
    }
    public static void arrayPrint(int[][] array){
        for (int[] arrayRow:array){
            for (int item : arrayRow){
                System.out.print(item+" ");
            }
            System.out.println();
        }

    }
}
