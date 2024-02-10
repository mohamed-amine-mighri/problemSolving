public class Solution {
    public int[] countBits(int n) {
        int[] num = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // The count of set bits in the current number is equal to the count of set bits in i/2,
            // plus the least significant bit of i (i & 1).
            num[i] = num[i / 2] + (i & 1);
        }
        return num;
    }
}
