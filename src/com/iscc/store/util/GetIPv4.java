package com.iscc.store.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class GetIPv4 {

	private GetIPv4() {

	}

	public static String getInetAddress() {
		try {
			Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
			while (allNetInterfaces.hasMoreElements()) {
				NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
				Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
				while (addresses.hasMoreElements()) {
					InetAddress ip = (InetAddress) addresses.nextElement();
					// loopback地址即本机地址，IPv4的loopback范围是127.0.0.0
					// ~ 127.255.255.255
					if (ip != null && ip instanceof Inet4Address && !ip.isLoopbackAddress() 
							&& ip.getHostAddress().indexOf(":") == -1) {
						return ip.getHostAddress();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
