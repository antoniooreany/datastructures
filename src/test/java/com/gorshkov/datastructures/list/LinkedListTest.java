package com.gorshkov.datastructures.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest<V> extends ListTest<V> {

    @Override
    List getList() {return new LinkedList<>();}

}