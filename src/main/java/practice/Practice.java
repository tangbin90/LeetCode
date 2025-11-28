package practice;

import bnb.OrderDishes;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.*;

public class Practice {
    /**
     * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
     *
     * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
     * Return true if you can finish all courses. Otherwise, return false.
     *
     *
     *
     * Example 1:
     *
     * Input: numCourses = 2, prerequisites = [[1,0]]
     * Output: true
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0. So it is possible.
     * Example 2:
     *
     * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
     * Output: false
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
     *
     *
     * Constraints:
     *
     * 1 <= numCourses <= 2000
     * 0 <= prerequisites.length <= 5000
     * prerequisites[i].length == 2
     * 0 <= ai, bi < numCourses
     * All the pairs prerequisites[i] are unique.
     */

    Map<Integer, Set<Integer>> graph;
    Map<Integer, Integer> inDegree;
    public boolean canFinish(int[][] prerequisites, int numCourses){
        for(int i=0; i< numCourses; i++){
            graph.put(i, new HashSet<>());
            inDegree.put(i, 0);
        }

        for(int[] course : prerequisites){
            graph.compute(course[1], (a, b) -> {
                b.add(course[0]);
                return b;
            });

            inDegree.compute(course[0], (a, b) -> b == null? 1 : b+1);
        }


        Queue<Integer> queue = new LinkedList<>();

        for(int key : inDegree.keySet()){
            if(inDegree.get(key) == 0){
                queue.offer(key);
            }
        }

        List<Integer> rslt = new LinkedList<>();
        while(!queue.isEmpty()){
            int course = queue.poll();
            Set<Integer> subCourse = graph.getOrDefault(course, new HashSet<Integer>());
            rslt.add(course);
            for(Integer item : subCourse){
                int indegree = inDegree.get(item);
                indegree--;
                if(indegree == 0){
                    queue.offer(indegree);
                }
            }
        }


        return rslt.size() == numCourses;

    }

    /**
     * You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.
     *
     * All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.
     *
     * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
     * You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.
     */

     public List<String> findItinerary(List<List<String>> tickets){
         Map<String, PriorityQueue<String>> graph = new HashMap<>();
         List<String> path = new LinkedList<>();

         for(int i=0; i< tickets.size(); i++){
             List<String> ticket = tickets.get(i);

             PriorityQueue<String> pq = graph.getOrDefault(ticket.get(0), new PriorityQueue<String>());
             pq.add(ticket.get(1));
             graph.put(ticket.get(0), pq);
         }

         dfs("JFK",path, graph);

         Collections.reverse(path);
         return path;
     }

