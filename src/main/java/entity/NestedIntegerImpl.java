package entity;

import java.util.ArrayList;
import java.util.List;

public class NestedIntegerImpl implements NestedInteger {

    private Integer integer;
    private List<NestedInteger> list;

    public NestedIntegerImpl(Integer integer) {
        this.integer = integer;
        this.list = null;
    }

    public NestedIntegerImpl(List<NestedInteger> list) {
        this.integer = null;
        this.list = list;
    }

    @Override
    public boolean isInteger() {
        return integer != null;
    }

    @Override
    public Integer getInteger() {
        return integer;
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }

    // 添加一个方法，能够给列表添加元素。
    public void add(NestedInteger nestedInteger){
        if (this.list == null){
            this.list = new ArrayList<>();
        }
        this.list.add(nestedInteger);
    }
}
