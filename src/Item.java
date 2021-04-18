import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.Scanner;

/** 
 * @author John Huynh, Riley Morrow
 * 
 * Date: 10/22/2019
 * Assignment:HomeWork 3 PurpleBox
 * Group 2
 */

public class Item extends PurpleBox {

	/**
	 * This lists the private data members
	 */
	
	private String movieOrGame; //If it is a movie or a game
	private String systemType; //if it is X-Box, PS4, Blu-Ray, DVD
	private String genre; //Genre of Game or Movie
	private int day;
	private int month;
	private int year;
	private String name; // Name of Game/Movie
	private double score; //Critic score
	private int stock; //amount of stock inventory has
	private double price; //the price to purchase

	/**
	 * This is a default blank constructor
	 */
	
	public Item() {
	}

	/**
	 * This is a constructor with everything included in it
	 * 
	 * @param movieOrGame
	 * @param systemType
	 * @param genre
	 * @param name
	 * @param score
	 * @param stock
	 * @param price
	 * @param day
	 * @param month
	 * @param year
	 */
	
	public Item(String movieOrGame, String systemType, String genre, String name, double score, int stock, double price, int day, int month, int year) {
		this.movieOrGame = movieOrGame;
		this.systemType = systemType;
		this.genre = genre;
		this.name = name;
		this.score = score;
		this.stock = stock;
		this.price = price;
		this.day = day;
		this.month = month;
		this.year = year;
	}


	/**
	 * The Setters and Getters are provided below.
	 * 
	 * @return movieOrGame
	 */

	public String getMovieOrGame() {
		return movieOrGame;
	}
	
	/**
	 * @param movieOrGame
	 */

	public void setMovieOrGame(String movieOrGame) {
		this.movieOrGame = movieOrGame;
	}

	/**
	 * 
	 * @return systemType
	 */

	public String getSystemType() {
		return systemType;
	}

	/**
	 * @param systemType
	 */
	
	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}

	/**
	 * @return genre
	 */
	
	public String getGenre() {
		return genre;
	}
	
	/**
	 * @param genre
	 */

	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * @return day
	 */
	
	public int getDay() {
		return day;
	}
	
	/**
	 * @param day
	 */

	public void setDay(int day) {
		this.day = day;
	}
	
	/**
	 * @return month
	 */

	public int getMonth() {
		return month;
	}

	/**
	 * @param month
	 */
	
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * @return year
	 */
	
	public int getYear() {
		return year;
	}
	
	/**
	 * @param year
	 */

	public void setYear(int year) {
		this.year = year;
	}
	
	/** 
	 * @return name
	 */

	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return score
	 */

	public double getScore() {
		return score;
	}
	
	/**
	 * @param score
	 */

	public void setScore(double score) {
		this.score = score;
	}
	
	/**
	 * @return stock
	 */

	public int getStock() {
		return stock;
	}
	
	/**
	 * @param stock
	 */

	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * @return price
	 */
	
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 */
	
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * This method calculates the total price
	 * in a recursive manner (price + price)
	 * 
	 * @return (price + price)
	 */
	
	public double calculateTotalPrice() {
		return (price + price);
	}

	/**
	 * This declares a new comparator object to compare the names
	 */

	public static Comparator<Item> NameComparator = new Comparator<Item>() {
		
		/**
		 * This method compares the two names, n1 and n2
		 * and returns the integer value of the comparison
		 */
		
		@Override
		public int compare(Item n1, Item n2) {
			return (int) n1.getName().compareTo(n2.getName());
		}
	};

	/**
	 * This declares a new comparator object to compare the genres
	 */
	
	public static Comparator<Item> GenreComparator = new Comparator<Item>() {
		
		/**
		 * This method compares the two genres, g1 and g2
		 * and returns the integer value of the comparison
		 */
		
		@Override
		public int compare(Item g1, Item g2) {
			return (int) g1.getGenre().compareTo(g2.getGenre());
		}
	};

	/**
	 * This declares a new comparator object to compare the critics' scores
	 */
	
	public static Comparator<Item> ScoreComparator = new Comparator<Item>() {
		
		/**
		 * This method compares the two scores, s1 and s2
		 * and returns the integer value of the comparison
		 */
		
		@Override
		public int compare(Item s1, Item s2) {
			if (s1.getScore() < s2.getScore()) return 1;
			if (s1.getScore() > s2.getScore()) return -1;
			return 0;
		}
	};

	/**
	 * This declares a new comparator object to compare the system types
	 */
	
	public static Comparator<Item> SystemTypeComparator = new Comparator<Item>() {
		
		/**
		 * This method compares the two system types, b1 and b2
		 * and returns the integer value of the comparison
		 */
		
		@Override
		public int compare(Item b1, Item b2) {
			return (int) b1.getSystemType().compareTo(b2.getSystemType());
		}
	};
	
	/**
	 * This is a toString method to display the information
	 * about the particular item
	 */
	
	public String toString() {
		return "\n[" + movieOrGame + "]" +
				"\nName: " + name + 
				"\nGenre: " + genre + 
				"\nRelease Date: " + month + "/" + day + "/" + year +
				"\nCritic Score: " + score + 
				"\nTotal Stock: " + stock + 
				"\nPrice: $" + price + 
				"\nSystem Type: " + systemType + "\n";
	} //end main

} //end class
