package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercises {

	/*
	 * Map Exercises
	 */

	/*
	 * Given the name of an animal, return the name of a group of that animal (e.g.
	 * "Elephant" -> "Herd", "Rhino" - "Crash").
	 *
	 * The animal name should be case insensitive so "elephant", "Elephant", and
	 * "ELEPHANT" should all return "herd".
	 *
	 * If the name of the animal is not found, null, or empty, return "unknown".
	 *
	 * Rhino -> Crash Giraffe -> Tower Elephant -> Herd Lion -> Pride Crow -> Murder
	 * Pigeon -> Kit Flamingo -> Pat Deer -> Herd Dog -> Pack Crocodile -> Float
	 *
	 * animalGroupName("giraffe") → "Tower" animalGroupName("") -> "unknown"
	 * animalGroupName("walrus") -> "unknown"
	 *
	 */
	public String animalGroupName(String animalName) {

		Map<String, String> groupName = new HashMap<String, String>();
		groupName.put("rhino", "Crash");
		groupName.put("giraffe", "Tower");
		groupName.put("elephant", "Herd");
		groupName.put("lion", "Pride");
		groupName.put("crow", "Murder");
		groupName.put("pigeon", "Kit");
		groupName.put("flaming", "Pat");
		groupName.put("deer", "Herd");
		groupName.put("dog", "Pack");
		groupName.put("crocodile", "Float");

		String animalNameLowerCase = animalName.toLowerCase();

		for (String check : groupName.keySet())

			if (check.equals(animalNameLowerCase)) {

				return groupName.get(animalNameLowerCase);
			}
		return "unknown";

	}

	/*
	 * Given an String item number (a.k.a. SKU), return the discount percentage if
	 * the item is on sale. If the item is not on sale, return 0.00.
	 *
	 * If the item number is empty or null, return 0.00.
	 *
	 * "KITCHEN4001" -> 0.20 "GARAGE1070" -> 0.15 "LIVINGROOM" -> 0.10 "KITCHEN6073"
	 * -> 0.40 "BEDROOM3434" -> 0.60 "BATH0073" -> 0.15
	 *
	 * The item number should be case insensitive so "kitchen4001", "Kitchen4001",
	 * and "KITCHEN4001" should all return 0.20.
	 *
	 * isItOnSale("kitchen4001") → 0.20 isItOnSale("") → 0.00
	 * isItOnSale("GARAGE1070") → 0.15 isItOnSale("dungeon9999") → 0.00
	 *
	 */
	public Double isItOnSale(String itemNumber) {
		Map<String, Double> discountList = new HashMap<String, Double>();
		discountList.put("KITCHEN4001", 0.20);
		discountList.put("GARAGE1070", 0.15);
		discountList.put("LIVINGROOM", 0.10);
		discountList.put("KITCHEN6073", 0.40);
		discountList.put("BEDROOM3434", 0.60);
		discountList.put("BATH0073", 0.15);

		String listToLowerCase = itemNumber.toUpperCase();
		Double noValueFound = 0.00;

		for (String check : discountList.keySet())

			if (check.equals(listToLowerCase)) {

				return discountList.get(listToLowerCase);
			}

		return noValueFound;
	}

	/*
	 * Modify and return the given map as follows: if "Peter" has more than 0 money,
	 * transfer half of it to "Paul", but only if Paul has less than $10s.
	 *
	 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100,
	 * ... $10=1000, ...
	 *
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul":
	 * 1099} robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000,
	 * "Paul": 30000}
	 *
	 */
	public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {

		Map<String, Integer> scammedPeter = new HashMap<String, Integer>();
		int paul = peterPaul.get("Paul");
		int peter = peterPaul.get("Peter");
		int halfOfPeter = peter / 2;
		int moneyForPaul = paul + halfOfPeter;

		if (peter > 0 && paul < 1000) {
			scammedPeter.put("Peter", halfOfPeter);
			scammedPeter.put("Paul", moneyForPaul);
			return scammedPeter;
		}

		return peterPaul;
	}

	/*
	 * Modify and return the given map as follows: if "Peter" has $50 or more, AND
	 * "Paul" has $100 or more, then create a new "PeterPaulPartnership" worth a
	 * combined contribution of a quarter of each partner's current worth.
	 *
	 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100,
	 * ... $10=1000, ...
	 * 
	 * peterPaulPartnership({"Peter": 5000, "Paul": 10000}) → {"Peter": 3750,
	 * "Paul": 7500, "PeterPaulPartnership": 3750} peterPaulPartnership({"Peter":
	 * 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
	 *
	 */
	public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) {
		Map<String, Integer> partnership = new HashMap<String, Integer>();
		int paul = peterPaul.get("Paul");
		int peter = peterPaul.get("Peter");
		int contributed = (paul * 25 / 100) + (peter * 25 / 100);
		int paul25 = paul - (paul * 25 / 100);
		int peter25 = peter - (peter * 25 / 100);

		if (peter >= 5000 && paul >= 10000) {
			partnership.put("Paul", paul25);
			partnership.put("Peter", peter25);
			partnership.put("PeterPaulPartnership", contributed);
			return partnership;
		}

		return peterPaul;
	}

	/*
	 * Given an array of non-empty strings, return a Map<String, String> where for
	 * every different string in the array, there is a key of its first character
	 * with the value of its last character.
	 *
	 * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
	 * beginningAndEnding(["man", "moon", "main"]) → {"m": "n"}
	 * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d",
	 * "m": "t", "n": "t"}
	 */
	public Map<String, String> beginningAndEnding(String[] words) {
		Map<String, String> startAndEnd = new HashMap<String, String>();
		char first;
		char last;
		String firstChar;
		String lastChar;
		for (int i = 0; i < words.length; i++) {
			first = words[i].charAt(0);
			last = words[i].charAt(words[i].length() - 1);
			firstChar = Character.toString(first);
			lastChar = Character.toString(last);

			startAndEnd.put(firstChar, lastChar);
		}

		return startAndEnd;
	}

	/*
	 * Given an array of strings, return a Map<String, Integer> with a key for each
	 * different string, with the value the number of times that string appears in
	 * the array.
	 *
	 * ** A CLASSIC **
	 *
	 * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2} wordCount([])
	 * → {} wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
	 *
	 */
	public Map<String, Integer> wordCount(String[] words) {

		Map<String, Integer> numberOfTimes = new HashMap<String, Integer>();

		for (String s : words) {
			if (!numberOfTimes.containsKey(s)) {
				numberOfTimes.put(s, 1);
			} else {
				int count = numberOfTimes.get(s);
				numberOfTimes.put(s, count + 1);
			}
		}
		return numberOfTimes;
	}

	/*
	 * Given an array of int values, return a Map<Integer, Integer> with a key for
	 * each int, with the value the number of times that int appears in the array.
	 *
	 * ** The lesser known cousin of the the classic wordCount **
	 *
	 * integerCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 1, 44: 1, 55: 1,
	 * 63: 3, 77: 1, 99:2} integerCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33:
	 * 4, 106: 1, 107: 3} integerCount([]) → {}
	 *
	 */
	public Map<Integer, Integer> integerCount(int[] ints) {

		Map<Integer, Integer> numberOfTimesNumbers = new HashMap<Integer, Integer>();

		for (int s : ints) {
			if (!numberOfTimesNumbers.containsKey(s)) {
				numberOfTimesNumbers.put(s, 1);
			} else {
				int count = numberOfTimesNumbers.get(s);
				numberOfTimesNumbers.put(s, count + 1);
			}
		}
		return numberOfTimesNumbers;
	}

	/*
	 * Given an array of strings, return a Map<String, Boolean> where each different
	 * string is a key and value is true only if that string appears 2 or more times
	 * in the array.
	 *
	 * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a": true}
	 * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
	 * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
	 *
	 */
	public Map<String, Boolean> wordMultiple(String[] words) {

		Map<String, Boolean> numberOfTimesMoreThan2 = new HashMap<String, Boolean>();

		for (String s : words) {
			if (!numberOfTimesMoreThan2.containsKey(s)) {
				numberOfTimesMoreThan2.put(s, false);
			} else {
				numberOfTimesMoreThan2.put(s, true);
			}

		}
		return numberOfTimesMoreThan2;
	}

	/*
	 * Given two maps, Map<String, Integer>, merge the two into a new map,
	 * Map<String, Integer> where keys in Map2, and their Integer values, are added
	 * to the Integer values of matching keys in Map1. Return the new map.
	 *
	 * Unmatched keys and their Integer values in Map2 are simply added to Map1.
	 *
	 * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11,
	 * "SKU4": 5}) → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
	 *
	 */
	public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse,
			Map<String, Integer> remoteWarehouse) {

		Map<String, Integer> consolidated = new HashMap<String, Integer>(mainWarehouse);
//		
//		for (String s : mainWarehouse.keySet())
//			consolidated.put(s, mainWarehouse.get(s));
//		
//		for (String s: remoteWarehouse.keySet()) {
//			if (consolidated.containsKey(s)) {
//				int add = consolidated.get(s);
//				consolidated.put(s, add +); I discovered the merge function after being stuck at this point.
//			}
//		}
//		
//		
//		return consolidated; 

		remoteWarehouse.forEach((k, v) -> consolidated.merge(k, v, Integer::sum));

		return consolidated;
	}

	/*
	 * Just when you thought it was safe to get back in the water ---
	 * last2Revisited!!!!
	 *
	 * Given an array of strings, for each string, the count of the number of times
	 * that a substring length 2 appears in the string and also as the last 2 chars
	 * of the string, so "hixxxhi" yields 1.
	 *
	 * We don't count the end substring, but the substring may overlap a prior
	 * position by one. For instance, "xxxx" has a count of 2, one pair at position
	 * 0, and the second at position 1. The third pair at position 2 is the end
	 * substring, which we don't count.
	 *
	 * Return Map<String, Integer>, where the key is string from the array, and its
	 * last2 count.
	 *
	 * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1,
	 * "xaxxaxaxx": 1, "axxxaaxx": 2}
	 *
	 */
	public Map<String, Integer> last2Revisited(String[] words) {
		return null;
	}
//		Map <String, Integer> last2 = new HashMap <String, integer> ();
//		String [] end = words[]
////		for (String s : words)
////			if (!last2.containsKey(s)) {
////				last2.put(s, 1);
////			if ()	
//				
//			                
//			    for(int i = 0; i < words.length - 2; i++) {
//			        if(words[i].inn   equals(end))
//			            count++;
//			    }
//			}
//		return null;
//	}

	/*
	 * Given a list of Strings, return a list that contains the distinct values. In
	 * other words, no value is to be included more than once in the returned list.
	 * (Hint: Think Set) distinctValues( ["red", "yellow", "green", "yellow",
	 * "blue", "green", "purple"] ) -> ["red", "yellow", "green", "blue", "purple"]
	 * distinctValues( ["jingle", "bells", "jingle", "bells", "jingle", "all",
	 * "the", "way"] ) -> ["jingle", "bells", "all", "the", "way"]
	 */
	public List<String> distinctValues(List<String> stringList) {

		List<String> myList = new ArrayList<String>();

		for (String s : stringList)
			if (!myList.contains(s)) {
				myList.add(s);
			}

		return myList;
	}

}
