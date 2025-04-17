package leetcodesolutions;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 *
 *
 */

import java.util.*;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
public class NO155MinStack {
    private Stack<Integer> miniStack;
    // 这里需要使用LinkedList，因为在pop时需要删除最后一个元素
    // 如果使用ArrayList，删除最后一个元素的时间复杂度为O(n)
    // 但是LinkedList删除最后一个元素的时间复杂度为O(1)

    private LinkedList<Integer> minList;

    private Integer min;
    public NO155MinStack() {
        miniStack = new Stack<>();
        min = null;
        minList = new LinkedList<>();
    }

    public void push(int val) {
        miniStack.push(val);
        if(min == null)
            min = val;
        else if(min > val)
            min = val;
        minList.add(min);
    }

    public void pop() {
        miniStack.pop();
        minList.removeLast();
        if(!minList.isEmpty())
            min = minList.getLast();
        else
            min = null;
    }

    public int top() {
        return miniStack.peek();
    }

    public int getMin() {
        return  minList.getLast();
    }

}
