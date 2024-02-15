package org.sourav.Leetcode.SlidingWindow;

public class MaxConsecutiveAnswerKey {

    public static void main(String[] args) {
        System.out.println(maxConsecutiveAnswers("TFFTTF", 2));
    }

    public static int maxConsecutiveAnswers(String answerKey, int k) {
        int windowStart = 0;
        int windowEnd = 0;
        int tCount = 0;
        int fCount = 0;
        int maxLength = 0;

        for (windowEnd = 0; windowEnd < answerKey.length(); windowEnd++) {
            if (answerKey.charAt(windowEnd) == 'T') {
                tCount++;
            }
            else {
                fCount++;
            }

            while (tCount > k && fCount > k) {
                if (answerKey.charAt(windowStart) == 'T') {
                    tCount--;
                }
                else {
                    fCount--;
                }

                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

}
