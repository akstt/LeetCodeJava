package datastructure;

/**
 * 节点类
 */
public class ListNode<T> {
    public T val;
    public ListNode next;

    public ListNode(){}

    public ListNode(T val){
        this.val = val;
    }

    public ListNode(T val, ListNode next){
        this.val = val;
        this.next = next;
    }

    public String toString(){
        return "val: " + this.val;
    }


    public String toString1(){
        var result = new StringBuilder();
        result.append(val);
        var nodeTemp = next;
        while (nodeTemp != null){
            result.append(" -> ").append(nodeTemp.val);
            nodeTemp = nodeTemp.next;
        }
        return result.toString();
    }
}
