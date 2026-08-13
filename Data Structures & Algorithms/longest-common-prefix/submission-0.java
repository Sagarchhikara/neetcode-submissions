class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length== 0) return "";
        String prefix=strs[0];
        int prefixlen=prefix.length();
         for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            while (prefixlen > s.length() || !prefix.equals(s.substring(0, prefixlen))) {
                prefixlen--;
                if (prefixlen == 0) {
                    return "";
                }
                prefix = prefix.substring(0, prefixlen);
            }
        }
        return prefix;

    }
    }
