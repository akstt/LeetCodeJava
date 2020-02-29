package LeetCode.question1to50;

import datastructure.ListNode;

public class Q21MergeTwoSortedLists {
    /**
     * 逐个比较两个链表的结点，将较小的接在结果的node后
     * @param l1 排序链表1
     * @param l2 排序链表2
     * @return 合并的排序链表
     */
    public ListNode mergeTwoLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode nodeHead = new ListNode(1);
        ListNode nodeTemp = nodeHead;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                nodeTemp.next = l1;
                nodeTemp = l1;
                l1 = l1.next;
            }else{
                nodeTemp.next = l2;
                nodeTemp = l2;
                l2 = l2.next;
            }
        }
        if (l1 != null){
            nodeTemp.next = l1;
        }else if(l2 != null){
            nodeTemp.next = l2;
        }
        return nodeHead.next;
    }
    public static void main(String[] args) {
        var a = new int[]{1, 2, 4 ,5};
        ListNode<Integer> nodeTemp1 = null;
        for (int i = a.length-1; i >=0; i--){
            var node = new ListNode<Integer>(a[i], nodeTemp1);
            nodeTemp1 = node;
        }
        var b = new int[]{1, 2, 5, 6};
        ListNode<Integer> nodeTemp2 = null;
        for (int i = b.length-1; i >=0; i--){
            var node = new ListNode<Integer>(b[i], nodeTemp2);
            nodeTemp2 = node;
        }
        var x = new Q21MergeTwoSortedLists();
        var node = x.mergeTwoLists(nodeTemp1, nodeTemp2);
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
