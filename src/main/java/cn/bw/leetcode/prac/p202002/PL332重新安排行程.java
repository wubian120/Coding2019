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

        if (tickets == null || tickets.size() == 0) {
            return Collections.emptyList();
        }

        Map<String, List<String>> stopMap = new HashMap<>();

        for (List<String> ticket : tickets) {

            List<String> stops = stopMap.computeIfAbsent(
                    ticket.get(0), t -> new LinkedList<>()
            );

            stops.add(ticket.get(1));

        }

        stopMap.values().forEach(t->t.sort(String::compareTo));

        List<String> reuslts = new LinkedList<>();

        dfs(stopMap,"JFK",reuslts);

        return reuslts;

    }

    private void dfs(Map<String, List<String>> stopMap,
                     String start,
                     List<String> results) {

        List<String> stops = stopMap.get(start);
        while (stops != null && stops.size() != 0) {

            String nextStop = stops.remove(0);
            dfs(stopMap, nextStop, results);

        }
        results.add(0, start);

    }


}
