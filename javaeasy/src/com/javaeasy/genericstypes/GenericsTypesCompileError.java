package com.javaeasy.genericstypes;

import java.util.ArrayList;
import java.util.List;

import com.javaeasy.compare.Student;

public class GenericsTypesCompileError {
	public void test() {
		// 使用泛型，将Student作为类型参数传递
		List<Student> stuList = new ArrayList<Student>();
		String str = "str";
		stuList.add(str);				// 错误，只能添加Student类型的元素
	}
}
