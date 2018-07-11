package com.javaeasy.compare;						// 程序所在的包

import javax.print.attribute.standard.Sides;

public class Student {	
	private String name;							// 姓名
	private int number;								// 编号// 类名
	
	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}

	public Student(String name, int number) {		// 构造方法
		this.name = name;
		this.number = number;
	}

	// 此处省略对于属性name和number的get 和 set方法

	public boolean equals(Object objStu) {		// 覆盖Object类的equals()
												// 方法
		if (!(objStu instanceof Student)) {	// 首先判断对方是不是Student
												// 类的对象
			return false;						// 不是则直接判定两个对象不等
		}
		Student other = (Student) objStu;		// 强制类型转换为Student
		// 比较两者的name属性和number属性是否都相等，是则返回true，否则返回false
		return (name.equals(other.name)) && (number == other.number);
	}
	public int hashCode() {
		final int prime = 31;					// 使用素数生成其hashCode
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + number;
		return result;
	}
	
	public static void main(String[] args) {
		Student s1 = new Student("Karlinglee", 1120161156);
		Student s2 = new Student("KarlingLee", 1120161156);
		
		System.out.println("用equals() 方法判断s1 和s2 是否相等: " + 	s1.equals(s2));
		int hashcode1 = s1.hashCode();
		int hashcode2 = s2.hashCode();
		System.out.println("s1 的hashcode 为: " + hashcode1);
		System.out.println("s2 的hashcode 为: " + hashcode2);
		if (hashcode1 == hashcode2) {
			System.out.println("s1 与s2 的hashcode 值相等，故s1 与s2 相等");
		} else {
			System.out.println("s1 与s2 的hashcode 值不等，故s1 与s2 不等");
		}
	}
}
