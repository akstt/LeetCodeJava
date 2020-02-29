package datastructure;

import java.lang.reflect.Array;
import java.util.Arrays;
/**
 * 堆栈链式存储
 */
public class LinkStack<T> extends LinkStorage<T> {
    private int length;
    public LinkStack(){
        super();
    }

    public LinkStack(T[] array){
        ListNode nodeOld = getHead();
        length = array.length;
        for (var i = length-1; i >=0; i--){
            var nodeNew = new ListNode<T>(array[i]);
            nodeOld.next = nodeNew;
            nodeOld = nodeNew;
        }
    }

    @Override
    public ListNode get(int i) {
        i = length - i;
        ListNode nodeTemp = getHead();
        for (var j = 0; j<i && nodeTemp != null; j++){
            nodeTemp = nodeTemp.next;
        }
        if (nodeTemp == null){
            System.out.println("索引错误");
        }
        return nodeTemp;
    }

    @Override
    public int find(T val) {
        ListNode nodeTemp = getHead();
        for (var i = 0; nodeTemp != null; i++){
            if (nodeTemp.val == val){
                return length - i;
            } else{
                nodeTemp = nodeTemp.next;
            }
        }
        return -1;
    }

    @Override
    public boolean insert(T val) {
        ListNode head = getHead();
        ListNode nodeNew = new ListNode<T>(val);
        nodeNew.next = head.next;
        head.next = nodeNew;
        length++;
        return true;
    }

    @Override
    public ListNode delete() {
        ListNode head = getHead();
        var nodeResult = head.next;
        if (nodeResult == null){
            System.out.println("堆栈空");
            return null;
        }
        length--;
        head.next = nodeResult.next;
        return nodeResult;
    }

    @Override
    public int length() {
//        ListNode nodeTemp = getHead();
//        var length = 0;
//        while (nodeTemp != null){
//            length++;
//            nodeTemp = nodeTemp.next;
//        }
        return length;
    }

    public String toString(){
        var result = new StringBuilder();
        var nodeTemp = getHead();
        result.append("end");
        nodeTemp = nodeTemp.next;
        while (nodeTemp != null){
            result.append(" <- ").append(nodeTemp.toString());
            nodeTemp = nodeTemp.next;
        }
        return result.toString();
    }
}

//class LinkStackTest{
//    public static void main(String[] args) {
//        var linkStack1 = new LinkStack<Integer>();
//        var linkStack2 = new LinkStack<Integer>(new Integer[]{1,2,3,4});
//        System.out.println(linkStack1);
//        System.out.println(linkStack2);
//        System.out.println(linkStack2.length());
//        linkStack2.insert(5);
//
//        System.out.println(linkStack2);
//        System.out.println(linkStack2.length());
//        System.out.println(linkStack2.get(2));
//        System.out.println(linkStack2.delete());
//        System.out.println(linkStack2.find(4));
//        System.out.println(linkStack2);
//        System.out.println(linkStack2.length());
//    }
//}