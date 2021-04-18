/**
 * @author John Huynh, Riley Morrow
 * 
 * Date: 10/22/2019
 * Assignment:HomeWork 3 PurpleBox
 * Group 2
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class PurpleBox implements PurpleBoxAdminInterface, PurpleBoxUserInterface, Comparator<Item> {

	/**
	 * This declares a new Scanner object
	 */
	
	Scanner console = new Scanner(System.in);

	/**
	 * These are the data members and objects to be used
	 */

	public ArrayList<Item> userCart = new ArrayList<>();
	public ArrayList<Item> adminInventory = new ArrayList<Item>();
	public ArrayList<Item> filterInventory = adminInventory;
	private double volumeDiscountPercent = 0.0;
	private boolean checkOut = false;
	private boolean codeValid = false;
	
	/**
	 * These are the admin methods for the administrator
	 *
	 * This is a method to add the item to the inventory
	 */
	
	
	
	public void addToInv(int typeInput) {
		
		/**
		 * Try to add the item to the admin's inventory,
		 * based on the information provided
		 */
		
		try {
			
			/**
			 * If the admin enters 1 for a menu input,
			 * make admin enter the following movie information 
			 * and make the String isMovie = "Movie"
			 */
			
			if(typeInput == 1) {
				String isMovie = "Movie";
				try {
					
					/**
					 * User input to enter the movie name
					 * 
					 * @ensure movieName != null
					 */
					
					System.out.print("Enter the Movie Name: ");
					String movieName = console.next();
					movieName += console.nextLine();
					
					/**
					 * User input to enter the genre
					 * 
					 * @ensure movieGenre != null
					 */

					System.out.print("Enter the Genre:");
					String movieGenre = console.next();
					
					/**
					 * User input to enter the month of the release date
					 * 
					 * @ensure movieReleaseMonth > 0 && movieReleaseMonth < 13
					 */

					System.out.print("Enter the Release Date [Month]: ");
					int movieReleaseMonth = console.nextInt();
					
					/**
					 * User input to enter the day of the release date
					 * 
					 * @ensure movieReleaseDay > 0 && movieRelaseDay < 31
					 */

					System.out.print("Enter the Release Date [Day]: ");
					int movieReleaseDay = console.nextInt();
					
					/**
					 * User input to enter the year of the release date
					 * 
					 * @ensure movieReleaseYear != 0
					 */

					System.out.print("Enter the Release Date [Year]: ");
					int movieReleaseYear = console.nextInt();
					
					/**
					 * User input to enter the critics' score
					 * 
					 * @ensure movieRating >= 0.00 && movieRating <= 100.00
					 */

					System.out.print("Enter the Critic Score: ");
					double movieRating = console.nextDouble();
					
					/**
					 * User input to enter the quantity of stock
					 * 
					 * @ensure movieStock >= 0
					 */

					System.out.print("Enter the Amount of Stock: ");
					int movieStock = console.nextInt();
					
					/**
					 * User input to enter the price
					 * 
					 * @ensure moviePrice >= 0.00
					 */

					System.out.print("Enter the price of the movie: ");
					double moviePrice = console.nextDouble();
					
					/**
					 * User input to choose between DVD or Blu-Ray
					 * 
					 * @ensure movieType == "DVD" || movieType == "Blu-Ray"
					 */

					System.out.print("Enter if it is a DVD or Blu-Ray: ");
					String movieType = console.next();
					
					/**
					 * Add the filled information to the admin's inventory
					 */

					adminInventory.add(new Item(isMovie, movieType, movieGenre, movieName, movieRating, movieStock, moviePrice, movieReleaseDay, movieReleaseMonth, movieReleaseYear));
				}
				
				/**
				 * Print an error message, if an exception has occurred
				 */
				
				catch(Exception e) {
					System.out.println("An error has occurred. Try Again.");
				}


			}
			
			/**
			 * If admin enters option 2 in the menu,
			 * make admin enter game information below
			 * and declare the String to be "Game"
			 */
			
			else if(typeInput == 2) {
				String isGame = "Game";
				try {
					
					/**
					 * User input to enter the name of the game
					 * 
					 * @ensure gameName != null
					 */
					
					System.out.print("Enter the Game Name: ");
					String gameName = console.next();
					gameName += console.nextLine();
					
					/**
					 * User input to enter the genre
					 * 
					 * @ensure genre != null
					 */

					System.out.print("Enter the Genre: ");
					String gameGenre = console.next();

					/**
					 * User input to enter the month of the release date
					 * 
					 * @ensure gameReleaseMonth > 0 && gameReleaseMonth < 13
					 */
					
					System.out.print("Enter the Release Date [Month]: ");
					int gameReleaseMonth = console.nextInt();

					/**
					 * User input to enter the day of the release date
					 * 
					 * @ensure gameReleaseDay > 0 && gameReleaseDay < 31
					 */
					
					System.out.print("Enter the Release Date [Day]: ");
					int gameReleaseDay = console.nextInt();

					/**
					 * User input to enter the year of the release date
					 * 
					 * @ensure gameReleaseYear != 0
					 */
					
					System.out.print("Enter the Release Date [Year]: ");
					int gameReleaseYear = console.nextInt();
					
					/**
					 * User input to enter the critics' score
					 * 
					 * @ensure gameRating >= 0.00 && gameRating <= 100.00
					 */

					System.out.print("Enter the Critic Score: ");
					double gameRating = console.nextDouble();
					
					/**
					 * User input to enter the quantity of the stock
					 * 
					 * @ensure gameStock >= 0
					 */

					System.out.print("Enter the Amount of Stock: ");
					int gameStock = console.nextInt();

					/**
					 * User input to enter the price
					 * 
					 * @ensure gamePrice >= 0.00
					 */
					
					System.out.print("Enter the price of the game: ");
					double gamePrice = console.nextDouble();
					
					/**
					 * User input to enter whether it's X-Box or PS4
					 * 
					 * @ensure gameSystem == "X-Box" || gameSystem == "PS4"
					 */

					System.out.print("Enter if it is a X-Box or PS4: ");
					String gameSystemType = console.next();
					
					/**
					 * Add the game information provided to the admin's inventory
					 */

					adminInventory.add(new Item(isGame, gameSystemType, gameGenre, gameName, gameRating, gameStock, gamePrice, gameReleaseDay, gameReleaseMonth, gameReleaseYear));
				}
				
				/**
				 * Print an error message if an exception has occurred
				 */
				
				catch(Exception e) {
					System.out.println("An error has occurred. Try Again.");
				}

			/**
			 * Print an error message for invalid input
			 */
				
			}
			else {
				System.out.println("Invalid input, Try Again.");
			}
			
		/**
		 * Print an error message if an exception has occurred
		 */
			
		}
		catch(Exception e) {
			System.out.println("An error has occurred. Try Again.");
		}
	} //end addToInv method

	/**
	 * This method deals with restocking the inventory
	 */
	
	public void restock(String findItem, int addStock) {
		
		/**
		 * Try to sort the items in the inventory by name and find the index
		 */
		
		try {

			for(int i = 0; i < adminInventory.size(); i++) {
				
				/**
				 * Determines if the item is old or new
				 * and prints the information
				 */
				
				if(((Item) adminInventory.get(i)).getName().contains(findItem)) {
					System.out.println("[OLD]\n" + adminInventory.get(i).toString());

					int newStock = ((Item) adminInventory.get(i)).getStock() + addStock;
					((Item) adminInventory.get(i)).setStock(newStock);

					System.out.println("[NEW]\n" + adminInventory.get(i).toString());

					break;
				}
			}
		}
		
		/**
		 * Print an error message if an exception has occurred
		 */
		
		catch(Exception e) {
			System.out.println("An error has occurred. Try Again.");
		}

	} //end restock method

	/**
	 * This methods removes an item from the admin's inventory
	 */
	
	public void removeFromInv(String removeItem) {

		/**
		 * Find the index of the item searched
		 */
		
		int index = LinearSearchAdmin(adminInventory, removeItem);

		/**
		 * Verifies if the item exists and prints an error message
		 * if it's not found in the inventory
		 */
		
		if(index == -1) {
			System.out.println("Item was not found in the Inventory");
		}

		/**
		 * Remove the item from the inventory
		 */
		
		adminInventory.remove(index);

	} //end removeFromInv method
	
	/**
	 * This method changes the prices of inventory items
	 */
	
	public void changePrice(String forPriceChange, double newPrice) {

		/**
		 * Finds the item in the admin's inventory to change the price
		 */
		
		for(int i = 0; i < adminInventory.size(); i++) {
			if(((Item) adminInventory.get(i)).getSystemType().contains(forPriceChange)) {
				System.out.println("[OLD]\n" + adminInventory.get(i).toString());

				((Item) adminInventory.get(i)).setPrice(newPrice);

			}
		}

		/**
		 * Display the new price
		 */
		
		for(int j = 0; j < adminInventory.size(); j++) {
			if(((Item) adminInventory.get(j)).getSystemType().contains(forPriceChange)) {
				System.out.println("[NEW]\n" + adminInventory.get(j).toString());
			}
		}

	} //end changePrice method

	/**
	 * This method deals with volume discounts
	 */
	
	public void volumeDiscount(double discountPercentOff) {
		volumeDiscountPercent = discountPercentOff / 10;

	} //end volumeDiscount method

	/**
	 * This methods adds the promo code and
	 * takes the discounts that are affiliated
	 * with it
	 */
	
	public void addPromoCode() {
		try {
			
			/**
			 * User input to enter the promo code
			 * 
			 * @ensure promoCode != null
			 */
			
			System.out.print("Enter a Promotion code: ");
			String promoCode = console.next();
			
			/**
			 * User input to enter the amount to be discounted
			 * 
			 * @ensure promoOffTotal >= 0.00
			 */

			System.out.print("Enter the amount of money taken off: ");
			int promoOffTotal = console.nextInt();
		}
		
		/**
		 * Print an error message if an exception has occurred
		 */
		
		catch(Exception e) {
			System.out.println("An error has occurred. Try Again.");
		}
	} //end addPromoCode method

	/**
	 * A method to switch on and off
	 */
	public boolean switchOnOff(int onOff) {

		if(onOff == 1) {
			return true;
		}
		else{
			return false;
		}


	} //end switch method

	/**
	 * Next methods here are the user methods.
	 * 
	 * A method to filter the list of movies and games
	 * and it sorts/searches once
	 */

	public void filter(int userFilterInput) {

		/**
		 * Filters the input
		 */
		
		switch(userFilterInput) {

		/**
		 * Case 1 sorts all items alphabetically
		 */
		
		case 1:
			Collections.sort(filterInventory, Item.NameComparator);
			System.out.print("Sort Alphabetically: \n");
			System.out.print(filterInventory.toString().replace(",", "").replace("[", "").replace("]", "") + "\n" + "\n");
			break;
			
		/**
		 * Case 2 sorts all items by genre
		 */

		case 2:

			showGenreMenu();
			int selectGenre = console.nextInt();

			String genre = null;

			switch(selectGenre) {

			case 1://Action
				genre = "Action";
				break;

			case 2://Adventure
				genre = "Adventure";
				break;

			case 3://Comedy
				genre = "Comedy";
				break;

			case 4://Crime
				genre = "Crime";
				break;

			case 5://Drama
				genre = "Drama";
				break;

			case 6://Fantasy
				genre = "Fantasy";
				break;

			case 7://Horror
				genre = "Horror";
				break;

			case 8://Mystery
				genre = "Mystery";
				break;

			case 9://Sci Fi
				genre = "Sci Fi";
				break;

			case 10://Thriller
				genre = "Thriller";
				break;

			case 11://etc
				genre = "etc";
				break;

			} //end genre switch

			/**
			 * Sorting all genres
			 * Cloning the adminInventory to filter inventory
			 */
			
			Collections.sort(filterInventory, Item.GenreComparator);
			System.out.print("Sort " + genre + " Alphabetically: \n");
			
			/**
			 * Finds items by genre
			 */

			for(int i = 0; i < filterInventory.size(); i++) {
				if(((Item) filterInventory.get(i)).getGenre().contains(genre)) {
					System.out.println(filterInventory.get(i).toString());
				}
			}

			break;

		/**
		 * Case 3 sorts all items by the critics' scores from highest to lowest
		 */
			
		case 3:
			
			/**
			 * Finds items by critics' score
			 */

			Collections.sort(filterInventory, Item.ScoreComparator);
			System.out.print("Sort by Critic Score: \n");
			System.out.print(filterInventory.toString().replace(",", "").replace("[", "").replace("]", "") + "\n" + "\n");

			break;
			
		/**
		 * Case 4 sorts all items by format (DVD, Blu-ray, X-Box, PS4)
		 */

		case 4:
			showFormatMenu();
			int format = console.nextInt();
			String formatString = null;

			switch(format) {

			case 1://Blu-Ray
				formatString = "Blu-Ray";
				break;

			case 2://DVD
				formatString = "DVD";
				break;

			case 3://X-Box
				formatString = "X-Box";
				break;

			case 4://PS4
				formatString = "PS4";
				break;
			}

			Collections.sort(filterInventory, Item.SystemTypeComparator);
			System.out.print("Sort " + formatString + " Alphabetically: \n");

			/**
			 * Find items released by format
			 */
			
			for(int i = 0; i < filterInventory.size(); i++) {
				if(((Item) filterInventory.get(i)).getSystemType().contains(formatString)) {
					System.out.println(filterInventory.get(i).toString());
				}
			}

			break;
			
		/**
		 * Case 5 sorts all items by release date and formats it by year
		 */

		case 5:
			
			/**
			 * User input to enter a release year
			 * 
			 * @ensure releaseYear >= 0
			 */
			
			System.out.print("Enter a Release Year: ");
			int releaseYear = console.nextInt();

			/**
			 * Find items released by year
			 */
			
			for(int i = 0; i < filterInventory.size(); i++) {
				if(((Item) filterInventory.get(i)).getYear() == releaseYear) {
					System.out.println(filterInventory.get(i).toString());
				}
			}
			
			break;

		} //end switch

	} //end filter method

	/**
	 * A methods to search for a particular item
	 */
	
	public void search(String searchName) {
		boolean found = false;
		
		/**
		 * Searches for the item
		 */
		
		for(int i = 0; i < adminInventory.size(); i++) {
			if(((Item) adminInventory.get(i)).getName().contains(searchName)) {
				System.out.println(adminInventory.get(i).toString());
				found = true;
				break;
			}

		}
		
		/**
		 * Print an error message if the item was not found
		 */
		
		if(!found) {
			System.out.println("Item was not found in the Inventory.");
		}

	} //end search method

	/**
	 * This methods adds a particular item to the cart
	 */
	
	public void addToCart(String searchNameAdd) {
		
		boolean found = false;
		
		for(int i = 0; i < adminInventory.size(); i++) {
			
			/**
			 * Verifying if the item exists
			 */
			
			if(((Item) adminInventory.get(i)).getName().contains(searchNameAdd)) {
				found = true;
				
				/**
				 * Removes stock from the inventory
				 */
				
				if(((Item) adminInventory.get(i)).getStock() >= 1) {
					((Item) adminInventory.get(i)).setStock(((Item) adminInventory.get(i)).getStock() - 1);
				}

				/**
				 * Clones the item into the user's cart with stock set to 1
				 */
				
				Item oneToCart = new Item(((Item) adminInventory.get(i)).getMovieOrGame(), ((Item) adminInventory.get(i)).getSystemType(), ((Item) adminInventory.get(i)).getGenre(), ((Item) adminInventory.get(i)).getName(), ((Item) adminInventory.get(i)).getScore(), ((Item) adminInventory.get(i)).getStock(), ((Item) adminInventory.get(i)).getPrice(), ((Item) adminInventory.get(i)).getDay(), ((Item) adminInventory.get(i)).getMonth(), ((Item) adminInventory.get(i)).getYear());
				oneToCart.setStock(1);
				System.out.println(oneToCart);

				/**
				 * Puts the item into the user's cart
				 */
				
				userCart.add(oneToCart);

			}
		}
		
		/**
		 * Prints an error message if the item was not found
		 */
		
		if(!found) {
			System.out.println("Item was not found in the inventory. Try Again.");
		}

	} //end addToCart Method

	/**
	 * A method to remove the item from the cart
	 */
	
	public void removeFromCart(String searchNameRemove) { 
		
		/**
		 * Searches the user's cart and remove it if found
		 */
		
		for(int i = 0; i < userCart.size(); i++) {
			if(((Item) userCart.get(i)).getName().contains(searchNameRemove)) {
				userCart.remove(i);
				
				/**
				 * Put the stock back into the inventory
				 */
				
				for(int j = 0; j < adminInventory.size(); j++) {
					if(((Item) adminInventory.get(j)).getName().contains(searchNameRemove)) {
						((Item) adminInventory.get(j)).setStock(((Item) adminInventory.get(j)).getStock() + 1);
					}
				}
			}
		}
	} //end removeFromCart method

	/**
	 * A method to remove all the items from the cart
	 */
	
	public void removeAll() {

		/**
		 * Removes all items from cart and add back all items to inventory(clear all)
		 * Matches between ArrayList
		 */
		
		for(int i = 0; i < userCart.size(); i++) {
			for(int j = 0; j < adminInventory.size(); j++) {
				
				/**
				 * Puts everything back into the Inventory
				 */
				
				if(((Item) adminInventory.get(j)).getName().contains(((Item) userCart.get(i)).getName())) {
					((Item) adminInventory.get(i)).setStock(((Item) adminInventory.get(j)).getStock() + 1);
				}
			}
		}
		
		/**
		 * Empty out the user's cart
		 */
		
		userCart.clear();

	}

	/**
	 * A rent/checkout method
	 */
	
	public double rent() {

		/**
		 * Set the total to 0
		 */
		
		double total = 0;
		
		if(userCart.size() >= 1) {
			
			if(checkOut) {
				
				/**
				 * Find the total cost
				 */
				
				for(int i = 0; i < userCart.size(); i++) {
					//volume discount
					if(userCart.size() >= 5) {
						total += userCart.get(i).getPrice();
						
						/**
						 * Apply the percentage off and give a new total
						 */
						
						return total = total - (total * (volumeDiscountPercent));
					}
					//if promoCode is valid 
					else if(codeValid) {
						total += userCart.get(i).getPrice();
						return total -= 5;
					}
					else {
						return total += userCart.get(i).getPrice();
					}
				}
			}
		}
		
		/**
		 * Print error message if card number if invalid
		 */
		
		else {
			System.out.println("Invalid card number. Try Again.");
		}
		
		/*
		 * Return the total
		 */
		
		return total;

	} //end rent method

	/**
	 * A method to pay with credit
	 */
	
	public void payCredit(long paymentNum) {

		/**
		 * Check if valid card number allowing to rent
		 */
		
		if(paymentNum >= Long.parseLong("1000000000000000") && paymentNum <= Long.parseLong("9999999999999999")) {
			checkOut = true;
		}
		
		/**
		 * Print an error message if it's invalid
		 */
		
		else {
			System.out.println("Invalid. Try Again.");
		}

	} //end paycredit method

	/**
	 * A method to enter the user's promo code
	 */
	
	public void promoCode(String userPromoCode) { //see if the promo code matches
		String promoCode =null;
		
		/**
		 * Verify the promo code
		 */
		
		if(userPromoCode.compareToIgnoreCase(promoCode) == 0) {
			codeValid = true;
			System.out.println("Code Valid. Discounted $5.");
		}
		
		/**
		 * Print an error message if the code was not valid
		 */
		
		else {
			System.out.println("Code was not valid.");
		}

	} //end payCredit method


	/**
	 * Other methods to display
	 * 
	 * A method to show genre menu
	 */
	
	public static void showGenreMenu() {
		
		/**
		 * Displays the genre menu
		 */
		
		System.out.print("**************************************" + "\n" + 
				"Pick the Genre you want to search for: " + "\n" + 
				"1 = Action \n" + 
				"2 = Adventure \n" +  
				"3 = Comedy \n" + 
				"4 = Crime \n" +  
				"5 = Drama \n" + 
				"6 = Fantasy \n" + 
				"7 = Horror \n" + 
				"8 = Mystery \n" +
				"9 = Sci Fi \n" +
				"10 = Thriller \n" +
				"11 = ETC. \n" +
				"**************************************\n" + 
				"Enter Here: ");
	}

	/**
	 * A method to show format menu
	 */
	
	public static void showFormatMenu() {
		
		/**
		 * Displays the format menu
		 */
		
		System.out.print("***************************************\n" + 
				"Sort by: \n" + 
				"1 = Blu-Ray \n" + 
				"2 = DVD \n" + 
				"3 = X-Box \n" + 
				"4 = PS4\n"+ 
				"**************************************\n" + 
				"Enter Here: ");
	}

	/**
	 * A Linear Search Method for Index in the admin's inventory
	 * 
	 * @param adminInventory
	 * @param target
	 * @return i
	 */
	
	public static int LinearSearchAdmin(ArrayList adminInventory, String target) {

		for(int i = 0; i < adminInventory.size(); i++) {
			if(((Item) adminInventory.get(i)).getName().contains(target)) {
				System.out.println(adminInventory.get(i).toString());
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * A method to compare two items, o1 and o2
	 */

	@Override
	public int compare(Item o1, Item o2) {
		// TODO Auto-generated method stub
		return 0;
	}

} //end class
