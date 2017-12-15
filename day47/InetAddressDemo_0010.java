package com.briup.jd1721.corejava.day47;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo_0010{
	public static void main(String[] args)
			throws UnknownHostException{
		InetAddress ia=
			InetAddress.getByName("www.baidu.com");
		// 180.97.33.108
		// 180.97.33.107

		String ip=ia.getHostAddress();
		System.out.println(ip);

		String hn=ia.getHostName();
		System.out.println(hn);
	}
}
