package cn.bw.leetcode.prac;

import java.util.*;

public class A332重新规划行程p3 {

    public List<String> findItinerary(List<List<String>> tickets){

        if(tickets==null || tickets.size()==0){
            return Collections.emptyList();
        }

        Map<String,List<String>> stopsMap = new HashMap<>();
        for(List<String> ticket:tickets){
            List<String> stop = stopsMap.computeIfAbsent(ticket.get(0),s->new LinkedList<>());
            stop.add(ticket.get(1));
        }

        stopsMap.values().forEach(s->s.sort(String::compareTo));

        List<String> results = new LinkedList<>();
        dfs(stopsMap,"JFK",results);
        return results;



    }
    private void dfs(Map<String,List<String>> stopsMap,String start,List<String> results){

        List<String> stops=stopsMap.get(start);
        while (stops!=null &&stops.size()>0){
            String end = stops.remove(0);
            dfs(stopsMap,end,results);
        }
        results.add(0,start);

    }


}
