package org.sourav.recursion;

public class TOH {
    public static void main(String[] args) {
        TOH(3,"A","C","B");
    }

    private static void TOH(int n , String A, String B, String C){
        if(n >1){
            TOH(n-1,A,C,B);
            System.out.println(A +"- >" +B);
            TOH(n-1,C,B,A);
        }else if(n==1){
            System.out.println(A +"- >" +B);
            return;
        }else
            return;
    }
}
