package com.techelevator.bike;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BIkeApp {

	public static void main(String[] args) {
		
		BigDecimal bd = new BigDecimal(100);
		bd.add(new BigDecimal(50));
		
		

       Bike bike = new Bike(4, "Blue", "Trek");
//       bike.setBrand("Trek");
//       bike.setColor("Blue");
//       bike.setNumberOfGears(10);
       
       BMXBike bmx = new BMXBike(1, "Black", "Huffy", false);
//       bmx.setBrand("Huffy");
//       bmx.setColor("Black");
//       bmx.setNumberOfGears(1);
//       bmx.setHasPegs(true);
       
      
       MountainBike mb = new MountainBike(20, "Green", "Specialized");
       //mb.setBrand("Specialized");
       
       
       List<Bike> bikeList = new ArrayList<Bike>();
       
       bikeList.add(mb);
       bikeList.add(bmx);
       
       for (Bike b : bikeList) {
    	   System.out.println(b.getBrand());
    	   if (b instanceof BMXBike) {
    		   System.out.println(b.ride());
    		   
    	   }
    	   System.out.println(b.ride());
    	   System.out.println(b.toString());
	}

}
}
