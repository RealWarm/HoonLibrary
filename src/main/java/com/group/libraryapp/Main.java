package com.group.libraryapp;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[][] grp;
    public static int[] wei=new int[2];
    public static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        grp=new int[n][n];
//        System.out.println("==============================");
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++){
                grp[i][j]=Integer.parseInt(st.nextToken());
//                System.out.print(grp[i][j]+" ");
            }//for-j
//            System.out.println();
        }//for-i
//        System.out.println("==============================");
        dfs(0,0, n);
        for(int a : wei){
            System.out.println(a);
        }
    }//main

    public static void dfs(int sx, int sy, int n){
        int tmp=countArea(sx, sy, n);
        if(tmp != -1){
            wei[tmp]++;
        }else{
            dfs(sx, sy, n/2);
            dfs(sx, sy+n/2, n/2);
            dfs(sx+n/2, sy, n/2);
            dfs(sx+n/2, sy+n/2, n/2);
        }
    }//dfs

    public static boolean countArea1(int sx, int sy, int ex, int ey){
        int flag = grp[sx][sy];
        for(int i=sx; i<=ex; i++){
            for(int j=sy; j<=ey; j++){
                if(grp[i][j]!=flag){
                    return false;
                }//if
            }//for-j
        }//for-i
        return true;
    }//countArea1

    public static int countArea(int sx, int sy, int ll){
        int flag=grp[sx][sy];
        for(int i=sx; i<sx+ll; i++){
            for(int j=sy; j<sy+ll; j++){
                if(grp[i][j]!=flag){
                    return -1;
                }//if
            }//for-j
        }//for-i
        return flag;
    }//countArea

}//end













































