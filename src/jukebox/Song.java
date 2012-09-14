package jukebox;

public class Song implements Comparable<Song> {
	public String title;
	public String artist;
	public String rating;
	public String bpm;

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public String getRating() {
		return rating;
	}

	public String getBpm() {
		return bpm;
	}

	public int compareTo(Song o) {
		return title.compareTo(o.getTitle());
	}

}
