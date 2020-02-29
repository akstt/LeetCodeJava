package datastructure;

/**
 * 链式存储抽象类
 */
abstract class LinkStorage<T>{
    private ListNode head;

    public LinkStorage(){
        head = new ListNode<T>();
    }

    public LinkStorage(T val){
        head = new ListNode<T>(val);
    }

    public LinkStorage(T[] array){
        this();
        insertArray(array);
    }
    public LinkStorage(T[] array, T val){
        this(val);
        insertArray(array);
    }

    public void insertArray(T[] array){
        ListNode nodeOld = head;
        while(nodeOld.next != null){
            nodeOld =nodeOld.next;
        }
        for (T obj: array){
            var nodeNew = new ListNode<T>(obj);
            nodeOld.next = nodeNew;
            nodeOld = nodeNew;
        }
    }

    public ListNode getHead() {
        return head;
    }


    // 根据位序i返回相应元素
    public abstract ListNode get(int i);

    // 在线性表中查找某个元素x第一次出现位置
    public abstract int find(T val);

    // 插入一个新元素val
    public abstract boolean insert(T val);

    // 删除元素
    public abstract ListNode delete();

    // 返回线性表L的长度
    public abstract int length();

}
