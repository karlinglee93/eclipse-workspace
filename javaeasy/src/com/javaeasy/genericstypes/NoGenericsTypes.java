package com.javaeasy.genericstypes;			// 程序所在的包

import java.util.ArrayList;						// 引入需要使用的类
import java.util.List;
import com.javaeasy.compare.Student;

public class NoGenericsTypes {

	public static void main(String[] args) {	// main()方法
		Student stu = new Student("刘伟", 1);	// 创建一个Stusdent类的实例
		// (1) 创建一个ArrayList 的实例，尖括号中的内容是指定此列表中元素的类型
		List<Student> students = new ArrayList<Student>();
		// (2) 将stu 放入List 中，此时students 只能够添加student 类型的元素
		students.add(stu);
		// (3) 得到第一个元素，因为使用了泛型，所以无需强制类型转换
		Student stuFromList = students.get(0);
		printStudentProps(stuFromList);		// 传递给printStudent-
												// Props()方法
	}

	public static void printStudentProps(Student stu) {
												// 输出stu对象的属性
		System.out.println("学生姓名：" + stu.getName());
		System.out.println("学生编号：" + stu.getNumber());
	}
}
