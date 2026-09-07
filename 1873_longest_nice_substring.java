class Solution {

    public String longestNiceSubstring(String s) {

        if (s.length() < 2) {
            return "";
        }

        // Check every character
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Check whether both cases exist
            if (!s.contains(String.valueOf(Character.toLowerCase(ch))) ||
                !s.contains(String.valueOf(Character.toUpperCase(ch)))) {

                // Split around the bad character
                String left = longestNiceSubstring(s.substring(0, i));
                String right = longestNiceSubstring(s.substring(i + 1));

                // Return the longer one
                if (left.length() >= right.length()) {
                    return left;
                } else {
                    return right;
                }
            }
        }

        // If no bad character exists,
        // the whole string is nice
        return s;
    }
}