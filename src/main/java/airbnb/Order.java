package airbnb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static class Ordered{
        List<MenuItem> items;
        int totalPrice;

        public Ordered(List<MenuItem> items, int totalPrice){
            this.items = items;
            this.totalPrice = totalPrice;
        }
    }

    Map<String, Ordered> mem = new HashMap<>();
    public Ordered findTheBestSolution(List<String> orders, List<MenuItem> menu){

    }

    public String generageKey(List<String> orders){
        StringBuilder sb = new StringBuilder();
        for (String k : orders) {
            sb.append(k).append(":").append(k).append("|");
        }
        return sb.toString();
    }





}
