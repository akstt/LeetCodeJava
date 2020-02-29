package LeetCode.question1to50;

import datastructure.ListNode;

public class Q19RemoveNthNodeFromEndOfList {
    /**
     * 先找到正数第n个，让nodeTemp2指向尾节点，删除nodeTemp1后一个即可
     * @param head 输入链表
     * @param n 删除倒数第几个
     * @return 结果链表
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // ListNode<Integer> nodeHead = new ListNode<>(0);
        ListNode nodeHead = new ListNode(0);

        nodeHead.next = head;
        ListNode nodeTemp1, nodeTemp2;
        nodeTemp1 = nodeHead;
        nodeTemp2 = nodeHead.next;
        while (nodeTemp2.next != null && n > 1){
            nodeTemp2 = nodeTemp2.next;
            n--;
        }
        if (n != 1){
            // 链表不够长
        }
        while (nodeTemp2.next != null){
            nodeTemp1 = nodeTemp1.next;
            nodeTemp2 = nodeTemp2.next;
        }
        nodeTemp1.next = nodeTemp1.next.next;
        return nodeHead.next;
    }

    public static void main(String[] args) {
        var a = new int[]{1, 2, 3 ,4 ,5};
        ListNode<Integer> nodeTemp = null;
        for (int i = a.length-1; i >=0; i--){
            var node = new ListNode<Integer>(a[i], nodeTemp);
            nodeTemp = node;
        }
        var x = new Q19RemoveNthNodeFromEndOfList();
        var node = x.removeNthFromEnd(nodeTemp, 2);
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
