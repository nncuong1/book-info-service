package io.nnc.bookinfoservice.algorithm;

import io.nnc.bookinfoservice.algorithm.sort.*;
import org.aspectj.apache.bcel.generic.MethodGen;

import java.util.*;

public class SortTest {
  public static void main(String[] args) {
    int[] arr = {64, 34, 25, 12, 22, 11, 90};

    Sort bubbleSort = new BubbleSort();
    bubbleSort.sort(arr);

    System.out.println(Arrays.toString(arr));

    System.out.println("============================");

    int[] arr2 = {64, 34, 25, 12, 22, 11, 90};
    Sort quickSort = new QuickSort();
    quickSort.sort(arr2);

    System.out.println(Arrays.toString(arr2));

    System.out.println("============================");

    int[] arr3 = {64, 34, 25, 12, 22, 11, 90};
    Sort insertionSort = new InsertionSort();
    insertionSort.sort(arr3);

    System.out.println(Arrays.toString(arr3));

    System.out.println("============================");

    int[] arr4 = {64, 34, 25, 12, 22, 11, 90};
    Sort mergeSorted = new MergeSort();
    mergeSorted.sort(arr4);

    System.out.println(Arrays.toString(arr4));

  }
}
