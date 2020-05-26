package com.kikyc.utils.utils;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraysUtils {

    public static void main(String[] args) {
        int[] arr = {8, 9, 4, 3, 2, 1, 0, 1, 3, 10};
//        int arr[] = new int[800000];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int) (Math.random() * 100000);
//        }
//        long start = System.currentTimeMillis();
//        bubbleSort(arr, true); //80000条数据耗时  8950ms
        //choose(arr, true);     //80000条数据耗时  1656ms
//        insertSort(arr, true); //80000条数据耗时  472ms
//        shellSort(arr, true);  //80000条数据耗时  4810ms
//        shellSort2(arr, false);//80000条数据耗时  14ms  八十万条数据耗时  128ms  八百万条数据耗时  1698ms
//        quickSort(arr, 0, arr.length - 1, true); //八十万条数据耗时  100ms 八百万条数据耗时 815ms
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);
//        System.out.println(Arrays.toString(arr));
//        getSz(arr);
//        System.out.println(Arrays.toString(arr));
//        ArrayList
    }


    public static void  getSz(int arr[]) {
       //[1,2,3,1,1,1,1,2,2,2,3,3,3,3,3]  按照数字从小到大排序  且相同数字必须相邻  不能占用多的空间
        //思路:使用选择排序法 将数字从小到大排序即可
        int value;
        int index;
        for(int i =0;i<arr.length;i++){
            value = arr[i];
            index = i;
            //找到当前数字中的最小值和当前遍历的位置的值交换位置
            for(int j=i+1;j<arr.length;j++){
                //如果坐标为j的值小于i 则交换两者之间的位置
                if(value >arr[j]){
                 value = arr[j];
                 index = j;
                }
            }
            arr[index] = arr[i];
            arr[i] = value;
        }
    }
    //排序 2020 4.12  by  zw

    /**
     * 冒泡排序
     *
     * @param arr  数组
     * @param flag true  从大到小  false 从小到大
     * @return
     */
    public static void bubbleSort(int arr[], boolean flag) {
        //思路： 从大到小  遍历数组，从第一个开始  如果 下一个数 大于 当前数  则交换两个数的位置 从小到大只需要修改比较符即可
        //优化： 当一次循环从没交换过位置  说明 排序已然完成 此时直接跳出循环
        //时间频度  f(n*n)时间复杂度 O(n*n)
        int temp;
        boolean flag1 = false;
        if (flag) {
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    if (arr[j] < arr[j + 1]) {
                        temp = arr[j + 1];
                        arr[j + 1] = arr[j];
                        arr[j] = temp;
                        flag1 = true;
                    }
                }
//                System.out.println("第" + (i + 1) + "次排序结果为:" + Arrays.toString(arr));
                if (!flag1) {
                    break;
                }
                flag1 = false;//重置flag1
            }
        } else {
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        temp = arr[j + 1];
                        arr[j + 1] = arr[j];
                        arr[j] = temp;
                        flag1 = true;
                    }
                }
