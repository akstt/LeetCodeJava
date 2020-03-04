package LeetCode.question51to100;

import datastructure.ListNode;

public class Q61RotateList {

    // 找到最后一个结点，和第前k % length（链表长度）个结点，调整一下结点顺序就好
    public ListNode rotateRight(ListNode head, int k) {
        int length = 0;
        ListNode nodeTemp1 = head;
        while (nodeTemp1 != null){
            nodeTemp1 = nodeTemp1.next;
            length += 1;
        }
        if (length == 0){
            return head;
        }
        int kNew = k % length;
        if (kNew == 0){
            return head;
        }

        nodeTemp1 = head;
        ListNode nodeTemp2 = head;
        for (int i = 0; i < kNew; i++){
            nodeTemp2 = nodeTemp2.next;
        }

        while (nodeTemp2.next != null){
            nodeTemp1 = nodeTemp1.next;
            nodeTemp2 = nodeTemp2.next;
        }

        // 调整链表顺序
        ListNode headNew = nodeTemp1.next;
        nodeTemp1.next = null;
        nodeTemp2.next = head;
        return headNew;
    }
}
