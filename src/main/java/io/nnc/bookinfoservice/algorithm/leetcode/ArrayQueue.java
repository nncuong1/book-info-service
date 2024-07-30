package io.nnc.bookinfoservice.algorithm.leetcode;

public class ArrayQueue {
  private int[] arrayQueue;
  private int rear;

  private int front;

  private int maxSize;

  public ArrayQueue(int maxSize) {
    this.maxSize = maxSize;
    this.arrayQueue = new int[maxSize];
    this.rear = -1;
    this.front = 0;
  }

  public boolean enqueue(int data) {
    if (rear == maxSize - 1) {
      throw new RuntimeException("Queue is full");
    } else {
      arrayQueue[++rear] = data;
    }

    return true;
  }

  public int dequeue() {
    if (front > rear) {
      throw new RuntimeException("Queue is empty");
    }
    int data = arrayQueue[front];
    for (int i = 0; i < rear; i++) {
      arrayQueue[i] = arrayQueue[i + 1];
    }
    rear--;
    return data;
  }

  void display() {
    if (front > rear) {
      System.out.println("Queue is Empty");
      return;
    }

    // Traverse front to rear and print elements
    for (int i = front; i <= rear; i++) {
      System.out.print(arrayQueue[i] + " <-- ");
    }
    System.out.println();
  }
}
