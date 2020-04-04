package cn.bw.leetcode.sample;

import java.util.*;

/**
 * @ClassName : A332重新安排行程s
 * @Author : Richard.Wu
 * @Date: 2020-03-17 08:33
 * @Description :
 */

public class A332重新安排行程s {

    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null || tickets.size() == 0) {
            return Collections.emptyList();
        }

        Map<String, List<String>> stopsMap = new HashMap<>();
        for (List<String> ticket : tickets) {
            List<String> stops
                    = stopsMap.computeIfAbsent(ticket.get(0),
                    t -> new LinkedList<>());
            stops.add(ticket.get(1));
        }

        stopsMap.values().forEach(t -> t.sort(String::compareTo));

        List<String> results = new LinkedList<>();

        dfs(stopsMap, "JFK", results);

        return results;
    }

    private static void dfs(Map<String, List<String>> stopMap,
                            String start,
                            List<String> result) {

        List<String> stops = stopMap.get(start);
        while (stops != null && stops.size() > 0) {
            String end = stops.remove(0);
            dfs(stopMap, end, result);
        }
        result.add(0, start);
    }


    public static void main(String...args){

        List<String> stops1= Arrays.asList("MUC","LHR");
        List<String> stops2= Arrays.asList("JFK","MUC");
        List<String> stops3= Arrays.asList("SFO","SJC");
        List<String> stops4= Arrays.asList("LHR","SFO");

        List<List<String>> stopss= Arrays.asList(stops1,stops2,stops3,stops4);

        A332重新安排行程s a = new A332重新安排行程s();
        List<String> results= a.findItinerary(stopss);

        results.forEach(System.out::println);

        System.out.println("end");


    }

}
