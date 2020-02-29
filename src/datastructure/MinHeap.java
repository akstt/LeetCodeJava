package datastructure;

import java.util.*;

public class MinHeap<T> {

    private int size=1;
    private int rear = 1;
    private Integer[] minHeapDataKey;
    private List<T> minHeapData;

    public int getSize() {
        return size - 1;
    }

    public int getNum() {
        return rear-1;
    }

    public MinHeap(int size){
        this.size = size + 1;
        this.minHeapDataKey = new Integer[this.size];
        this.minHeapDataKey[0] = Integer.MIN_VALUE;
        this.minHeapData = new ArrayList<>();
        for (int i = 0; i<this.size; i++){
            this.minHeapData.add(null);
        }
    }

    public MinHeap(int size, Integer[] dataKey){
        if (dataKey.length > size){
            System.out.println("堆空间不足");
        }else{
            this.size = size + 1;
            this.minHeapData = new ArrayList<>();
            for (int i = 0; i<this.size; i++){
                this.minHeapData.add(null);
            }
            this.minHeapDataKey = new Integer[this.size];
            this.minHeapDataKey[0] = Integer.MIN_VALUE;
            for (;this.rear <= dataKey.length;this.rear ++){
                this.minHeapDataKey[this.rear] = dataKey[this.rear-1];
            }
            for (int i = this.rear-1; i > 0; i --){
                subMinHeapAdjust(i, false);
            }

        }
    }

    public MinHeap(int size, Integer[] dataKey, T[] dataAll){
        if (dataKey.length > size){
            System.out.println("堆空间不足");
        }else{
            this.size = size + 1;
            this.minHeapData = new ArrayList<>();
            for (int i = 0; i<this.size; i++){
                this.minHeapData.add(null);
            }
            this.minHeapDataKey = new Integer[this.size];
            this.minHeapDataKey[0] = Integer.MIN_VALUE;
            for (;this.rear <= dataKey.length;this.rear ++){
                this.minHeapDataKey[this.rear] = dataKey[this.rear-1];
                this.minHeapData.set(this.rear, dataAll[this.rear-1]);
            }
            for (int i = this.rear-1; i > 0; i --){
                subMinHeapAdjust(i, true);
            }

        }
    }
    private int getLeft(int indexNode){
        return indexNode * 2;
    }

    private int getRight(int indexNode){
        return indexNode * 2 + 1;
    }

    private int getParent(int indexNode){
        return indexNode / 2;
    }

    /**
     * 交换DataKey index1， index2的值
     * @param index_1
     * @param index_2
     */
    private void exchangeKey(int index_1, int index_2){
        Integer numTemp = this.minHeapDataKey[index_2];
        this.minHeapDataKey[index_2] = this.minHeapDataKey[index_1];
        this.minHeapDataKey[index_1] = numTemp;
    }

    /**
     * 交换Data index1，index2的值
     * @param index_1
     * @param index_2
     */
    private void exchangeData(int index_1, int index_2){
        T numTemp = this.minHeapData.get(index_1);
        this.minHeapData.set(index_1, this.minHeapData.get(index_2));
        this.minHeapData.set(index_2, numTemp);
    }

    /**
     *
     * @param indexNode 将以indexNode为根节点的子树转为最小堆，dataKey一定要调整
     * @param flag 是否调整data
     */
    private void subMinHeapAdjust(int indexNode, boolean flag){
        int left = getLeft(indexNode);
        int right = getRight(indexNode);
        if (left >= this.rear){

        }else if (right >= this.rear){
            if (this.minHeapDataKey[left] < this.minHeapDataKey[indexNode]){
                exchangeKey(left, indexNode);
                if (flag){
                    exchangeData(left, indexNode);
                }
                subMinHeapAdjust(left, flag);
            }
        }else{
            if (this.minHeapDataKey[left] < this.minHeapDataKey[indexNode] ||
                    this.minHeapDataKey[right] < this.minHeapDataKey[indexNode]){
                if(this.minHeapDataKey[left] < this.minHeapDataKey[right]){
                    exchangeKey(left, indexNode);
                    if (flag){
                        exchangeData(left, indexNode);
                    }
                    subMinHeapAdjust(left, flag);
                }else{
                    exchangeKey(right, indexNode);
                    if (flag){
                        exchangeData(right, indexNode);
                    }
                    subMinHeapAdjust(right, flag);
                }
            }
        }
    }

