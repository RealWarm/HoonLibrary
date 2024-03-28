package com.group.libraryapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int r, c;
    public static int bx, by, cx, cy;
    public static String[][] grp;
    public static int[][] water;
    public static int[][] beaver;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Queue<int[]> q1 = new LinkedList<>();
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        grp = new String[r][c];
        water = new int[r][c];
        beaver = new int[r][c];
        //////////////////////////////////////////////////////
        for (int i = 0; i < r; i++) {
            Arrays.fill(water[i], -1);
            Arrays.fill(beaver[i], -1);
            grp[i] = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                if (grp[i][j].equals("S")) {
                    bx = i;
                    by = j;
                    beaver[i][j] = 0;
                } else if (grp[i][j].equals("*")) {
                    q1.add(new int[]{i, j});
                    water[i][j] = 0;
                } else if (grp[i][j].equals("D")) {
                    cx = i;
                    cy = j;
                }//if-1
            }//for-j
        }//for-i
        ///////////////////////////////////////////////////////
        bfsWater(q1);
//        for (int i = 0; i < r; i++) {
//            for (int j = 0; j < c; j++) {
//                System.out.print(water[i][j] + " ");
//            }//for-j
//            System.out.println();
//        }//for-i
//        System.out.println();
        ///////////////////////////////////////////////////////
        bfsBeaver(bx, by);
//        for (int i = 0; i < r; i++) {
//            for (int j = 0; j < c; j++) {
//                System.out.print(beaver[i][j] + " ");
//            }//for-j
//            System.out.println();
//        }//for-i
        ///////////////////////////////////////////////////////
        if (beaver[cx][cy] == -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(beaver[cx][cy]);
        }//if
    }//main

    public static void bfsWater(Queue<int[]> q1) {
        while (!q1.isEmpty()) {
            int[] nw = q1.poll();
            int nwx = nw[0];
            int nwy = nw[1];
            for (int i = 0; i < dx.length; i++) {
                int ntx = nwx + dx[i];
                int nty = nwy + dy[i];
                if (ntx < 0 || ntx >= r || nty < 0 || nty >= c) continue;
                if ((grp[ntx][nty].equals("."))
                        && water[ntx][nty] == -1) {
                    water[ntx][nty] = water[nwx][nwy] + 1;
                    q1.offer(new int[]{ntx, nty});
                }//if
            }//for-i
        }//while
    }//bfsWater

    public static void bfsBeaver(int bx, int by) {
        Queue<int[]> q1 = new LinkedList<>(Arrays.asList(new int[]{bx, by}));
        while (!q1.isEmpty()) {
            int[] nw = q1.poll();
            int nwx = nw[0];
            int nwy = nw[1];
            for (int i = 0; i < dx.length; i++) {
                int ntx = nwx + dx[i];
                int nty = nwy + dy[i];
                if (ntx < 0 || ntx >= r || nty < 0 || nty >= c) continue;
//                if (grp[ntx][nty].equals("D")) {
//                    beaver[ntx][nty] = beaver[nwx][nwy] + 1;
//                }
                if (grp[ntx][nty].equals("X")) continue;
                if (grp[ntx][nty].equals("*")) continue;
                if (grp[ntx][nty].equals(".")
                        && beaver[ntx][nty] == -1
                        && (water[ntx][nty] == -1 || water[ntx][nty] > beaver[nwx][nwy] + 1)) {
                    beaver[ntx][nty] = beaver[nwx][nwy] + 1;
                    q1.offer(new int[]{ntx, nty});
                }//if
            }//for-i
        }//while
    }//bfsBeaver

}//end

// . : 비어있음, * : 물, X: 돌, D: 비버의 굴, S: 고슴도치
// 물과 고슴도치는 돌을 통과 못함
// 고슴도치 물 못감 || 물도 비버의 소굴로 이동 안됨


// for(int i=0; i<r; i++){
//        for(int j=0;j<c; j++){
//        System.out.print(grp[i][j]);
//        }//for-j
//        System.out.println();
//        }//for-i


//for(int i=0; i< r; i++) {
//        for (int j = 0; j < c; j++) {
//        System.out.print(grp[i][j]);
//        }//for-j
//        System.out.println();
//        }//for-i