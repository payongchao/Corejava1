package com.briup.jd1721.corejava.day28;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapDemo_0010{
	public static void main(String[] args){
		/**
		 * Map的映射关系存储<座位号，学生姓名>
		 */
		// 1.向Map集合中添加元素（键值对）
		Map<Integer,String> map=new HashMap<>();
		map.put(1,"zhangsan");
		map.put(3,"wangwu");
		map.put(2,"lisi");
		map.put(4,"zhaoliu");

		// 添加相同的键，返回的是上一个值
		//System.out.println(map.put(2,"qianqi"));

		// 添加的键为null
		//map.put(null,"sunba");
		//map.put(null,"sunba1");

		// 添加的值为null
		//map.put(5,null);
		//map.put(6,null);

		// 通过键来获取值
		//System.out.println(map.get(1));
		//System.out.println(map.get(2));

		// 既然能够通过键得到值，
		// 能不能获取到所有的键，
		// 然后遍历这些键，获取到所有的值？

		// 可以通过keySet方法先获取到所有的键组成的集合
		// 然后遍历该集合得到每一个键，
		// 然后通过map的get()方法，传递上面得到的每一个
		// 键作为参数，就可以得到每一个值。
		//Set<Integer> keys=map.keySet();
		//for(Integer key:keys){
		//	System.out.println(key+"="+map.get(key));
		//}

		// 通过remove方法删除元素（映射关系/键值对）
		//System.out.println(map.remove(1));
		//System.out.println(map.remove(2));
		//System.out.println(map.remove(3));

		// 能不能通过某个方法拿到值的集合？
		// 能，就是那个values()方法。
		// 但是，不能通过遍历值拿到键。
		//Collection<String> values=map.values();
		//System.out.println(values);

		// 能不能拿到键值对的集合呢？？？
		// 能，通过entrySet方法可以拿到。
		Set<Entry<Integer,String>> entries
			=map.entrySet();
		for(Entry<Integer,String> en:entries){
			Integer key=en.getKey();
			String value=en.getValue();
			System.out.println(key+"="+value);
		}

		// 打印map
		System.out.println(map);
	}
}
