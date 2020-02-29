package datastructure;

import java.util.*;

/*
整数二叉搜索树
 */
public class BinarySearchTree<T> extends BinaryTree<T>{
    /**
     * @param dataKey 该节点数据
     * @param dataKey 用于搜索树操作的key           
     * @param left 左子树
     * @param right 右子树
     */
    private T data = null;
    private Integer dataKey = null;
    private BinarySearchTree<T> left = null;
    private BinarySearchTree<T> right = null;

    public BinarySearchTree(){

    }

    public BinarySearchTree(Integer dataKey){
        this.dataKey = dataKey;
        this.left = new BinarySearchTree<T>();
        this.right = new BinarySearchTree<T>();
    }

    public BinarySearchTree(Integer dataKey, T data){
        this.data= data;
        this.dataKey = dataKey;
        this.left = new BinarySearchTree<T>();
        this.right = new BinarySearchTree<T>();
    }
    
    public Integer getDataKey() {
        return dataKey;
    }

    public void setDataKey(Integer dataKey) {
        this.dataKey = dataKey;
    }

    @Override
    public void setData(T data) {
        if (this.dataKey == null) {
            System.out.println("空结点无法赋予值");
        } else {
            this.data = data;
        }
    }

    public void setLeft(BinarySearchTree<T> left) {
        if (this.dataKey == null) {
            System.out.println("空结点无法赋予子树");
        } else {
            this.left = left;
        }
    }

    public void setRight(BinarySearchTree<T> right) {
        if (this.dataKey == null) {
            System.out.println("空结点无法赋予子树");
        } else {
            this.right = right;
        }
    }

    /**
     *
     * @param linkTree
     * @return BinarySearchTree是否为空树
     */

    public boolean ifEmptyNode(BinarySearchTree<T> linkTree){
        return (linkTree == null || linkTree.dataKey == null);
    }

    /**
     * 查找元素
     * @param dataKeyFind 需要查找的元素的key
     * @return 该元素所在结点
     */
    public BinarySearchTree<T> find(Integer dataKeyFind){
        if (this.dataKey == null){
            System.out.println("未找到目标值");
            return null;
        }else if (dataKeyFind > this.dataKey){
            return this.right.find(dataKeyFind);
        }else if (dataKeyFind < this.dataKey){
            return this.left.find(dataKeyFind);
        }else{
            return this;
        }
    }

    /**
     *
     * @return 二叉搜索树的最小值
     */
    public BinarySearchTree<T> findMin(){
        if (this.dataKey == null){
            System.out.println("目标树为空树");
            return null;
        }else if (this.left.dataKey != null){
            return this.left.findMinPrivate();
        }else{
            return this;
        }
    }

    private BinarySearchTree<T> findMinPrivate(){
        if (this.left.dataKey != null){
            return this.left.findMinPrivate();
        }else{
            return this;
        }
    }

    /**
     *
     * @return 二叉搜索树的最大值
     */
    public BinarySearchTree<T> findMax(){
        if (this.dataKey == null){
            System.out.println("目标树为空树");
            return null;
        }else if (this.right.dataKey != null){
            return this.right.findMaxPrivate();
        }else{
            return this;
        }
    }

    private BinarySearchTree<T> findMaxPrivate(){
        if (this.right.dataKey != null){
            return this.right.findMaxPrivate();
        }else{
            return this;
        }
    }

    /**
     * 插入操作
     * @param valInsert 插入数值
     */
    public void insert(Integer valInsert){
        if (this.dataKey == null){
            this.dataKey = valInsert;
            this.left = new BinarySearchTree<T>();
            this.right = new BinarySearchTree<T>();
            System.out.println("插入成功");
        }else if (this.dataKey > valInsert){
            this.left.insert(valInsert);
        }else if (this.dataKey < valInsert){
            this.right.insert(valInsert);
        }else {
            System.out.println("替换为null成功");
            this.data = null;
        }
    }

    public void insert(Integer valInsert, T data){
        if (this.dataKey == null){
            this.dataKey = valInsert;
            this.data = data;
            this.left = new BinarySearchTree<T>();
            this.right = new BinarySearchTree<T>();
            System.out.println("插入成功");
        }else if (this.dataKey > valInsert){
            this.left.insert(valInsert, data);
        }else if (this.dataKey < valInsert){
            this.right.insert(valInsert, data);
        }else {
            System.out.println("替换元素成功");
            this.data = data;
        }
    }

