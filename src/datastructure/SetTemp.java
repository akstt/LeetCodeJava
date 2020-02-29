package datastructure;

public class SetTemp {
    private int size;
    private int rear;
    /**
     * @param data 集合值
     * @param relation 集合关系，和data一一对应，表示父节点的索引，如果为根节点则为该集合大小的负数
     */
    private int[] data;
    private int[] relation;

    public SetTemp(int size){
        this.size = size;
        this.rear = 0;
        this.data = new int[size];
        this.relation = new int[size];
    }

    public SetTemp(int size, int[] data, int[] relation){
        if (size < data.length){
            System.out.println("集合空间不足");
        }else{
            this.size = size;
            this.data = new int[size];
            this.relation = new int[size];
            for (; this.rear<data.length; this.rear++){
                this.data[this.rear] = data[this.rear];
                this.relation[this.rear] = relation[this.rear];
            }
        }
    }

    public int find(int val){
        int result = -1;
        for (int i = 0; i < this.rear; i++){
            if (this.data[i] == val){
                result = i;
                break;
            }
        }
        if (result != -1){
            while(this.relation[result] >= 0){
                result = this.relation[result];
            }
        }
        return result;
    }

    public void union(int val_1, int val_2){
        int index_1 = find(val_1);
        int index_2 = find(val_2);
        if (index_1 == -1 || index_2 == -1){
            System.out.println("未找到相应集合");
        }else if (index_1 != index_2){
            if (this.relation[index_1] < this.relation[index_2]){
                this.relation[index_1] = this.relation[index_1] + this.relation[index_2];
                this.relation[index_2] = index_1;
            }else{
                this.relation[index_2] = this.relation[index_1] + this.relation[index_2];
                this.relation[index_1] = index_2;
            }
        }
    }

//    public static void main(String[] args) {
//        var set = new SetTemp(10, new int[]{1,2,3,4,5,6,7,8,9,10}, new int[]{-3,-3,-4,0,1,2,5,4,3,6});
//        for(int i = 1; i <= 10; i++){
//            System.out.println(set.find(i));
//        }
//        set.union(9, 10);
//        System.out.println("=======");
//        for(int i = 1; i <= 10; i++){
//            System.out.println(set.find(i));
//        }
//    }

}
