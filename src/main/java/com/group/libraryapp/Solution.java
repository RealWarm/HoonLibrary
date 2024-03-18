package com.group.libraryapp;

public class Solution {
    public int solution(String S1, String S2) {
        int[] index1 = {0};
        int[] index2 = {0};

        int count1 = countBlackPixels(S1, index1);
        int count2 = countBlackPixels(S2, index2);

        int combinedCount = combineImages(count1, count2);

        return combinedCount;
    }

    private int countBlackPixels(String quadTree, int[] index) {
        char node = quadTree.charAt(index[0]);

        if (node == 'b') {
            return (int) Math.pow(2, 10-index[0]);
        } else if (node == 'w') {
            return 0;
        } else {
            int totalCount = 0;
            index[0]++;
            for (int i = 0; i < 4; i++) {
                totalCount += countBlackPixels(quadTree, index);
            }
            return totalCount;
        }
    }

    private int combineImages(int count1, int count2) {
        return count1 + count2 - Math.min(count1, count2);
    }
}