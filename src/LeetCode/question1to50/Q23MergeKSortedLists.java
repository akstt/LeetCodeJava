package LeetCode.question1to50;

import datastructure.ListNode;

import java.util.Arrays;

public class Q23MergeKSortedLists {
    /**
     * @param lists 结点列表
     * @return 合并结点
     */
    public ListNode mergeKLists(ListNode<Integer>[] lists) {
        int startIndex = 0;
        for(int i = 0; i < lists.length; i++){
            if (lists[i] == null){
                lists[i] = lists[startIndex];
                lists[startIndex++] = null;
            }
        }
        if (startIndex == lists.length){
            return null;
        }
        Arrays.sort(lists, this::compare );
        ListNode nodeHead = new ListNode(1);
        ListNode nodeTemp = nodeHead;

        while (startIndex < lists.length){
            nodeTemp.next = lists[startIndex];
            nodeTemp = nodeTemp.next;
            if (nodeTemp.next == null){
                startIndex ++;
            }else{
                lists[startIndex] = nodeTemp.next;
                for(int i = startIndex + 1; i < lists.length; i++){
                    if (lists[i-1].val > lists[i].val){
                        lists[i-1] = lists[i];
                        lists[i] = nodeTemp.next;
                    }else{
                        break;
                    }
                }

            }

        }
        return nodeHead.next;


    }
    public int compare(ListNode<Integer> n1, ListNode<Integer> n2){
        if (n1 == null){
            return -1;
        }
        if (n2 == null){
            return 1;
        }
        return n1.val==n2.val ? 0: n1.val > n2.val ? 1:-1;
    }

    public static void main(String[] args) {
        ListNode[] a = new ListNode[3];
        a[0] = new ListNode(1);
        a[1] = new ListNode(3);
        a[2] = new ListNode(2);
        var x = new Q23MergeKSortedLists();
        x.mergeKLists(a);
    }


}
