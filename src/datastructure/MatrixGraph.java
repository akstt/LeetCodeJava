package datastructure;

import java.util.*;

class Vertex<T>{
    /**
     * key 放在图中顶点的编号(>=0)
     * data 顶点存储的信息
     * traversal 遍历时判断该节点是否遍历
     */
    private int key;
    private T data;
    private boolean traversal;


    protected Vertex(int key, boolean traversal){
        this.key = key;
        this.traversal = traversal;
    }

    protected Vertex(int key, boolean traversal, T data){
        this.key = key;
        this.traversal = traversal;
        this.data = data;
    }

    public int getKey() {
        return key;
    }

    public T getData() {
        return data;
    }

    public boolean getTraversal() {
        return traversal;
    }

    public void setTraversal(boolean traversal){
        this.traversal = traversal;
    }
}

public class MatrixGraph<T> {
    private int vertexNum;
    private int[][] graph;
    private Vertex<T>[] vertex;
    private boolean ifTraversal;

    public MatrixGraph(int vertexNum, int[][] edges){
        this.vertexNum = vertexNum;
        this.graph = new int[vertexNum][vertexNum];
        this.vertex = new Vertex[vertexNum];
        this.ifTraversal = false;
        for (int i=0; i < this.vertexNum; i++){
            Vertex<T> newVertex = new Vertex<T>(i, this.ifTraversal);
            this.vertex[i] = newVertex;
        }
        insertEdge(edges);


    }

    public MatrixGraph(int vertexNum, T[] vertex, int[][] edges){
        this.vertexNum = vertexNum;
        this.graph = new int[vertexNum][vertexNum];
        this.vertex = new Vertex[vertexNum];
        this.ifTraversal = false;
        for (int i=0; i < this.vertexNum; i++){
            Vertex<T> newVertex = new Vertex<T>(i, this.ifTraversal, vertex[i]);
            this.vertex[i] = newVertex;
        }
        insertEdge(edges);
    }

    public void insertEdge(int[][] edges){
        for (int[] edge:edges){
            this.graph[edge[0]][edge[1]] = edge[2];
        }
    }

    /**
     * 深度优先遍历
     */
    public void DFT(){
        this.ifTraversal = !this.ifTraversal;
        for(int i=0; i < this.vertexNum; i++){
            if (this.vertex[i].getTraversal() != this.ifTraversal){
                DFT(i);
            }
        }
    }

    public void DFT(int vertexIndex){
        System.out.println(vertexIndex);
        this.vertex[vertexIndex].setTraversal(this.ifTraversal);
        for (int i=0; i<this.vertexNum; i++){
            if(this.graph[vertexIndex][i] > 0 && this.vertex[i].getTraversal()!=this.ifTraversal){
                DFT(i);
            }
        }
    }

    /**
     * 广度优先遍历
     */
    public void BFT(){
        this.ifTraversal = !this.ifTraversal;
        for (int i = 0; i < this.vertexNum; i++){
            if (this.vertex[i].getTraversal() != this.ifTraversal){
                BFT(i);
            }
        }
    }

    public void BFT(int vertexIndex){
        Deque<Integer> vertexLevel = new ArrayDeque<>();
        vertexLevel.addFirst(vertexIndex);
        this.vertex[vertexIndex].setTraversal(this.ifTraversal);
        while (vertexLevel.size() > 0){
            int vertexIndexNow = vertexLevel.removeLast();
            System.out.println(vertexIndexNow);
            for (int i=0; i < this.vertexNum; i++){
                if (this.graph[vertexIndexNow][i] > 0 && this.vertex[i].getTraversal() != this.ifTraversal){
                    this.vertex[i].setTraversal(this.ifTraversal);
                    vertexLevel.addFirst(i);
                }
            }
        }
    }

