package cn.bw.leetcode.prac;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class A20有效的括号r1 {

    private static final Map<Character, Character> charMap = new HashMap<Character, Character>() {{
        put('{', '}');
        put('(', ')');
        put('[', ']');
        put('?', '?');
    }};

    public boolean isValid(String s) {
        if (s.length() > 0 && !charMap.containsKey(s.charAt(0))) {
            return false;
        }

        List<Character> chars = new LinkedList<Character>() {{
                add('?'); }};

        for(Character c : s.toCharArray()){
            if(charMap.containsKey(c)){
                chars.add(c);
            }else if(charMap.get(((LinkedList<Character>) chars)
                    .removeLast())!=c){
                return false;
            }
        }
        return chars.size() ==1;

    }

}
