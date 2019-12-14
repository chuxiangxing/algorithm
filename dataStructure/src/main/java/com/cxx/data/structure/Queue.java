package com.cxx.data.structure;

import java.util.Scanner;

/**
 * @author chu_xiangxing
 * @date 2019/12/14
 * @description:
 */
public class Queue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayqueuePlus queue = new ArrayqueuePlus(3);
        int choose;
        while ((choose = scanner.nextInt()) != 0) {
            switch (choose) {
                case 1:
                    queue.joinQueue(scanner.nextInt());
                    break;
                case 2:
                    System.out.println(queue.exitQueue());
                    break;
                case 3:
                    queue.peep();
                    break;
                case 4:
                    queue.print();
                    break;
            }
        }
    }
}

/**
 * 增强版  循环队列
 *初期 top和tail的位置都是0
 * 添加节点后，tail指向1
 *
 *
 */
class ArrayqueuePlus {
    //指向队列头的当前位置
    private int top;
    //指向队列尾的下一个位置
    private int tail;
    //队列的长度
    private int size;

    //队列数据存放
    private int[] array;

    public ArrayqueuePlus(int size) {
        array = new int[size];
        this.size=size;
    }

    public void joinQueue(int num) {
        boolean full = isFull();
        if (full) {
            System.out.println("队列以满加入失败");
            return;
        }
        array[tail++%size]=num;
    }

    public int exitQueue() {
        boolean empty = isEmpty();
        if (empty) {
            throw new RuntimeException("队列为空");
        }
        return  array[top++%size];
    }

    public boolean isEmpty() {
        return top==tail;
    }

    public boolean isFull() {

        return (tail+1)%size==top%size;
    }

    public void peep() {
        System.out.println(array[top%size]);
    }

    public void print() {
        for (int i=0;i<(tail%size-top%size);i++ ){
            System.out.println(array[top%size+i]);
        }
    }
}


/**
 * 简单实现
 */
class Arrayqueue {
    //指向队列头前一个位置的下标
    private int top;
    //指向队列尾的下标
    private int tail;

    //队列数据存放
    private int[] array;

    public Arrayqueue(int size) {
        array = new int[size];
        top = -1;
        tail = -1;
    }

    public void joinQueue(int num) {
        boolean full = isFull();
        if (full) {
            System.out.println("队列以满加入失败");
            return;
        }
        tail++;
        array[tail] = num;
    }

    public int exitQueue() {
        boolean empty = isEmpty();
        if (empty) {
            throw new RuntimeException("队列为空");
        }
        top++;
        return array[top];
    }

    public boolean isEmpty() {
        return top == tail;
    }

    public boolean isFull() {
        return tail == array.length - 1;
    }

    public void peep() {
        System.out.println(array[top + 1]);
    }

    public void print() {
        for (int i = top + 1; i <= tail; i++) {
            System.out.println(array[i]);
        }
    }
}
