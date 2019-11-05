package com.iscc.store.text;

import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.iscc.store.util.Md5Utils;
import com.iscc.store.util.myDBConnection;

public class MyTest1 {

	@Test
	public void testConnection() {

		Connection conn = myDBConnection.getConnection();

		System.out.println(conn);

	}

	@Test
	public void testIPv4() {
		try {
			Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
			while (allNetInterfaces.hasMoreElements()) {
				NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
				Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
				while (addresses.hasMoreElements()) {
					InetAddress ip = (InetAddress) addresses.nextElement();
					if (ip != null && ip instanceof Inet4Address && !ip.isLoopbackAddress() // loopback地址即本机地址，IPv4的loopback范围是127.0.0.0
																							// ~ 127.255.255.255
							&& ip.getHostAddress().indexOf(":") == -1) {
						System.out.println("本机的IP = " + ip.getHostAddress());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testMd5() {
		String str = "tom";
		String newStr = null;
		try {
			newStr = Md5Utils.EncoderByMd5(str);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(newStr);
	}

	@Test
	public void testNewUUID() {

		String str1 = UUID.randomUUID().toString();
		String str2 = UUID.randomUUID().toString();
		str2 += str1;

		str2 = str2.replace("-", "");
		System.out.println(str2);
		System.out.println(str2.length());
	}

}
