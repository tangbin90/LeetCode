package bnb;

import java.awt.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.List;

public class OrderDishes {
    /**
     * 这道题目通常被称为 "Menu Combination" 或 "Cheapest Order" (最便宜的点菜方案)。
     *
     * 这是一道经典的 背包问题 (Knapsack Problem) 变种，确切地说，是一个 完全背包问题 (Unbounded Knapsack) 或者 精确覆盖 (Exact Cover) 问题。
     *
     * 1. 题目核心逻辑
     * 输入：
     *
     * User Order: 用户想吃的菜和数量（例如：2 Burgers, 1 Fries）。
     *
     * Menu: 菜单，包含单品价格和套餐（Combo）价格。
     *
     * Single: Burger $5, Fries $3
     *
     * Combo: "Burger + Fries" $7 (比单点 $5+$3=$8 便宜)
     *
     * 目标： 找到总价最低的购买组合，凑齐用户需要的菜品（通常要求数量精确匹配，不能多也不能少）。
     * */
    public static class MenuItem{
        public String id;
        Map<String, Integer> items;
        BigDecimal price;

        public MenuItem(String id, Map<String, Integer> items, BigDecimal price){
            this.id = id;
            this.items = items;
            this.price = price;
        }

        @Override
        public int hashCode(){
            return id.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (!(o instanceof MenuItem)) {
                return false;
            }

            MenuItem p = (MenuItem) o;

            return this.id.equals(p.id);
        }
    }

    public static class Order implements Comparable<Order> {
        List<MenuItem> items;
        BigDecimal price;

        public Order(List<MenuItem> items){
            this.items = items;
            this.price = new BigDecimal(0);
            for(MenuItem item : items){
                this.price = this.price.add(item.price);
            }
        }

        @Override
        public int compareTo(Order o) {
            if(this.price.equals(o.price)){
                return this.items.size() - o.items.size();
            } else {
                return this.price.compareTo(o.price);
            }
        }


    }

    private Order rslt;
    private Map<String, Order> mem;
    private Map<String, Integer> left;
    private Map<String , List<MenuItem>> itemMenuMap;
    private List<MenuItem> menu;
    public Order findBestOorder(List<MenuItem> menu, List<String> order){
        mem = new HashMap<>();
        left = new HashMap<>();
        itemMenuMap = new HashMap<>();
        rslt = new Order(new ArrayList<>());
        rslt.price = new BigDecimal(Double.MAX_VALUE);
        this.menu = menu;
        for(MenuItem menuItem : menu){
            for(String item : menuItem.items.keySet()){
                List<MenuItem> menuItems =  itemMenuMap.getOrDefault(item, new ArrayList<>());
                menuItems.add(menuItem);
                itemMenuMap.put(item, menuItems);
            }
        }

        Map<String, Integer> orderMap = new HashMap<>();

        for(String item : order){
            orderMap.put(item, 1 + left.getOrDefault(item, 0));
        }
        return dfs(orderMap);
    }

    public String toKey(Map<String, Integer> needs){
        List<String> keys = new ArrayList<>(needs.keySet());
        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();
        for(String key : keys){
            sb.append(key);
            sb.append(":");
            sb.append(needs.get(key));
            sb.append(";");
        }
        return sb.toString();
    }
    public Order dfs(Map<String, Integer> currentNeeds){
        if(currentNeeds.isEmpty()){
            return new Order(new ArrayList<>());
        }

        if(mem.containsKey(toKey(currentNeeds))){
            return mem.get(toKey(currentNeeds));
        }

        Order bestOrder = null;

        for(MenuItem menuItem : menu){
            Map<String, Integer> nextNeeds = new HashMap<>();
            if(canUse(menuItem, currentNeeds, nextNeeds)){
                Order subOrder = dfs(nextNeeds);
                if(subOrder != null){
                    List<MenuItem> combinedItems = new ArrayList<>(subOrder.items);
                    combinedItems.add(menuItem);
                    Order newOrder = new Order(combinedItems);
                    if(bestOrder == null || newOrder.compareTo(bestOrder) < 0){
                        bestOrder = newOrder;
                    }
                }
            }
        }
        mem.put(toKey(currentNeeds), bestOrder);
        return bestOrder;
    }

    public boolean canUse(MenuItem menuItem, Map<String, Integer> currentNeeds, Map<String, Integer> nextNeeds){
        nextNeeds.clear();
        Set<String> menuItemsSet = menuItem.items.keySet();
        Boolean canUse = true;
        for(String item : currentNeeds.keySet()){
            if(!menuItemsSet.contains(item)) {
                canUse = false;
            }
        }

        if(canUse){
            for(String item : currentNeeds.keySet()){
                int needCount = currentNeeds.get(item);
                int menuCount = menuItem.items.getOrDefault(item, 0);
                if(needCount - menuCount > 0){
                    nextNeeds.put(item, needCount - menuCount);
                }
            }
        }
        return canUse;
    }

    public static void main(String[] args) {
        OrderDishes orderDishes = new OrderDishes();
        List<MenuItem> menu = new ArrayList<>();
        Map<String, Integer> item1 = new HashMap<>();
        item1.put("Burger", 1);
        MenuItem mi1 = new MenuItem("Burger", item1, new BigDecimal(5));

        Map<String, Integer> item2 = new HashMap<>();
        item2.put("Fries", 1);
        MenuItem mi2 = new MenuItem("Fries", item2, new BigDecimal(3));

        Map<String, Integer> item3 = new HashMap<>();
        item3.put("Burger", 1);
        item3.put("Fries", 1);
        MenuItem mi3 = new MenuItem("Burger+Fries", item3, new BigDecimal(7));

        menu.add(mi1);
        menu.add(mi2);
        menu.add(mi3);

        List<String> order = new ArrayList<>();
        order.add("Burger");
        order.add("Burger");
        order.add("Fries");

        Order bestOrder = orderDishes.findBestOorder(menu, order);
        System.out.println("Best Order Price: " + bestOrder.price);
        System.out.println("Items in Best Order:");
        for(MenuItem item : bestOrder.items){
            System.out.println(item.id + " - $" + item.price);
        }
    }

    public BigDecimal calPrice(List<MenuItem> items){
        BigDecimal bg = new BigDecimal(0);
        for(MenuItem item : items){
            bg = bg.add(item.price);
        }
        return bg;
    }


    public String getOrderKey(List<String> toOrderList, int pos){
        List<String> subList = toOrderList.subList(pos, toOrderList.size());
        Collections.sort(subList);
        StringBuilder sb = new StringBuilder();
        for(String str : subList){
            sb.append(str);
        }
        return sb.toString();
    }


}
