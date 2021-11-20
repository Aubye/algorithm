package com.app.algorithm.base.data.structures.link;

import lombok.Data;

@Data
public class LinkedNode<T> {

    private T data;

    private LinkedNode<T> next;

    public LinkedNode() {
    }

    public LinkedNode(T data, LinkedNode<T> next) {
        this.data = data;
        this.next = next;
    }

}
