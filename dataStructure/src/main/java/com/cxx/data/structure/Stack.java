package com.cxx.data.structure;

import java.util.Scanner;

/**
 * 栈
 *
 * @author chu_xiangxing
 * @date 2019/12/15
 * @description:
 */
public class Stack {
    public static void main(String[] args) {

    }
}

class ArrayStack {
    private int maxSize;
    private int top = -1;
    private int[] array;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
    }

    public int pop() {
        if (isEnmpty()) {
            throw new RuntimeException("栈以空,无法取");
        }
        return array[--top];
    }

    public void push(int item) {
        if (isFull()) {
            System.out.println("加入失败,栈已满");
            return;
        }
        array[++top] = item;
    }

    //栈是否空
    public boolean isEnmpty() {
        if (top < 0) {
            return true;
        } else {
            return false;
        }
    }

    //栈是否满
    public boolean isFull() {
        if (top >= maxSize - 1) {
            return true;
        } else {
            return false;
        }
    }

    public int peek(){
        return array[top];
    }
    public void list(){
        if (isEnmpty()){

        }else{
            for (int i=0;i<=top;i++){
                System.out.println(array[i]);
            }
        }
    }

}