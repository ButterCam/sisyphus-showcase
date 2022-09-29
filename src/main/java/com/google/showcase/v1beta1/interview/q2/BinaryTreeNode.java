package com.google.showcase.v1beta1.interview.q2;

public class BinaryTreeNode<T> {
    private final T value;
    private BinaryTreeNode<T> parent = null;
    private BinaryTreeNode<T> left = null;
    private BinaryTreeNode<T> right = null;

    private BinaryTreeNode(BinaryTreeNode<T> parent, T value) {
        this.parent = parent;
        this.value = value;
    }

    BinaryTreeNode(T value) {
        this.value = value;
    }

    public T value() {
        return value;
    }

    public BinaryTreeNode<T> parent() {
        return parent;
    }

    public BinaryTreeNode<T> left() {
        return left;
    }

    public BinaryTreeNode<T> right() {
        return right;
    }

    public void replaceLeft(BinaryTreeNode<T> left) {
        this.left = left;
        left.parent = this;
    }

    public void replaceRight(BinaryTreeNode<T> right) {
        this.right = right;
        left.parent = this;
    }

    public void setLeft(T value) {
        this.left = new BinaryTreeNode<>(this, value);
    }

    public void setRight(T value) {
        this.right = new BinaryTreeNode<>(this, value);
    }
}
