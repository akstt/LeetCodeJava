package datastructure;

import java.util.Arrays;

/**
 * 堆栈顺序存储
 */
public class SequenceStack<T> extends SequenceStorage<T> {
    private T[] sequenceStack= super.getSequenceList();

    public SequenceStack(Class<T> type, int maxSize) {
        super(type, maxSize);
    }

    public SequenceStack(Class<T> type, int maxSize, T[] sequenceList) {
        super(type, maxSize, sequenceList);
    }

    public String toString() {
        // return Arrays.toString(sequenceStack);
        StringBuilder string = new StringBuilder();
        string.append("[");
        for (var i = 0; i < getRear(); i++){
            string.append(sequenceStack[i]).append(",");
        }
        string.append("]");
        return string.toString();
    }

    @Override
    public T get(int i) {
        if (i < 0 || i >=getRear()){
            System.out.println("索引错误");
            return null;
        }else{
            return sequenceStack[i];
        }
    }

    @Override
    public int find(T val) {
        int i = 0;
        while (i < getRear() && sequenceStack[i] !=val ){
            i++;
        }
        return i >= getRear() ? -1:i;
    }

    @Override
    public boolean insert(T val) {
        if (isFull()){
            System.out.println("堆栈满");
            return false;
        }else{
            sequenceStack[getRear()] = val;
            setRear(getRear() + 1);
            return true;
        }
    }

    @Override
    public T delete() {
        if (isEmpty()){
            System.out.println("堆栈空");
            return null;
        }else{
            var result = sequenceStack[getRear()-1];
            sequenceStack[getRear()-1] = null;
            setRear(getRear()-1);
            return result;
        }
    }

    @Override
    public int length() {
        return getRear();
    }

    public boolean isFull(){
        return getRear() == getMaxSize();
    }

    public boolean isEmpty(){
        return getRear() == 0;
    }
}

//class SequenceStackTest{
//    public static void main(String[] args) {
//        var sequenceStack1 = new SequenceStack<Integer>(Integer.class, 5);
//        var sequenceStack2 = new SequenceStack<Integer>(Integer.class, 5, new Integer[]{1,2,3,4});
//        System.out.println(sequenceStack1);
//        System.out.println(sequenceStack2);
//        System.out.println(sequenceStack2.isEmpty());
//        System.out.println(sequenceStack2.isFull());
//        sequenceStack2.insert(5);
//        sequenceStack2.insert(6);
//        System.out.println(sequenceStack2.isEmpty());
//        System.out.println(sequenceStack2.isFull());
//        System.out.println(sequenceStack2);
//        System.out.println(sequenceStack2.delete());
//        System.out.println(sequenceStack2.delete());
//        System.out.println(sequenceStack2.delete());
//        System.out.println(sequenceStack2.delete());
//        System.out.println(sequenceStack2.delete());
//        System.out.println(sequenceStack2.delete());
//        System.out.println(sequenceStack2.isEmpty());
//        System.out.println(sequenceStack2.isFull());
//        System.out.println(sequenceStack2);
//    }
//}
