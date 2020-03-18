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

        if(tickets==null||tickets.size()==0){
            return Collections.emptyList();
        }

        List<String> results=new LinkedList<>();

        Map<String,List<String>> stopMap=new HashMap<>();

        for(List<String> ticket:tickets){

            List<String> stops=stopMap.computeIfAbsent(ticket.get(0),t->new LinkedList<>());
            stops.add(ticket.get(1));
        }

        stopMap.values().forEach(t->t.sort(String::compareTo));




        dfs(stopMap,"JFK",results);


        return results;

    }

    private void dfs(Map<String,List<String>> stopsMap, String start, List<String> results){

        List<String> stops = stopsMap.get(start);

        while (stops!=null&&!stops.isEmpty()){
            String nextStop = stops.remove(0);
            dfs(stopsMap,nextStop,results);
        }

        results.add(0,start);
    }

}
