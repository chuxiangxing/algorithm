package com.cxx.data.algorithm;


import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author chu_xiangxing
 * @date 2019/12/21
 * @description:
 */
public class Sort {
    public static void main(String[] args) {
        int[] array = new int[80000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 80000);
        }

        long befor = System.currentTimeMillis();
        //Arrays.sort(array);
         //bubbleSort(array);
        //selectSort(array);
        //insertSort(array);
        //shellExchangeSort(array);
        shellMoveSort(null);
        System.out.println("耗时：" + (System.currentTimeMillis() - befor));
        System.out.println(Arrays.toString(array));
    }

    /**
     * 希尔排序移动法
     * @param array
     */
    public static void shellMoveSort(int[] array) {
         array = new int[]{8, 9, 1, 7, 2,3, 5, 4, 6, 0};
        for (int gap=array.length/2;gap>0;gap=gap/2){
            for (int i=0;i<array.length/gap;i++){
                //待插入的值
                int value = array[i+gap];
                //插入的位置
                int index = i+gap;
            }
        }
    }
    /**
     * 希尔排序交换法
     * 8万数据耗时大约：耗时：20
     *
     * @param array
     */
    public static void shellExchangeSort(int[] array) {
        // array = new int[]{8, 9, 1, 7, 2,3, 5, 4, 6, 0};
        //自己的实现，减去不必要的操作性能还是很好
        //根据数组长度，计算步长
        for (int gap=array.length/2;gap>0;gap=gap/2){
            //通过步长来控制循环次数,循环次数等于步长
            for (int i=0;i<gap;i++){
                //通过i + 步长 来循环从后往前比较，将小的数，往前移动，
                for (int j=array.length-1-i;j-gap>=0;j-=gap){
                    if (array[j]<array[j-gap]){
                        int temp = array[j];
                        array[j] = array[j-gap];
                        array[j-gap] =temp;
                    }
                }
            }
        }
        //尚硅谷视频教程里的实现方式
      /*  for (int gap=array.length/2;gap>0;gap=gap/2){
            for (int i=gap;i<array.length;i++){
                for (int j=i-gap;j>=0;j-=gap){
                    if (array[j]<array[j+gap]){
                        int temp = array[j];
                        array[j] = array[j+gap];
                        array[j+gap] =temp;
                    }
                }
            }
        }*/

        //System.out.println(Arrays.toString(array));
    }

    /**
     * 插入排序
     * 8万数据耗时大约：耗时：999
     *
     * @param array
     */
    public static void insertSort(int[] array) {
        //array = new int[]{1, 8, 2, 6};
        for (int i = 1; i < array.length; i++) {
            //待插入的值
            int value = array[i];
            //插入的位置
            int index = i;
            //不是合适的位置，将有序列表中的内容后移
            while (index > 0 && value < array[index - 1]) {
                array[index] = array[index - 1];
                index--;
            }
            //是合适位置
            array[index] = value;

        }
        //System.out.println(Arrays.toString(array));
    }

    /**
     * 选择排序
     * <p>
     * 8万数据耗时大约：耗时：4221
     */

    public static void selectSort(int[] array) {
//        array = new int[]{1,8,2,6};
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }

    /**
     * 冒泡排序
     * flag：用于标识是否完成排序
     * 8万数据耗时大约：耗时：14420
     *
     * @param array array进行排序的数组
     */
    public static void bubbleSort(int[] array) {
        boolean flag = false;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    flag = true;
                    array[j] = array[j] + array[j + 1];
                    array[j + 1] = array[j] - array[j + 1];
                    array[j] = array[j] - array[j + 1];
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }

    }
}
