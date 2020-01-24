package cn.bw.leetcode.prac.p2019;

import java.util.*;

public class A332p4 {
    public List<String> findItinerary(List<List<String>> tickets) {

        if (tickets == null || tickets.size() == 0) {
            return Collections.emptyList();
        }

        Map<String, List<String>> stopsMap = new HashMap<>();
        for (List<String> ticket : tickets) {
            List<String> stops
                    = stopsMap.computeIfAbsent(ticket.get(0),
                    s -> new LinkedList<>());

            stops.add(ticket.get(1));
        }
        stopsMap.values().forEach(s -> s.sort(String::compareTo));
        List<String> results = new LinkedList<>();

        dfs(stopsMap,"JFK",results);
        return results;
    }

    private void dfs(
            Map<String, List<String>> stopMap,
            String start,
            List<String> result) {

        List<String> stops = stopMap.get(start);
        while (stops!=null && stops.size()>0){
            String end = stops.remove(0);
            dfs(stopMap,end,result);
        }
        result.add(0,start);

    }
}
