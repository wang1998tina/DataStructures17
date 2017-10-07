package debuggingexample;

import java.util.List;

//TODO: Auto-generated Javadoc
/**
* The Class Song.
*
* @author john_ortega
*/
public class Song {
	
	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the track.
	 *
	 * @return the track
	 */
	public String getTrack() {
		return track;
	}

	/**
	 * Sets the track.
	 *
	 * @param track the new track
	 */
	public void setTrack(String track) {
		this.track = track;
	}

	/**
	 * Gets the author.
	 *
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets the author.
	 *
	 * @param author the new author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Gets the reviews.
	 *
	 * @return the reviews
	 */
	public List<Review> getReviews() {
		return reviews;
	}

	/**
	 * Sets the reviews.
	 *
	 * @param reviews the new reviews
	 */
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	/** The title. */
	String title;
	
	/** The track. */
	String track;
	
	/** The author. */
	String author;
	
	/** The revies. */
	List<Review> reviews;

}

