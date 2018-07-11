package com.jianinglee.main;

//class Dog extends Animal{
//	   public void move(){
//	      System.out.println("狗可以跑和走");
//	   }
//	   public void bark(){
//	      System.out.println("狗可以吠叫");
//	   }
//	}

class Dog extends Animal{
	   public void move(){
	      super.move(); // 应用super类的方法
	      System.out.println("狗可以跑和走");
	   }
}