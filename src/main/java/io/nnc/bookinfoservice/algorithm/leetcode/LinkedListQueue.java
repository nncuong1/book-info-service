package io.nnc.bookinfoservice.algorithm.leetcode;

public class LinkedListQueue {
  private Node front;
  private Node rear;

  static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
    }
  }

  public boolean enqueue(int data) {
    Node newNode = new Node(data);
    if (this.rear == null) {
      this.front = this.rear = newNode;
    } else {
      this.rear.next = newNode;
      this.rear = newNode;
    }

    return true;
  }

  public int dequeue() {
    if (this.front == null) {
      throw new RuntimeException("Queue is empty");
    }
    int data = this.front.data;
    this.front = this.front.next;
    if (this.front == null) {
      this.rear = null;
    }
    return data;
  }

  public void display() {
    Node data = this.front;
    while (data != null) {
      System.out.println(data.data);
      data = data.next;
    }
  }
}
