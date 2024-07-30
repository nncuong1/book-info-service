package io.nnc.bookinfoservice.algorithm.leetcode;

public class LinkedListStack {
  private Node top;

  public boolean push(int data) {
    Node newNode = new Node(data);

    if (top == null) {
      top = newNode;
    } else {
      Node temp = top;
      top = newNode;
      newNode.next = temp;
    }

    return true;
  }

  public int pop() {
    if (top == null) {
      throw new RuntimeException("Stack is empty");
    } else {
      int data = top.data;
      top = top.next;
      return data;
    }
  }

  public boolean isEmpty() {
    return top == null;
  }

  public int peek() {
    if (top == null) {
      throw new RuntimeException("Stack is empty");
    } else {
      return top.data;
    }
  }

  static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
    }
  }
}
