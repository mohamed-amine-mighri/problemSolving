class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        int max_len = 1;
        int n = s.length();
        int sta = 0;
        int end = 0;

        for (int i = 0; i < n-1; i++) {
            int l = i;
            int r = i;

            while (l >= 0 && r < n) {
                if (s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                } else
                    break;
            }

            if (r - l - 1 > max_len) {
                max_len = r - l - 1;
                sta = l + 1;
                end = r - 1;
            }
        }

        for (int i = 0; i < n-1; i++) {
            int l = i;
            int r = i + 1;

            while (l >= 0 && r < n) {
                if (s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                } else
                    break;
            }

            if (r - l - 1 > max_len) {
                max_len = r - l - 1;
                sta = l + 1;
                end = r - 1;
            }
        }
        return s.substring(sta, end + 1);
    }
}
