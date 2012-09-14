package jukebox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Jukebox {

	private ArrayList<Song> songList = new ArrayList<Song>();

	private class ArtistCompare implements Comparator<Song> {
		public int compare(Song o1, Song o2) {
			return o1.getArtist().compareTo(o2.getArtist());
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Jukebox().go();

	}

	public void go() {
		getSongs();
		System.out.println(songList);
		Collections.sort(songList);
		System.out.println(songList);

		ArtistCompare artistCompare = new ArtistCompare();
		Collections.sort(songList, artistCompare);
		System.out.println(songList);
	}

	private void getSongs() {
		// TODO código de I/O
	}

	private void addSong(String lineToParse) {
		// TODO analisa a linha e adiciona
	}
}
