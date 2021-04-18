import java.util.ArrayList;

/**
 * @author John Huynh, Riley Morrow
 * 
 * Date: 10/22/2019
 * Assignment:HomeWork 3 PurpleBox
 * Group 2
 */

public interface PurpleBoxAdminInterface {
	
	/**
	 * Add item to Admin Inventory
	 * 
	 * @param int typeInput
	 * @ensure adminInventory.add(new Item)
	 */
	public void addToInv(int typeInput); 
	
	/**
	 * Adds more stock to existing item
	 * 
	 * @require item name 
	 * @param String findItem
	 * @param int addStock
	 * @ensure adminInventory.getStock() += addStock
	 */
	public void restock(String findItem, int addStock);
	
	
	/**
	 * Remove item from Admin Inventory
	 * 
	 * @param String removeItem
	 * @ensure adminInventory.remove(removeItem)
	 */
	public void removeFromInv(String removeItem);//
	
	/**
	 * Change Price of Movie
	 * 
	 * @param String forPriceChange
	 * @param double newPrice
	 * @ensure item price is changed
	 */
	public void changePrice(String forPriceChange, double newPrice);
	
	/**
	 * Discount price when over curtain number of items
	*
	 * @require item in cart >= 5
	 * @param double discountPercentOff
	 * @ensure one item discount is being used
	 */
	public void volumeDiscount(double discountPercentOff);
	
	/**
	 * Adds a promo code 
	 * 
	 * @ensure if volume discount is used 
	 * 		   calculate promo code discount first  
	 * 		   than use volume discount
	 * 
	 * 		   else just if volume discount is not used 
	 * 		   than just use promo code discount
	 */
	public void addPromoCode();
	
	/**
	 * Turn on/off machine
	 * 
	 * @param int onOff
	 * @ensure on = boolean true
	 * 		   off = boolean false
	 */
	public boolean switchOnOff(int onOff);

}
