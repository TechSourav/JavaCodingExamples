package org.sourav.recursion;

/**
* Pring pattern
 * n =6
 *  output : 6 , 3 , 0, 3, 6
 *  incsrease the num if 0 / -ve till same as input.
 *
**/

public class PrintPattern {
    public static void main(String[] args) {
        int num = 16;
        int diff = 5;
        boolean flag = false;
        PrintPattern pp = new PrintPattern();
        System.out.print(num);
        pp.formPattern(num-diff, diff, num, flag);
    }

    private void  formPattern(int n, int d, int c, boolean flag) {
        System.out.print(" "+ n);
        if(n==c){
            return;
        }else if (n == 0 || n < 0) {
            formPattern(n+d,d,c,true);
        }else if(flag){
            formPattern(n+d,d,c,true);
        }else{
            formPattern(n-d,d,c,false);
        }
    }
}
