package org.general;

public class Product {

    public static void main(String[] args) {
        int[] arr = {0,5,400,8,7, 1, 2}; // {}
        // {-7, -5, 4} -> ans
        // 0,1,3,4,5,7 -> nlog(n)
        // hi: 400  sec: 8  thi: -5
        // max of neg num: -19, -7

        System.out.println(getMaxProduct(arr));

    }

    static int getMaxProduct(int[] arr) {
        int highestPos = Integer.MIN_VALUE, secHiPos = 0, thirdHiPos = 0;
        int hiNeg = Integer.MIN_VALUE, secHiNeg = 0;

        for (int i = 0; i< arr.length; i++) {
            if (arr[i] == 0) {
                continue;
            } else if (arr[i] > 0 ) {
                if (arr[i] > highestPos) {
                    thirdHiPos = secHiPos;
                    secHiPos = highestPos;
                    highestPos = arr[i];
                } else if (arr[i] > secHiPos) {
                    thirdHiPos = secHiPos;
                    secHiPos = arr[i];
                } else if (arr[i] > thirdHiPos) {
                    thirdHiPos =  arr[i];
                }
            } else {
                if (Math.abs(arr[i]) > Math.abs(hiNeg)) {
                    secHiNeg = hiNeg;
                    hiNeg = arr[i];
                } else if (Math.abs(arr[i]) > Math.abs(secHiNeg)) {
                    secHiNeg = arr[i];
                }
            }
        }
        // At the end of the above loop, I will ahve all the highest numbers. Now I can compare

        int maxMul = highestPos * secHiPos * thirdHiPos;
        maxMul = Math.max(maxMul, (highestPos * hiNeg * secHiNeg));

        return maxMul;
    }

}
