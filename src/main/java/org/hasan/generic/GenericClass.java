package org.hasan.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericClass<T> {
    private List<T> myList;

    public void add(T value) {
        myList.add(value);
    }

    public GenericClass() {
        myList = new ArrayList<>();
    }

    public List<T> getList() {
        return this.myList;
    }
}
