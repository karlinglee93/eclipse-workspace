package control;

import javax.swing.JFrame;

public class DebugTest {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		System.out.println(123456);
//		System.out.println(true);
//		System.out.println("this is a String debug info");
//		System.out.println(new JFrame() {
//			@Override
//			public String toString() {
//				// TODO Auto-generated method stub
//				return "This is a JFrame";
//			}
//		});
//		System.err.println("this is a String debug info");	// 红色代码输出错误信息
		
//		int[] ints = new int[20];
//		for (int i = 0; i < ints.length; i++) {
//			ints[i]= i + 1;
//			System.out.println(ints[i]);
//		}
		
		int[] ints = new int[20];
		try {
			for (int i = 0; i < 21; i++) {
				ints[i]= i + 1;
				System.out.println(ints[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("数组越界！");
		}		
		
	}

}
