package bnb;

import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDishes2 {
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
    private static class MenuItem{
        String id;
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

    private static class Order implements Comparable<Order> {
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


    public Order findBestOorder(List<MenuItem> menu, List<String> order){
        mem = new HashMap<>();
        left = new HashMap<>();
        itemMenuMap = new HashMap<>();
        rslt = new Order(new ArrayList<>());
        rslt.price = new BigDecimal(Double.MAX_VALUE);

        for(MenuItem menuItem : menu){
            for(String item : menuItem.items.keySet()){
                List<MenuItem> menuItems =  itemMenuMap.getOrDefault(item, new ArrayList<>());
                menuItems.add(menuItem);
                itemMenuMap.put(item, menuItems);
            }
        }


        List<MenuItem> ordered = new ArrayList<>();
        dfs(order, ordered, left);

        return this.rslt;
    }

    public void dfs(List<String> toOrder, List<MenuItem> ordered, Map<String, Integer> left) {
        if (toOrder.isEmpty()) {
            Order currentOrder = new Order(ordered);
            if (currentOrder.compareTo(rslt) < 0) {
                rslt = currentOrder;
            }
            return;
        }

        String item = toOrder.get(0);
        if (!itemMenuMap.containsKey(item)) {
            return;
        }

        if (left.containsKey(item)) {
            int need = left.get(item);
            if (need > 0) {
                List<String> newToOrder = new ArrayList<>(toOrder);
                newToOrder.remove(item);
                Map<String, Integer> newLeft = new HashMap<>(left);
                newLeft.put(item, need - 1);
                dfs(newToOrder, ordered, newLeft);
            }
        }


        for (MenuItem menuItem : itemMenuMap.get(item)) {
            List<String> newToOrder = new ArrayList<>(toOrder);
            newToOrder.remove(0);
            List<MenuItem> newOrdered = new ArrayList<>(ordered);
            newOrdered.add(menuItem);
            Map<String, Integer> newLeft = new HashMap<>(left);
            for (String menuItemKey : menuItem.items.keySet()) {
                if(menuItemKey.equals(item)){
                    int need = menuItem.items.get(menuItemKey);
                    newLeft.put(menuItemKey, newLeft.getOrDefault(menuItemKey, 0) + need - 1);
                } else {
                    int need = menuItem.items.get(menuItemKey);
                    newLeft.put(menuItemKey, newLeft.getOrDefault(menuItemKey, 0) + need);
                }
            }

            dfs(newToOrder, newOrdered, newLeft);
        }
    }

    public static void main(String[] args) {
        OrderDishes2 orderDishes2 = new OrderDishes2();
        List<MenuItem> menu = new ArrayList<>();

        Map<String, Integer> combo1Items = new HashMap<>();
        combo1Items.put("Burger", 1);
        combo1Items.put("Fries", 1);
        MenuItem combo1 = new MenuItem("Combo1", combo1Items, new BigDecimal(7));
        menu.add(combo1);

        Map<String, Integer> singleBurgerItems = new HashMap<>();
        singleBurgerItems.put("Burger", 1);
        MenuItem singleBurger = new MenuItem("SingleBurger", singleBurgerItems, new BigDecimal(5));
        menu.add(singleBurger);

        Map<String, Integer> singleFriesItems = new HashMap<>();
        singleFriesItems.put("Fries", 1);
        MenuItem singleFries = new MenuItem("SingleFries", singleFriesItems, new BigDecimal(3));
        menu.add(singleFries);

        List<String> order = new ArrayList<>();
        order.add("Burger");
        order.add("Burger");
        order.add("Fries");

        Order bestOrder = orderDishes2.findBestOorder(menu, order);
        System.out.println("Best Order Price: " + bestOrder.price);
        System.out.println("Items in Best Order:");
        for (MenuItem item : bestOrder.items) {
            System.out.println("- " + item.id + " ($" + item.price + ")");
        }
    }

}
