package airbnb;

import java.util.*;

public class Order {
    public static class MenuItem {
        String name;
        Map<String, Integer> items;
        int price;

        public MenuItem(String name, Map<String, Integer> items, int price){
            this.name = name;
            this.items = items;
            this.price = price;
        }

        public MenuItem(String name, String item, int price){
            this.name = name;
            this.price = price;
            items = new HashMap<>();
            items.put(item, 1);
        }


        @Override
        public int hashCode(){
            int rslt = 37;
            rslt = 37 + 17 * name.hashCode();
            return rslt;
        }

        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(!(o instanceof MenuItem)) return false;
            MenuItem p = (MenuItem) o;
            return p.name.equals(this.name);
        }
    }


    Map<String, Integer> mem = new HashMap<>();
    public List<String> findTheBestSolution(List<String> orders, List<MenuItem> menu){
        Map<String, Integer> orderMap = new HashMap<>();
        for(String order : orders){
            orderMap.put(order, orderMap.getOrDefault(order, 0) + 1);
        }

        List<String> path = new LinkedList<>();
        return dfs(orderMap, menu, path);
    }

    public List<MenuItem> dfs(Map<String, Integer> orderMap, List<MenuItem> menu, List<String> path){
        if(orderMap.isEmpty()){
            return new ArrayList<>();
        }

        for(MenuItem item : menu){
            Map<String, Integer> newOrder = canUse(orderMap, item);
            if(newOrder != null){

            }
        }
    }

    privae



    public String generageKey(List<String> orders){
        StringBuilder sb = new StringBuilder();
        for (String k : orders) {
            sb.append(k).append(":").append(k).append("|");
        }
        return sb.toString();
    }
}
