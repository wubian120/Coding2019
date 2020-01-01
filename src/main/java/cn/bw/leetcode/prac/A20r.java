package cn.bw.leetcode.prac;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class A20r {


    private static final Map<Character, Character> charMap =
            new HashMap<>();

    static {
        charMap.put('{', '}');
        charMap.put('(', ')');
        charMap.put('[', ']');
        charMap.put('?', '?');
    }

    public boolean isValid(String s) {
        if (s.length() > 0 && !charMap.containsKey(s.charAt(0))) {
            return false;
        }
        List<Character> stack = new LinkedList<>();
        stack.add('?');

        for (Character c : s.toCharArray()) {
            if(charMap.containsKey(c)){
                stack.add(c);
            }else if(charMap.get(((LinkedList<Character>) stack).removeLast())!=c){
                return false;
            }
        }
        return stack.size() == 1;

    }

}
