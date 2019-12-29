package cn.bw.leetcode.sample;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class A20有效的括号s {
    private static final Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
        put('?', '?');
    }};

    public boolean isValid(String s) {
        if (s.length() > 0 && !map.containsKey(s.charAt(0)))
            return false;
        LinkedList<Character> stack = new LinkedList<Character>() {{
            add('?');
        }};
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c))
                stack.addLast(c);
            else if (map.get(stack.removeLast()) != c)
                return false;
        }
        return stack.size() == 1;
    }

    public static void main(String... args) {


        String s = "()[]{}";
        A20有效的括号s a = new A20有效的括号s();
        boolean result = a.isValid(s);
        System.out.println(result);
    }

}
