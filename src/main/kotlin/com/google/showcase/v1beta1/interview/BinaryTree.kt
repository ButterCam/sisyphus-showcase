package com.google.showcase.v1beta1.interview

class BinaryTreeNode<T>(val parent: BinaryTreeNode<T>?, val value: T) {
    var left: BinaryTreeNode<T>? = null

    var right: BinaryTreeNode<T>? = null
}