     public void dfs(String start, List<String> path, Map<String, PriorityQueue<String>> graph) {
           if(!graph.containsKey(start)){
               path.add(start);
               return;
           }

           PriorityQueue<String> pq = graph.getOrDefault(start, new PriorityQueue<String>());

           while(!pq.isEmpty()){
               String to = pq.poll();
               dfs(to, path, graph);
           }

           path.add(start);

     }
    /**
     * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
     *
     *
     *
     * Example 1:
     *
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
     * Example 2:
     *
     * Input: intervals = [[1,4],[4,5]]
     * Output: [[1,5]]
     * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
     * Example 3:
     *
     * Input: intervals = [[4,7],[1,4]]
     * Output: [[1,7]]
     * Explanation: Intervals [1,4] and [4,7] are considered overlapping.
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> rslt = new LinkedList<>();

        for(int i=1; i< intervals.length; i++){
            if(intervals[i][0] <= end){
                end = Math.max(end, intervals[i][1]);
            } else {
                rslt.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        rslt.add(new int[]{start, end});

        int[][] ans = new int[rslt.size()][2];

        for(int i=0; i < ans.length; i++){
            ans[i] = rslt.get(i);
        }

        return ans;
    }
    /**
     * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
     *
     *
     *
     * Example 1:
     *
     * Input: intervals = [[0,30],[5,10],[15,20]]
     * Output: 2
     * Example 2:
     *
     * Input: intervals = [[7,10],[2,4]]
     * Output: 1
     */
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0){
            return 0;
        }

        int rslt = 0;

        int curr = 0;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for(int[] interval : intervals){
            curr ++;
            while(!pq.isEmpty() && pq.peek()[1] <= interval[0]){
                pq.poll();
                curr --;
            }
            pq.add(interval);
            rslt = Math.max(rslt, curr);
        }

        return rslt;

    }

    /**
     * Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
     *
     * Return the minimized largest sum of the split.
     *
     * A subarray is a contiguous part of the array.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [7,2,5,10,8], k = 2
     * Output: 18
     * Explanation: There are four ways to split nums into two subarrays.
     * The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
     * Example 2:
     *
     * Input: nums = [1,2,3,4,5], k = 2
     * Output: 9
     * Explanation: There are four ways to split nums into two subarrays.
     * The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.
     *
     * dp[i][j] = 把前 i 个数字分成 j 段的最小可能最大段和
     * larget sum bigger, k smaller
     * sum k=1 min max(array)
     *  mid . = sum + max /2
     *  mid
     */

    public int splitArray(int[] nums, int k){
        int max = 0;
        int sum = 0;

        for(int num : nums){
            max = Math.max(max, num);
            sum += num;
        }

        long low = max;
        long high = sum;

        while(low < high){
            long mid = (low + high)/2;
            int need = countArraySum(nums, mid);
            if (need <= k){
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return (int) low;
    }

    public int countArraySum(int[] nums, long sum){
        int count = 1;
        int curr = 0;

        for (int num : nums) {
            if (curr + num <= sum) {
                curr += num;
            } else {
                // 当前段放不下 num，必须切新段
                count++;
                curr = num;
            }
        }

        return count;
    }

/**
 * # There are two things to focus on. The first (and most importantly)
 * # is correctly parsing the CSV format. The second is writing
 * # clean code that another engineer would enjoy using.
 * # You may assume that the CSV file is correctly formatted.
 * # An ideal parse will look like this:
 * # [['John', 'Smith', 'john.smith@gmail.com', 'Los Angeles', '1'],
 * #  ['Jane', 'Roberts', 'janer@msn.com', 'San Francisco, CA', '0'],
 * #  ['Alexandra "Alex"', 'Menendez', 'alex.menendez@gmail.com', 'Miami', '1'],
 * #  ['1','2','','4','5']]
 * csv_lines = [
 *   'John,Smith,john.smith@gmail.com,Los Angeles,10',
 *   'Jane,Roberts,janer@msn.com,"San Francisco, CA",0',
 *   '"Alexandra ""Alex""",Menendez,alex.menendez@gmail.com,Miami,1',
 *   '1,2,,4,"5"'
 * ]
 */


    List<List<String>> csvParser(Reader in) throws IOException {
        PushbackReader read = new PushbackReader(in);

        int ch = 0;
        boolean inQuote = false;
        List<List<String>> rslt = new LinkedList<>();
        List<String> currentLine = new LinkedList<>();
        StringBuilder currentColumn = new StringBuilder();
        while((ch = read.read()) != -1){
            char c = (char) ch;

            if(c == '"'){
                if(inQuote){
                    int next = read.read();
                    if(next == '"'){
                        currentColumn.append('"');
                    } else {
                        read.unread(next);
                        inQuote = false;
                        currentLine.add(currentColumn.toString());
                        currentColumn.setLength(0);
                    }
                } else {
                    inQuote = true;
                }
            } else if(c== ',' && !inQuote){
                // 字段结束
                currentLine.add(currentColumn.toString());
                currentColumn.setLength(0);
            } else if(c== '\n' && ! inQuote){
                currentLine.add(currentColumn.toString());
                currentColumn.setLength(0);
                rslt.add(currentLine);
                currentLine = new ArrayList<>();
            } else {
                currentColumn.append(c);
            }
        }

        if (!currentColumn.isEmpty() || !currentLine.isEmpty()) {
            currentLine.add(currentColumn.toString());
            rslt.add(currentLine);
        }

        return rslt;
    }

    public static class MenuItem{
        String id;
        Map<String, Integer> items;
        int price;

        public MenuItem(String id, Map<String, Integer> items, int price){
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

            if (!(o instanceof OrderDishes.MenuItem)) {
                return false;
            }

            OrderDishes.MenuItem p = (OrderDishes.MenuItem) o;

            return this.id.equals(p.id);
        }
    }

    List<MenuItem> bestOrder(List<MenuItem> items, List<String> order){
        int start = 0;
        Map<String, Integer> needs = new HashMap<>();
        for (String dish : order) {
            needs.merge(dish, 1, Integer::sum);
        }
        return bestOrderHelp(items, needs);
    }


    List<MenuItem> bestOrderHelp(List<MenuItem> items, Map<String, Integer> order){
        if(order.isEmpty()){
            return new ArrayList<>();
        }

        int bestPrice = Integer.MAX_VALUE;
        List<MenuItem> best = new ArrayList<>();
        for (MenuItem menuItem : items) {
            Map<String, Integer> nextNeeds = new HashMap<>();
            if(canUse(menuItem, order,  nextNeeds)){
                List<MenuItem> sub = bestOrderHelp(items, nextNeeds);
                int total = getPrice(sub) + menuItem.price;

                if (total < bestPrice) {
                    bestPrice = total;
                    best = new ArrayList<>(sub);
                    best.add(menuItem);
                }
            }
        }

        return best;
    }

    int getPrice(List<MenuItem> items){
        return items.stream().mapToInt((a) -> a.price).sum();
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











}
