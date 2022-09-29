package com.google.showcase.v1beta1.interview.q1;

import java.util.function.Consumer;

interface LinkedList<T> {
    LinkedListNode<T> head();

    int size();

    void foreach(Consumer<T> block);

    void addLast(T value);

    void addFirst(T value);

    T removeLast();

    T removeFirst();
}