//                System.out.println("第" + (i + 1) + "次排序结果为:" + Arrays.toString(arr));
                if (!flag1) {
                    break;
                }
                flag1 = false;//重置flag1
            }
        }
    }

    /**
     * 选择排序法
     *
     * @param arr  数组
     * @param flag true  从大到小  false 从小到大
     * @return
     */
    public static void choose(int arr[], boolean flag) {
        // 从大到小  找到当前数组中最大值 记录下标  和值  和第i个数进行交换
        //时间频度  f(n*n)时间复杂度 O(n*n)
        int index;
        int value;
        if (flag) {
            for (int i = 0; i < arr.length - 1; i++) {
                value = arr[i];
                index = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (value < arr[j]) {
                        value = arr[j];
                        index = j;
                    }
                }
                arr[index] = arr[i];
                arr[i] = value;
                //System.out.println("第"+(i+1)+"次排序结果为:"+Arrays.toString(arr));
            }
        } else {
            for (int i = 0; i < arr.length - 1; i++) {
                value = arr[i];
                index = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (value > arr[j]) {
                        value = arr[j];
                        index = j;
                    }
                }
                arr[index] = arr[i];
                arr[i] = value;
                //System.out.println("第"+(i+1)+"次排序结果为:"+Arrays.toString(arr));
            }
        }
    }

    /**
     * 插入排序法
     *
     * @param arr  数组
     * @param flag true  从大到小  false 从小到大
     * @return
     */
    public static void insertSort(int arr[], boolean flag) {
        //思路  从大到小 将数组分为一个有序数组和一个无序数组  每次遍历从无序数组中取一个值  放进有序数组中  小于该值的位置的前一个位置 其余值比较过程中依次后移
        //时间频度  f(n*n)时间复杂度 O(n*n)
        //定义插入值
        int value;
        int index;
        if (flag) {
            for (int i = 1; i < arr.length; i++) {
                value = arr[i];
                index = i - 1;
                while (index >= 0 && value > arr[index]) {
                    arr[index + 1] = arr[index];
                    index--;
                }
                arr[index + 1] = value;
            }
        } else {
            for (int i = 1; i < arr.length; i++) {
                value = arr[i];
                index = i - 1;
                while (index >= 0 && value < arr[index]) {
                    arr[index + 1] = arr[index];
                    index--;
                }
                arr[index + 1] = value;
            }
        }
    }

    /**
     * 希尔排序(交换)
     *
     * @param arr  数组
     * @param flag true  从大到小  false 从小到大
     */
    public static void shellSort(int arr[], boolean flag) {
        //思路 将一个数组  分成数组长度除以二  即 length/2 个组 然后 比较组内各值并使用交换的方式进行排序 当分为一个组时  即排序完成
        if (flag) {
            for (int num = arr.length / 2; num > 0; num /= 2) {
                for (int i = num; i < arr.length; i++) {
                    for (int j = i - num; j >= 0; j -= num) {
                        if (arr[j] < arr[j + num]) {
                            int temp;
                            temp = arr[j];
                            arr[j] = arr[j + num];
                            arr[j + num] = temp;
                        }
                    }
                }
            }
        } else {
            for (int num = arr.length / 2; num > 0; num /= 2) {
                for (int i = num; i < arr.length; i++) {
                    for (int j = i - num; j >= 0; j -= num) {
                        if (arr[j] > arr[j + num]) {
                            int temp;
                            temp = arr[j];
                            arr[j] = arr[j + num];
                            arr[j + num] = temp;
                        }
                    }
                }
            }
        }
    }

    /**
     * 希尔排序(移位)
     *
     * @param arr  数组
     * @param flag true  从大到小  false 从小到大
     */
    public static void shellSort2(int arr[], boolean flag) {
        //思路：逻辑同上  排序时使用插入排序
        if (flag) {
            for (int num = arr.length / 2; num > 0; num /= 2) {
                for (int i = num; i < arr.length; i++) {
                    //当前值依次与上一个值比较  比较过的值依次后移  当找到插入位置时  当前位置值等于插入值  因为值均后移  故数组不变
                    int value = arr[i];
                    int index = i;
                    while (index - num >= 0 && value > arr[index - num]) {
                        arr[index] = arr[index - num];
                        index -= num;
                    }
                    arr[index] = value;
                }
            }
        } else {
            for (int num = arr.length / 2; num > 0; num /= 2) {
                for (int i = num; i < arr.length; i++) {
                    int value = arr[i];
                    int index = i;
                    while (index - num >= 0 && value < arr[index - num]) {
                        arr[index] = arr[index - num];
                        index -= num;
                    }
                    arr[index] = value;
                }
            }
        }
    }

    /**
     * 快速排序
     *
     * @param arr  数组
     * @param flag true  从大到小  false 从小到大
     */
    public static void quickSort(int[] arr, int left, int right, boolean flag) {
        //思路  找到数组中间位置的值  依次取数组中间值 向左边找小于中间值的值  向右边找大于中间值的值  将两个值的位置交换（从大到小排序）
        //第一次排序 {8, 9, 1, 7, 2, 3, 5, 4, 6, 0,3};
        //找到中间值的下标
        int l = left;
        int r = right;
        int m = arr[((left + right) / 2)];
        int temp;
//        int count = 0;
        if (flag) {
            //依次找到左边小于中间值的值的下标  右边大于中间值的小标
            while (l < r) {
                //向左遍历 当左边找到比中间值小的数据时  退出循环 每一次遍历  左下标+1
                while (arr[l] > m) {
                    l++;
                }
                //向右遍历 当右边找到比中间值大的数据时  退出循环 每一次遍历  右下标-1
                while (arr[r] < m) {
                    r--;
                }
                if (l >= r) {
                    break;
                }
                //交换数据位置
                temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
//                System.out.println("第" + (++count) + "次" + Arrays.toString(arr) + "其中l=" + l + "---r=" + r + "--left=" + left + "--right=" + right);
                //当交换完后的数据 等于中间值  此时  不能继续使用此下标 因为此下标会一直不满足条件 无法移动 当另一侧无法满足下标移动时 会导致死循环
                // 所以  应该手动移动下标   左边相等则右下标+1 右边相等则左下标-1  以当前值为中间值
                // 如果左边相等 左下标+1的话  会导致中间值被交换位置 则排序出错
                if (arr[r] == m) {
                    l++;
                }
                if (arr[l] == m) {
                    r--;
                }
                //此处仍需添加判断  保证r >0  避免  两个数时  右下标遍历到0时 交换位置  导致上一个判断r--<0 导致下面代码报错 可以考虑交换两个方法位置应该能减少判断
//            if (r > 0 && arr[r] == m) {
//                l++;
//            }
            }
            //当左右下标重合时 避免同一个数一直交换 导致栈溢出
            if (l == r) {
                l += 1;
                r -= 1;
            }
            //向左递归 当遍历完之后的左下标和插入时的右下标一样时 则  跳出循环
            //此时数组已经分成了两个数为一组  即最后一次分组了
            if (left < r) {
                quickSort(arr, left, r, flag);
            }
            //向右递归  当遍历完之后的右下标和插入时的左下标一致时 则跳出循环
            if (right > l) {
                quickSort(arr, l, right, flag);
            }
        } else {
            //依次找到左边小于中间值的值的下标  右边大于中间值的小标
            while (l < r) {
                //向左遍历 当左边找到比中间值小的数据时  退出循环 每一次遍历  左下标+1
                while (arr[l] < m) {
                    l++;
                }
                //向右遍历 当右边找到比中间值大的数据时  退出循环 每一次遍历  右下标-1
                while (arr[r] > m) {
                    r--;
                }
                if (l >= r) {
                    break;
                }
                temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                if (arr[r] == m) {
                    l++;
                }
                if (arr[l] == m) {
                    r--;
                }
            }
            //当左右下标重合时 避免同一个数一直交换 导致栈溢出
            if (l == r) {
                l += 1;
                r -= 1;
            }
            //向左递归 当遍历完之后的左下标和插入时的右下标一样时 则  跳出循环
            if (left < r) {
                quickSort(arr, left, r, flag);
            }
            //向右递归  当遍历完之后的右下标和插入时的左下标一致时 则跳出循环
            if (right > l) {
                quickSort(arr, l, right, flag);
            }
        }
    }
}

