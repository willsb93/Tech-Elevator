package com.techelevator.overloadingexample;

public class CalcApp {

	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
		
		int rs = calc.add(2, 3);
		System.out.println("Answer is: " + rs);
		
		int rs1 = calc.add(1, 2, 3);
		System.out.println("Answer is: " + rs1);
	
		int[] nums1 = new int[] {2,3,4,5,6,7,8,9};
		int rs2 = calc.add(nums1);
		System.out.println("Answer is: " + rs2);
		
		int[] nums2Array = new int[] {2,3,4,5,6};
		int rs3 = calc.add(nums2Array);
		System.out.println("Answer is: " + rs3);
		
	}

}
