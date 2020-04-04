package cn.bw.leetcode.prac.p202002;

import java.util.*;

/**
 * @ClassName : PL332重新安排行程
 * @Author : Richard.Wu
 * @Date: 2020-03-17 08:35
 * @Description :
 */

public class PL332重新安排行程 {

    public List<String> findItinerary(List<List<String>> tickets) {
        if(tickets==null||tickets.isEmpty()){
            return Collections.emptyList();
        }

        Map<String,List<String>> stopmap = new HashMap<>();
        for(List<String> ticket:tickets){

            List<String> stops
                    = stopmap.computeIfAbsent(ticket.get(0),
                            s->new LinkedList<>());
            stops.add(ticket.get(1));
        }

        stopmap.values().forEach(t->t.sort(String::compareTo));

        List<String> results = new LinkedList<>();

        dfs(stopmap,"JFK",results);

        return results;


    }

    private void dfs(Map<String, List<String>> stopmap,
                     String start,
                     List<String> results) {

        List<String> stops = stopmap.get(start);
        while (stops != null && stops.size() > 0) {
            String end = stops.remove(0);
            dfs(stopmap, end, results);
        }
        results.add(0, start);
    }


}
