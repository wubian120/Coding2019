package cn.bw.leetcode;

import java.util.*;

/**
 *
 * 整体逻辑：
 *
 *
 *
 *
 */

public class A332重新规划行程p2 {

    public List<String> findItinerary(List<List<String>> tickets){

        if(tickets == null || tickets.size()==0){
            return Collections.emptyList();
        }

        List<String> results = new LinkedList<>();
        Map<String,List<String>> stopMap = new HashMap<>();

        for(List<String> ticket : tickets){
            List<String> stops = stopMap.computeIfAbsent(ticket.get(0),t->new LinkedList<>());
            stops.add(ticket.get(1));
        }

        stopMap.values().forEach(t->t.sort(String::compareTo));

        dfs(stopMap,"JFK",results);

        return results;
    }
    private void dfs(Map<String,List<String>> stopMap,String start,List<String> results){

        List<String> stops = stopMap.get(start);
        while (stops!=null && stops.size()>0){
            String stop = stops.remove(0);
            dfs(stopMap,stop,results);
        }

        results.add(0,start);

    }



}
