class Solution {
    public List<String> commonChars(String[] words) {

        List<String> result = new ArrayList<>();

        String str = words[0];

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);
            boolean common = true;

            for (int j = 1; j < words.length; j++) {

                int index = words[j].indexOf(c);

                if (index == -1) {
                    common = false;
                    break;
                }

                // Remove this occurrence so duplicates are handled
                words[j] = words[j].substring(0, index)
                         + words[j].substring(index + 1);
            }

            if (common) {
                result.add(String.valueOf(c));
            }
        }

        return result;
    }
}