    /**
     * 删除操作
     * @param valDelete 删除的数值
     */
    public void delete(int valDelete){
        BinarySearchTree<T> nodeDelete = this.find(valDelete);
        if (nodeDelete != null){
            if (nodeDelete.left.dataKey != null && nodeDelete.right.dataKey != null){
                BinarySearchTree<T> nodeExchange = nodeDelete.left.findMax();
                nodeDelete.dataKey = nodeExchange.dataKey;
                nodeDelete.data = nodeExchange.data;
                nodeExchange.dataKey = valDelete;
                nodeExchange.delete(valDelete);
            }else if (nodeDelete.left.dataKey != null){
                nodeDelete.dataKey = nodeDelete.left.dataKey;
                nodeDelete.data = nodeDelete.left.data;
                nodeDelete.right = nodeDelete.left.right;
                nodeDelete.left = nodeDelete.left.left;
                System.out.println("删除成功");
            }else if (nodeDelete.right.dataKey != null){
                nodeDelete.dataKey = nodeDelete.right.dataKey;
                nodeDelete.data = nodeDelete.right.data;
                nodeDelete.left = nodeDelete.right.left;
                nodeDelete.right = nodeDelete.right.right;
                System.out.println("删除成功");
            }else{
                nodeDelete.dataKey = null;
                nodeDelete.data = null;
                nodeDelete.left = null;
                nodeDelete.right = null;
                System.out.println("删除成功");
            }
        }else{
            System.out.println("删除失败");
        }
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        Deque<BinarySearchTree<T>> subTreeAll = new ArrayDeque<>();
        if (!ifEmptyNode(this)){
            subTreeAll.addLast(this);
        }
        while (subTreeAll.size() > 0){
            Deque<BinarySearchTree<T>> subTreeAllNext = new ArrayDeque<>();
            while (subTreeAll.size() > 0) {
                BinarySearchTree<T> treeNode = subTreeAll.removeFirst();
                result.append("(");
                result.append(treeNode.dataKey);
                result.append(", ");
                result.append(treeNode.data);
                result.append(")");
                result.append(" -> ");
                if (!ifEmptyNode(treeNode.left)){
                    result.append("(");
                    result.append(treeNode.left.dataKey);
                    result.append(", ");
                    result.append(treeNode.left.data);
                    result.append(")");
                    subTreeAllNext.addLast(treeNode.left);
                }
                result.append(", ");
                if (!ifEmptyNode(treeNode.right)){
                    result.append("(");
                    result.append(treeNode.right.dataKey);
                    result.append(", ");
                    result.append(treeNode.right.data);
                    result.append(")");
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
//        var linkTree1 = new BinarySearchTree<Integer>();
//        List<Integer> dataList = new ArrayList<>();
//        for(int i = 0; i < 20; i++){
//            dataList.add(i);
//        }
//        Collections.shuffle(dataList);
//        System.out.println(dataList.toString());
//
//        List<Integer> keyList = new ArrayList<>();
//        for(int i = 0; i < 20; i++){
//            keyList.add(i);
//        }
//        Collections.shuffle(keyList);
//        System.out.println(keyList.toString());
//        System.out.println("开始添加");
//        for(int i = 0; i < keyList.size(); i++){
//            linkTree1.insert(keyList.get(i), dataList.get(i));
//            // System.out.println(linkTree1);
//        }
//        System.out.println("最大值最小值");
//        System.out.println(linkTree1.findMax().dataKey);
//        System.out.println(linkTree1.findMin().dataKey);
//        Collections.shuffle(keyList);
//        linkTree1.insert(2, 50);
//        System.out.println(linkTree1.find(2).data);
//        linkTree1.insert(5);
//        System.out.println(linkTree1.find(5).data);
//        System.out.println(keyList.toString());
//        linkTree1.delete(30);
//        System.out.println("开始删除");
//        for(int i : keyList){
//            linkTree1.delete(i);
//            // System.out.println(linkTree1);
//        }
//    }
}
