package io.nnc.bookinfoservice.algorithm.leetcode;

public class MergeTwoSortedList {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode();
    ListNode cur = dummy;

    while (list1 != null && list2 != null) {
      if (list1.val <= list2.val) {
        cur.next = list1;
        list1 = list1.next;
      } else {
        cur.next = list2;
        list2 = list2.next;
      }
      cur = cur.next;
    }

    if (list1 != null) {
      cur.next = list1;
    }

    if (list2 != null) {
      cur.next = list2;
    }

    return dummy.next;
  }

  static class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ;

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(2);
    l1.next.next = new ListNode(4);

    ListNode l2 = new ListNode(1);
    l2.next = new ListNode(3);
    l2.next.next = new ListNode(4);

    MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();
    ListNode rs = mergeTwoSortedList.mergeTwoLists(l1, l2);

    while (rs.next != null) {
      System.out.println(rs.val);
      rs = rs.next;
    }
  }
}
