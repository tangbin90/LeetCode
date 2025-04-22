package labula;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {
    List<Integer> nextGreaterElement(List<Integer> nums){
        List<Integer> reslt = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=nums.size(); i>=0; i--){
            while(!stack.empty() && stack.peek() <= nums.get(i))
                stack.pop();
            reslt.add(stack.isEmpty()? -1 : stack.peek());
            stack.push(nums.get(i));
        }

        return reslt;

    }
}
