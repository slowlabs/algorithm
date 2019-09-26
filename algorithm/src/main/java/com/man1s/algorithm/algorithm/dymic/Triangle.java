package com.man1s.algorithm.algorithm.dymic;

public class Triangle {

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        triangle.lwstBT(0,0,0);
        System.out.println(triangle.minDist);
    }
    private char[] a = "mitcmu122".toCharArray();
    private char[] b = "mtacnu211".toCharArray();
    private final int n = 8;
    private final int m = 8;
    private int minDist = Integer.MAX_VALUE; // 存储结果
    // 调用方式 lwstBT(0, 0, 0);
    public void lwstBT(int i, int j, int edist) {
        if (i == n || j == m) {
            if (i < n) {edist += (n-i);}
            if (j < m){ edist += (m - j);}
            if (edist < minDist){minDist = edist;}
            return;
        }
        if (a[i] == b[j]) { // 两个字符匹配
            lwstBT(i+1, j+1, edist);
        } else { // 两个字符不匹配
            lwstBT(i + 1, j, edist + 1); // 删除 a[i] 或者 b[j] 前添加一个字符
            lwstBT(i, j + 1, edist + 1); // 删除 b[j] 或者 a[i] 前添加一个字符
            lwstBT(i + 1, j + 1, edist + 1); // 将 a[i] 和 b[j] 替换为相同字符
        }
    }


}
