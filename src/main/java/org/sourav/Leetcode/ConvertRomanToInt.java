package org.sourav.Leetcode;

public class ConvertRomanToInt {

    public static void main(String[] args) {
        System.out.println(intToRoman(999));
    }

    public static String intToRoman(int num) {
        int j = num;
        String romanResult = "";
        Character ch[] = {'I','X','C','M'};
        Character ch2[] = {'V','L','D'};
        Character ch3[] = {'X','C','M'};

        int i=0;
        while(j > 0)
        {
            int seg = j %10;
            String temp = "";
            switch(seg)
            {
            case 1:
            {
                temp = temp+ch[i];
                break;
            }
            case 2:
            {
                temp = temp+ch[i]+ch[i];
                break;
            }
            case 3:
            {
                temp = temp + ch[i] + ch[i] + ch[i];
                break;
            }
            case 4:
            {
                temp = temp + ch[i] + ch2[i];
                break;
            }
            case 5:
            {
                temp = temp + ch2[i];
                break;
            }
            case 6:
            {
                temp = temp + ch2[i] + ch[i];
                break;
            }
            case 7:
            {
                temp = temp + ch2[i] + ch[i] + ch[i];
                break;
            }
            case 8:
            {
                temp = temp + ch2[i] + ch[i] + ch[i] + ch[i];
                break;
            }
            case 9:
            {
                temp = temp + ch[i] + ch3[i];
                break;
            }
            default:
            {
                // Do nothing
                break;
            }
            }
            j = j /10;
            i++;
            romanResult = temp + romanResult;
        }
        return romanResult;
    }

}
