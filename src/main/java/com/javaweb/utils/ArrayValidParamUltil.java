package com.javaweb.utils;

import java.util.List;

public class ArrayValidParamUltil {
	public static <T> boolean isExistParam(List<T>lst) {
		return lst!=null && !lst.isEmpty();
	}
}
