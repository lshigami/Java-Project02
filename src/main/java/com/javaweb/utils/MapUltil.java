package com.javaweb.utils;

import java.util.List;
import java.util.Map;

import javax.crypto.interfaces.PBEKey;

public class MapUltil {
	public static<T> T getObject(Map<String, Object> params,String key,Class<T>tClass ) {
		Object object = params.getOrDefault(key,null);
		if(object!=null) {
			if(tClass.getTypeName().equals("java.lang.Long")) {
				object= object!="" ? Long.valueOf(object.toString()) : null;
			}
			else if (tClass.getTypeName().equals("java.lang.String")) {
				object= object.toString();
			}
			return tClass.cast(object);
		}
		
		return null;
	}
}
