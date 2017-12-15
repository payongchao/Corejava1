package com.briup.jd1721.corejava.day28;

import java.util.HashMap;
import java.util.Map;

public class MapDemo_0020{
	/**
	 * bweajbsgwlzmsswqdsaasmzl
	 *
	 * 思路：
	 * 	1.将字符串转化成字符数组
	 * 	2.遍历数组，得到每一个字符
	 * 	3.创建一个Map集合
	 * 	4.将上面得到每一个字符向Map中添加，在添加之前先
	 * 	  判断该字符在Map中的keys中是否存在？
 	 *    如果不存在，将该字符存储到key中，value存1。
     *    如果存在，将该字符存储到key中，value值是通过
     *    该字符取出原来的value值，加1之后再存入value位置。
	 */
	public static void main(String[] args){
		String string="bweajbsgwlzmsswqdsaasmzl";
		char[] chars=string.toCharArray();
		Map<Character,Integer> map=new HashMap<>();
		for(char c:chars){
			if(!(map.containsKey(c))){
				map.put(c,1);
			}else{
				Integer time=map.get(c);
				map.put(c,time+1);
			}
			//map.put(c,map.containsKey(c)?map.get(c)+1:1);
		}
		System.out.println(map);
	}
}
