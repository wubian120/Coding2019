package cn.bw.leetcode;

import java.util.*;

/***
 *
 * 2019-12-12
 * leetcode 332 重新规划行程
 *
 */
public class A332重新规划行程 {


    public List<String> findItinerary2(List<List<String>> tickets) {
        // 因为逆序插入，所以用链表
        List<String> ans = new LinkedList<>();

        if (tickets == null || tickets.size() == 0)
            return ans;

        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> pair : tickets) {
            // 因为涉及删除操作，我们用链表
            PriorityQueue<String> nbr = graph.computeIfAbsent(pair.get(0), k -> new PriorityQueue<>());
            nbr.add(pair.get(1));
        }

        // 按目的顶点排序

        visit(graph, "JFK", ans);

        return ans;
    }

    // DFS方式遍历图，当走到不能走为止，再将节点加入到答案
    private void visit(Map<String, PriorityQueue<String>> graph, String src, List<String> ans) {

        Stack<String> stack = new Stack<>();

        stack.push(src);

        while (!stack.isEmpty()) {
            PriorityQueue<String> nbr;

            while ((nbr = graph.get(stack.peek())) != null &&
                    nbr.size() > 0) {
                stack.push(nbr.poll());
            }
            ans.add(0, stack.pop());
        }
    }



    public List<String> findItinerary(List<List<String>> tickets) {
        if(tickets == null || tickets.size()==0){
            return Collections.emptyList();
        }
        List<String> result = new LinkedList<>();

        Map<String,List<String>> stopsMap = new HashMap<>();
        for(List<String> ticket : tickets){

            List<String> stops = stopsMap.computeIfAbsent(ticket.get(0),k->new LinkedList<>());
            stops.add(ticket.get(1));
        }

        stopsMap.values().forEach(x->x.sort(String::compareTo));

        dfs(stopsMap,"JFK",result);
        return result;
    }

    private void dfs(Map<String, List<String>> stopMap, String start, List<String> result) {

        List<String> stops = stopMap.get(start);
        while (stops != null && stops.size() > 0) {
            String end = stops.remove(0);
            dfs(stopMap,end,result);
        }
        result.add(0,start);

    }


    public static void main(String...args){

        List<String> ticket = new LinkedList<>();
        List<List<String>> tickets = new LinkedList<>();

        String b1="", e1="";
        String b2="", e2="";
        String b3="", e3="";
        String b4="", e4="";
        String b5="", e5="";

        A332重新规划行程 a = new A332重新规划行程();
//        a.findItinerary2()
    }


}
