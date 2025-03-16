import entity.NestedInteger;


import java.util.List;
import java.util.Stack;

public class NestedIterator{

    public void NestedIterator2(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }
    private Stack<NestedInteger> stack;


    public boolean hasNext2() {
        while (!stack.isEmpty()) {
            NestedInteger top = stack.peek();
            if (top.isInteger()) {
                return true;
            } else {
                stack.pop();
                List<NestedInteger> list = top.getList();
                if(list != null){
                    for (int i = list.size() - 1; i >= 0; i--) {
                        stack.push(list.get(i));
                    }
                }
            }
        }
        return false;
    }

    public Integer next2() {
        if (!hasNext2()) {
            return null; // 或者抛出异常
        }
        return stack.pop().getInteger();
    }
}
