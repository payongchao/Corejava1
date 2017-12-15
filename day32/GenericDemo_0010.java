package com.briup.jd1721.corejava.day32;

public class GenericDemo_0010{
}

/**
 * 子类继承父类：
 * 		如果父类有泛型，子类没有泛型，必须对父类的泛型进行泛型确定。
 * 		子父类都有泛型，
 * 			要么子类继承父类的泛型；
 * 			要么子类有自己的泛型，但是父类的泛型必须进行泛型确定。
 */


class Father<T>{

}

class Son<V> extends Father<String>{

}

