package entity;

import java.util.List;

public interface NestedInteger {
    // 如果此 NestedInteger 保存一个整数，则返回 true；否则返回 false
    boolean isInteger();

    // 如果此 NestedInteger 保存一个整数，则返回该整数；否则返回未定义的行为
    Integer getInteger();

    // 如果此 NestedInteger 保存一个列表，则返回该列表；否则返回未定义的行为
    List<NestedInteger> getList();
}

