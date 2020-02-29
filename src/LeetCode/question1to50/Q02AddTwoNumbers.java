package LeetCode.question1to50;
import datastructure.*;
public class Q02AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        // nodeTemp为进位数字，因为只有两个数字相加，所以为0或1
        ListNode nodeTemp = head;
        addNumber(nodeTemp, l1, l2, 0);
        return head.next;
    }

    // 递归的主体部分
    public boolean addNumber(ListNode nodeTemp, ListNode l1, ListNode l2, int numTemp){
        // 如果l1或l2不为null，则将nodeTemp分别加上他们的值，并转到下个结点
        if (l1 != null || l2 != null){
            if (l1 != null){
                numTemp += (int) l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                numTemp += (int) l2.val;
                l2 = l2.next;
            }
            ListNode nodeNew;
            // 相加结果是否大于10
            if (numTemp >= 10){
                nodeNew = new ListNode(numTemp - 10);
                numTemp = 1;
            }else{
                nodeNew = new ListNode(numTemp);
                numTemp = 0;
            }
            nodeTemp.next = nodeNew;
            nodeTemp = nodeNew;
            return addNumber(nodeTemp, l1, l2, numTemp);
        }else{
            // 当两个链表都遍历一遍之后
            if (numTemp==1){
                ListNode nodeNew = new ListNode(numTemp);
                nodeTemp.next = nodeNew;
            }
            return true;
        }

    }

    public static void main(String[] args) {
        var linkList1 = new LinkList<Integer>(new Integer[]{2, 4, 3});
        var linkList2 = new LinkList<Integer>(new Integer[]{5, 6, 7});
        var addTwoNumber = new Q02AddTwoNumbers();
        ListNode linkList3 = addTwoNumber.addTwoNumbers(linkList1.get(1), linkList2.get(1));
        System.out.println(linkList3.toString1());

    }

}
