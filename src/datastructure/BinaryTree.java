package datastructure;

import java.util.ArrayDeque;
import java.util.Deque;

/*
二叉树的链式存储
 */
public class BinaryTree<T> {
    /**
     * @param data 该节点数据
     * @param left 左子树
     * @param right 右子树
     */
    private T data;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    public BinaryTree() {
    }

    public BinaryTree(T data){
        this.data = data;
    }

    /**
     * 将一组数据转为树的链式表示方法
     * @param dataArray 一组树的数据组成的n维数组
     * @param nodeRelation 结点的关系，是一个n*2维的数组；和dataArray一一对应，分别表示左子树和右子树数据的索引，如果为空则为-1
     * @param dataIndex 当前结点在数组的索引位置
     */
    public BinaryTree(T[] dataArray, int[][] nodeRelation, int dataIndex){
        this.data = dataArray[dataIndex];
        if (nodeRelation[dataIndex][0] != -1){
            this.left = new BinaryTree<T>(dataArray, nodeRelation, nodeRelation[dataIndex][0]);
        }
        if (nodeRelation[dataIndex][1] != -1){
            this.right = new BinaryTree<T>(dataArray, nodeRelation, nodeRelation[dataIndex][1]);
        }

    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryTree<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTree<T> left) {
        if (this.data == null) {
            System.out.println("空结点无法赋予子树");
        } else {
            this.left = left;
        }
    }

    public BinaryTree<T> getRight() {
        return right;
    }

    public void setRight(BinaryTree<T> right) {
        if (this.data == null) {
            System.out.println("空结点无法赋予子树");
        } else {
            this.right = right;
        }
    }

    /**
     * 当LinkTree=null或LinkTree.data=null时表示空结点
     * @param linkTree 输入的树结点
     * @return 是否为空结点
     */
    public boolean ifEmptyNode(BinaryTree<T> linkTree){
        return (linkTree == null || linkTree.data == null);

    }
    /**
     * 先序遍历
     */
    public void preOrderTraversal(){
        if (! ifEmptyNode(this)) {
            System.out.println(this.data);
            if (! ifEmptyNode(this.left)) {
                this.left.preOrderTraversal();
            }
            if (! ifEmptyNode(this.right)) {
                this.right.preOrderTraversal();
            }
        }
    }

    /**
     * 中序遍历
     */
    public void InOrderTraversal(){
        if (! ifEmptyNode(this)) {
            if (! ifEmptyNode(this.left)){
                this.left.InOrderTraversal();
            }
            System.out.println(this.data);
            if (! ifEmptyNode(this.right)){
                this.right.InOrderTraversal();
            }
        }
    }

    /**
     * 后续遍历
     */
    public void postOrderTraversal(){
        if (! ifEmptyNode(this)) {
            if (! ifEmptyNode(this.left)) {
                this.left.postOrderTraversal();
            }
            if (! ifEmptyNode(this.right)) {
                this.right.postOrderTraversal();
            }
            System.out.println(this.data);
        }
    }

    /**
     * 层次遍历
     */
    public void levelOrderTraversal(){
        Deque<BinaryTree<T>> nodeDeque = new ArrayDeque<>();
        if (! ifEmptyNode(this)) {
            nodeDeque.addLast(this);
        }
        while (nodeDeque.size() != 0){
            BinaryTree<T> treeTemp = nodeDeque.removeFirst();
            System.out.println(treeTemp.data);
            if (! ifEmptyNode(treeTemp.left)){
                nodeDeque.addLast(treeTemp.left);
            }
            if (! ifEmptyNode(treeTemp.right)){
                nodeDeque.addLast(treeTemp.right);
            }
        }
    }

    /**
     * 判断两棵二叉树是否同构
     * @param otherTree 另一个二叉树
     * @return 是否同构
     */
    public boolean isomorphic(BinaryTree<T> otherTree){
        if (ifEmptyNode(this) && ifEmptyNode(otherTree)){
            return true;
        }else if (ifEmptyNode(this) || ifEmptyNode(otherTree)) {
            return false;
        }else{
            if (this.data != otherTree.data) {
                return false;
            } else if (ifEmptyNode(this.left) && ifEmptyNode(this.right)) {
                return isomorphicTwoNull(otherTree);
            } else if (ifEmptyNode(this.left)) {
                return isomorphicOneNull(this.right, otherTree);
            } else if (ifEmptyNode(this.right)) {
                return isomorphicOneNull(this.left, otherTree);
            } else {
                return isomorphicZeroNull(otherTree);
            }
        }
    }

