package com.lgz.flyme.algorithm;

/**
 * 进制转换
 * @author: liguangzhi01
 * @date: 2021/1/12
 */
public class ResolveHex {

    public static void main(String[] args) {
        System.out.println(solve(-100000000, 16));
    }

    public static String solve (int M, int N) {
        // write code here
        String str ="0123456789ABCDEF";
        return M > 0 ?  doSolve(M, N, str) : "-" + doSolve(Math.abs(M), N, str);
    }
    public static String doSolve(int M, int N, String str) {
        if( M != 0 ) {
            return doSolve(M/N, N, str) + str.charAt(M%N);
        }
        return "";
    }


}
