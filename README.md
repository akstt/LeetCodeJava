# LeetCode
1. 所有解法都是自己写的，基本都是在python解法过几天后，用java重写时，想到的第一个解法
2. 所有的解法都能经过测试
3. 本来想写一些解题时的想法，但是看了leetcode上别人写的题解（图文并茂，思路清晰，种类齐全）后，确实有云泥之别，有兴趣的可以看leetcode上热门题解
4. 我不赞成在解题时，主要逻辑利用语言中自带的方法
5. 以后会整理做的各类题目，把可以利用相同方法解决的问题整理到一起。
# DataStructure
一些自己写的关于数据结构的类，做过简单的测试，但有可能会有bug
## 线性表链式存储
1. [链式存储结点类](src/datastructure/ListNode.java)
2. [链式存储抽象类](src/datastructure/LinkStorage.java)
3. [线性表链式存储](src/datastructure/LinkList.java)
4. [队列链式存储](src/datastructure/LinkQueue.java) 
5. [堆栈链式存储](src/datastructure/LinkStack.java)  
在写链式存储类的时候，我把结点类和存储类分开作为两个类。之后我感觉其实可以把这两个类合并成一个类
## 线性表顺序存储
1. [顺序存储抽象类](src/datastructure/SequenceStorage.java)
2. [线性表顺序存储](src/datastructure/SequenceList.java)
3. [队列顺序存储](src/datastructure/SequenceQueue.java) 
4. [堆栈顺序存储](src/datastructure/SequenceStack.java)
## 树
1. [二叉树的链式存储](src/datastructure/BinaryTree.java)   
实现的方法：在递归和循环中选择较方便理解一种进行实现  
当LinkTree=null或LinkTree.data=null时表示空结点 
2. [二叉搜索树的链式存储](src/datastructure/BinarySearchTree.java)  
一些关于二叉搜索树的规定：
    1. 当该结点data=null时，则该节点为一个空结点；一个空结点的两棵子树都为null；一个非空结点两颗子树都不为null（我大致看了一下红黑树，这样规定方便以后在这个基础上改成红黑树）；
    2. 增加一个Integer dataKey属性，用于查找，插入和删除操作，大概和Map的key差不多；dataKey可以不是Integer，但是一定要可以用来比较大小
3. [堆的顺序存储](src/datastructure/MinHeap.java)  
    1. 最小堆，方便在写哈夫曼树类时重复利用
    2. 每一个结点有两个值，dataKey和data; dataKey的数据格式为Integer;在一个堆中，dataKey可以不唯一
4. [哈夫曼树的链式存储](src/datastructure/HuffmanTree.java)  
在构造哈夫曼树时，可以利用最小堆，不过需要对原来的堆类进行修改，暂时不适用堆来生成哈夫曼树
5. [集合的顺序存储](src/datastructure/SetTemp.java)  
只有固定几个元素的集合的查找和并操作,而且假设集合中元素只能是int

## 图
还有一些无向无权的图，基本上是有向带权图的简化版本，就不写了
1. [有向带权图的邻接矩阵表示](src/datastructure/MatrixGraph.java)
    1. 本身作为一个图类，图中每个结点为结点类；
    2. 我想用数组表示图，这样添加和删除顶点的操作会稍微有些麻烦，暂时先不写；
    3. 权值要大于0
    4. 该类适合稠密图（边数量比较多的图）
    4. 如果两个顶点之间不直接相连，初始化为一个极大值，感觉在求最短路径以及生成最小树时方便一些（现在初始化为0）
   
# 算法
一些常用算法
1. [排序算法](src/algorithms/Sort.java)
   1. 冒泡排序
   2. 插入排序 
   3. 希尔排序
   4. 选择排序
   5. 堆排序
   6. 归并排序
   7. 快速排序 