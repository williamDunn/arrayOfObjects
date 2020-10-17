//Author: William Dunn
//Date:1/23/17
//165 02
//Assignment 2

public class Song {
	String album;
	String artist;
	String songTitle;
	int position;
	int minutes;
	int seconds;
	int duration;

	public Song(String album, String artist, String songTitle, int position, int minutes, int seconds) {

		this.album = album;
		this.artist = artist;
		this.songTitle = songTitle;
		this.position = position;
		this.minutes = minutes;
		this.seconds = seconds;

	}

	///////////////

	public String getAlbum() {
		return album;
	}

	///////////////

	public String getArtist() {
		return artist;
	}

	///////////////

	public String getSongTitle() {
		return songTitle;

	}

	///////////////

	public int getPosition() {
		return position;
	}

	///////////////

	public String getDuration() {

		String duration = minutes + ":" + seconds;
		if (seconds < 10)
			return minutes + ":0" + seconds;
		else
			return duration;
	}

	///////////////

	public String toString() {
		return "Song: " + getSongTitle() + "\nAlbum: " + getAlbum() + "\nArtist: " + getArtist() + "\nPosition: "
				+ getPosition() + "\nDuration: " + getDuration();
	}

}
