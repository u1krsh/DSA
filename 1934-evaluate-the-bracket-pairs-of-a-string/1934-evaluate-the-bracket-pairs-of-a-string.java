class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> kmap = new HashMap<>();
        for (List<String> pair : knowledge) {
            kmap.put(pair.get(0), pair.get(1));
        }

        StringBuilder result = new StringBuilder();
        StringBuilder key = new StringBuilder();
        boolean inBracket = false;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                inBracket = true;
                key.setLength(0);
            } else if (ch == ')') {
                inBracket = false;
                result.append(kmap.getOrDefault(key.toString(), "?"));
            } else if (inBracket) {
                key.append(ch);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }
}