    public void insert(Integer indexKey){
        if (ifFull()){
            System.out.println("堆满，无法插入");
        }else{
            this.minHeapDataKey[this.rear] = indexKey;
            nodeAdjust(this.rear, false);
            this.rear += 1;

        }
    }
    public void insert(Integer indexKey, T dataInsert){
        if (ifFull()){
            System.out.println("堆满，无法插入");
        }else{
            this.minHeapDataKey[this.rear] = indexKey;
            this.minHeapData.set(this.rear, dataInsert);
            nodeAdjust(this.rear, true);
            this.rear += 1;

        }
    }

    /**
     * 只有indexKey结点可能不满足最小堆要求，调整结点使该结点满足最小堆要求
     * @param indexKey 调整dataKey
     * @param flag 是否调整data
     */
    public void nodeAdjust(Integer indexKey, boolean flag){
        int parent = getParent(indexKey);
        if (this.minHeapDataKey[indexKey] < this.minHeapDataKey[parent]){
            exchangeKey(indexKey, parent);
            if (flag){
                exchangeData(indexKey, parent);
            }
            nodeAdjust(parent, flag);
        }
    }

    /**
     * 删除最小值
     * @return 两个元素的list，第一个时dataKey，第二个是data
     */
    public List<Object> delete(){
        List<Object> result = new ArrayList<>();
        if (ifEmpty()){
            System.out.println("堆空");
        }else{
            result.add(this.minHeapDataKey[1]);
            result.add(this.minHeapData.get(1));
            this.rear--;
            this.minHeapDataKey[1] = this.minHeapDataKey[this.rear];
            this.minHeapData.set(1, this.minHeapData.get(this.rear));
            subMinHeapAdjust(1, true);
        }
        return result;
    }

    public boolean ifFull(){
        return (this.rear == this.size);
    }

    public boolean ifEmpty(){
        return (this.rear == 1);
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        Deque<BinarySearchTree<T>> subTreeAll = new ArrayDeque<>();
        int indexKey = 1;
        while(indexKey < this.rear){
            int indexKeyNext = getLeft(indexKey);
            for(int i = indexKey; i < Math.min(indexKeyNext, this.rear); i++){
                result.append("(");
                result.append(this.minHeapDataKey[i]);
                result.append(", ");
                result.append(this.minHeapData.get(i));
                result.append(")");
                result.append(" -> ");
                int left  = getLeft(i);
                if (left < this.rear){
                    result.append("(");
                    result.append(this.minHeapDataKey[left]);
                    result.append(", ");
                    result.append(this.minHeapData.get(left));
                    result.append(")");
                }
                result.append(", ");
                int right = getRight(i);
                if (right < this.rear){
                    result.append("(");
                    result.append(this.minHeapDataKey[right]);
                    result.append(", ");
                    result.append(this.minHeapData.get(right));
                    result.append(")");
                }
                result.append("; ");
            }
            result.append("\n");
            indexKey = indexKeyNext;
        }
        return result.toString();
    }



//    public static void main(String[] args) {
//        List<Integer> valList = new ArrayList<>();
//        for (int i = 0; i<50; i++){
//            valList.add(i);
//        }
//        Collections.shuffle(valList);
//        Integer[] vals = new Integer[50];
//        for (int i = 0; i<50; i++){
//            vals[i] = valList.get(i);
//        }
//        System.out.println(Arrays.toString(vals));
//        var minHeap = new MinHeap<Character>(60, vals);
//        System.out.println(minHeap);
//        for(int i = 10; i > -10; i--){
//            minHeap.insert(i);
//        }
//        System.out.println(minHeap);
//        for(int i = 0; i <= 65; i++){
//            System.out.println(minHeap.delete());
//        }
//    }

}
