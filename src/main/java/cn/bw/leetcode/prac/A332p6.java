package cn.bw.leetcode.prac;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class A332p6 {

    public List<String> findItinerary(List<List<String>> tickets) {


        Map<String, List<String>> stopMap = new HashMap<>();
        for (List<String> ticket : tickets) {
            List<String> stops
                    = stopMap
                    .computeIfAbsent(ticket.get(0),t->new LinkedList<>());

            stops.add(ticket.get(1));
        }

        stopMap.values().forEach(t->t.sort(String::compareTo));

        List<String> results = new LinkedList<>();

        dfs(stopMap,"JFL",results);

        return results;

    }

    private void dfs(Map<String,List<String>> stopMap,String start,List<String> results){

        List<String> stops = stopMap.get(start);
        while (stops!=null&&stops.size()>0){
            String stop = stops.remove(0);
            dfs(stopMap,stop,results);
        }

        results.add(0,start);
    }


}
