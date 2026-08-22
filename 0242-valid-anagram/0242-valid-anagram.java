class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        HashMap<Character, Integer> ss = new HashMap<>();
        HashMap<Character, Integer> tt = new HashMap<>();
        for(int i =0 ;i<s.length();i++){

            ss.merge(s.charAt(i), 1, Integer::sum);
            tt.merge(t.charAt(i), 1, Integer::sum);
        }

        return ss.equals(tt);
    }


}