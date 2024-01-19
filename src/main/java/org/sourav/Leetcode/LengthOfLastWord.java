package org.sourav.Leetcode;

public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord(" Hello World "));
    }

    public static int lengthOfLastWord(String s) {
        /*final String[] arr = s.trim().split(" ");
        return arr[arr.length - 1].length();*/

        int count=0;

        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i) != ' '){
                count++;
            }
            else{
                if(count > 0){
                    return count;
                }
            }

        }
        return count;
    }

}