    /**
     * 没有子树的情况
     * @param otherTree 另一个二叉树
     * @return 是否同构
     */
    private boolean isomorphicTwoNull(BinaryTree<T> otherTree){
        return (ifEmptyNode(otherTree.left) && ifEmptyNode(otherTree.right));
    }
    /**
     * 一颗子树的情况
     * @param subTree 不为null的子树
     * @param otherTree 另一个二叉树
     * @return 是否同构
     */
    private boolean isomorphicOneNull(BinaryTree<T> subTree, BinaryTree<T> otherTree) {
        if (ifEmptyNode(otherTree.left) && ! ifEmptyNode(otherTree.right)) {
            return subTree.isomorphic(otherTree.right);
        } else if (ifEmptyNode(otherTree.right) && ! ifEmptyNode(otherTree.left)) {
            return subTree.isomorphic(otherTree.left);
        }else{
            return false;
        }
    }
    /**
     * 两颗子树的情况
     * @param otherTree 另一个二叉树
     * @return 是否同构
     */
    private boolean isomorphicZeroNull(BinaryTree<T> otherTree){
        if (ifEmptyNode(otherTree.left) || ifEmptyNode(otherTree.right)){
            return false;
        }else{
            return ((this.left.isomorphic(otherTree.left) && this.right.isomorphic(otherTree.right)) ||
                    (this.left.isomorphic(otherTree.right) && this.right.isomorphic(otherTree.left)));
        }
    }

    /**
     *
     * @return 树的高度
     */
    public int getHeight(){
        int leftHeight = ifEmptyNode(this.left) ? 0 : this.left.getHeight();
        int rightHeight = ifEmptyNode(this.right)  ? 0 : this.right.getHeight();
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Deque<BinaryTree<T>> subTreeAll = new ArrayDeque<>();
        if (!ifEmptyNode(this)){
            subTreeAll.addLast(this);
        }
        while (subTreeAll.size() > 0){
            Deque<BinaryTree<T>> subTreeAllNext = new ArrayDeque<>();
            while (subTreeAll.size() > 0) {
                BinaryTree<T> treeNode = subTreeAll.removeFirst();

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

//        public static void main(String[] args) {
//        var dataArray1 = new Integer[]{1,2,3,5,6,7,10,12,13,14};
//        var nodeRelation1 = new int[][]{new int[]{1, 2}, new int[]{-1, 3},new int[]{4, 5},new int[]{6, -1},new int[]{7, 8},
//                                       new int[]{9, -1},new int[]{-1, -1},new int[]{-1, -1},new int[]{-1, -1},new int[]{-1, -1}};
//        var linkTree1 = new BinaryTree<>(dataArray1, nodeRelation1, 0);
//        System.out.println("前序遍历");
//        linkTree1.preOrderTraversal();
//        System.out.println("中序遍历");
//        linkTree1.InOrderTraversal();
//        System.out.println("后序遍历");
//        linkTree1.postOrderTraversal();
//        System.out.println("层次遍历");
//        linkTree1.levelOrderTraversal();
//        System.out.println("树的高度");
//        System.out.println(linkTree1.getHeight());
//        var dataArray2 = new Integer[]{1,3,2,6,7,5,13,12,14,10};
//        var nodeRelation2 = new int[][]{new int[]{1, 2}, new int[]{3, 4},new int[]{5, -1},new int[]{6, 7},new int[]{-1, 8},
//                new int[]{9, -1},new int[]{-1, -1},new int[]{-1, -1},new int[]{-1, -1},new int[]{-1, -1}};
//        var linkTree2 = new BinaryTree<>(dataArray2, nodeRelation2, 0);
//        System.out.println(linkTree1.isomorphic(linkTree2));
//            System.out.println(linkTree1);
//            System.out.println(linkTree2);
//
//    }

}
