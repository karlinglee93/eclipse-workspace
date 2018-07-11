package com.javaeasy.genericstypes;			// 程序所在的包

import java.util.ArrayList;						// 引入需要使用的类
import java.util.List;
import com.javaeasy.compare.Student;

public class NoGenericsTypes {

	public static void main(String[] args) {	// main()方法
		Student stu = new Student("刘伟", 1);	// 创建一个Stusdent类的实例
		List students = new ArrayList();		// 创建一个ArrayList的实例
		students.add(stu);						// 将stu放入List中
		Student stuFromList = (Student) students.get(0);
												// 得到第一个元素，强制类型转换
		printStudentProps(stuFromList);		// 传递给printStudent-
												// Props()方法
	}

	public static void printStudentProps(Student stu) {
												// 输出stu对象的属性
		System.out.println("学生姓名：" + stu.getName());
		System.out.println("学生编号：" + stu.getNumber());
	}
}
