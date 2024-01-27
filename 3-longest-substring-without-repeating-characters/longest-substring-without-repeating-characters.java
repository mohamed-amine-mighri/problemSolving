class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int ans = 0;
        Set<Character> c = new HashSet<>();
        for(int right =0; right < s.length(); right++){            
            char ch = s.charAt(right);
            while (c.contains(ch)){
                char lchar = s.charAt(left);
                c.remove(lchar);
                left++;
            }
            ans = Math.max(ans, (right - left)+1);
            c.add(ch);
        }
       
        return ans;
    }
}
