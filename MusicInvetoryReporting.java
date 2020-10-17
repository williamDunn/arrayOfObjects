//Author: William Dunn
//Date:1/23/17
//165 02
//Assignment 2

public class MusicInvetoryReporting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MusicCollection collection = new MusicCollection();
		
		collection.printInventory();
		
		collection.printAlbumsInCollection();
		
		collection.printAlbumsForArist("LED ZEPPELIN");
		
		collection.printAlbumsForArist("PHISH");
		
		collection.printSongsOnAlbum("AUGUST AND EVERYTHING AFTER");
		
		collection.printSongsOnAlbum("AUGUST & EVERYTHING AFTER");
		
		collection.printSongsOnAlbum("400 DEGREES");
		
		collection.endRpt();
		
		collection.findASong("RAIN KING");

	}

}
