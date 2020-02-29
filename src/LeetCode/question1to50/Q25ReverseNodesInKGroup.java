package LeetCode.question1to50;

import datastructure.ListNode;

public class Q25ReverseNodesInKGroup {
    /**
     *
     * @param head 需要翻转链表
     * @param k 每k个结点翻转一次
     * @return 翻转后的链表
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode nodeHead = new ListNode(0);
        ListNode nodeTemp1, nodeTemp2;
        // k 个一组，储存需要翻转的结点
        ListNode[] nodeList = new ListNode[k];
        nodeHead.next = head;
        nodeTemp1 = nodeHead;
        nodeTemp2 = head;
        int index1 = 0;
        // 遍历链表
        while (nodeTemp2!=null){
            nodeList[index1] = nodeTemp2;
            nodeTemp2 = nodeTemp2.next;
            if (index1<k-1){
                index1 ++;
            }else{
                for (; index1 >=0; index1 --){
                    nodeTemp1.next = nodeList[index1];
                    nodeTemp1 = nodeTemp1.next;
                }
                index1 ++;
                nodeTemp1.next = nodeTemp2;
            }
        }
        return nodeHead.next;
    }

    public static void main(String[] args) {
        var a = new int[]{1, 2, 4 ,5, 6};
        ListNode<Integer> nodeTemp1 = null;
        for (int i = a.length-1; i >=0; i--){
            var node = new ListNode<Integer>(a[i], nodeTemp1);
            nodeTemp1 = node;
        }
        var x = new Q25ReverseNodesInKGroup();
        var node = x.reverseKGroup(nodeTemp1, 2);
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
