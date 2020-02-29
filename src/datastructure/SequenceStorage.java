package datastructure;


import java.lang.reflect.Array;

/**
 * 顺序存储抽象类
 */
abstract class SequenceStorage<T> {
    //
    private int maxSize;
    private T[] sequenceList;
    private int rear;


    public SequenceStorage(Class<T> type, int maxSize){
        this.maxSize = maxSize;
        this.sequenceList = (T[]) Array.newInstance(type, maxSize);
    }

    public SequenceStorage(Class<T> type, int maxSize, T[] sequenceList){
        this(type, maxSize);
        boolean flag = insertArray(sequenceList);
        if (!flag){
            throw new ArrayIndexOutOfBoundsException();
        }
        this.rear = sequenceList.length;
//        try {
//            for (int i = 0; i < sequenceList.length; i++) {
//                this.sequenceList[this.rear + i] = sequenceList[i];
//            }
//            // System.arraycopy(sequenceList, 0, this.sequenceList, this.rear + 0, sequenceList.length);
//            this.rear += sequenceList.length;
//        } catch (ArrayIndexOutOfBoundsException e1){
//            System.out.println("空间不足");
//            // e1.printStackTrace();
//            throw e1;
//        }catch (Exception e2){
//            System.out.println("未知错误");
//            // e2.printStackTrace();
//            throw e2;
//        }

    }
    public boolean insertArray(T[] sequenceList){
        if (sequenceList.length <= maxSize-rear){
            for (int i = 0; i < sequenceList.length; i++) {
                this.sequenceList[this.rear + i] = sequenceList[i];
            }
            // System.arraycopy(sequenceList, 0, this.sequenceList, this.rear + 0, sequenceList.length);
            return true;
        }else{
            System.out.println("空间不足");
            return false;
            // throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int getMaxSize() {
        return maxSize;
    }

    public T[] getSequenceList() {
        return sequenceList;
    }

    public int getRear() {
        return rear;
    }

    public void setRear(int rear) {
        this.rear = rear;
    }

    // 根据位序i返回相应元素
    public abstract T get(int i);

    // 在线性表中查找某个元素x第一次出现位置
    public abstract int find(T val);

    // 插入一个新元素val
    public abstract boolean insert(T val);

    // 删除元素
    public abstract T delete();

    // 返回线性表L的长度
    public abstract int length();

}
