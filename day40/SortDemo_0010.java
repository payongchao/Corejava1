package com.briup.jd1721.corejava.day40;

import java.util.Arrays;

public class SortDemo_0010{

	public static void main(String[] args){
		int[] arr={4,3,1,2,0,5};
		System.out.println(Arrays.toString(arr));
		//bubbleSort(arr);
		//selectSort(arr);
		insertSort(arr);
		System.out.println(Arrays.toString(arr));
	}


	/**
	 * 冒泡排序：
	 * 思路：相邻的两个元素比较。
	 */
	public static void bubbleSort(int[] arr){
		for(int i=0;i<arr.length;i++){
			for(int k=0;k<arr.length-1-i;k++){
				swap(arr,k);
			}
		}
	}

	public static void swap(int[] arr,int k){
		if(arr[k]>arr[k+1]){
			// 第一种
            int tmp=arr[k];
            arr[k]=arr[k+1];
            arr[k+1]=tmp;

            // 第二种
            //arr[k]=arr[k]+arr[k+1];
            //arr[k+1]=arr[k]-arr[k+1];
            //arr[k]=arr[k]-arr[k+1];

			// 第三种
			//arr[k]=arr[k]^arr[k+1];
			//arr[k+1]=arr[k]^arr[k+1];
			//arr[k]=arr[k]^arr[k+1];
        }
	}

	/**
	 * 选择排序：
	 * 选择数组中的一个元素（一般第一次选第一个），
	 * 然后跟其他所有的元素进行比较，
	 * 如果遇到比选中的元素小的，让这俩元素换位置。
	 */
	public static void selectSort(int[] arr){
		for(int i=0;i<arr.length;i++){
			for(int k=i+1;k<arr.length;k++){
				if(arr[i]>arr[k]){
					int tmp=arr[i];
					arr[i]=arr[k];
					arr[k]=tmp;
				}
			}
		}
	}

	/**
	 * 插入排序：
	 * 选择数组中的一个元素，将剩下的所有元素一个一个的根
	 * 该元素进行比较，然后插入到该元素的前面或者后面。
	 */
	public static void insertSort(int[] arr){
		int num;
		for(int i=1;i<arr.length;i++){
			num=arr[i];
			for(int k=i-1;k>=0;k--){
				if(num<arr[k]){
					arr[k+1]=arr[k];
					arr[k]=num;
				}else{
					break;
				}
			}
		}
	}
}
