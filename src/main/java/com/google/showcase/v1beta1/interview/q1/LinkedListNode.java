package com.google.showcase.v1beta1.interview.q1;

interface LinkedListNode<T> {
    LinkedListNode<T> next();

    LinkedListNode<T> prev();

    T value();
}