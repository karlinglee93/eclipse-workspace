package com.javaeasy.usemap;						// 例程在的包

import java.util.HashMap;							// 引入所需要的类
import java.util.Map;

import com.javaeasy.compare.Student;
import com.javaeasy.genericstypes.NoGenericsTypes;

public class UseMap {								// 例程
	public static void main(String[] args) {		// main()方法
		Map students = new HashMap();				// 创建一个HashMap实例
		Student stu1 = new Student("刘伟", 1);		// 创建两个Student实例
		Student stu2 = new Student("成秋", 2);
		// 以Student实例的name属性为键值，Student为值，将它们加入到Map中
		students.put(stu1.getName(), stu1);
		students.put(stu2.getName(), stu2);
		String stuName = "成秋";				// 要寻找的学生的名字
		Student findStu = (Student) students.get(stuName);
												// 使用get()方法寻找对应的值
		NoGenericsTypes.printStudentProps(findStu);		// 输出结果
	}
}
