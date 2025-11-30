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

        @Override
        public String toString(){
            return this.name;
        }
    }

    Map<String, List<MenuItem>> mem = new HashMap<>();
    public List<MenuItem> findTheBestSolution(List<String> orders, List<MenuItem> menu){
        Map<String, Integer> orderMap = new HashMap<>();
        for(String order : orders){
            orderMap.put(order, orderMap.getOrDefault(order, 0) + 1);
        }

        List<MenuItem> path = new LinkedList<>();
        return dfs(orderMap, menu);
    }

    public List<MenuItem> dfs(Map<String, Integer> orderMap, List<MenuItem> menu){
        if(orderMap.isEmpty()){
            return new ArrayList<>();
        }
        String key = generageKey(orderMap);
        if(mem.containsKey(key)){
            return mem.get(key);
        }
        int bestPrice = Integer.MAX_VALUE;
        List<MenuItem> bestOrder = null;
        for(MenuItem item : menu){
            Map<String, Integer> newOrder = canUse(orderMap, item);
            if(newOrder != null){
                List<MenuItem> restOrder = dfs(newOrder, menu);
                List<MenuItem> candidate = new ArrayList<>(restOrder);
                candidate.add(item);
                int newPrice = calPrice(candidate);
                if (newPrice < bestPrice) {
                    bestPrice = newPrice;
                    bestOrder = new ArrayList<>(candidate);
                }
            }
        }

        mem.put(generageKey(orderMap), bestOrder);
        return bestOrder;
    }

    public int calPrice(List<MenuItem> path){
        int rslt = 0;

        for(MenuItem item : path){
            rslt += item.price;
        }

        return rslt;
    }

    Map<String, Integer> canUse(Map<String, Integer> order, MenuItem item) {
        Map<String, Integer> newOrder = new HashMap<>();
        Map<String, Integer> menuItems = item.items;

        boolean hasEffect = false;

        // 遍历当前所有需求，进行扣减
        for (String dish : order.keySet()) {
            int need = order.get(dish);
            int provide = menuItems.getOrDefault(dish, 0);
            if (provide > 0) {
                hasEffect = true;
            }
            int remain = need - provide;
            if (remain > 0) {
                newOrder.put(dish, remain);
            }
            // remain <= 0 表示已经满足或超额，直接忽略
        }

        return hasEffect ? newOrder : null;
    }



    public String generageKey(Map<String, Integer> orderMap){
        StringBuilder sb = new StringBuilder();
        List<String> keys = new ArrayList<>(orderMap.keySet());
        Collections.sort(keys);
        for (String k : keys) {
            sb.append(k).append(":").append(orderMap.get(k));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Order orderSolver = new Order();

        List<Order.MenuItem> menu = new ArrayList<>();
        menu.add(new Order.MenuItem("Burger", "burger", 5));
        menu.add(new Order.MenuItem("Fries", "fries", 3));
        Map<String, Integer> items = new HashMap<>();
        items.put("burger", 2);
        menu.add(new Order.MenuItem("Double Burger", items, 2));


        Map<String, Integer> comboItems = new HashMap<>();
        comboItems.put("burger", 1);
        comboItems.put("fries", 1);
        menu.add(new Order.MenuItem("Burger+Fries Combo", comboItems, 7));

        List<String> orders = Arrays.asList("burger", "burger", "burger", "fries");
        List<Order.MenuItem> best = orderSolver.findTheBestSolution(orders, menu);
        System.out.println(best); // 看看有没有选到一份 Combo + 一份 Burger 或其他组合
    }
}
