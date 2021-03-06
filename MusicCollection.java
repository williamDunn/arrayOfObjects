//Author: William Dunn
//Date:1/23/17
//165 02
//Assignment 2

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class MusicCollection {
	final int MAX_SONGS = 300;
	int counter;
	Song songs[] = null;
	PrintWriter rpt = null;

	///////////////

	public MusicCollection() {
		songs = new Song[MAX_SONGS];
		counter = 0;
		loadArray();
		try {
			rpt = new PrintWriter(new FileWriter("rpt.txt"));
		} catch (Exception ex) {
		}

	}

	///////////////

	private void loadArray() {
		String album;
		String artist;
		String songTitle;
		int position;
		int minutes;
		int seconds;
		String line;
		String[] splitLine;
		Scanner inF;
		try {
			inF = new Scanner(new File("musicCSV.txt"));
			while (inF.hasNext()) {
				line = inF.nextLine();
				splitLine = line.split(",");
				artist = splitLine[0];
				album = splitLine[1];
				songTitle = splitLine[2];
				
				try{

				position = Integer.parseInt(splitLine[3]);
				minutes = Integer.parseInt(splitLine[4]);
				seconds = Integer.parseInt(splitLine[5]);
				}
				catch (NumberFormatException ex)
				{
					position = 0;
					minutes = 0;
					seconds = 0;
					System.err.println("Error loading data");
				}
				songs[counter] = new Song(album, artist, songTitle, position, minutes, seconds);
				System.out.println(songs[counter].toString());
				counter++;
			
			}
		} catch (FileNotFoundException ex) {
			System.err.println("File not found");
		}
	}

	///////////////

	public void printInventory() {
		try {
			rpt.printf("%-30s %-20s %23s %3s %8s%n", "Album", "Artist", "Song", "Position", "Duration");
			rpt.println(
					"****************************** ******************** *********************** ******** ********");
			for (int i = 0; i < counter; i++) {
				rpt.printf("%-30s %-20s %23s %8s %8s%n", songs[i].getAlbum(), songs[i].getArtist(),
						songs[i].getSongTitle(), songs[i].getPosition(), songs[i].getDuration());
			}

		} catch (Exception ex) {
			System.err.println("inventory.txt could not be opened. Program will now end.");
		}
		rpt.println();
	}

	///////////////

	public void printAlbumsInCollection() {
		String[] albums = new String[counter];
		int numAlbums = 0;
		int i;
		int b;
		boolean found;

		for (i = 0; i < counter; i++) {
			b = 0;
			found = false;
			while (found == false && b < numAlbums) {
				if (songs[i].getAlbum().equals(albums[b]))
					found = true;
				else
					b++;
			}
			if (!found) {
				albums[b] = songs[i].getAlbum();
				numAlbums++;
			}
			
		}
		rpt.println("Here are the albums in the music collection.");

		for (i = 0; i < numAlbums; i++) {
			rpt.println(" " + albums[i]);
		}
		rpt.println();
		rpt.println("There are " + numAlbums + " albums.");
		rpt.println();
	}

	///////////////

	public void printAlbumsForArist(String anArtist) {
/*		String[] albumsByArtist = new String[counter];
		int numAlbumsByArtist = 0;
		int i;
		int b;
		boolean found;
		
		rpt.println("");

		for (i = 0; i < counter; i++) {
			b = 0;
			found = false;
			while (found == false && b < numAlbumsByArtist) {
				if (songs[i].getArtist().equals(albumsByArtist[b]))
					found = true;
				else
					b++;
			}
			if (!found) {
				albumsByArtist[b] = songs[i].getArtist();
				numAlbumsByArtist++;
			}
				else
					rpt.println("No albums in the collection by " + anArtist);
			}
	*/		
		
		rpt.println("Albums by " + anArtist + " in this collection");
		//for (i = 0; i < numAlbums; i++){
		for (int i = 0; i < counter; i++) {
			if (anArtist.equals(songs[i].getArtist()))
				rpt.println(songs[i].getAlbum());
			else
				rpt.println("No albums in the collection by " + anArtist);
		}
		
		rpt.println();
		}


	///////////////

	public void printSongsOnAlbum(String anAlbum) {
		rpt.println("Here are the songs on the '" + anAlbum + "' album:");
		
		for (int i = 0; i < counter; i++) {
			if (anAlbum.equals(songs[i].getAlbum()))
				rpt.println(songs[i].getSongTitle());
		}
		rpt.println();
	}

	///////////////

	public void endRpt() {
		rpt.close();
	}

	///////////////

	public Song findASong(String songtitle) {
		for (int i = 0; i < counter; i++) {
			{
				if (songtitle.equals(songs[i].getSongTitle())) {
					rpt.println(songs[i].getSongTitle());
					rpt.close();
					return songs[i];
				} else
					return null;
			}
		}
		return null;

	}

}
