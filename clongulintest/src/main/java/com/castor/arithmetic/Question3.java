package com.castor.arithmetic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Question3 {

    public static int lengthOfLongestSubstring(String s) {
        /*int max = 0;
        if(s == null || "".equals(s))
            return max;
        Set<String> charSets = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length - max +1;i++){
            charSets.clear();
            String opt = String.valueOf(chars[i]);
            charSets.add(opt);
            for (int j = i+1;j<chars.length;j++){
                String opt1 = String.valueOf(chars[j]);
                if(charSets.contains(opt1)){
                    break;
                }else{
                    charSets.add(opt1);
                }
            }
            max = max < charSets.size() ? charSets.size() : max;
            System.out.println(charSets.toString());
        }
        return max;*/
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pkpv"));
    }
}
