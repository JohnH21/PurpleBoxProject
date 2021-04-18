import java.util.ArrayList;

/* Name: John Huynh, Riley Morrow
 * Date: 10/22/2019
 * Assignment:HomeWork 3 PurpleBox
 * Group 2
 */

public interface PurpleBoxUserInterface {
	 
	/**
	 * Filter through the  filterInventory (copy of adminInventory)
	 * 
	 * @param int userFilterInput
	 * @ensure filterInventory fits criteria (menu based)
	 */
	public void filter(int userFilterInput);
	
	/**
	 * Traverse ArrayList from Admin Inventory
	 * 
	 * @param String searchName
	 * @ensure Finds item in inventory with the same name
	 */
	public void search(String searchName);
	
	/**
	 * Adds item into Cart ArrayList
	 * 
	 * @param String searchNameAdd
	 * @require stock of item be >= 1
	 * @ensure item is remove from adminInventory put into userCart
	 * 		   make stock to 1 in userCart and -1 from adminInventory
	 */
	public void addToCart(String searchNameAdd);
	
	/**
	 * Remove item from Cart ArrayList
	 * 
	 * @param removeFromCart
	 * @ensure item is remove from user cart to admin inventory
	 * 		   add stock back to adminInventory
	 */
	public void removeFromCart(String searchNameRemove);
	
	/**
	 * Remove all items from Cart ArrayList
	 * 
	 * @ensure all item remove from user cart to adminInventory
	 * 		   add everything from userCart back to adminInventory
	 */
	public void removeAll();
	
	/**
	 * Gives the total amount for payment
	 * 
	 * @require item >= 1
	 * 
	 * @ensure take the total of all items in userCart 
	 * 		   of possible put add volume discount or promo code
	 */
	public double rent();
	
	/**
	 * Takes the credit card info and check if valid
	 * 
	 * @require long 
	 * @param long paymentNum
	 * @ensure check if card number is valid (length)
	 */
	public void payCredit(long paymentNum);
	
	/**
	 * Checks the promo code is valid
	 * 
	 * @require String
	 * @param String userPromoCode
	 * @ensure take a dollar amount from total price
	 * 		   used first if volume discount applies
	 */
	public void promoCode(String userPromoCode);

}
