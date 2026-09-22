class Solution {
    public char findTheDifference(String s, String t) {

        int[] freq = new int[26];

        // Count characters of s
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Remove characters of t
        for (char ch : t.toCharArray()) {
            freq[ch - 'a']--;

            if (freq[ch - 'a'] < 0) {
                return ch;
            }
        }

        return ' ';
    }
}