package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /*
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */

		// ### EXAMPLE:
		int initialNumberOfBirds = 4;
		int birdsThatFlewAway = 1;
		int remainingNumberOfBirds = initialNumberOfBirds - birdsThatFlewAway;

        /*
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */

		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;

        /*
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
			int raccoonsPlaying = 3;
			int raccoonsThatWentHome = 2;
			int raccoonsLeft = raccoonsPlaying - raccoonsThatWentHome;
        /*
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
			int flowers = 5;
			int bees = 3;
			int difference = flowers - bees;
        /*
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
			int pigeonEating = 1;
			int pigeonThatJoinedToEat = 1;
			int totalOfPigeonsEating = pigeonEating + pigeonThatJoinedToEat;
        /*
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
			int owlsSittingOnFence = 3;
			int owlsThatJoined = 2;
			int totalOwlsOnFence = owlsSittingOnFence + owlsThatJoined;
        /*
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
			int beaversWorking = 2;
			int beaversSwimming = 1;
			int beaversLeftWorking = beaversWorking - beaversSwimming;
        /*
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
			int toucansSitting = 2;
			int toucansThatJoined = 1;
			int totalToucans = toucansSitting + toucansThatJoined;
        /*
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
			int squirrelsInTreesWithNuts = 4;
			int nuts = 2;
			int differenceBetweenSquirrelsAndNuts = squirrelsInTreesWithNuts - nuts;
        /*
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
			int quarter = 25;
			int dime = 10;
			int nickel = 5;
			int numberOfNickels = 2;
			
			float totalAmount = (float)(quarter + dime + (nickel * numberOfNickels))/100;
			
        /*
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
			int brierClassMuffin = 18;
			int macAdamClassMuffin = 20;
			int flanneryClassMuffin = 17;
			
			int hiltFirstGradeTotalMuffins = brierClassMuffin + macAdamClassMuffin + flanneryClassMuffin;
			
			
        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
			int yoyoCost = 24;
			int whistleCost = 14;
			float totalCostToys = (float)(yoyoCost + whistleCost)/100;
        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
			 int largeMarshmallows = 8;
			 int miniMarshmallows = 10;
			 int totalMarshmallows = largeMarshmallows + miniMarshmallows;
        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
			 int hiltHouseSnow = 29;
			 int brecknockSchoolSnow  = 17;
			 int snowDifferenceAtHiltHouse = hiltHouseSnow - brecknockSchoolSnow;
        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */
			    int hiltTotalMoney = 10;
				int toyTruckCost = 3;
				int pencilCaseCost = 2;
				
				int hiltMoneyLeft = hiltTotalMoney - toyTruckCost - pencilCaseCost;
        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
				int joshTotalMarbles = 16;
				int joshLostMarbles = 7;
				int joshRemainingMarbles = joshTotalMarbles - joshLostMarbles;
        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
				int meganSeashells = 19;
				int desiredSeashells = 25;
				int numberSeashellsNeeded = desiredSeashells - meganSeashells;
        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
				 int bradBallons = 17;
				 int bradRedBallons = 8;
				 int bradGreenBallons = bradBallons - bradRedBallons;
        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
				 int shelfBooks = 38;
				 int addedBooks = 10;
				 
				 int totalShelfBooks = shelfBooks + addedBooks;
        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
				 int beeLegs = 6;
				 int beesRightHere = 8;
				 
				 int totalLegs = beeLegs * beesRightHere;
        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
				    int iceCreamCost = 99;
					int amountIceCream = 2;
					
					float totalIceCreamCost = (float)(iceCreamCost * amountIceCream) /100;
        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
					int hiltRocksOwned = 64;
					int hiltRocksGoal = 125;
					
					int hiltRocksNeeded = hiltRocksGoal - hiltRocksOwned;
        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
					int hiltMarbles = 38;
					int hiltMissedMarbles = 15;
					
					int hiltMarblesLeft = hiltMarbles - hiltMissedMarbles;
        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
					int concertDistance = 78;
					int milesDriven = 32;
					
					int milesLeft = concertDistance - milesDriven;
        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */
					int hourToMinutes = 1 * 60;
					int remainingMinutes = 75;
					
					int totalTimeMinutes = hourToMinutes + remainingMinutes;
					float totalTimeHours = (float)totalTimeMinutes / 60;	
        /*
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
					int hotDogsBought = 6;
					int hotDogCost = 50;
					
					float totalHotDogsCost = (float) (hotDogsBought * hotDogCost) /100;	
        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
					float hiltCash = 0.50f;
					float pencilCost = 0.07f;
					
					int pencilsAcquirable =  (int) (hiltCash / pencilCost) ;
        /*
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
					int butterfliesSaw = 33;
					int orangeButterflies = 20;
					
					int redButterflies = butterfliesSaw - orangeButterflies;
        /*
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
					int moneyGivenInCents = 1 * 100;
					int productCostInCents = 54;
					
					float change = (float) (moneyGivenInCents - productCostInCents) /100;
        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
					int treesInBackyard = 13;
					int treesPlanted = 12;
					
					int totalTrees = treesInBackyard + treesPlanted;
        /*
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
					int daysLeft = 2;
					int hoursInDay = 24;
					
					int hoursLeft = daysLeft * hoursInDay;
        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
					int kimCousins = 4;
					int gumToEach = 5;
					
					int gumNeeded = kimCousins * gumToEach;	
        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
					int danCash = 3;
					int candyBarCost = 1;
					
					int cashLeft = danCash - candyBarCost;
        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
					int boatsInLake = 5;
					int peopleInEachBoat = 3;
					
					int peopleInBoats = boatsInLake * peopleInEachBoat;
        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
					int ellenLegos = 380;
					int legosLost = 57;
					
					int legosLeft = ellenLegos - legosLost;
        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
					int arthurBakedMuffins = 35;
					int arthurGoalMuffins = 83;
					
					int muffinsLeftToBake = arthurGoalMuffins - arthurBakedMuffins;
        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
					int willyCrayons = 1400;
					int lucyCrayons = 290;
					
					int differenceInCrayons = willyCrayons - lucyCrayons;
        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
					int stickersOnPage = 10;
					int numberOfPages = 22;
					
					int totalStickers = stickersOnPage * numberOfPages;
        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
					int totalCupcakes = 96;
					int totalChildren =  8;
					
					int shareOfCupcakes = totalCupcakes / totalChildren;
        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */
					int totalGingerbread = 47;
					int jarCapacity = 6;
					
					int cookiesLeftOutside = totalGingerbread % jarCapacity;
        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */
					int totalCroissants = 59;
					int neighboorsToGetCroissants = 8;
					
					int croissantsLeftToMarian = totalCroissants % neighboorsToGetCroissants;
        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
					int oatmealCookiesGoal = 276;
					int trayCookieCapacity = 12;
					
					int traysNeeded = oatmealCookiesGoal / trayCookieCapacity;
        /*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
					 
					int totalPretzels = 480;
					int oneServing = 12;
					
					int amountsOfServing = totalPretzels / oneServing;
        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
					int lemonCupcakes = 53;
					int cupcakesLeftAtHome = 2;
					int cupcakesInABox = 3;
					
					int boxesGiven = (lemonCupcakes - cupcakesLeftAtHome) / cupcakesInABox;
        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
					 
					int carrotSticks = 74;
					int peopleEating = 12;
					
					int carrotLeftOut = carrotSticks % peopleEating;
        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
					int teddyBears = 98;
					int shelfCapacity = 7;
					
					int numberOfShelvesFilled = teddyBears / shelfCapacity;
        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
					int albumCapacity = 20;
					int pictures = 480;
					
					int albumsNeeded = pictures / albumCapacity;
        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
					int tradingCards = 94;
					int boxCapacity = 8;
					
					int boxesFilled = tradingCards % boxCapacity;
					 
							
        /*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
					int numberOfBooks = 210;
					int shelvesAvailable = 10;
					
					int booksPerShelf = numberOfBooks / shelvesAvailable;
        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
					int croissants = 17;
					int guests = 7;
					
					int croissantsPerGuest = croissants / guests;
        /*
            CHALLENGE PROBLEMS
        */

        /*
        Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
        1.90 hours. How long will it take the two painter working together to paint 5 12 x 14 rooms?
        Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
        Challenge: How many days will it take the pair to paint 623 rooms assuming they work 8 hours a day?.
        */
					float billFeetTimeHourly = (12*14) / 2.15f;
					float jillFeetTimeHourly = (12*14) /1.90f;
					
					float hourlyFeetRateCombined = billFeetTimeHourly + jillFeetTimeHourly ; 
					float wallsFeetCombined = 5 * (12*14) / hourlyFeetRateCombined;
					
					float finalAnswer = wallsFeetCombined;
					
					//challenge below
					
					float daysFor623Rooms = 623 * (12*14) / (hourlyFeetRateCombined * 8);
        /*
        Create and assign variables to hold your first name, last name, and middle initial. Using concatenation,
        build an additional variable to hold your full name in the order of last name, first name, middle initial. The
        last and first names should be separated by a comma followed by a space, and the middle initial must end
        with a period.
        Example: "Hopper, Grace B."
        */
					String firstName = "William";
					String lastName = "Rabuske";
					String middleInitial = "M";
					
					String fullName = lastName + "," + " " + firstName + " " + middleInitial + ".";
        /*
        The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
        What percentage of the trip has been completed?
        Hint: The percent completed is the miles already travelled divided by the total miles.
        Challenge: Display as an integer value between 0 and 100 using casts.
        */
					int distanceBetweenCities = 800;
					int distanceTravelled = 537;
					float completed = (float) distanceTravelled / distanceBetweenCities;
					int percentageCompleted = (int)(completed * 100);
					
					System.out.println(percentageCompleted);
	}

}
