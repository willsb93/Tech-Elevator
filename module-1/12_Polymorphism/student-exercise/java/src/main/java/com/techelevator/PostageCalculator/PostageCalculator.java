package com.techelevator.PostageCalculator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostageCalculator {

	public static void main(String[] args) {

		FirstClass postalFirst = new FirstClass();
		SecondClass postalSecond = new SecondClass();
		ThirdClass postalThird = new ThirdClass();
		FexEd fexEd = new FexEd();
		SPU2DayBusiness spu2Days = new SPU2DayBusiness();
		SPU4DayGround spu4Days = new SPU4DayGround();
		SPUNextDay spuNextDay = new SPUNextDay();
		List<IDeliveryDriver> listWithValues = new ArrayList<IDeliveryDriver>();

		listWithValues.add(postalFirst);
		listWithValues.add(postalSecond);
		listWithValues.add(postalThird);
		listWithValues.add(fexEd);
		listWithValues.add(spu4Days);
		listWithValues.add(spu2Days);
		listWithValues.add(spuNextDay);

		Double packageWeight = 0.0;
		String weightUnit = "";
		int miles = 0;

		System.out.println("Please enter the weight of the package:");
		Scanner input = new Scanner(System.in);
		packageWeight = input.nextDouble();

		System.out.println("Is the weight in (O)unces or (P)ounds?");
		input.nextLine();
		weightUnit = input.nextLine().toLowerCase();

		if (weightUnit.equals("p")) {
			packageWeight = packageWeight * 16; // converts to ounces
		}

		System.out.println("What distance will it be traveling?");
		miles = input.nextInt();

		System.out.println(String.format("%-28s | %-10s ", "Delivery Method", "Cost"));
		System.out.println("***********************************");
		for (IDeliveryDriver print : listWithValues) {
			System.out.println(
					String.format("%-28s | %-10s", print.getName(), "$" + print.calculateRate(miles, packageWeight)));
		}
	}

}
