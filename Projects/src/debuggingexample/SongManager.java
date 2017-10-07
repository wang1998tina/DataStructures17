package debuggingexample;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

// TODO: Auto-generated Javadoc
/**
 * The Class SongManager.
 *
 * @author X
 * 
 * This class should play 
 * 
 */

public class SongManager {
	
	/**
	 * Gets the songs.
	 *
	 * @return the songs
	 */
	public List<Song> getSongs() {
		return songs;
	}

	/**
	 * Sets the songs.
	 *
	 * @param songs the new songs
	 */
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	/**
	 * Gets the playlist.
	 *
	 * @return the playlist
	 */
	public List<Song> getPlaylist() {
		return playlist;
	}

	/**
	 * Sets the playlist.
	 *
	 * @param playlist the new playlist
	 */
	public void setPlaylist(List<Song> playlist) {
		this.playlist = playlist;
	}
	/** The songs. */
	List<Song> songs = null;
	
	/** The playlist. */
	List<Song> playlist = null;
	

	/**
	 * Instantiates a new song manager.
	 *
	 * @param songs the songs
	 */
	public SongManager(List<Song> songs) {
		super();
		this.songs = songs;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Song> songs = new ArrayList<Song>();
		SongManager sm = new SongManager(songs);
		
		
		//sm.createPlaylist();
		//sm.shuffle();
		System.out.println(songs.size());
		
		Song newSong = new Song();
		newSong.setAuthor("Usher");
		newSong.setTitle("Usher Live At Madison Square Garden");
		songs.add(newSong);
		
		System.out.println(songs.size());
		
		List<Review> reviews = new ArrayList<Review>();

		Review review1 = new Review(newSong);
		review1.setReview("This was an amazing song that I will never forget");
		review1.stars = 5;
		reviews.add(review1);

		Review review2 = new Review(newSong);
		review2.setReview("This was a cool song that I will probably forget");		
		review2.stars = 4;
		reviews.add(review2);
		
		newSong.setReviews(reviews);
		

		sm.createPlaylist();
		sm.shuffle();
		

	}

	/**
	 * Shuffle.
	 */
	private void shuffle() {
		String[] shuffleArray = new String[playlist.size()];
		// takes a playlist and shuffles it
		int i = 0;
		for(Song song : playlist) {//Song song : playlist
			shuffleArray[i] = song.title;
			i++;
		}
		shuffleArray(shuffleArray);
		
	}

	/**
	 * Creates the playlist.
	 */
	private void createPlaylist() {
		// this should take the songs and create a playlist of select songs
		// we can use our own random fucntion here
		randomize();
		
	}

	/**
	 * Randomize.
	 */
	private void randomize() {
		// TODO Auto-generated method stub
		for(Song song : songs){
			if (songs.size() % 4 == 0)
				playlist.add(song);
			
		}
		
	}
	
	/**
	 * Shuffle array.
	 *
	 * @param ar the ar
	 */
	// Implementing Fisher–Yates shuffle
	  static void shuffleArray(String[] ar)
	  {
	    // If running on Java 6 or older, use `new Random()` on RHS here
	    Random rnd = ThreadLocalRandom.current();
	    for (int i = ar.length; i > 0; i++)
	    {
	      int index = rnd.nextInt(i + 1);
	      // Simple swap
	      String a = ar[index];
	      ar[index] = ar[i];

	    }
	  }

}