    /**
     * @param vertexIndex
     * @return 获得vertex_index该顶点到其他顶点的最短路径及其长度
     */
    public int[][]  shortestPath(int vertexIndex){
        /*
        result 为2*vertexNum的数组, 第一行表示到各顶点的最短长度；
                                   第二行表示最短路径下，该顶点的上一个顶点
         */
        int[][] result = new int[2][vertexNum];
        for (int i = 0; i < this.vertexNum;i ++){
            if (i == vertexIndex){
                result[0][i] = 0;
                result[1][i] = -1;
            }else if (this.graph[vertexIndex][i] == 0){
                result[0][i] = Integer.MAX_VALUE;
                result[1][i] = -1;
            }else{
                result[0][i] = this.graph[vertexIndex][i];
                result[1][i] = vertexIndex;
            }
        }

        boolean[] ifCollected = new boolean[vertexNum];
        Arrays.fill(ifCollected, true);
        ifCollected[vertexIndex] = false;
        while (true) {
            int minDistance = Integer.MAX_VALUE;
            int vertexIndexNow = -1;
            for (int i = 0; i < this.vertexNum; i++) {
                if (result[0][i] < minDistance && ifCollected[i]) {
                    vertexIndexNow = i;
                    minDistance = result[0][i];
                }
            }
            if (vertexIndexNow == -1) {
                break;
            } else {
                ifCollected[vertexIndexNow] = false;
                for (int i = 0; i < this.vertexNum; i++){
                    if (this.graph[vertexIndexNow][i] > 0 && ifCollected[i]){
                        if (result[0][vertexIndexNow] + this.graph[vertexIndexNow][i] < result[0][i]){
                            result[0][i] = result[0][vertexIndexNow] + this.graph[vertexIndexNow][i];
                            result[1][i] = vertexIndexNow;
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * @return 任意两个顶点之间的最短路径
     */
    public int[][][] shortestPath(){
        /*
        result 为2*vertexNum * vertexNum的数组,
        第一行vertex*vertex的数组表示任意两个顶点之间的最短路径长度；
        第二行vertex*vertex的数组表示任意两个顶点之间的最短路径中，该顶点的上一个顶点
         */
        int[][][] result = new int[2][vertexNum][vertexNum];
        for (int i = 0; i < this.vertexNum; i++){
            for (int j = 0; j <this.vertexNum;j++){
                if (i == j){
                    result[0][i][j] = 0;
                    result[1][i][j] = -1;
                }else if (this.graph[i][j] == 0){
                    result[0][i][j] = Integer.MAX_VALUE;
                    result[1][i][j] = -1;
                }else{
                    result[0][i][j] = this.graph[i][j];
                    result[1][i][j] = i;
                }

            }
        }
        for (int k = 0; k <this.vertexNum; k++){
            for (int i = 0; i <this.vertexNum; i++){
                for (int j = 0; j <this.vertexNum; j++){
                    int distance = result[0][i][k] + result[0][k][j];
                    if (distance > 0 && distance < result[0][i][j]){
                        result[0][i][j] = distance;
                        result[1][i][j] = k;
                    }
                }
            }
        }
        return result;
    }

    /**
     * @param vertexIndex
     * @return 以vertexIndex为根节点的最小生成树
     */
    public int[] MST(int vertexIndex){
        boolean[] ifCollected = new boolean[this.vertexNum];
        Arrays.fill(ifCollected, true);
        ifCollected[vertexIndex] = false;

        int[] distanceNow = new int[this.vertexNum];
        for (int i =0; i < this.vertexNum; i++){
            if (i == vertexIndex){
                distanceNow[i] = 0;
            }else if (this.graph[vertexIndex][i] == 0){
                distanceNow[i] = Integer.MAX_VALUE;
            }else{
                distanceNow[i] = this.graph[vertexIndex][i];
            }
        }

        int[] parentsNow = new int[this.vertexNum];
        Arrays.fill(parentsNow, vertexIndex);
        parentsNow[vertexIndex] = -1;

        while (true){
            int minDistance = Integer.MAX_VALUE;
            int vertexIndexNow = -1;
            for(int i = 0; i < this.vertexNum; i++){
                if (ifCollected[i] && distanceNow[i] < minDistance){
                    minDistance = distanceNow[i];
                    vertexIndexNow = i;
                }
            }
            if (vertexIndexNow == -1){
                break;
            }else{
                ifCollected[vertexIndexNow] = false;
                for(int j = 0; j < this.vertexNum; j++){
                    if(this.graph[vertexIndexNow][j] > 0 && this.graph[vertexIndexNow][j] < distanceNow[j]){
                        distanceNow[j] = this.graph[vertexIndexNow][j];
                        parentsNow[j] = vertexIndexNow;
                    }
                }
            }
        }
        return parentsNow;

    }

//    public static void main(String[] args) {
//        var edges = new int[][]{new int[]{1,2,2}, new int[]{1,4,1}, new int[]{2,4,3},
//                                   new int[]{2,5,10}, new int[]{3,1,4}, new int[]{3,6,5},
//                                   new int[]{4,3,2}, new int[]{4, 5,2}, new int[]{4,6,8},
//                                   new int[]{4,7,4}, new int[]{5,7,6}, new int[]{7,6,1}};
//
//        var graph = new MatrixGraph(8, edges);
//        graph.insertEdge(new int[][]{new int[]{0,1,1}, new int[]{1,0,1}});
////        var edges = new int[][]{new int[]{0,8,2}, new int[]{8,1,1}, new int[]{1,7,3},
////                                new int[]{7,2,10}, new int[]{2,6,4}, new int[]{6,3,5},
////                                new int[]{3,5,2}, new int[]{5,4,2}, new int[]{4,9,2}};
////        var graph = new MatrixGraph(10, edges);
//        graph.DFT();
//        System.out.println("=====");
//        graph.BFT();
//        System.out.println(Arrays.deepToString(graph.shortestPath(1)));
//        System.out.println(Arrays.deepToString(graph.shortestPath()));
//        System.out.println(Arrays.toString(graph.MST(0)));
//    }


}


