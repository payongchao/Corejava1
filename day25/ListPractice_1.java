package com.briup.jd1721.corejava.day25;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListPractice_1{
	public static void main(String[] args){
		List list=new ArrayList();
		list.add("briup01");
		list.add("briup01");
		list.add("briup01");
		list.add("briup02");
		list.add("briup02");
		list.add("briup02");
		list.add("briup03");
		list.add("briup01");
		list.add("briup02");
		list.add("briup02");
		list.add("briup01");
		/**
		 *去重思路2：
		 * 使用两个嵌套的for循环，来遍历原集合，
		 * 每个循环可以得到一个元素，然后判断该两元素
		 * 是否相等，如果相等，干掉内层循环得到的那个元素。
		 * 如果不相等，内层循环继续遍历，得到下一个元素，
		 * 和外层循环的那个元素再次进行判断。直到所有的元素
		 * 都判断完成为止。
		 */
		/**
		 * 下面注释掉的for循环会出现bug：
		 * 在遍历并且比较的过程中会漏掉一部分元素。
		 * 造成高bug的原因是：remove()方法，因为在使用
		 * remove()方法删除元素之后，该位置后面的元素
		 * 必须向前移动，以保证索引的连续性。
		 * 解决方案：
		 */
		//for(int i=0;i<list.size();i++){
		//	Object o1=list.get(i);
		//	for(int j=i+1;j<list.size();j++){
		//		Object o2=list.get(j);
		//		if(o1.equals(o2)){
		//			list.remove(j);
		//		}
		//	}
		//}

		for(int i=0;i<list.size();i++){
				Object o1=list.get(i);
				for(int j=i+1;j<list.size();j++){
					Object o2=list.get(j);
					if(o1.equals(o2)){
						list.remove(o2);
						j--;
					}
				}
		}
		System.out.println(list);
	}

	public static void practice_1(){
		List list=new ArrayList();

		list.add("briup01");
		list.add("briup01");
		list.add("briup02");
		list.add("briup02");
		list.add("briup03");

		/**
		 * 去重的思路1：
		 * 重新创建一个新的集合，然后遍历原集合中的元素，
		 * 得到一个元素就往新集合中添加，在添加之前先判断
		 * 该元素在新集合中是否存在，如果存在，则不添加到
		 * 新集合中；如果不存在，则添加到新集合中。那么，
		 * 最后形成的新集合就是去重的结果。
		 */

		// 1.创建新的集合
		List temp=new ArrayList();
		// 2.遍历原集合
		Iterator iterator=list.iterator();
		while(iterator.hasNext()){
			// 3.每次迭代得到原集合中的一个元素，
			//   存储到next变量中
			Object next=iterator.next();
			// 4.判断该元素是否存在于新创建的集合中
			if(temp.contains(next)){
				continue;
			}else{
				temp.add(next);
			}
		}
		// 5.遍历原集合结束之后所形成的temp集合
		// 就是去重之后的结果
		System.out.println(temp);
	}
}
