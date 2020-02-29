package datastructure;

/**
 *线性表链式存储
 */
public class LinkList<T> extends LinkStorage<T> {

    public LinkList(){
        super();
    }

    public LinkList(T val){
        super(val);
    }

    public LinkList(T[] array){
        super(array);
    }

    public LinkList(T[] array, T val){
        super(array, val);
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
        return insert(1, val);
    }

    public boolean insert(int i,T val){
        if (i<1){
            System.out.println("索引错误");
            return false;
        }
        ListNode node1 = get(i-1);
        if (node1 == null){
            return false;
        }
        ListNode nodeNew = new ListNode<T>(val);
        nodeNew.next = node1.next;
        node1.next = nodeNew;
        return true;
    }
    @Override
    public ListNode delete() {
        return delete(1);
    }

    public ListNode delete(int i) {
        if (i<1){
            System.out.println("索引错误");
            return null;
        }
        ListNode nodeTemp = get(i-1);
        if (nodeTemp  == null || nodeTemp.next == null){
            System.out.println("索引错误");
            return null;
        }
        var nodeResult = nodeTemp.next;
        nodeTemp.next = nodeResult.next;
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

    public String toString(){
        var result = new StringBuilder();
        var nodeTemp = getHead();
        result.append("head: ").append(nodeTemp.val);
        nodeTemp = nodeTemp.next;
        while (nodeTemp != null){
            result.append(" -> ").append(nodeTemp.toString());
            nodeTemp = nodeTemp.next;
        }
        return result.toString();
    }
}

//class LinkListTest{
//    public static void main(String[] args) {
//        var linkList1 = new LinkList<Integer>();
//        var linkList2 = new LinkList<Integer>(10);
//        var linkList3 = new LinkList<Integer>(new Integer[]{1,2,3,4});
//        var linkList4 = new LinkList<Integer>(new Integer[]{1,2,3,4}, 10);
//        System.out.println(linkList1);
//        System.out.println(linkList2);
//        System.out.println(linkList3);
//        System.out.println(linkList4);
//        System.out.println(linkList3.get(2));
//        System.out.println(linkList3.get(0));
//        linkList3.insert(12);
//        System.out.println(linkList3);
//        linkList3.insert(0,13);
//        linkList3.insert(10,13);
//        linkList3.insert(6,14);
//        System.out.println(linkList3);
//        linkList3.delete(1);
//        System.out.println(linkList3);
//        linkList3.delete(0);
//        linkList3.delete(6);
//        linkList3.delete(5);
//        System.out.println(linkList3);
//        System.out.println(linkList3.length());
//        System.out.println(linkList3.find(4));
//        System.out.println(linkList3.find(1));
//
//    }
//}
