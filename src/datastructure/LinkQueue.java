package datastructure;

import javax.sound.midi.Soundbank;

/**
 * 队列链式存储
 */
public class LinkQueue<T> extends LinkStorage<T>{
    private ListNode rear;
    public LinkQueue(){
        super();
        rear = getHead();
    }

    public LinkQueue(T[] array){
        super();
        rear = getHead();
        ListNode nodeOld = rear;
        for (T obj: array){
            var nodeNew = new ListNode<T>(obj);
            nodeOld.next = nodeNew;
            nodeOld = nodeNew;
        }
        rear = nodeOld;
    }

    public ListNode getRear() {
        return rear;
    }

    @Override
    public ListNode get(int i) {
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
                return i;
            } else{
                nodeTemp = nodeTemp.next;
            }
        }
        return -1;
    }

    @Override
    public boolean insert(T val) {
        ListNode nodeNew = new ListNode<T>(val);
        rear.next = nodeNew;
        rear = nodeNew;
        return true;
    }

    @Override
    public ListNode delete() {
        ListNode head = getHead();
        var nodeResult = head.next;
        if (nodeResult == null){
            System.out.println("堆栈空");
            return null;
        } else if (nodeResult == rear){
            rear = head;
        }
        head.next = nodeResult.next;
        return nodeResult;
    }

    @Override
    public int length() {
        ListNode nodeTemp = getHead();
        var length = 0;
        while (nodeTemp != null){
            length++;
            nodeTemp = nodeTemp.next;
        }
        return length;
    }

    public boolean isEmpty(){
        return getHead() == rear;
    }

    public String toString(){
        var result = new StringBuilder();
        var nodeTemp = getHead();
        result.append("start");
        nodeTemp = nodeTemp.next;
        while (nodeTemp != null){
            result.append(" -> ").append(nodeTemp.toString());
            nodeTemp = nodeTemp.next;
        }
        return result.toString();
    }
}

//class LinkQueueTest{
//    public static void main(String[] args) {
//        var linkQueue1 = new LinkQueue<Integer>();
//        var linkQueue2 = new LinkQueue<Integer>(new Integer[]{1,2,3});
//        System.out.println(linkQueue1);
//        System.out.println(linkQueue2);
//        System.out.println(linkQueue1.getRear());
//        System.out.println(linkQueue2.getRear());
//        System.out.println(linkQueue1.insert(1));
//        System.out.println(linkQueue1);
//        System.out.println(linkQueue1.length());
//        System.out.println(linkQueue1.getRear());
//        System.out.println(linkQueue2.delete());
//        System.out.println(linkQueue2.delete());
//        System.out.println(linkQueue2);
//        System.out.println(linkQueue2.delete());
//        System.out.println(linkQueue2.delete());
//        System.out.println(linkQueue2.delete());
//        System.out.println(linkQueue2.isEmpty());
//        System.out.println(linkQueue2.insert(1));
//        System.out.println(linkQueue2.isEmpty());
//        System.out.println(linkQueue2.length());
//        System.out.println(linkQueue2.getRear());
//        System.out.println(linkQueue2);
//    }
//}
