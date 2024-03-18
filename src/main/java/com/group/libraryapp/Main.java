package com.group.libraryapp;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[][] grp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        grp=new int[n][n];
        StringBuilder sb = new StringBuilder();
        System.out.println("==============================");
        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<n; j++){
                grp[i][j]=line.charAt(j)-'0';
                System.out.print(grp[i][j]+" ");
            }//for-j
            System.out.println();
        }//for-i
        System.out.println("==============================");
        sb.append("(");
        System.out.println(dfs(0, 0, n-1, n-1, sb).toString());
    }//main

    public static int countElement(int startX, int startY, int endX, int endY){
        int flag=grp[startX][startY];
        for(int i=startX; i<=endX; i++){
            for(int j=startY; j<=endY; j++){
                if(grp[i][j]!=flag) return -1;
            }//for-j
        }//for-i
        return flag;
    }// countElement

    public static StringBuilder dfs(int startX, int startY, int endX, int endY, StringBuilder bb){
        System.out.println("=============================");
        System.out.println(startX+", "+ startY+", "+ endX+", "+ endY);
        int result=countElement(startX, startY, endX, endY);
        int length=(endX-startX);
        if(length==2){
            bb.append("(");
            for(int i=startX; i<=endX; i++){
                for(int j=startY; j<=endY; j++){
                    bb.append(grp[i][j]);
                }//for-j
            }//for-i
            bb.append(")");
        } else if(result==-1){
            int half=((int)((endX-startX)/2));
            StringBuilder bb1=dfs(startX, startY, startX+half, startY+half, bb);
            StringBuilder bb2=bb.append(dfs(startX, startY+half, startX+half, endY, bb));
            StringBuilder bb3=bb.append(dfs(startX+half, startY, endX, startY+half, bb));
            StringBuilder bb4=bb.append(dfs(startX+half, startY+half, endX, endY, bb));
            bb.append("(").append(bb1).append(bb2).append(bb3).append(4).append(")");
        }else{
            System.out.println("inhere!");
            bb.append(result).append(")");
        }
        System.out.println(bb.toString());
        System.out.println("=============================");
        return bb;
    }//dfs

}//end
