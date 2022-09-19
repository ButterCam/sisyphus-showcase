package com.google.showcase.v1beta1.interview

import java.util.function.Consumer

interface LinkedListNode<T> {
    val next: LinkedListNode<T>?

    val prev: LinkedListNode<T>?

    val value: T
}

interface LinkedList<T> {
    val root: LinkedListNode<T>?

    fun size(): Int

    fun foreach(block: Consumer<T>)

    fun addLast(value: T)

    fun addFirst(value: T)

    fun removeLast(): T?

    fun removeFirst(): T?
}