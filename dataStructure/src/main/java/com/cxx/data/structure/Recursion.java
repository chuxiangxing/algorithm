package com.cxx.data.structure;

import javax.xml.stream.FactoryConfigurationError;

/**
 * 递归
 *
 * @author chu_xiangxing
 * @date 2019/12/16
 * @description:
 */
public class Recursion {
    public static void main(String[] args) {
        Maze maze = new Maze();
        int[][] map = new int[8][7];
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        map[2][1] = 1;
        map[2][2] = 1;
        maze.move(map, 1, 1);

        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        Queen8 q = new Queen8();
        q.recursion(0);
        System.out.println(q.count);
    }
}

class Queen8 {
    private int[] array = new int[8];
    int count = 0;

    /**
     * 进行递归
     */
    public void recursion(int n) {
        if (n == array.length) {
            count++;
            return;
        }
        for (int i = 0; i < array.length; i++) {
            array[n] = i;
            if (!isConflict(n)) {
                recursion(n + 1);
            }
        }

    }

    /***
     * 检测是否有冲突
     * @param n 行数
     * @return 不冲突
     */
    public boolean isConflict(int n) {

        for (int i = 0; i < n; i++) {
            if (array[n] == array[i] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return true;
            }
        }
        return false;
    }


}


/**
 * 迷宫
 * 1:墙  2：走过的路  3：死路  0：未走过的路
 */
class Maze {
    public boolean move(int[][] map, int i, int j) {
        //找到出口
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (move(map, i - 1, j)) {
                    return true;
                } else if (move(map, i, j + 1)) {
                    return true;
                } else if (move(map, i + 1, j)) {
                    return true;
                } else if (move(map, i, j - 1)) {
                    return true;
                } else {
                    //死路
                    map[i][j] = 3;
                    return false;
                }
            } else {

                return false;
            }
        }


    }
}
