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

    /**
     * 19. 删除链表的倒数第 N 个结点
     * 快慢指针
     */
    private static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode slowNode = dummyNode;
        ListNode fastNode = dummyNode;
        for (int i = 0; i < n; i++) {
            fastNode = fastNode.next;
        }
        while (fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        slowNode.next = slowNode.next.next;
        return dummyNode.next;
    }

    /**
     * 面试题 02.07. 链表相交
     */
    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode curA = headA;
        ListNode curB = headB;

        int lenA = 0, lenB = 0;
        while (curA != null) {
            curA = curA.next;
            lenA++;
        }
        while (curB != null) {
            curB = curB.next;
            lenB++;
        }

        //初始化指针，指向链表头部
        curA = headA;
        curB = headB;
        //若A链表比B链表短，两者对调，使A比B长
        if (lenA < lenB) {
            int tmp = lenA;
            lenA = lenB;
            lenB = tmp;

            ListNode tmpNode = curA;
            curA = curB;
            curB = tmpNode;
        }

        int gapLen = lenA - lenB;
        while (gapLen-- > 0) curA = curA.next;

        //此时curA,curB指向的节点长度一致
        while (curA != null) {
            if (curA == curB) return curA;  //注：因为要求地址相等，所以不能用curA.val==curB.val判断
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }

    /**
     * 142. 环形链表 II
     * 快慢指针，快比慢多走1步
     */
    private static ListNode detectCycle(ListNode head) {

        ListNode slowNode = head, fastNode = head;
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if (slowNode == fastNode) {
                ListNode index1 = fastNode;
                ListNode index2 = head;
                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
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
