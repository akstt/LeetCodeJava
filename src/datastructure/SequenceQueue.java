package datastructure;

import java.util.Arrays;

/**
 *队列顺序存储
 */
public class SequenceQueue<T> extends SequenceStorage<T>{
    private int front;
    private T[] sequenceQueue = super.getSequenceList();

    public SequenceQueue(Class<T> type, int maxSize) {
        super(type, maxSize);
    }

    public SequenceQueue(Class<T> type, int maxSize, T[] sequenceQueue) {
        super(type, maxSize, sequenceQueue);
    }

    @Override
    public T get(int i) {
        if (i < 0 || i >=length()){
            System.out.println("索引错误");
            return null;
        }else{
            i = (i + front) % getMaxSize();
            return sequenceQueue[i];
        }

    }

    @Override
    public int find(T val) {
        int i = 0;
        int length = length();
        while (i < length && sequenceQueue[(i + front) % getMaxSize()] !=val ){
            i++;
        }
        return i >= length() ? -1:i;
    }

    @Override
    public boolean insert(T val) {
        if (isFull()){
            System.out.println("堆栈满");
            return false;
        }else{
            sequenceQueue[getRear()] = val;
            setRear((getRear() + 1) % getMaxSize());
            return true;
        }
    }

    @Override
    public T delete() {
        if (isEmpty()){
            System.out.println("堆栈空");
            return null;
        }else{
            var result = sequenceQueue[front];
            sequenceQueue[front] = null;
            front = (front + 1) % getMaxSize();
            return result;
        }
    }

    @Override
    public int length() {
        return (getRear() + getMaxSize() - front) % getMaxSize();
    }

    public boolean isFull(){
        return front == (getRear()+1)%getMaxSize();
    }

    public boolean isEmpty(){
        return front == getRear();
    }

    public String toString(){
        // return Arrays.toString(sequenceQueue);
        StringBuilder string = new StringBuilder();
        string.append("[");
        int length = length();
        for (var i = 0; i < length; i++){
            string.append(sequenceQueue[(i + front) % getMaxSize()]).append(",");
        }
        string.append("]");
        return string.toString();
    }
}

//class SequenceQueueTest{
//    public static void main(String[] args) {
//        var sequenceQueue1 = new SequenceQueue<Integer>(Integer.class, 5);
//        var sequenceQueue2 = new SequenceQueue<Integer>(Integer.class, 6, new Integer[]{1,2,3,4});
//        System.out.println(sequenceQueue1);
//        System.out.println(sequenceQueue2);
//        System.out.println(sequenceQueue2.get(2));
//        System.out.println(sequenceQueue2.get(0));
//        sequenceQueue2.insert(5);
//        sequenceQueue2.insert(6);
//        System.out.println(sequenceQueue2);
//        System.out.println(sequenceQueue2.delete());
//        System.out.println(sequenceQueue2.delete());
//        System.out.println(sequenceQueue2.delete());
//        System.out.println(sequenceQueue2);
//        sequenceQueue2.insert(6);
//        sequenceQueue2.insert(7);
//        System.out.println(sequenceQueue2);
//        System.out.println(sequenceQueue2.length());
//        System.out.println(sequenceQueue2.delete());
//        System.out.println(sequenceQueue2.delete());
//        System.out.println(sequenceQueue2.delete());
//        System.out.println(sequenceQueue2.delete());
//        System.out.println(sequenceQueue2.delete());
//        System.out.println(sequenceQueue2);
//        sequenceQueue2.insert(8);
//        sequenceQueue2.insert(9);
//        sequenceQueue2.insert(10);
//        System.out.println(sequenceQueue2);
//    }
//}
