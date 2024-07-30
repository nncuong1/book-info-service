package io.nnc.bookinfoservice.algorithm.leetcode;

public class ArrayStack {
  private int maxSize;

  private int[] stackArrays;

  private int top;

  public ArrayStack(int maxSize) {
    this.maxSize = maxSize;
    this.stackArrays = new int[maxSize];
    this.top = -1;
  }

  public boolean push(int element) {
    if (top == maxSize - 1) {
      throw new RuntimeException("Stack is full");
    } else {
      stackArrays[++top] = element;
    }

    return true;
  }

  public int pop() {
    if (top == -1) {
      throw new RuntimeException("Stack is empty");
    } else {
      return stackArrays[top--];
    }
  }

  public int peek() {
    if (top == -1) {
      throw new RuntimeException("Stack is empty");
    } else {
      return stackArrays[top];
    }
  }

  public boolean isEmpty() {
    return top < 0;
  }
}
