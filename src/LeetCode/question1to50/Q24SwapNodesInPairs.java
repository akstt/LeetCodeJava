package LeetCode.question1to50;

import datastructure.ListNode;

public class Q24SwapNodesInPairs {
    /**
     * @param head 要求翻转的链表
     * @return 翻转后的链表
     */
    public ListNode swapPairs(ListNode head) {
        ListNode nodeHead = new ListNode(1);
        nodeHead.next = head;
        ListNode nodeTemp1, nodeTemp2;
        nodeTemp1 = nodeHead;
        nodeTemp2 = head;
        while (nodeTemp2!=null && nodeTemp2.next!=null){
            nodeTemp1.next = nodeTemp2.next;
            nodeTemp2.next = nodeTemp2.next.next;
            nodeTemp1.next.next = nodeTemp2;

            nodeTemp1 = nodeTemp2;
            nodeTemp2 = nodeTemp2.next;
        }
    return nodeHead.next;
    }
}
