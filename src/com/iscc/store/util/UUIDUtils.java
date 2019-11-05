package com.iscc.store.util;

import java.util.UUID;

public class UUIDUtils {

	private UUIDUtils() {

	}

	public static String getNewUUID() {

		String str1 = UUID.randomUUID().toString();
		String str2 = UUID.randomUUID().toString();
		str2 += str1;

		str2 = str2.replace("-", "");
		
		return str2;
	}

}
