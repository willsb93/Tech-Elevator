package com.techelevator;

public class Scratchpad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//
		String name = "Tech Elevator";
		String name2 = new String("I am a string too");
		
		char c = name.charAt(5);
		System.out.println(c);
		
		int rs = name.compareTo(name2);
		System.out.println(rs);
		
		name = name.concat(name2);
		System.out.println(name);
		
		if (name.contains("ch")) {
			System.out.println("Yes");
		}
		else {
			System.out.println("Not found");
		}
		
		if (name.endsWith("too")) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
		
		int index = name.indexOf("I");
		System.out.println(index);
		
		System.out.println(name.length());
		
		if (name.length() >= 2) {
			
		}
		
	    String firstPart = name.substring(8);
	    System.out.println(firstPart);
	    
	    String middlePart = name.substring(5,8);
	    System.out.println(name);
	    System.out.println(middlePart);
	    
	    System.out.println(name.toLowerCase());
	    System.out.println(name.toUpperCase());
	    
	    String var1 = "    my user input  ";
	    System.out.println("[" + var1+ "]");
	    System.out.println("[" + var1.trim() + "]");
	
		
		
		
				
				
		
		
		
		
		
		
		

	}

}
