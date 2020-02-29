package algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Sort {

    /**
     * @param arraySort
     * @return 数组是否排序
     */
    public boolean ifSort(int[] arraySort){
        for (int i=0; i<arraySort.length-1; i++) {
            if (arraySort[i] > arraySort[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 交换数组array index1, index2处的值
     * @param array
     * @param index1
     * @param index2
     */
    public void swapValue(int[] array, int index1, int index2){
        int numTemp = array[index1];
        array[index1] = array[index2];
        array[index2] = numTemp;
    }

    /**
     * 打乱数组
     * @param array
     */
    public void shuffle(int[] array){
        Random r = new Random();
        for (int index1 = array.length; index1>0; index1--){
            int index2 = r.nextInt(index1);
            swapValue(array, index1-1, index2);
        }

    }

    /**
     * 冒泡排序
     * 平均时间复杂度O(n^2)
     * 最差时间复杂度O(n^2)
     * 额外空间复杂度O(1)
     * 稳定
     * @param arraySort 需要排序的整数数组
     */
    public void bubbleSort(int[] arraySort){
        for (int i = arraySort.length-1; i>0; i--){
            boolean flag = true;
            for (int j = 0; j<i; j++){
                if (arraySort[j] > arraySort[j+1]){
                    swapValue(arraySort, j , j+1);
                    flag=false;
                }
            }
            if (flag){
                break;
            }
        }
    }

    /**
     * 插入排序
     * 平均时间复杂度O(n^2)
     * 最差时间复杂度O(n^2)
     * 额外空间复杂度O(1)
     * 稳定
     * @param arraySort 需要排序的整数数组
     */
    public void insertSort(int[] arraySort){
        for (int i = 1; i < arraySort.length; i++){
            int j = i;
            int numTemp = arraySort[i];
            for (; j > 0; j--){
                if (arraySort[j-1] > numTemp){
                    arraySort[j] = arraySort[j-1];
                }else{
                    break;
                }
            }
            arraySort[j] = numTemp;
        }
    }

    /**
     * 选择排序
     * 平均时间复杂度O(n^2)
     * 最差时间复杂度O(n^2)
     * 额外空间复杂度O(1)
     * 不稳定
     * @param arraySort 需要排序的整数数组
     */
    public void selectSort(int[] arraySort){
        for (int i = 0; i < arraySort.length; i ++){
            int indexMinVal = i;
            for (int j = i +1 ; j< arraySort.length; j++){
                if (arraySort[j] < arraySort[indexMinVal]){
                    indexMinVal = j;
                }
            }
            swapValue(arraySort, i, indexMinVal);
        }
    }

    /**
     * 希尔排序
     * 平均时间复杂度和增量序列有关
     * 最差时间复杂度O(n^2)
     * 额外空间复杂度O(1)
     * 不稳定
     * @param arraySort 需要排序的整数数组
     */
    public void shellSort(int[] arraySort){
        // i 为增量序列
        for (int i = arraySort.length/2; i >0; i /= 2){
            for (int j = i; j < arraySort.length; j ++){
                int numTemp = arraySort[j];
                int k = j;
                for (; k >=i; k -= i){
                    if (arraySort[k-i] > numTemp){
                        arraySort[k] = arraySort[k-i];
                    }else{
                        break;
                    }
                }
                arraySort[k] = numTemp;
            }
        }
    }

    /**
     * 堆排序
     * 平均时间复杂度O(n*logn)
     * 最差时间复杂度O(n*logn)
     * 额外空间复杂度O(1)
     * 不稳定
     * @param arraySort 需要排序的整数数组
     */
    public void heapSort(int[] arraySort){
        for (int i = arraySort.length/2; i >= 0; i --){
            buildMaxHeap(arraySort, i, arraySort.length-1);
        }
        for (int i = arraySort.length-1; i > 0; i--){
            swapValue(arraySort, 0, i);
            buildMaxHeap(arraySort, 0, i-1);
        }
    }

    /**
     * 建立最大堆
     * @param arraySort 数组
     * @param indexStart 根节点索引
     * @param indexEnd 最后结点索引
     */
    private void buildMaxHeap(int[] arraySort, int indexStart, int indexEnd){
        while(indexStart < indexEnd){
            int indexLeft = indexStart * 2 + 1;
            int indexRight = indexStart * 2 + 2;
            if (indexRight <= indexEnd){
                if (arraySort[indexLeft] > arraySort[indexStart] && arraySort[indexLeft] >= arraySort[indexRight]){
                    swapValue(arraySort, indexStart, indexLeft);
                    indexStart = indexLeft;
                }else if(arraySort[indexRight] > arraySort[indexStart] && arraySort[indexRight] >= arraySort[indexLeft]){
                    swapValue(arraySort, indexStart, indexRight);
                    indexStart = indexRight;
                }else{
                    break;
                }
            }else{
                if (indexLeft == indexEnd && arraySort[indexLeft] > arraySort[indexStart]){
                    swapValue(arraySort, indexStart, indexLeft);
                }
                break;
            }
        }
    }

    /**
     * 归并排序
     * 平均时间复杂度O(n*logn)
     * 最差时间复杂度O(n*logn)
     * 额外空间复杂度O(n)
     * 稳定
     * @param arraySort 需要排序的整数数组
     */
    public void mergeSort(int[] arraySort){
        int[] arrayStore = new int[arraySort.length];
        mSort(arraySort, arrayStore, 0, arraySort.length-1);
    }

    // 分
    private void mSort(int[] arraySort, int[] arrayStore, int indexStart, int indexEnd){
        if (indexStart < indexEnd){
            int indexMiddle = (indexStart + indexEnd) / 2;
            mSort(arraySort, arrayStore, indexStart, indexMiddle);
            mSort(arraySort, arrayStore, indexMiddle+1, indexEnd);
            merge(arraySort, arrayStore, indexStart, indexMiddle, indexEnd);

        }
    }

    // 治
    private void merge(int[] arraySort, int[] arrayStore, int indexStart1, int indexEnd1, int indexEnd2){
        int indexStart2 = indexEnd1+1;
        int indexStart = indexStart1;
        int indexNow = indexStart1;
        while (indexStart1 <= indexEnd1 && indexStart2 <= indexEnd2){
            if (arraySort[indexStart2] < arraySort[indexStart1]){
                arrayStore[indexNow++] = arraySort[indexStart2++];
            }else{
                arrayStore[indexNow++] = arraySort[indexStart1++];
            }
        }
        while (indexStart1 <= indexEnd1){
            arrayStore[indexNow++] = arraySort[indexStart1++];
        }
        while (indexStart2 <= indexEnd2){
            arrayStore[indexNow++] = arraySort[indexStart2++];
        }
        for (int i = indexStart; i < indexNow; i++){
            arraySort[i] = arrayStore[i];
        }
    }

    /**
     * 快速排序
     * 平均时间复杂度O(n*logn)
     * 最差时间复杂度O(n^2)
     * 额外空间复杂度O(logn)
     * 不稳定
     * @param arraySort 需要排序的整数数组
     */
    public void quickSort(int[] arraySort){
        int cutOff = 1;
        qSort(arraySort, 0, arraySort.length-1, cutOff);
    }

    // 插入排序
    private void insertSort(int[] arraySort, int indexStart, int indexEnd){
        for (int i = indexStart + 1; i <= indexEnd; i++){
            int numTemp = arraySort[i];
            int j = i;
            for (; j > 0; j--){
                if (arraySort[j-1] > numTemp){
                    arraySort[j] = numTemp;
                }else{
                    break;
                }
            }
            arraySort[j] = numTemp;
        }
    }

    // 获得主元
    private int getPivot(int[] arraySort, int indexStart, int indexEnd){
        int indexMiddle = (indexStart + indexEnd) / 2;
        if (arraySort[indexStart] > arraySort[indexMiddle]){
            swapValue(arraySort, indexStart, indexMiddle);
        }
        if (arraySort[indexStart] > arraySort[indexEnd]){
            swapValue(arraySort, indexStart, indexEnd);
        }
        if (arraySort[indexMiddle] > arraySort[indexEnd]){
            swapValue(arraySort, indexMiddle, indexEnd);
        }
        swapValue(arraySort, indexMiddle, indexEnd-1);
        return arraySort[indexEnd-1];
    }

    // 快速排序
    private void qSort(int[] arraySort, int indexStart, int indexEnd, int cutOff){
        if (indexEnd - indexStart < cutOff){
            insertSort(arraySort,indexStart, indexEnd);
        }else{
            int pivot = getPivot(arraySort, indexStart, indexEnd);
            int i = indexStart;
            int j = indexEnd - 1;
            if (indexEnd - indexStart > 2){
                while (true){
                    while (arraySort[++i] < pivot){}
                    while (arraySort[--j] > pivot){}
                    if (j > i){
                        swapValue(arraySort, i, j);
                    }else{
                        swapValue(arraySort, i, indexEnd-1);
                        break;
                    }
                }
                qSort(arraySort, indexStart, i-1, cutOff);
                qSort(arraySort, i + 1, indexEnd, cutOff);
            }
        }
    }
//    public static void main(String[] args) {
//        int[] array = new int[217];
//        Random r = new Random();
//        for (int i = 0; i <array.length; i++){
//            array[i] = r.nextInt(100) - 50;
//        }
//
//        var sort = new Sort();
//
//        System.out.println("bubbleSort");
//        sort.bubbleSort(array);
//        System.out.println(Arrays.toString(array));
//        System.out.println(sort.ifSort(array));
//
//        sort.shuffle(array);
//        System.out.println("insertSort");
//        sort.insertSort(array);
//        System.out.println(Arrays.toString(array));
//        System.out.println(sort.ifSort(array));
//
//        sort.shuffle(array);
//        System.out.println("selectSort");
//        sort.selectSort(array);
//        System.out.println(Arrays.toString(array));
//        System.out.println(sort.ifSort(array));
//
//        sort.shuffle(array);
//        System.out.println("shellSort");
//        sort.shellSort(array);
//        System.out.println(Arrays.toString(array));
//        System.out.println(sort.ifSort(array));
//
//        sort.shuffle(array);
//        System.out.println("HeapSort");
//        sort.heapSort(array);
//        System.out.println(Arrays.toString(array));
//        System.out.println(sort.ifSort(array));
//
//        sort.shuffle(array);
//        System.out.println("MergeSort");
//        sort.mergeSort(array);
//        System.out.println(Arrays.toString(array));
//        System.out.println(sort.ifSort(array));
//
//        sort.shuffle(array);
//        System.out.println("QuickSort");
//        sort.quickSort(array);
//        System.out.println(Arrays.toString(array));
//        System.out.println(sort.ifSort(array));
//
//    }
}
