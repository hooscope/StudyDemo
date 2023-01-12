package com.example.studyDemo.leetcode;

/**
 * @Author: hao wu
 * @Date： 2023/1/12 12:30
 */


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class LinkedListClass {

    public static void main(String[] args) {

    }

    /**
     * 203. 移除链表元素
     */
    private static ListNode removeElements(ListNode head, int val) {

        ListNode dummyHead = new ListNode(-1, head); //虚拟头节点
        ListNode cur = dummyHead; //定义一个新指针

        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }

        }
        return dummyHead.next;
    }

    /**
     * 206. 反转链表
     */
    private static ListNode reverseList(ListNode head) {

        //借助栈 o(n)
//        Stack<Integer> stack = new Stack<>();
//        while (head!=null){
//            stack.push(head.val);
//            head=head.next;
//        }
//        ListNode res = new ListNode();
//        ListNode cur = res;
//        while (!stack.empty()){
//            cur.next = new ListNode(stack.pop());
//            cur = cur.next;
//        }
//        return res;
//
        //双指针pre、cur o(1)
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    /**
     * 24. 两两交换链表中的节点
     */
    private static ListNode swapPairs(ListNode head) {

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode cur = dummyNode;

        while (cur.next != null && cur.next.next != null) {
            ListNode firstNode = cur.next;
            ListNode secondNode = cur.next.next;

            ListNode tmpNode = cur.next.next.next;

            cur.next = secondNode;
            secondNode.next = firstNode;
            firstNode.next = tmpNode;

            cur = firstNode;

        }

        return dummyNode.next;
    }

}


/**
 * 707. 设计链表
 */
class MyLinkedList {

    int size;
    ListNode head;

    public MyLinkedList() {
        //初始化
        this.size = 0;
        this.head = new ListNode(-1);
    }


    public int get(int index) {

        if (size <= index || index < 0) return -1;

        ListNode cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;

    }

    public void addAtHead(int val) {

        addAtIndex(0, val);

    }

    public void addAtTail(int val) {

        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {

        if (index < 0) {
            index = 0;
        }
        if (index > size) {
            return;
        }


        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        ListNode node = new ListNode(val);

        node.next = cur.next;
        cur.next = node;
        size++;


    }

    public void deleteAtIndex(int index) {

        if (index < 0 || index >= size) {
            return;
        }
        size--;
        if (index == 0) {
            head = head.next;
            return;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
    }
}
