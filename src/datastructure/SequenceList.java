package datastructure;

import java.util.Arrays;

/**
 *线性表顺序存储
 */
public class SequenceList<T> extends SequenceStorage<T> {
    private T[] sequenceList = super.getSequenceList();

    public SequenceList(Class<T> type, int maxSize) {
        super(type, maxSize);
    }

    public SequenceList(Class<T> type, int maxSize, T[] sequenceList) {
        super(type, maxSize, sequenceList);
    }

    @Override
    public String toString() {
//        return Arrays.toString(sequenceList);
        StringBuilder string = new StringBuilder();
        string.append("[");
        for (var i = 0; i < getRear(); i++){
            string.append(sequenceList[i]).append(",");
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
            return sequenceList[i];
        }

    }

    @Override
    public int find(T val) {
        int i = 0;
        while (i < getRear() && sequenceList[i] !=val ){
            i++;
        }
        return i >= getRear() ? -1:i;
    }

    @Override
    public boolean insert(T val) {
        return insert(getRear(), val);
//        if (getRear() == getMaxSize()){
//            System.out.println("表满");
//            return false;
//        }else{
//            sequenceList[getRear()] = val;
//            setRear(getRear() + 1);
//            return true;
//        }

    }
    public boolean insert(int i,T val) {
        if (getRear() == getMaxSize()){
            System.out.println("表满");
            return false;
        }else if (i < 0 || i>getRear()){
            System.out.println("索引出错");
            return false;
        }else{
            for(var j=getRear(); j>i; j--){
                sequenceList[j] = sequenceList[j-1];
            }
//            if (getRear() - i >= 0) {
//                System.arraycopy(sequenceList, i, sequenceList, i + 1, getRear() - i);
//            }
            sequenceList[i] = val;
            setRear(getRear() + 1);
            return true;
        }
    }

    @Override
    public T delete() {
        return this.delete(getRear()-1);
//        if (getRear() == 0){
//            System.out.println("表空");
//            return false;
//        }else{
//            sequenceList[getRear()-1] = null;
//            setRear(getRear() - 1);
//            return true;
//        }
    }
    public T delete(int i) {
        if (getRear() == 0){
            System.out.println("表空");
            return null;
        }else if (i <0 || i>=getRear()){
            System.out.println("索引错误");
            return null;
        }else{
//            if (getRear() >= 0) {
//                System.arraycopy(sequenceList, 1, sequenceList, 0, getRear());
//            }
            var result = sequenceList[i];
            for(var j=i; j<getRear()-1; j++){
                sequenceList[j] = sequenceList[j+1];
            }
            sequenceList[getRear()-1] = null;
            setRear(getRear()-1);
            return result;
        }
    }

    @Override
    public int length() {
        return getRear();
    }
}

// 测试SequenceList
//class SequenceListTest{
//    public static void main(String[] args) {
//        var sequenceList1 = new SequenceList<Integer>(Integer.class, 10);
//        System.out.println(sequenceList1.length());
//        sequenceList1.insert(3);
//        sequenceList1.insert(2);
//        System.out.println(sequenceList1);
//        System.out.println(sequenceList1.find(10));
//        System.out.println(sequenceList1.get(1));
//        sequenceList1.delete(0);
//        System.out.println(sequenceList1);
//        sequenceList1.delete(0);
//        System.out.println(sequenceList1);
//        sequenceList1.delete(0);
//        System.out.println(sequenceList1);
//        var sequenceList2 = new SequenceList<Integer>(Integer.class, 10, new Integer[]{1,2,3,4,5,6, 7, 8});
//        sequenceList2.insert(3,10);
//        sequenceList2.insert(10);
//        System.out.println(sequenceList2);
//        sequenceList2.insert(2);
//        System.out.println(sequenceList2.length());
//        System.out.println(sequenceList2.find(2));
//        System.out.println(sequenceList2.get(9));
//        System.out.println(sequenceList2.delete(9));
//        System.out.println(sequenceList2);
//        System.out.println(sequenceList2.delete());
//        System.out.println(sequenceList2);
//        sequenceList2.delete(3);
//        System.out.println(sequenceList2);
//        System.out.println(sequenceList2.length());
//
//    }
//}
