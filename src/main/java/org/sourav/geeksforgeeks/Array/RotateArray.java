package org.sourav.geeksforgeeks.Array;

import java.util.Scanner;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        Scanner sc = new Scanner(System.in);
        int d= sc.nextInt();
        int n=7;
        if(d>n) {
            System.out.println("Invalid input");
            System.exit(0);
        }
        System.out.println("Before rotate: ");
        for(int x:arr){
            System.out.print(x + " ");
        }
        leftRotateArrays(arr,d,n);
    }

    private static void leftRotateArrays(int[] a, int d, int n){
        int temp=0;
        while(d>0){
            temp=a[0];
            for(int i=0;i<n-1;i++){
                a[i]=a[i+1];
            }
            a[n-1]=temp;
            d--;
        }
        System.out.println("\nAfter rotate: ");
        for(int x:a){
            System.out.print(x + " ");
        }
    }
}
