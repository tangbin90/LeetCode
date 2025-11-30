package bnb;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;

public class RewardPoints {


// Maximize Reward Points

// Question Description
// An employee is given a list of N tasks. A deadline is associated with each task and some reward points are allotted to the employee if the corresponding tasks are completed within the deadline. Every task takes one unit of time to get completed and only one task can be done at a time.
// The minimum possible deadline for any task is 1. Write a program to determine the order of task execution to maximize the total rewards points for the employee.

// Question Prompt

// Input: {task_id, deadline, reward_points} list: {{ 'a', 2, 80 }, { 'b', 1, 19 }, { 'c', 2, 27 }, { 'd', 3, 15 }}

// Output:
// Tasks completion order: a c d
// Maximum reward points: 122


    public static class Solution {
        //sort(list, deadline, reward)
        //dp[i] = Math.max(dp[i - 1], dp[i-1] + list[i])
        // dp[i]  = 123
        // deadline = 4
        // PriorityQueye<> tasks: rewoard
        // capacity = deadline
        public static class Task {
            String id;
            int deadLine;
            int reward;
            public Task(String id, int deadLine, int reward){
                this.id = id;
                this.deadLine = deadLine;
                this.reward = reward;
            }

            @Override
            public int hashCode(){
                int rslt =17;
                rslt += id.hashCode() * 37;
                return rslt;
            }

            @Override
            public boolean equals(Object o){
                if(this == o) return true;
                if(o == null)  return false;

                if(! (o instanceof Task)) return false;

                Task p = (Task) o;
                return p.id.equals(this.id);
            }

        }


        LinkedHashSet<Task> hahsSet = new LinkedHashSet<>();

        public int maximizeRewardPoints(Task[] tasks){
            if(tasks.length == 0)
                return 0;

            int reward = 0;
            PriorityQueue<Task> queue = new PriorityQueue<Task>((a, b) -> a.reward - b.reward);
            Arrays.sort(tasks, (a, b) -> a.deadLine - b.deadLine);
            int len = tasks.length;
            int capacity = tasks[0].deadLine;
            queue.add(tasks[0]);

            for(int i=1; i < len; i++){
                Task curr = tasks[i];
                capacity = curr.deadLine;
                if(queue.size() < capacity){

                    queue.add(tasks[i]);
                } else {
                    if(queue.peek().reward < curr.reward){
                        queue.poll();
                        queue.add(curr);
                    } else {
                        continue;
                    }
                }
            }

            while(!queue.isEmpty()){
                Task tmp = queue.poll();
                reward += tmp.reward;
            }

            return reward;

        }
        public static void main(String[] args) {
            Solution solution = new Solution();
// Input: {task_id, deadline, reward_points} list: {{ 'a', 2, 80 }, { 'b', 1, 19 }, { 'c', 2, 27 }, { 'd', 3, 15 }}

            // Solution.Task task1 = new Task("a", 2, 80);
            // Solution.Task task2 = new Task("b", 1, 19);
            // Solution.Task task3 = new Task("c", 2, 27);
            // Solution.Task task4 = new Task("d", 3, 15);
            // {{ 'a', 1, 40 }, { 'b', 2, 10 }, { 'c', 3, 30 }, { 'd', 3, 20}}
            Solution.Task task1 = new Task("a", 1, 40);
            Solution.Task task2 = new Task("b", 2, 10);
            Solution.Task task3 = new Task("c", 3, 30);
            Solution.Task task4 = new Task("d", 3, 20);

            Solution.Task[] tasks = {task1, task2, task3, task4};

            int reward = solution.maximizeRewardPoints(tasks);
            // System.out.println("reward(122): " + reward);
            System.out.println("reward(90): " + reward);


        }
    }

// Test case 1
// {{ 'a', 2, 80 }, { 'b', 1, 19 }, { 'c', 2, 27 }, { 'd', 3, 15 }, {'e', 1, 20}}
// Tasks completion order: a c d
// Maximum reward points: 122
// or,
// Tasks completion order: c a d
// Maximum reward points: 122
// Test case 2
// {{ 'a', 2, 80 }, { 'b', 1, 19 }, { 'c', 1, 27 }, { 'd', 1, 15 }}
// Tasks completion order: c a
// Maximum reward points: 107
// Test case 3
// {{ 'a', 2, 80 }, { 'b', 1, 27 }, { 'c', 1, 27 }}
// Tasks completion order: c a
// Maximum reward points: 107
// Solution.Task task1 = new Task("a", 2, 80);
// Solution.Task task2 = new Task("b", 1, 27);
// Solution.Task task3 = new Task("c", 1, 27);
// or,
// Tasks completion order: b a
// Maximum reward points: 107
// Test case 4
// {{ 'a', 1, 40 }, { 'b', 2, 10 }, { 'c', 3, 30 }, { 'd', 3, 20}}
// Tasks completion order: a c d
// Maximum reward points: 90


}
