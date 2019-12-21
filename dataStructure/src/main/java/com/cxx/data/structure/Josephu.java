package com.cxx.data.structure;

/**
 * 约瑟夫问题,又称“丢手绢问题”
 *
 * @author chu_xiangxing
 * @date 2019/12/14
 * @description:
 */
public class Josephu {
    public static void main(String[] args) {
        CircleLinkedList cl = new CircleLinkedList();
        cl.addChild(125);
        cl.show();
        System.out.println("------------------");
        cl.skip(10, 20);
    }

}

class CircleLinkedList {
    private Child first;
    private Child current;

    /**
     * 小孩出圈
     *
     * @param start 起始位置
     * @param step  间隔
     */
    public void skip(int start, int step) {
        //将first移动到起始位置
        for (int i = 1; i < start; i++) {
            current = first;
            first = first.getNext();
        }
        //此时将current当做first的前一个节点，方便删除节点数据
        int index = 0;
        while (first.getNext() != first) {
            index++;

            if (index % step == 0) {
                //小孩出圈
                first = first.getNext();
                current.setNext(first);
                continue;
            }
            current=first;
            first=first.getNext();
        }
        System.out.println(first);
    }

    //添加多少小孩
    public void addChild(int number) {
        if (number < 2) {
            System.out.println("这么少，别玩了");
            return;
        }
        for (int i = 1; i <= number; i++) {
            Child c = new Child(i);
            if (i == 1) {
                first = c;
                first.setNext(first);
                current = first;
                continue;
            }
            current.setNext(c);
            current = c;
            current.setNext(first);
        }
    }

    public void show() {
        if (first == null)
            return;
        while (first != current) {
            System.out.println(first);
            first=first.getNext();
        }
        System.out.println(current);
       first= current.getNext();
    }
}
//环形单向列表

class Child {
    private int no;
    private Child next;

    public Child(int no) {
        this.no = no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setNext(Child next) {
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public Child getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "当前节点是:" + no;
    }
}
