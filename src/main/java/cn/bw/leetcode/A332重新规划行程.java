package cn.bw.leetcode;

import java.util.*;

/***
 *
 * 2019-12-12
 * leetcode 332 重新规划行程
 *
 */
public class A332重新规划行程 {


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


}
