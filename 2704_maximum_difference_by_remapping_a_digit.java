class Solution {
    public int minMaxDifference(int num) {

        String s = String.valueOf(num);

        // Maximum
        char maxDigit = ' ';
        for (char ch : s.toCharArray()) {
            if (ch != '9') {
                maxDigit = ch;
                break;
            }
        }

        String max = s;

        if (maxDigit != ' ') {
            max = s.replace(maxDigit, '9');
        }

        // Minimum
        char minDigit = s.charAt(0);

        String min = s.replace(minDigit, '0');

        return Integer.parseInt(max) - Integer.parseInt(min);
    }
}