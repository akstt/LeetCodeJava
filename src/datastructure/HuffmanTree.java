package datastructure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class HuffmanTree<T> extends BinaryTree<T>{
    private T data;
    private Integer weight;
    private HuffmanTree<T> left;
    private HuffmanTree<T> right;

    @Deprecated
    public void setData(T data) {
    }

    @Deprecated
    public void setWeight(Integer weight) {
    }

    @Deprecated
    public void setLeft(HuffmanTree<T> left) {

    }

    @Deprecated
    public void setRight(HuffmanTree<T> right) {
    }

    public HuffmanTree(T data, Integer weight){
        this.data = data;
        this.weight = weight;
    }

    public HuffmanTree(T data, Integer weight, HuffmanTree<T> left, HuffmanTree<T> right){
        this.data = data;
        this.weight = weight;
        this.left = left;
        this.right = right;
    }

    /**
     *
     * @param weightAll 权重数组
     * @param dataAll 数据数组 和权重数组一一对应
     */
    public HuffmanTree(Integer[] weightAll, T[] dataAll){
        HuffmanTree[] treeAll = new HuffmanTree[dataAll.length];
        for (int i = 0; i < dataAll.length; i ++){
            treeAll[i] = new HuffmanTree<T>(dataAll[i], weightAll[i]);
        }
        MinHeap<HuffmanTree> heap = new MinHeap<>(dataAll.length, weightAll, treeAll);

        while (! heap.ifEmpty()){
            List<Object> leftWeightTree = heap.delete();
            HuffmanTree<T> leftTree = (HuffmanTree) leftWeightTree.get(1);
            if (heap.ifEmpty()){
                this.data = leftTree.data;
                this.weight = leftTree.weight;
                this.left = leftTree.left;
                this.right = leftTree.right;
            }else {
                List<Object> rightWeightTree = heap.delete();
                HuffmanTree<T> rightTree = (HuffmanTree) rightWeightTree.get(1);
                heap.insert(leftTree.weight + rightTree.weight, new HuffmanTree<T>(null, leftTree.weight + rightTree.weight, leftTree, rightTree));
            }
        }
    }

    private boolean ifEmptyNode(HuffmanTree<T> tree) {
        return (tree == null || tree.weight == null);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Deque<HuffmanTree<T>> subTreeAll = new ArrayDeque<>();
        if (!ifEmptyNode(this)){
            subTreeAll.addLast(this);
        }
        while (subTreeAll.size() > 0){
            Deque<HuffmanTree<T>> subTreeAllNext = new ArrayDeque<>();
            while (subTreeAll.size() > 0) {
                HuffmanTree<T> treeNode = subTreeAll.removeFirst();
                result.append(treeNode.data);
                result.append(" -> ");
                if (!ifEmptyNode(treeNode.left)){
                    result.append(treeNode.left.data);
                    subTreeAllNext.addLast(treeNode.left);
                }
                result.append(", ");
                if (!ifEmptyNode(treeNode.right)){
                    result.append(treeNode.right.data);
                    subTreeAllNext.addLast(treeNode.right);
                }
                result.append("; ");
            }
            result.append("\n");
            subTreeAll = subTreeAllNext;
        }
        return result.toString();
    }



//    public static void main(String[] args) {
//        var weight = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
//        var val = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
//        HuffmanTree<Integer> hufman = new HuffmanTree<Integer>(weight, val);
//        System.out.println(hufman);
//    }
}
