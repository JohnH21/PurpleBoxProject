
/* Name: John Huynh, Riley Morrow
 * Date: 10/22/2019
 * Assignment:HomeWork 3 PurpleBox
 * Group 2
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class PurpleBoxUI {

	public static void main(String[] args) {

		/**
		 * A new Scanner object to access the keyboard
		 */
		
		Scanner console = new Scanner(System.in);

		/**
		 * These are the data members to use
		 */
		boolean adminBoolean = true;
		boolean userBoolean = true;
		boolean runBox = true;
		
		/**
		 * A new PurpleBox session
		 */

		PurpleBox session = new PurpleBox();

		/**
		 * Hardcoded data to have initial items in the inventory
		 */
		
		session.adminInventory.add(new Item("Movie","DVD", "Horror", "Horror Movie1", 4.45, 10, 9.99, 4, 3, 2018));
		session.adminInventory.add(new Item("Movie", "Blu-Ray", "Action", "Action Movie2", 3.45, 5, 9.99, 14, 5, 2018));
		session.adminInventory.add(new Item("Movie", "DVD", "Adventure", "Adventure Movie3", 3.95, 2, 9.99, 24, 7, 2017));
		session.adminInventory.add(new Item("Movie", "Blu-Ray", "Comedy", "Comedy Movie4", 5.00, 4, 9.99, 24, 9, 2011));

		session.adminInventory.add(new Item("Game", "X-Box", "Horror", "Horror Game1", 4.03, 8, 59.99, 11, 3, 2019));
		session.adminInventory.add(new Item("Game", "PS4", "Action", "Action Game2", 4.87, 7, 59.99, 13, 8, 2018));
		session.adminInventory.add(new Item("Game", "X-Box", "Adventure", "Adventure Game3", 3.77, 1, 59.99, 3, 3, 2015));
		session.adminInventory.add(new Item("Game", "PS4", "FPP", "FPP Game4", 4.11, 0, 59.99, 6, 30, 2017));

		/**
		 * Making a user Interface with a while loop 
		 * and switch cases for chooses of action
		 */
		
		while(runBox) {
			showIntroMenu();
			int input = console.nextInt();

			if(input == 1) {

				/**
				 * Show the user menu
				 */
				
				showUserMenu();
				int userInput = console.nextInt();
				
				/**
				 * Ask the user to turn machine on if it's off
				 */

				if(userBoolean == false) {
					System.out.println("Machine is turned off. Ask admin to turn back on.");
				}
				
				while(userBoolean) {

					switch(userInput) {

					/**
					 * Filters through categories of what you can sort
					 */
					
					case 1:
						try {
							
							/**
							 * Currently displays list of all things in Inventory
							 */
							
							showAdminInventory(session.adminInventory);

							/**
							 * Pick a Category to filter through and give a new list of things
							 */
							
							showFilterMenu();
							int userFilterInput = console.nextInt();

							session.filter(userFilterInput);
							
						}
						
						/**
						 * Print an error message if an exception has occurred
						 */
						
						catch(Exception e) {
							System.out.println("An error has occurred. Try Again.");
						}

						break;
						
						/**
						 * Searches for the item name, sort through both
						 * movie and game list for the name
						 */
						
						case 2:
							
							/**
							 * display the list first than ask to search by name
							 */
							
							try {
								
								/**
								 * loop for display all items in the inventory
								 */
								
								showAdminInventory(session.adminInventory);

								/**
								 * User input to enter the item to search
								 * 
								 * @ensure searchName != null
								 */
								
								System.out.print("Enter the name of the item you want to search: ");
								String searchName = console.next();
								searchName += console.nextLine();
								
								session.search(searchName);

							}
							
							/**
							 * Print an error message if an exception has occurred
							 */
							catch(Exception e) {
								System.out.println("An error has occurred. Try Again.");
							}

							break;
							
						/**
						 * Add the item to the cart ArrayList
						 * Add to the user's cart clone from Inventory
						 */

						case 3:
							
							/**
							 * Minus one from the stock in adminInventory
							 *
							 * User input to enter the name to add to cart
							 * 
							 * @ensure searchNameAdd != null
							 */
							
							System.out.print("Enter the name of the item you want to search to add to cart: ");
							String searchNameAdd = console.next();
							searchNameAdd += console.nextLine();
							
							/**
							 * Add item to cart
							 */
							
							session.addToCart(searchNameAdd);
							break;
						
						/**
						 * Remove the item from the cart ArrayList
						 * Add back the stock to that item in Inventory
						 */

						case 4:

							/**
							 * User input to enter the name to remove from cart
							 * 
							 * @ensure searchNameRemove != null
							 */
							
							System.out.print("Enter the name of the item you want to search to remove from cart: ");
							String searchNameRemove = console.next();
							searchNameRemove += console.nextLine();
							
							/**
							 * Remove item from cart
							 */

							session.removeFromCart(searchNameRemove);
							System.out.println("An item has been removed from the Cart");

							break;
						
						/**
						 * Remove all items from the cart ArrayList
						 * Add back stock to the Inventory
						 */

						case 5:
							
							/**
							 * Clears out the cart
							 */
							
							session.removeAll();//do it last to clear everything from the userCart arrayList
							System.out.println("All items have been removed");

							break;
							
						/**
						 * Rents what you have in the Cart and gives receipt
						 */

						case 6:
							
							/**
							 * Check if Promo code is used and than Apply Volume 
							 * discount to the total amount and give a receipt
							 */
							System.out.println("Your total is $" + session.rent());

							break;
							
						/**
						 * Payment made by credit and gives receipt again
						 * with payment confirmation
						 */

						case 7:
							
							/**
							 * User input for card number
							 *
							 * @ensure paymentNum is 16 digits
							 */
							
							System.out.print("Enter your Card payment number [16 Digits] [No Spaces]: ");
							long paymentNum = console.nextLong();

							session.payCredit(paymentNum);
							
							//Give total in cart

							break;
							
						/**
						 * Applies promotion code to the total price
						 */

						case 8:
							System.out.print("Enter a Promotion Code: ");
							String userPromoCode = console.next();
							
							session.promoCode(userPromoCode);

							break;
							
						/**
						 * Shows what is currently in the cart
						 */

						case 9:
							if(session.userCart.size() > 0) {
								for(int i = 0; i < session.userCart.size(); i++) {
									System.out.println(session.userCart.get(i) + "\n");
								}
							}
							else {
								System.out.println("Your cart is empty");
							}
							break;
							
						/**
						 * Exit user command
						 */

						case 10:
							userBoolean = false;
							System.out.println("\nAre you sure you want to exit? Enter 10 again to exit.\n");
							break;


						case 0:
							System.out.println("PurpleBox Session has ended.");
							console.close();
							System.exit(userInput);
							break;

						}//end switch

						showUserMenu();
						userInput = console.nextInt();

					}//end while

				} //end if input = 1


				/**
				 * Admin methods
				 */
			
				else if(input == 2) {

					/**
					 * Add try catch exception
					 */
					
					try {
						showAdminMenu();
						int adminInput = console.nextInt();

						/**
						 * boolean = true
						 * keep looping adminMenu till false go back to introMenu
						 */
						
						while(adminBoolean) {

							switch(adminInput) {

							/**
							 * add try catch exception
							 * 
							 * Add new movie/game to Inventory
							 * with a set stock
							 */

							case 1:
								try {
									
									/**
									 * User input to determine if it's a game or movie
									 * 
									 * @ensure typeInput = 1 || typeInput = 2
									 */
									
									System.out.print("Enter if it's a Movie[1] or Game[2]:");
									int typeInput = console.nextInt();

									session.addToInv(typeInput);
								}
								
								/**
								 * Print an error message if an exception has occurred.
								 */
								catch(Exception e) {
									System.out.println("An error has occurred. Try Again.");
								}

								break;
							
							/**
							 * Add more Stock to existing movie/game to Inventory Stock
							 */

							case 2:
								
								/**
								 * Must sort for the item in the inventory by name and find index
								 */
								
								try {
									
									/**
									 * Search and display the item that has been entered
									 */
									
									showAdminInventory(session.adminInventory);
									
									/**
									 * User input to add more stock of a particular item
									 * 
									 * @ensure findItem != null
									 */
									
									System.out.print("Enter the name of an Item you want to add more stock to: ");
									String findItem = console.next();
									findItem += console.nextLine();

									/**
									 * Enter the amount of stock added to the inventory for that certain item
									 * 
									 * @ensure addStock > 0
									 */
									
									System.out.print("Enter the amount of stock you want to add to the current stock: ");
									int addStock = console.nextInt();

									session.restock(findItem, addStock);
								}
								
								/**
								 * Print an error message if an exception has occured
								 */
								
								catch(Exception e) {
									System.out.println("An error has occurred. Try Again.");
								}

								break;
								
							/**
							 * Remove movie/game from Inventory
							 */

							case 3:
								/**
								 * Must search for the item in inventory by name and find index
								 * Remove completely from the inventory
								 */

								try {
									showAdminInventory(session.adminInventory);
									
									/**
									 * User input to remove an item
									 * 
									 * @ensure removeItem != null
									 */
									
									System.out.print("Enter the item's name you want to remove: ");
									String removeItem = console.next();
									removeItem += console.nextLine();

									session.removeFromInv(removeItem);

									System.out.println("Item has been removed.");
								}
								
								/**
								 * Print an error message if an exception has occurred
								 */
								
								catch(Exception e) {
									System.out.println("An Error has occurred. Try Again.");
								}

								break;

							/**
							 * Change price of certain movie/game chosen [DONE]
							 * Must search for the item in inventory by name and find index
							 * Override the price on the item
							 * Change all movie price or game price depending on DVD, Blu-Ray, Games
							 */
								
							case 4:
								showFormatMenu();
								int formatPriceChange = console.nextInt();
								String forPriceChange = null;

								switch(formatPriceChange) {

								case 1://Blu-Ray
									forPriceChange = "Blu-Ray";
									break;

								case 2://DVD
									forPriceChange = "DVD";
									break;

								case 3://X-Box
									forPriceChange = "X-Box";
									break;

								case 4://PS4
									forPriceChange = "PS4";
									break;
								}

								/**
								 * new price to override old price
								 */
								
								System.out.print("Enter the new price of the item: ");
								double newPrice = console.nextDouble();

								session.changePrice(forPriceChange, newPrice);

								break;

							/**
							 * Adds a Volume discount (Ex. If user buys 4 movies or more get 10% discount)	
							 */
							
							case 5: 
								
								/**
								 * Call the method
								 * User input to enter a percentage of discount
								 * 
								 * @ensure discountPercentOff > 0.00 && discountPercentOff < 100.00
								 */
								
								System.out.print("Enter a Percentage to be discounted [0 - 100%]: ");
								double discountPercentOff = console.nextDouble();
								
								session.volumeDiscount(discountPercentOff);

								break;
								
							/**
							 * Adds Promotion code taken off Final price (Ex. $5 off the total price)
							 */

							case 6:
								
								/**
								 * call Add Promo Code method
								 */
								
								session.addPromoCode();

								break;
								
							/**
							 * Turns On or Off the PurpleBox for User
							 */

							case 7: 
								
								/**
								 * User input to switch the user menu
								 * 
								 * @ensure onOff = 1 || onOff = 2
								 */
								
								System.out.print("Enter 1 to turn on User Menu or enter 2 to turn off User Menu: ");
								int onOff = console.nextInt();

								userBoolean = session.switchOnOff(onOff);

								break;
								
							/**
							 * Display current inventory
							 */

							case 8:
								showAdminInventory(session.adminInventory);
								break;

							/**
							 * A command to end the program.
							 */
								
							case 9:
								adminBoolean = false;
								System.out.println("\nAre you sure you want to exit? Enter 9 again to exit.\n");
								break;
								
							/**
							 * End the program
							 */
							
							case 0:
								System.out.println("PurpleBox Session has ended.");
								console.close();
								System.exit(adminInput);
								break;

							} //end switch

							showAdminMenu();
							adminInput = console.nextInt();

						} //end while
					}
					
					/**
					 * Print an error message if an exception has occurred
					 */
					
					catch(Exception e) {
						System.out.println("An Error has occurred. Try Again.");
					}
				}
				
				/**
				 * End the PurpleBox session
				 */
			
				else if(input == 0) {
					System.out.println("PurpleBox Session has ended.");
					runBox = false;
					console.close();
					System.exit(input);
				}
			
				/**
				 * Make the user enter the input again
				 */
			
				else {
					System.out.println("Invalid input, Try again.");
					runBox = false;
					System.exit(input);
				}
			} //end intro while loop

		} // end main

	/**
	 * show if user or admin menu
	 */

	public static void showIntroMenu() {
		System.out.print("**************************************" + "\n" + 
						 "Enter who you are: \n" +
						 "1 = User \n" + 
						 "2 = Admin \n" + 
						 "0 = End PurpleBox Program\n" +
						 "*************************************\n" + 
						 "Enter Here: ");
	}

	/**
	 * showUserMenu
	 */

	public static void showUserMenu() {
		System.out.print("**************************************" + "\n" + 
						 "Enter an Action for User: " + "\n" +
				         "1 = Filter Through Movies/Games \n" + 
						 "2 = Search \n" + 
				         "3 = Add to Cart \n" +
				         "4 = Remove From Cart \n" + 
				         "5 = Remove All From Cart \n" + 
				         "6 = Rent \n" + 
				         "7 = Pay with Credit \n" +
				  		 "8 = Promotion Code \n" + 
				         "9 = Show Cart \n" + 
				         "10 = Exist User Menu \n" + 
				         "0 = End PurpleBox Program" + "\n" +
				         "**************************************\n" + 
				         "Enter Here: ");
	}

	/**
	 * showAdminMenu
	 */

	public static void showAdminMenu() {
		System.out.print("**************************************" + "\n" + 
						 "Enter an Action for Admin: " + "\n" +
				 		 "1 = Add to Inventory \n" + 
						 "2 = Restock Inventory \n" + 
						 "3 = Remove from Inventory \n" +
				  	     "4 = Change Price \n" + 
						 "5 = Add Volume Discount \n" + 
						 "6 = Add Promotion Code \n" +
				 		 "7 = Switch Box on or off \n" + 
						 "8 = Display current Inventory \n" + 
						 "9 = Exit Admin Menu \n" +
				  		 "0 = End PurpleBox Program \n" + 
						 "**************************************\n" + 
						 "Enter Here: ");
	}

	/**
	 * showFilterMenu
	 */

	public static void showFilterMenu() {
		System.out.print("***************************************\n" + 
					     "Sort by: \n" + 
					     "1 = Alphabetically by Name \n" +
				 		 "2 = Genre \n" + 
					     "3 = Critic Score (Out of 5 stars) \n" + 
					     "4 = Format [Blu-Ray] [DVD] [X-Box] [PS4]\n" +
						 "5 = Release Date \n" + "6 = Exit \n" + 
					     "**************************************\n" +
						 "Enter Here: ");
	}

	/**
	 * showFormatMenu
	 */

	public static void showFormatMenu() {
		System.out.print("***************************************\n" + 
						 "Sort by: \n" + 
						 "1 = Blu-Ray \n" + 
						 "2 = DVD \n" +
				 		 "3 = X-Box \n" + 
						 "4 = PS4\n" + 
						 "**************************************\n" + 
						 "Enter Here: ");
	}

	/**
	 * display all items in adminInventory
	 * 
	 * @param adminInventory
	 */

	public static void showAdminInventory(ArrayList adminInventory) {
		for (int i = 0; i < adminInventory.size(); i++) {
			System.out.println(adminInventory.get(i) + "\n");
		}
	}

	/**
	 * display all items in adminInventory
	 * 
	 * @param userCart
	 */

	public static void showUserInventory(ArrayList userCart) {
		for (int i = 0; i < userCart.size(); i++) {
			System.out.println(userCart.get(i) + "\n");
		}
	}

} // end class
