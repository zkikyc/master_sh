package com.sh.springbootdemo.utils;

import java.util.ArrayList;
import java.util.List;

public class queryUtils {


    public static void main(String[] args) {
        int []arr = {2,2,2,2,2,2,2,2,2,2};
//       int i =  dichotomy(arr,0,arr.length-1,12);
//       if(i>=0){
//           System.out.println(arr[i]);
//       }
//       else{
//           System.out.println("查找不到该数据！");
//       }
        List<Integer> list = dichotomy2(arr,0,arr.length-1,2);
        System.out.println(list);
    }
    /**
     * 二分法查找有序数组(只返回第一次找到的数据的下标)
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int dichotomy(int []arr,int left,int right,int value){
        //找到数组中间值的下标  因为数组有序  且 为从大到小  所以  比较当前查找的值  如果大于 中间值 则从中间值左边继续递归
        //什么时候  算找到值了呢？  如果没有找到 又是什么清况
        int mid = (right +left)/2;
        int finValue = arr[mid];
//        System.out.println("l="+l+"------r="+r);
        if(left>right){
            return -1;
        }
        if(value>finValue){
            //如果查找值大于中间值，当前数组 应为  left ,mid
           return dichotomy(arr,left,mid-1,value);
        }
        else if(value<finValue){
            //小于中间值 则需要继续迭代的下标为  mid  right
            return dichotomy(arr,mid+1,right,value);
        }
        else{
            return mid;
        }
    }

    /**
     * 二分法 查询所有出现的数
     * @param arr
     * @param left
     * @param right
     * @param value
     * @return
     */
    public static List<Integer> dichotomy2(int []arr,int left,int right,int value){
        //思路: 在第一个方法的基础上  应该建立一个数组或者一个集合存储查询出来的小标
        int mid = (left+right)/2;
        int finValue = arr[mid];
        List<Integer> list = new ArrayList<Integer>();
        if(left>right){
            return new ArrayList<Integer>();
        }
        if(value>finValue){
            //当前值大于中间值  因为前提条件arr为一个从大到小的有序数组  所以  应该从中间值的左边递归
            return  dichotomy2(arr,left,mid-1,value);
        }
        else if(value<finValue){
            return  dichotomy2(arr,mid+1,right,value);
        }
        else{
            //当找到值时  向左向右遍历  找到所有相同值
            int temp = mid-1;
            while(true) {
                if (temp < 0 || arr[temp] != value) {
                    break;
                }
                list.add(temp);
                temp--;
            }
            list.add(mid);
            temp = mid +1;
            while(true) {
                if (temp > arr.length-1 || arr[temp] != value) {
                    break;
                }
                list.add(temp);
                temp++;
            }
            return list;
        }
    }
}
